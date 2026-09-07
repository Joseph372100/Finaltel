package com.finantel.autenticar_usuario.infraestructura.persistence;

import java.time.YearMonth;

public class SingletonConfiguracionSistema {

    private static SingletonConfiguracionSistema instancia;

    private String nombreEmpresa = "FINANTEL S.A.C.";
    private final String ruc = "20123456789";
    private final String moneda = "PEN";
    private String periodoActivo;
    private final String algoritmoJWT = "RS512";
    private String version = "1.0.0";
    private int totalSesionesActivas = 0;

    private SingletonConfiguracionSistema() {
        System.out.println("SingletonConfiguracionSistema inicializada — instancia única creada.");
    }

    public static SingletonConfiguracionSistema getInstancia() {
        if (instancia == null) {
            instancia = new SingletonConfiguracionSistema();
        }
        return instancia;
    }

    public String getPatron() {
        return "Patrón Singleton — instancia única de ConfiguracionSistema";
    }

    public String getNombreEmpresa() { return nombreEmpresa; }
    public String getRuc() { return ruc; }
    public String getMoneda() { return moneda; }
    //periodo activoo
    public String getPeriodoActivo() { 
        return periodoActivo != null ? periodoActivo : YearMonth.now().toString(); 
    }
    public String getAlgoritmoJWT() { return algoritmoJWT; }
    public String getVersion() { return version; }
    public int getTotalSesionesActivas() { return totalSesionesActivas; }

    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public void setPeriodoActivo(String periodoActivo) { this.periodoActivo = periodoActivo; }
    public void setVersion(String version) { this.version = version; }

    public void incrementarSesiones() { totalSesionesActivas++; }
    public void decrementarSesiones() { if (totalSesionesActivas > 0) totalSesionesActivas--; }

    public String getResumen() {
        return "Patrón: " + getPatron() +
               " | Empresa: " + nombreEmpresa +
               " | RUC: " + ruc +
               " | Moneda: " + moneda +
               " | Periodo: " + periodoActivo +
               " | JWT: " + algoritmoJWT +
               " | Sesiones activas: " + totalSesionesActivas +
               " | Versión: " + version;
    }
}