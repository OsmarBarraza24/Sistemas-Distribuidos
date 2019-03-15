/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.LineasTransportistas;
import entity.Transportes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Ángel
 */
@WebService(serviceName = "transportesWebService")
public class transportesWebService {

    private Connection _con;

    public transportesWebService(Connection _con) {
        this._con = _con;
    }

    public boolean agregarRegistro(@WebParam(name = "transportes") Object o, @WebParam(name ="lineastransportistas") int id) throws Exception {
        Transportes tps = (Transportes) o;
        
        String _sql = "INSERT INTO SDEduardo.transportes (placas, marca, modelo, descripcion, lineastransportistas) VALUES (?,?,?,?,?)";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        _st.setString(1, tps.getPlacas());
        _st.setString(2, tps.getMarca());
        _st.setString(3, tps.getModelo());
        _st.setString(4, tps.getDescripcion());
        _st.setInt(5, id);

        boolean resultado = _st.execute();
        if (_st != null) {
            _st.close();
        }
        return resultado;
    }

    @WebMethod(operationName = "consultarRegistros")
    public Object consultarRegistros() throws Exception {

        String _sql = "SELECT * FROM SDEduardo.transportes";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if (_st != null) {
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }

    @WebMethod(operationName = "eliminarTransporte")
    public boolean eliminarTransporte(@WebParam(name = "id") int id) throws Exception {
        String _sql = "DELETE FROM SDEduardo.transportes WHERE id=" + id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if (_st != null) {
            _st.close();
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarTransporte")
    public boolean modificarConductor(@WebParam(name = "conductor") Object o) throws Exception {
        Transportes tps = (Transportes) o;
        LineasTransportistas lp = new LineasTransportistas();
        String _sql = "UPDATE SDEduardo.conductores SET placas=" + tps.getPlacas() + ", marca=" + tps.getMarca() + ", modelo=" + tps.getModelo()
                + ", descripcion=" + tps.getDescripcion() + ", lineastransportistas=" + lp.getId();
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if (_st != null) {
            _st.close();
        }
        return resultado;
    }

    @WebMethod(operationName = "consultarRegistroPorId")
    public Object consultarRegistroPorId(int id) throws Exception {
        String _sql = "SELECT * FROM SDEduardo.transportes WHERE id=" + id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if (_st != null) {
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
}
