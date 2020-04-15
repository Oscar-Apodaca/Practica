// ColeccionPacientes.java

package medea.dominio;
import java.io.*;
import java.util.*;

public class ColeccionPacientes extends ArrayList implements Serializable{
     
     //////////////////////////////////////////////////////////////////////
                  
     public ColeccionPacientes(){          
          
     }      
      
     //////////////////////////////////////////////////////////////////////

     public boolean addPaciente(Paciente paciente){
          return super.add(paciente);              
     }
     public boolean removePaciente(Paciente paciente){
          return super.remove(paciente); 
     }
     public int sizeColeccionPacientes(){
          return super.size();
     }
     public void sortColeccionPacientes(){
          Collections.sort(this);
     } 
     public void sortColeccionPacientes(String opcionSort){
          if (opcionSort.equals("clavePaciente")){
             Collections.sort(this, new ClavePacienteComparator() );
          }  else if (opcionSort.equals("nombrePaciente")){
             Collections.sort(this, new NombrePacienteComparator() );
          }
     }     
     public PacienteIterator pacienteIterator(){ 
          return new PacienteIterator(this);
     }

     //////////////////////////////////////////////////////////////////////

     private class ClavePacienteComparator  implements Comparator {
          public int compare(Object paciente, Object pacienteComparado){
               Integer clavePaciente = new Integer ( ((Paciente)paciente).getClavePaciente() );
               Integer clavePacienteComparado = new Integer ( ((Paciente)pacienteComparado).getClavePaciente() );
               return clavePaciente.compareTo(clavePacienteComparado);
          }
     }
     private class NombrePacienteComparator implements Comparator {
          public int compare(Object paciente, Object pacienteComparado){
               String nombrePaciente = ((Paciente)paciente).getNombrePaciente();
               String nombrePacienteComparado = ((Paciente)pacienteComparado).getNombrePaciente();
               return nombrePaciente.compareTo(nombrePacienteComparado);
          }
     }

     //////////////////////////////////////////////////////////////////////
          
}
