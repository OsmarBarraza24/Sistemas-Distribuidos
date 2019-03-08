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
public class Usuarios {

    private int id = 0;
    private String nombreCompleto = new String();
    private String cuentaCorreo = new String();
    private String contrasena = new String();
    private PerfilUsuario perfilUsuario = new PerfilUsuario();
    private PuntoCaptura puntoCaptura = new PuntoCaptura();

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

    public String getCuentaCorreo() {
        return cuentaCorreo;
    }

    public void setCuentaCorreo(String cuentaCorreo) {
        this.cuentaCorreo = cuentaCorreo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public PerfilUsuario getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    public PuntoCaptura getPuntoCaptura() {
        return puntoCaptura;
    }

    public void setPuntoCaptura(PuntoCaptura puntoCaptura) {
        this.puntoCaptura = puntoCaptura;
    }

}
