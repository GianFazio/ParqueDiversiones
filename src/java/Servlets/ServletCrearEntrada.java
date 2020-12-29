
package Servlets;

import Logica.Cliente;
import Logica.Controladora;
import Logica.Cupo;
import Logica.Empleado;
import Logica.Entrada;
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


@WebServlet(name = "ServletCrearEntrada", urlPatterns = {"/ServletCrearEntrada"})
public class ServletCrearEntrada extends HttpServlet {


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
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        String juego = request.getParameter("juego"); //Id Juego
        juego = juego.substring(5);

       fecha = fecha.substring(8, 10) + "-"+ fecha.substring(5, 7) +"-"+ fecha.substring(0, 4) ;
       
       
       
       
       Cliente cliente = new Cliente();
       cliente.setNombre(nombre);
       cliente.setApellido(apellido);
       cliente.setDni(dni);
       
        try {
            if (control.validarCupo(fecha, juego, cantidad)) {
                control.crearCliente(cliente);
                for (int i = 0; i < cantidad; i++) {
                    Entrada entrada = new Entrada();
                    entrada.setCliente(cliente);
                    entrada.setFechaUtilizar(fecha);
                    entrada.setUnJuego(control.getJuegoXid(Integer.parseInt(juego)));
                    control.crearEntrada(entrada);
                } 
                 response.sendRedirect("entradas.jsp");
            } else {
                    response.sendRedirect("error.jsp");
                    }

        // response.sendRedirect("entradas.jsp");
        
       } catch (Exception ex){
                  response.sendRedirect("entradas.jsp");
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
