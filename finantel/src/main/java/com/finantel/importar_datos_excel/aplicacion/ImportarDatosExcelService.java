package com.finantel.importar_datos_excel.aplicacion;

import com.finantel.importar_datos_excel.dominio.repository.ImportarDatosExcelRepository;
import com.finantel.registrar_accion.aplicacion.AuditoriaService;
import com.finantel.registrar_asiento_contable.dominio.entity.AsientoContable;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportarDatosExcelService {

    private final ImportarDatosExcelRepository repository;
    private final AuditoriaService auditoriaService;

    public ImportarDatosExcelService(ImportarDatosExcelRepository repository, AuditoriaService auditoriaService) {
        this.repository = repository;
        this.auditoriaService = auditoriaService;
    }

    public String importar(MultipartFile archivo, String usuario) {
        if (archivo == null || archivo.isEmpty()) return "Error: archivo vacío";
        String nombre = archivo.getOriginalFilename();
        if (nombre == null || (!nombre.endsWith(".xlsx") && !nombre.endsWith(".xls")))
            return "Error: formato inválido";

        try (InputStream is = archivo.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            List<AsientoContable> asientos = new ArrayList<>();
            int count = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // saltar cabecera
                
                String tipo = getCellValue(row, 0);
                String descripcion = getCellValue(row, 1);
                String debeStr = getCellValue(row, 2);
                String haberStr = getCellValue(row, 3);

                if (tipo == null || tipo.isBlank()) continue;

                AsientoContable a = new AsientoContable();
                a.setTipo(tipo);
                a.setDescripcion(descripcion);
                a.setDebe(parseDouble(debeStr));
                a.setHaber(parseDouble(haberStr));
                a.setEstado("Activo");
                a.setUsuario(usuario);
                a.setCuentaContable("1011");
                a.setCentroCosto("General");
                a.setMoneda("PEN");
                a.setTipoCambio(1.0);
                a.setFechaRegistro(LocalDateTime.now());
                a.setNumeroCorrelativo("IMP-" + System.currentTimeMillis() + "-" + count);
                asientos.add(a);
                count++;
            }

            repository.saveAll(asientos);
            auditoriaService.registrar(usuario, "Importación Excel", "AsientosContables", null, nombre + " — " + count + " registros");
            return count + " asientos importados correctamente desde " + nombre;

        } catch (Exception e) {
            return "Error al procesar el archivo: " + e.getMessage();
        }
    }

    private String getCellValue(Row row, int col) {
        Cell cell = row.getCell(col);
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue().trim();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            default -> "";
        };
    }

    private double parseDouble(String val) {
        try { return Double.parseDouble(val); } catch (Exception e) { return 0.0; }
    }
}