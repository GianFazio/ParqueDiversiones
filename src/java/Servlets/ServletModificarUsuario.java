
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ServletModificarUsuario", urlPatterns = {"/ServletModificarUsuario"})
public class ServletModificarUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           HttpSession misesion = request.getSession();

           String usuario2 = (String) request.getSession().getAttribute("usuario");
           String nombre = (String) request.getSession().getAttribute("nombre");
           String apellido = (String) request.getSession().getAttribute("apellido");

           if (usuario2 == null) {
               response.sendRedirect("login.jsp");
           }
     
           
       Controladora control = new Controladora();
        
       Usuario user = new Usuario();
       Empleado emple = new Empleado();

       String usuario = request.getParameter("usuario");
       String password = request.getParameter("password");
       String email = request.getParameter("email");
       String esAdmin = request.getParameter("administrador");
       String empleado = request.getParameter("empleado"); //Id empleado
       emple = control.getEmpleadoXid(Integer.parseInt(empleado));
       int idUsuario = Integer.parseInt(request.getParameter("id"));
       user = control.getUsuarioXid(idUsuario);
       
       user.setUsuario(usuario);
       user.setPassword(password);
       user.setEmail(email);
       user.setEmail(email);
       user.setUnEmpleado(emple);
       if(esAdmin == null){
           user.setEsAdministrador(false);
           } else { 
               user.setEsAdministrador(true);
           }
     //  user.setUnEmpleado(emple);
       
       control.modificarUsuario(user);
        
       response.sendRedirect("usuarios.jsp");
       } catch (IOException | NumberFormatException ex) {
              response.sendRedirect("usuarios.jsp");
       
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
