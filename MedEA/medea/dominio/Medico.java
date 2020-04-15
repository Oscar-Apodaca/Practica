// Medico.java

package medea.dominio;
import  medea.datos.*;
import java.io.*;

public class Medico implements Serializable{

     //////////////////////////////////////////////////////////////////////
     
     private int                 claveMedico;
     private String              nombreMedico;          
     private ColeccionPacientes  coleccionPacientes;      

     ////////////////////////////////////////////////////////////////////// 
      
     public Medico(){
          
     }     

     //////////////////////////////////////////////////////////////////////

     public int getClaveMedico(){
          return claveMedico;
     }
     public void setClaveMedico(int claveMedico){
          this.claveMedico = claveMedico;
     }
 
     //////////////////////////////////////////////////////////////////////
 
     public String getNombreMedico(){
          return nombreMedico;
     }
     public void setNombreMedico(String nombreMedico){
          this.nombreMedico = nombreMedico;
     }
 
     //////////////////////////////////////////////////////////////////////

     public ColeccionPacientes getColeccionPacientes(){
          return this.coleccionPacientes;
     }
     public void setColeccionPacientes(ColeccionPacientes coleccionPacientes){
          this.coleccionPacientes = coleccionPacientes;
     }  
        
     //////////////////////////////////////////////////////////////////////
     
     public void saveMedico(String origenDatosMedico) throws Exception { 
          MedicoIO.saveMedico(this, origenDatosMedico);
     }
     public Medico loadMedico(String origenDatosMedico) throws Exception {
          Medico medico = MedicoIO.loadMedico(origenDatosMedico);
          return medico;
     } 

      //////////////////////////////////////////////////////////////////////     
}