// ColeccionConsultas.java

package medea.dominio;
import java.io.*;
import java.util.*;

public class ColeccionConsultas extends ArrayList implements Serializable{
     
     //////////////////////////////////////////////////////////////////////
                  
     public ColeccionConsultas(){          
          
     }      
      
     //////////////////////////////////////////////////////////////////////

     public boolean addConsulta(Consulta consulta){
          return super.add(consulta);              
     }
     public boolean removeConsulta(Consulta consulta){
          return super.remove(consulta); 
     }
     public int sizeColeccionConsultas(){
          return super.size();
     }
     public void sortColeccionConsultas(){
          Collections.sort(this);
     } 
     public void sortColeccionConsultas(String opcionSort){
          if (opcionSort.equals("fechaConsulta")){
             Collections.sort(this, new FechaConsultaComparator() );
          }  else if (opcionSort.equals("padecimientoConsulta")){
             Collections.sort(this, new PadecimientoConsultaComparator() );
          }
     }     
     public ConsultaIterator consultaIterator(){ 
          return new ConsultaIterator(this);
     }

     //////////////////////////////////////////////////////////////////////

     private class FechaConsultaComparator  implements Comparator {
          public int compare(Object consulta, Object consultaComparada){
               String fechaConsulta = ((Consulta)consulta).getFechaConsulta();
               String fechaConsultaComparada = ((Consulta)consultaComparada).getFechaConsulta();
               return fechaConsulta.compareTo(fechaConsultaComparada);
          }
     }
     private class PadecimientoConsultaComparator implements Comparator {
          public int compare(Object consulta, Object consultaComparada){
               String padecimientoConsulta = ((Consulta)consulta).getPadecimientoConsulta();
               String padecimientoConsultaComparada = ((Consulta)consultaComparada).getPadecimientoConsulta();
               return padecimientoConsulta.compareTo(padecimientoConsultaComparada);
          }
     }

     //////////////////////////////////////////////////////////////////////
          
}
