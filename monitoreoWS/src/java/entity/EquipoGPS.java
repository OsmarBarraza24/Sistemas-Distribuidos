/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author eduardolara
 */
public class EquipoGPS {

    private int id = 0;
    private String nombreCompleto = new String();
    private String marca = new String();
    private String modelo = new String();
    private String numeroSerie = new String();
    private String imeiGPS = new String();
    private String chipTelefono = new String();
    private String imeiChip = new String();
    private String digitoSeguridad = new String();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getImeiGPS() {
        return imeiGPS;
    }

    public void setImeiGPS(String imeiGPS) {
        this.imeiGPS = imeiGPS;
    }

    public String getChipTelefono() {
        return chipTelefono;
    }

    public void setChipTelefono(String chipTelefono) {
        this.chipTelefono = chipTelefono;
    }

    public String getImeiChip() {
        return imeiChip;
    }

    public void setImeiChip(String imeiChip) {
        this.imeiChip = imeiChip;
    }

    public String getDigitoSeguridad() {
        return digitoSeguridad;
    }

    public void setDigitoSeguridad(String digitoSeguridad) {
        this.digitoSeguridad = digitoSeguridad;
    }

}
