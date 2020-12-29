
package Logica;

import java.io.Serializable;
import java.util.ArrayList;
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
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int idEntrada;
    
    @Basic
    String fechaUtilizar;
    
    @OneToOne
    Juego unJuego; 
    
    @OneToOne
    Cliente cliente;
    

    public Entrada() {
    }

    public Entrada(int idEntrada, String fechaUtilizar, Juego unJuego, Cliente cliente) {
        this.idEntrada = idEntrada;
        this.fechaUtilizar = fechaUtilizar;
        this.unJuego = unJuego;
        this.cliente = cliente;
    }



    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public String getFechaUtilizar() {
        return fechaUtilizar;
    }

    public void setFechaUtilizar(String fechaUtilizar) {
        this.fechaUtilizar = fechaUtilizar;
    }



    public Juego getUnJuego() {
        return unJuego;
    }

    public void setUnJuego(Juego unJuego) {
        this.unJuego = unJuego;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    

}
