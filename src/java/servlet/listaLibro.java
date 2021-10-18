/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import C.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mery Acevedo
 */
@WebServlet(name = "listaLibro", urlPatterns = {"/listaLibro"})
public class listaLibro extends HttpServlet {
    
    private bd conn=new bd();

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
        
        conn.conectar();
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet listaLibro</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Listado de usuarios.-</h1>");
            out.println("<a href='formNuevoUsuario'>Agregar nuevo...</a></p>");
            out.println("<table border=1><tr>"
                    + "<td><b>ID</td>"
                    + "<td><b>NOMBRE</td>"
                    + "<td><b>AUTOR</td>"
                    + "<td><b>FECHA DE PUBLICACION</td><td>"
                    + "<b>UBICACION</td>"
                    + "<td><b>Acciones</td></tr>");
            try
            {
               ResultSet rs=this.conn.consultar();
               while (rs.next())
               {
                  out.println("<tr><td>"+rs.getString(1).trim()+"</td>"
                          + "<td>"+rs.getString(2).trim()+"</td>"
                          + "<td>"+rs.getString(3).trim()+"</td>"
                          + "<td>"+rs.getString(4).trim()+"</td>"
                          + "<td>"+rs.getString(5).trim()+"</td>"
                          + "<td><a href='borraUsu?id="+rs.getString(1).trim()+"'>Borrar</td>");
             
               }
            }
            catch(Exception ee)
            {}
            

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
