/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarioWebService;

import entity.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Leteo
 */
@WebService(serviceName = "UsuariosWebService")
public class UsuariosWebService {

    
    
    private Connection _con;

    public UsuariosWebService(Connection _con) {
        this._con = _con;
    }
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "agregarUsuario")
    public boolean agregarUsuario(@WebParam(name = "usuario") Object o) throws Exception {
        Usuarios usuario = (Usuarios)o;
        String _sql = "INSERT INTO SDEduardo.usuarios (nombreCompleto, cuentaCorreo, contrasena) VALUES (?,?,?)";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        _st.setString(1, usuario.getNombreCompleto());
        _st.setString(2, usuario.getCuentaCorreo());
        _st.setString(3, usuario.getContrasena());
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(@WebParam(name = "id") int id) throws Exception{
        String _sql = "DELETE FROM SDEduardo.usuarios WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarUsuario")
    public boolean modificarUsuario(@WebParam(name = "usuario") Object o) throws Exception{
        Usuarios usuario = (Usuarios)o;
        String _sql = "UPDATE SDEduardo.usuarios SET nombreCompleto="+usuario.getNombreCompleto()+", cuentaCorreo="+usuario.getCuentaCorreo()+", contrasena="+usuario.getContrasena() + " WHERE id="+usuario.getId();
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "consultarRegistrosUsuarios")
    public Object consultarRegistros() throws Exception{
        //Usuarios usuario = new Usuarios();
        String _sql = "SELECT * FROM SDEduardo.usuarios";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
    
    @WebMethod(operationName = "consultarRegistroUsuariosPorId")
    public Object consultarRegistroPorId(int id) throws Exception{
        String _sql = "SELECT * FROM SDEduardo.usuarios WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
}
