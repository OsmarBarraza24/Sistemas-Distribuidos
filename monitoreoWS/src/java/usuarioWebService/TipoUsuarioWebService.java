/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import entity.PerfilUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author osmar
 */
@WebServlet(name = "TipoUsuarioWebService", urlPatterns = {"/TipoUsuarioWebService"})
public class TipoUsuarioWebService extends HttpServlet {

    private Connection con;

    public TipoUsuarioWebService(Connection con) {
        this.con = con;
    }

    @WebMethod(operationName = "agregarTipoUsuario")
    public boolean agregarTipoUsuario(@WebParam(name = "tipoUsuario") Object o) throws Exception {
        PerfilUsuario perfilUsuario = (PerfilUsuario) o;
        String _sql = "INSERT INTO SDEduardo.perfilUsuario (nombreCompleto,descripcion,crear,guardar,editar,configuracion,usuarios) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement _st = this.con.prepareStatement(_sql);
        _st.setString(1, perfilUsuario.getNombreCompleto());
        _st.setString(2, perfilUsuario.getDescripcion());
        _st.setBoolean(3, perfilUsuario.isCrear());
        _st.setBoolean(4, perfilUsuario.isGuardar());
        _st.setBoolean(5, perfilUsuario.isEditar());
        _st.setBoolean(6, perfilUsuario.isConfiguracion());
        _st.setBoolean(7, perfilUsuario.isUsuarios());
        boolean resultado = _st.execute();

        if (_st != null) {
            _st.close();
        }
        return resultado;
    }
@WebMethod(operationName = "consultarRegistroPorId")
    public Object consultarRegistroPorId(int id) throws Exception{
        String _sql = "SELECT * FROM SDEduardo.tipoUsuario WHERE id="+id;
        PreparedStatement _st = this.con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
    
      @WebMethod(operationName = "consultarRegistros")
    public Object consultarRegistros() throws Exception{
        //Conductores conductor = new Conductores();
        String _sql = "SELECT * FROM SDEduardo.tipoUsuario";
        PreparedStatement _st = this.con.prepareStatement(_sql);
        if(_st != null){
            _st.close();
        }
        ResultSet _rs = _st.executeQuery();
        return _rs;
    }
    
      
    @WebMethod(operationName = "eliminarTipoUsuario")
    public boolean eliminarTipoUsuario(@WebParam(name = "id") int id) throws Exception{
        String _sql = "DELETE FROM SDEduardo.tipoUsuario WHERE id="+id;
        PreparedStatement _st = this.con.prepareStatement(_sql);
        boolean resultado = _st.execute();
        if(_st != null){
            _st.close();
        }
        return resultado;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TipoUsuarioWebService</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoUsuarioWebService at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
