
package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletCrearUsuario", urlPatterns = {"/ServletCrearUsuario"})
public class ServletCrearUsuario extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       String usuario = request.getParameter("usuario");
       String password = request.getParameter("password");
       String email = request.getParameter("email");
       String esAdmin = request.getParameter("administrador");
       String empleado = request.getParameter("empleado"); //Id empleado
       
       Controladora control = new Controladora();
       Empleado emple = control.getEmpleadoXid(Integer.parseInt(empleado));
       boolean existeUsuario = false;
       List<Usuario> listaUsuarios = control.getListUsuarios(); 
       
       for(Usuario user:listaUsuarios){
           if(user.getUnEmpleado().getIdEmpleado() == Integer.parseInt(empleado)){
               existeUsuario = true;
           }
       }
       
       if(existeUsuario == true){
           response.sendRedirect("error.jsp");
       } else {
           Usuario userNuevo = new Usuario();
           userNuevo.setEmail(email);
           if(esAdmin == null){
           userNuevo.setEsAdministrador(false);
           } else { 
               userNuevo.setEsAdministrador(true);
           }
           userNuevo.setUsuario(usuario);
           userNuevo.setPassword(password);
           userNuevo.setUnEmpleado(emple);
           control.crearUsuario(userNuevo);
           
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
