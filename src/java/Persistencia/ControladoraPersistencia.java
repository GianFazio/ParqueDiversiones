
package Persistencia;

import Logica.Cliente;
import Logica.Cupo;
import Logica.Empleado;
import Logica.Entrada;
import Logica.Juego;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    JuegoJpaController juegoJpa = new JuegoJpaController();
    ClienteJpaController clienteJpa = new ClienteJpaController();
    EntradaJpaController entradaJpa = new EntradaJpaController();
    CupoJpaController cupoJpa = new CupoJpaController();
  
    public void crearEmpleado(Empleado empleado){
        empleadoJpa.create(empleado);
    }
    
    public void crearUsuario(Usuario usuario){
        usuarioJpa.create(usuario);
    }
    
    public void crearJuego(Juego juego){
        juegoJpa.create(juego);
    }
    
    public void crearCliente(Cliente cliente){
        clienteJpa.create(cliente);
    }
    
    
    public void crearEntrada(Entrada entrada) {
        entradaJpa.create(entrada);
    }

    public void crearCupo(Cupo cupo) {
        cupoJpa.create(cupo);
    }

    public List<Usuario> getUsuarios() {
       
        return usuarioJpa.findUsuarioEntities();
    }

    public List<Empleado> getEmpleados() {
        return empleadoJpa.findEmpleadoEntities();
    }

    public Empleado getEmpleadoXid(int idEmpleado) {
      return empleadoJpa.findEmpleado(idEmpleado);
    }

    public void borrarUsuario(int idUsuario) {
        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuarioXid(int idUsuario) {
        return usuarioJpa.findUsuario(idUsuario);
    }

    public void modificarUsuario(Usuario user) {
        try {
            usuarioJpa.edit(user);
     
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEmpleado(int idEmpleado) {
        try {
            empleadoJpa.destroy(idEmpleado);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Juego> getJuegos() {
        return juegoJpa.findJuegoEntities();
    }

    public Juego getJuegoXid(int idJuego) {
        return juegoJpa.findJuego(idJuego);
    }

    public int getCantJuegos() {
        return juegoJpa.getJuegoCount();
    }

    public void modificarEmpleado(Empleado emple) {
        try {
            empleadoJpa.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getCantJuegosHabilitados() {
        List<Juego> listaJuegos;
        int nroJuegos = 0;
        listaJuegos = juegoJpa.findJuegoEntities();
        for (Juego jue:listaJuegos){
            if(jue.isHabilitado() == true){
            nroJuegos += 1;
            }
        }
        
        return nroJuegos;
        
        
        
    }

    public List<Cupo> getCupos() {
       return cupoJpa.findCupoEntities();
    }

    public List<Entrada> getEntradas() {
       return entradaJpa.findEntradaEntities();
    }

    public void descontarCupo(int idCupo, int cantidad) throws Exception {
            Cupo cupo = new Cupo();
            cupo = cupoJpa.findCupo(idCupo);
            cupo.setCuposDisponible(cupo.getCuposDisponible()-cantidad);
            cupoJpa.edit(cupo);
        
    }

    
    
    
    
}
