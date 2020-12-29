
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Juego;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletCrearJuego", urlPatterns = {"/ServletCrearJuego"})
public class ServletCrearJuego extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Controladora control = new Controladora();
       String juego = request.getParameter("juego");
       String horarioInicio = request.getParameter("horarioInicio");
       String horarioFin = request.getParameter("horarioFin");
       String habilitado = request.getParameter("habilitado");
       
       Juego jue = new Juego();
       
       jue.setDescripcionJuego(juego);
       
       if("on".equals(habilitado)){
       jue.setHabilitado(true); }
       
       jue.setHorarioInicio(horarioInicio);
       jue.setHorarioFin(horarioFin);
       
       
       try {
           control.crearJuego(jue);
              response.sendRedirect("juegos.jsp");
       } catch (Exception ex){
                  response.sendRedirect("error.jsp");
       }
                          
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
