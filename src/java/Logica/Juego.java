
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class Juego implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idJuego;
    @Basic
    String descripcionJuego;
    boolean habilitado;
    String horarioInicio;
    String horarioFin;
    
   


    public Juego() {

    }

    public Juego(int idJuego, String descripcionJuego, boolean habilitado, String horarioInicio, String horarioFin) {
        this.idJuego = idJuego;
        this.descripcionJuego = descripcionJuego;
        this.habilitado = habilitado;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getDescripcionJuego() {
        return descripcionJuego;
    }

    public void setDescripcionJuego(String descripcionJuego) {
        this.descripcionJuego = descripcionJuego;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }


    
    
    
    
}
