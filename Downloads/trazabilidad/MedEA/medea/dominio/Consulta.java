// Consulta.java
 
package medea.dominio;
import java.io.*;

public class Consulta implements Comparable, Serializable{    

     //////////////////////////////////////////////////////////////////////
    
     private String              fechaConsulta;    
     private String              padecimientoConsulta;  
     private String              tratamientoConsulta;
     private Paciente            paciente;  

     //////////////////////////////////////////////////////////////////////
 
     public Consulta(){
          
     }   

     //////////////////////////////////////////////////////////////////////

     public String getFechaConsulta(){
          return fechaConsulta;
     } 
     public void setFechaConsulta(String fechaConsulta){
          this.fechaConsulta = fechaConsulta;
     }     
     
     //////////////////////////////////////////////////////////////////////
    
     public String getPadecimientoConsulta(){
          return padecimientoConsulta;
     }
     public void setPadecimientoConsulta(String padecimientoConsulta){
          this.padecimientoConsulta = padecimientoConsulta;
     }         

     //////////////////////////////////////////////////////////////////////
    
     public String getTratamientoConsulta(){
          return tratamientoConsulta;
     }
     public void setTratamientoConsulta(String tratamientoConsulta){
          this.tratamientoConsulta = tratamientoConsulta;
     }         

     //////////////////////////////////////////////////////////////////////
     
     public Paciente getPaciente(){
          return this.paciente;
     }
     public void setPaciente(Paciente paciente){
          this.paciente = paciente;
     }
        
     //////////////////////////////////////////////////////////////////////
     
     public String toString(){
          return this.fechaConsulta;
     }     
     public int compareTo(Object consultaComparada){
          return this.toString().compareTo( ( (Consulta)consultaComparada ).toString() );
     }

     //////////////////////////////////////////////////////////////////////

}
