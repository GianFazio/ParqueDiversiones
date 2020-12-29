
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Cupo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idCupo;
    @Basic
    int cuposDisponible;
    String fechaCupo;
    @OneToOne
    Juego juego;
    
    public Cupo() {
    }

    public Cupo(int idCupo, int cuposDisponible, String fechaCupo, Juego juego) {
        this.idCupo = idCupo;
        this.cuposDisponible = cuposDisponible;
        this.fechaCupo = fechaCupo;
        this.juego = juego;
    }



    public int getIdCupo() {
        return idCupo;
    }

    public void setIdCupo(int idCupo) {
        this.idCupo = idCupo;
    }

    public int getCuposDisponible() {
        return cuposDisponible;
    }

    public void setCuposDisponible(int cuposDisponible) {
        this.cuposDisponible = cuposDisponible;
    }

    public String getFechaCupo() {
        return fechaCupo;
    }

    public void setFechaCupo(String fechaCupo) {
        this.fechaCupo = fechaCupo;
    }
    
    
    
    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }


    
}
