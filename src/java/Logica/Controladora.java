
package Logica;

import Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearEmpleado(Empleado empleado){
        controlPersis.crearEmpleado(empleado);
    }
    
    public void crearUsuario(Usuario usuario){
        controlPersis.crearUsuario(usuario);
    }
    
    public void crearJuego(Juego juego) {
        controlPersis.crearJuego(juego);
    }
        
   public void crearCliente(Cliente cliente){
       controlPersis.crearCliente(cliente);
    }
    
    
    public void crearEntrada(Entrada entrada) {
        controlPersis.crearEntrada(entrada);
    }

    public void crearCupo(Cupo cupo) {
       controlPersis.crearCupo(cupo);
    }

    public Empleado comprobarIngreso(String usuario, String password) {
        
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(-1);
        List <Usuario> listaUsuarios = new ArrayList<> ();
        
        listaUsuarios = controlPersis.getUsuarios();

        for (Usuario usu:listaUsuarios){
            if(usu.getUsuario().equals(usuario) && usu.getPassword().equals(password)){
            
            empleado = usu.getUnEmpleado();
            return empleado;
            
            }
        }
        
        return empleado;
        
    }
    
    public List<Usuario> getListUsuarios(){
        
        return controlPersis.getUsuarios();
    }
    
    public int getCantidadUsuarios(){
        List<Usuario> listaUsuarios;
        int nroUsuarios = 0;
        listaUsuarios = controlPersis.getUsuarios();
        for (Usuario usu:listaUsuarios){
        nroUsuarios += 1;
    }
        
        return nroUsuarios;
    }
    
   public int getCantidadUsuariosAdmin(){
        List<Usuario> listaUsuarios;
        int nroUsuarios = 0;
        listaUsuarios = controlPersis.getUsuarios();
        for (Usuario usu:listaUsuarios){
            if(usu.isEsAdministrador() == true){
            nroUsuarios += 1;
            }
        }
        
        return nroUsuarios;
    }
   
   public List<Empleado> getListaEmpleados(){
       return controlPersis.getEmpleados();
   }
   
   public Empleado getEmpleadoXid(int idEmpleado){
   
   return controlPersis.getEmpleadoXid(idEmpleado);
   }

    public void borrarUsuario(int idUsuario) {
     controlPersis.borrarUsuario(idUsuario);
    }

    public Usuario getUsuarioXid(int idUsuario) {
      return controlPersis.getUsuarioXid(idUsuario);
    }

    public void modificarUsuario(Usuario user) {
      controlPersis.modificarUsuario(user);
    }
    
    public int getCantidadEmpleados(){
            List<Empleado> listaEmpleados;
        int nroEmpleados = 0;
        listaEmpleados = controlPersis.getEmpleados();
        for (Empleado emple:listaEmpleados){
        nroEmpleados += 1;
    }
        
        return nroEmpleados;
    
    }

    public void borrarEmpleado(int idEmpleado) {
       controlPersis.borrarEmpleado(idEmpleado);
    }
    
      public List<Juego> getListaJuegos(){
       return controlPersis.getJuegos();
   }

    public Juego getJuegoXid(int idJuego) {
       return controlPersis.getJuegoXid(idJuego);
    }

    public int getCantidadJuegos() {
        return controlPersis.getCantJuegos();
    }

    public void modificarEmpleado(Empleado emple) {
        controlPersis.modificarEmpleado(emple);
    }
   
    public int getCantidadJuegosHabilitados() {
    return controlPersis.getCantJuegosHabilitados();
}
    
    public List<Cupo> getListaCupos(){
        return controlPersis.getCupos();
    }
    
        public List<Entrada> getListaEntradas(){
        return controlPersis.getEntradas();
    }

    public boolean validarCupo(String fecha, String juego, int cantidad) {
        
        List<Cupo> listaCupos = controlPersis.getCupos();
        
        for(Cupo cupo:listaCupos){
            if(cupo.fechaCupo.equals(fecha) && cupo.juego.idJuego == Integer.parseInt(juego) && cupo.cuposDisponible >= cantidad){
                controlPersis.descontarCupo(cupo.getIdCupo(), cantidad);
                return true;
            } 
              
            }
            return false;
        }
        
    }
    

