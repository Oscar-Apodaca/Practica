// Paciente.java
 
package medea.dominio;
import java.io.*;

public class Paciente implements Comparable, Serializable{    

     //////////////////////////////////////////////////////////////////////
    
     private int                 clavePaciente;    
     private String              nombrePaciente;   
     private String              rutaFotoPaciente;  
     private Medico              medico;  

     private ColeccionConsultas  coleccionConsultas;
   
 
     //////////////////////////////////////////////////////////////////////
 
     public Paciente(){
          
     }   

     //////////////////////////////////////////////////////////////////////

     public int getClavePaciente(){
          return clavePaciente;
     } 
     public void setClavePaciente(int clavePaciente){
          this.clavePaciente = clavePaciente;
     }     
     
     //////////////////////////////////////////////////////////////////////
    
     public String getNombrePaciente(){
          return nombrePaciente;
     }
     public void setNombrePaciente(String nombrePaciente){
          this.nombrePaciente = nombrePaciente;
     }  
       
     //////////////////////////////////////////////////////////////////////
    
     public String getRutaFotoPaciente(){
          return rutaFotoPaciente;
     }
     public void setRutaFotoPaciente(String rutaFotoPaciente){
          this.rutaFotoPaciente = rutaFotoPaciente;
     }         

     //////////////////////////////////////////////////////////////////////
     
     public Medico getMedico(){
          return this.medico;
     }
     public void setMedico(Medico medico){
          this.medico = medico;
     }

     //////////////////////////////////////////////////////////////////////
     
     public ColeccionConsultas getColeccionConsultas(){
          return this.coleccionConsultas;
     }
     public void setColeccionConsultas(ColeccionConsultas coleccionConsultas){
          this.coleccionConsultas = coleccionConsultas;
     }  
        
     //////////////////////////////////////////////////////////////////////
     
     public String toString(){
          return this.nombrePaciente;
     }     
     public int compareTo(Object pacienteComparada){
          return this.toString().compareTo( ( (Paciente)pacienteComparada ).toString() );
     }

     //////////////////////////////////////////////////////////////////////

}
