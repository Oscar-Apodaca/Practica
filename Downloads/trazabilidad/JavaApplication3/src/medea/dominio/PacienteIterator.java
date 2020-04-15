// PacienteIterator.java

package medea.dominio;
import java.util.*;

public class PacienteIterator {

     /////////////////////////////////////////////////////////////////////

     ListIterator listIterator;

     ///////////////////////////////////////////////////////////////////// 
 
     PacienteIterator(ColeccionPacientes coleccionPacientes){
          this.listIterator = coleccionPacientes.listIterator();
     }
     public boolean hasNextPaciente(){
          return this.listIterator.hasNext();
     }
     public Paciente nextPaciente(){
          return (Paciente) this.listIterator.next();
     }
     public void removePaciente(){
          this.listIterator.remove();
     }
     public boolean hasPreviousPaciente(){
          return this.listIterator.hasPrevious();
     }
     public void addPaciente(Paciente paciente){
          this.listIterator.add(paciente);
     }
     public void setPaciente(Paciente paciente){
          this.listIterator.set(paciente);
     }

     /////////////////////////////////////////////////////////////////////

}

