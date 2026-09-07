package com.finantel.ocr_documentos.aplicacion;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class OcrDocumentosService {

    public String extraerTexto(MultipartFile archivo) throws Exception {
        Path tempDir = Files.createTempDirectory("ocr");
        File originalFile = new File(tempDir.toFile(), archivo.getOriginalFilename());
        archivo.transferTo(originalFile);

        // Convertir a PNG para evitar problemas de formato
        BufferedImage image = ImageIO.read(originalFile);
        File pngFile = new File(tempDir.toFile(), "imagen.png");
        ImageIO.write(image, "png", pngFile);

        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:\\Users\\Diego\\AppData\\Local\\Programs\\Tesseract-OCR\\tessdata");
        tesseract.setLanguage("eng+spa");

        String resultado = tesseract.doOCR(pngFile);

        originalFile.delete();
        pngFile.delete();
        return resultado;
    }
}