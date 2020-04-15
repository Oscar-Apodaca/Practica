// ConsultaIterator.java

package medea.dominio;
import java.util.*;

public class ConsultaIterator {

     /////////////////////////////////////////////////////////////////////

     private ListIterator listIterator;

     ///////////////////////////////////////////////////////////////////// 
 
     ConsultaIterator(ColeccionConsultas coleccionConsultas){
          this.listIterator = coleccionConsultas.listIterator();
     }
     public boolean hasNextConsulta(){
          return this.listIterator.hasNext();
     }
     public Consulta nextConsulta(){
          return (Consulta) this.listIterator.next();
     }
     public void removeConsulta(){
          this.listIterator.remove();
     }
     public boolean hasPreviousConsulta(){
          return this.listIterator.hasPrevious();
     }
     public void addConsulta(Consulta consulta){
          this.listIterator.add(consulta);
     }
     public void setConsulta(Consulta consulta){
          this.listIterator.set(consulta);
     }

     /////////////////////////////////////////////////////////////////////

}

