
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


@WebServlet(name = "ServletCrearEmpleado", urlPatterns = {"/ServletCrearEmpleado"})
public class ServletCrearEmpleado extends HttpServlet {


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
       String nombre = request.getParameter("nombre");
       String apellido = request.getParameter("apellido");
       String dni = request.getParameter("dni");
       String cargo = request.getParameter("cargo");
       
       List<Juego> listaJuegos = new ArrayList();
        int cantJuegos = control.getCantidadJuegos();
        for (int i = 1; i <= cantJuegos; i++) {

            if (request.getParameter("Juego" + i) != null) {
                
                listaJuegos.add(control.getJuegoXid(i));
                
            }
        }
        
        Empleado emple = new Empleado();
        emple.setNombre(nombre);
        emple.setApellido(apellido);
        emple.setDni(dni);
        emple.setCargo(cargo);
        emple.setListaJuegos(listaJuegos);
        
        try {
        control.crearEmpleado(emple);
        response.sendRedirect("empleados.jsp");
        
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
