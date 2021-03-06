/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Gian
 */
public class metodosFecha {
    
    //MÉTODOS PARA MANEJAR FECHAS Y HORAS
//TodoCode
    public metodosFecha() {
    }
    
    
//Metodo usado para obtener la fecha actual
    //@return Retorna un STRING con la fecha actual formato "dd-MM-yyyy"
    public String getFechaActual() {
        Date ahora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd"); //acá pueden cambiar el formato si quieren
        return formatoFecha.format(ahora);
    }
	
	//Metodo usado para obtener la hora actual del sistema
    //@return Retorna un STRING con la hora actual formato "hh:mm"
    public String getHoraActual() {
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm");
        return formateador.format(ahora);
    }
	
	//Convierte un String a un tipo DATE en formato dd-MM-yyyy
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	//Convierte un String a un tipo DATE en formato dd/MM/yyyy
    //@return Retorna la fecha en formato Date
	   public static synchronized java.util.Date deStringToDate2(String fecha) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy"); //formato barra
        Date fechaEnviar = null;
        try {
            fechaEnviar = formatoDelTexto.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
	
	//Convertir Date a String
	 public static String DateAString(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        return formatoFecha.format(fecha);
    }
	
	//Convertir Hora a String
	  public static Date convertirHoraStringADate (String hora, String minutos) throws ParseException {
      
      String horaString = hora + ":" + minutos;
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Date horaCompleta = new Date();
          
                horaCompleta = formatoHora.parse(horaString);
            
        System.out.println("La hora es: " + horaCompleta);
      return horaCompleta;
      }

    
}
