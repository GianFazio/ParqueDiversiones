
package Servlets;

import Logica.Controladora;
import Logica.Cupo;
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


@WebServlet(name = "ServletCrearCupo", urlPatterns = {"/ServletCrearCupo"})
public class ServletCrearCupo extends HttpServlet {


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
       String fecha = request.getParameter("fecha");
       int cupos = Integer.parseInt(request.getParameter("cupos"));
       String juego = request.getParameter("juego"); //Id Juego
       juego = juego.substring(5);
       
       fecha = fecha.substring(8, 10) + "-"+ fecha.substring(5, 7) +"-"+ fecha.substring(0, 4) ;
       
       Cupo cupo = new Cupo();
       cupo.setCuposDisponible(cupos);
       cupo.setFechaCupo(fecha);
       
       
       cupo.setJuego(control.getJuegoXid(Integer.parseInt(juego)));
       

       
       try {
                  control.crearCupo(cupo);
                     response.sendRedirect("cupos.jsp");
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
