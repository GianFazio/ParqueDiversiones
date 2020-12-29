
package Logica;


import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empleado extends Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idEmpleado;

    @Basic
    String cargo;
    
    @OneToMany
    List <Juego> listaJuegos;

    public Empleado() {
    }


    public Empleado(int idEmpleado, String cargo, List<Juego> listaJuegos, String nombre, String apellido, String dni) {
        super(nombre, apellido, dni);
        this.idEmpleado = idEmpleado;
        this.cargo = cargo;
        this.listaJuegos = listaJuegos;
    }




    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Juego> getListaJuegos() {
        return listaJuegos;
    }

    public void setListaJuegos(List<Juego> listaJuegos) {
        this.listaJuegos = listaJuegos;
    }
    
    
    
    
    

    
    
}
