package com.finantel.ocr_documentos.dominio.entity;

public class DocumentoOcr {

    private String nombreArchivo;
    private String textoExtraido;
    private String estado;

    public DocumentoOcr(String nombreArchivo, String textoExtraido, String estado) {
        this.nombreArchivo = nombreArchivo;
        this.textoExtraido = textoExtraido;
        this.estado = estado;
    }

    public String getNombreArchivo() { return nombreArchivo; }
    public String getTextoExtraido() { return textoExtraido; }
    public String getEstado() { return estado; }
    public void setNombreArchivo(String n) { this.nombreArchivo = n; }
    public void setTextoExtraido(String t) { this.textoExtraido = t; }
    public void setEstado(String e) { this.estado = e; }
}