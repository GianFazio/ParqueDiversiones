/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(name = "ServletBorrarUsuario", urlPatterns = {"/ServletBorrarUsuario"})
public class ServletBorrarUsuario extends HttpServlet {

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
        HttpSession misesion = request.getSession();

        String usuario = (String) request.getSession().getAttribute("usuario");
        String nombre = (String) request.getSession().getAttribute("nombre");
        String apellido = (String) request.getSession().getAttribute("apellido");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
        }


        Controladora control = new Controladora();
        int idUsuario = Integer.parseInt(request.getParameter("id"));
        
        if(idUsuario <= 0){
           response.sendRedirect("error.jsp"); 
        } else {
        control.borrarUsuario(idUsuario);
        response.sendRedirect("usuarios.jsp");
        }
    }


    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
