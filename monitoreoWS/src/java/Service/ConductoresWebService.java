package Service;

import entity.Conductores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Arkuz
 */
@WebService(serviceName = "ConductoresWebService")
public class ConductoresWebService {

    private Connection _con;

    public ConductoresWebService(Connection _con) {
        this._con = _con;
    }

    @WebMethod(operationName = "agregarConductor")
    public boolean agregarRegistro(@WebParam(name = "conductor") Object o) throws Exception {
        Conductores conductor = (Conductores)o;
        String _sql = "INSERT INTO SDEduardo.conductores (nombreCompleto, descripcion, ife, curp, rfc, licencia, vigenciaLicencia, telefono) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        _st.setString(1, conductor.getNombreCompleto());
        _st.setString(2, conductor.getDescripcion());
        _st.setString(3, conductor.getIfe());
        _st.setString(4, conductor.getCurp());
        _st.setString(5, conductor.getRfc());
        _st.setString(6, conductor.getLicencia());
        _st.setString(7, conductor.getVigenciaLicencia());
        _st.setString(8, conductor.getTelefono());
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarConductor")
    public boolean eliminarConductor(@WebParam(name = "id") int id) throws Exception{
        String _sql = "DELETE FROM SDEduardo.conductores WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarConductor")
    public boolean modificarConductor(@WebParam(name = "conductor") Object o) throws Exception{
        Conductores conductor = (Conductores)o;
        String _sql = "UPDATE SDEduardo.conductores SET nombreCompleto="+conductor.getNombreCompleto()+", descripcion="+conductor.getDescripcion()+", ife="+conductor.getIfe()+", curp="+conductor.getCurp()+", rfc="+conductor.getRfc()+", licencia="+conductor.getLicencia()+", vigenciaLicencia="+conductor.getVigenciaLicencia()+", telefono="+conductor.getTelefono()+" WHERE id="+conductor.getId();
        PreparedStatement _st = this._con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    @WebMethod(operationName = "consultarRegistros")
    public Object consultarRegistros() throws Exception{
        //Conductores conductor = new Conductores();
        String _sql = "SELECT * FROM SDEduardo.conductores";
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
    
    @WebMethod(operationName = "consultarRegistroPorId")
    public Object consultarRegistroPorId(int id) throws Exception{
        String _sql = "SELECT * FROM SDEduardo.conductores WHERE id="+id;
        PreparedStatement _st = this._con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
}
