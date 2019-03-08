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
public class Transportes {

    private int id = 0;
    private String placas = new String();
    private String marca = new String();
    private String modelo = new String();
    private String descripcion = new String();
    private LineasTransportistas lineasTransportistas = new LineasTransportistas();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LineasTransportistas getLineasTransportistas() {
        return lineasTransportistas;
    }

    public void setLineasTransportistas(LineasTransportistas lineasTransportistas) {
        this.lineasTransportistas = lineasTransportistas;
    }

}
