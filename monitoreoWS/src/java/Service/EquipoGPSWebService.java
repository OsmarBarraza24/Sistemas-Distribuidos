/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import entity.EquipoGPS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author JoelRuiz
 */
@WebService(serviceName = "EquipoGPSWebService")
public class EquipoGPSWebService {

    private Connection _con;

    public EquipoGPSWebService(Connection _con) {
        this._con = _con;
    }

    @WebMethod(operationName = "agregarGPS")
    public boolean agregarGPS(@WebParam(name = "equipogps") Object o) throws Exception {
        EquipoGPS equipogps = (EquipoGPS)o;
        String _sql = "INSERT INTO SDEduardo.equipogps (nombreCompleto, marca, modelo, numeroSerie, imeiGPS, chipTelefono, imeiChip, digitoSeguridad) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        _st.setString(1, equipogps.getNombreCompleto());
        _st.setString(2, equipogps.getMarca());
        _st.setString(3, equipogps.getModelo());
        _st.setString(4, equipogps.getNumeroSerie());
        _st.setString(5, equipogps.getImeiGPS());
        _st.setString(6, equipogps.getChipTelefono());
        _st.setString(7, equipogps.getImeiChip());
        _st.setString(8, equipogps.getDigitoSeguridad());
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarEquipoGPS")
    public boolean eliminarEquipoGPS(@WebParam(name = "id") int id) throws Exception{
        String _sql = "DELETE FROM SDEduardo.equipogps WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarEquipoGPS")
    public boolean modificarEquipoGPS(@WebParam(name = "equipogps") Object o) throws Exception{
        EquipoGPS equipogps = (EquipoGPS)o;
        String _sql = "UPDATE SDEduardo.equipogps SET nombreCompleto="+equipogps.getNombreCompleto()+", marca="+equipogps.getMarca()+", modelo="+equipogps.getModelo()+", numeroSerie="+equipogps.getNumeroSerie()+", imeiGPS="+equipogps.getImeiGPS()+", chipTelefono="+equipogps.getChipTelefono()+", imeiChip="+equipogps.getImeiChip()+", digitoSeguridad="+equipogps.getDigitoSeguridad()+" WHERE id="+equipogps.getId();
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "consultarRegistros")
    public Object consultarRegistros() throws Exception{
        //EquipoGPS equipogps = new EquipoGPS();
        String _sql = "SELECT * FROM SDEduardo.equipogps";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
    
    @WebMethod(operationName = "consultarRegistroEquipoGPSPorId")
    public Object consultarRegistroEquipoGPSPorId(int id) throws Exception{
        String _sql = "SELECT * FROM SDEduardo.equipogps WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
}