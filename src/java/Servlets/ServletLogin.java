
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
        }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

         
        Controladora control = new Controladora();
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(-1);
        empleado = control.comprobarIngreso(usuario,password);
        
        if(empleado.getIdEmpleado() != -1){
            
            //verificar que exista sesion
            HttpSession misesion = request.getSession(true);
            misesion.setAttribute("usuario", usuario);
            misesion.setAttribute("password", password);
            misesion.setAttribute("nombre", empleado.getNombre());
            misesion.setAttribute("apellido", empleado.getApellido());
            //empleado = control.traerDatosEmpleado();
            response.sendRedirect("index.jsp");
        } else {
            
            response.sendRedirect("login.jsp");
            
        }
    }



}
