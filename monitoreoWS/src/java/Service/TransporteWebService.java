/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.Transportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mario
 */
@WebService(serviceName = "TransporteWebService")
public class TransporteWebService {

private Connection con;

    public TransporteWebService(Connection con) {
        this.con = con;
    }



    /**
     * Web service operation
     */
    @WebMethod(operationName = "agregarTransporte")
    public Boolean agregarTransporte(@WebParam(name = "transporte") Object objeto,@WebParam(name = "lineaTransportista") int id) throws SQLException {
         Transportes transporte = (Transportes)objeto;
        String _sql = "INSERT INTO SDEduardo.transportees (placas, marca, modelo, descripcion,id) VALUES (?,?,?,?,?)";
        PreparedStatement _st = this.con.prepareStatement(_sql);
        _st.setString(1, transporte.getPlacas());
        _st.setString(2, transporte.getMarca());
        _st.setString(3, transporte.getModelo());
        _st.setString(4, transporte.getDescripcion());
        _st.setInt(5, id);

        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "editarTransporte")
    public Object editarTransporte(@WebParam(name = "transporte") Object objeto) throws SQLException {
        Transportes transporte = (Transportes)objeto;
        String _sql = "UPDATE SDEduardo.transportees SET placas="+transporte.getPlacas()+", marca="+transporte.getMarca()+", modelo="+transporte.getModelo()+", descripcion="+transporte.getDescripcion();
        PreparedStatement _st = this.con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "eliminarTransporte")
    public Object eliminarTransporte(@WebParam(name = "id") String id) throws SQLException {
        String _sql = "DELETE FROM SDEduardo.transportes WHERE id="+id;
        PreparedStatement _st = this.con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarTransportes")
    public Object consultarTransportes() throws SQLException {
         String _sql = "SELECT * FROM SDEduardo.transportes";
        PreparedStatement _st = this.con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultarTransporteId")
    public Object consultarTransporteId(@WebParam(name = "id") int id) throws SQLException {
       String _sql = "SELECT * FROM SDEduardo.conductores WHERE id="+id;
        PreparedStatement _st = this.con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
}
