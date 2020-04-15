// MedicoIO.java

package medea.datos;
import medea.dominio.*;
import java.io.*;

public class MedicoIO{         
     
     public static void saveMedico(Medico medico, String nombreArchivoMedico) 
          throws Exception{
          ObjectOutputStream oos = null;
          try {
               oos = new ObjectOutputStream(new FileOutputStream(nombreArchivoMedico));       
               oos.writeObject(medico);
          }
          finally {
               if (oos != null) oos.close();
          }   
     }

     //////////////////////////////////////////////////////////////////////

     public static Medico loadMedico(String nombreArchivoMedico) 
          throws Exception {
          ObjectInputStream ois = null;
          Medico medico = null;
          try {
               ois = new ObjectInputStream(new FileInputStream(nombreArchivoMedico));                    
               medico = (Medico)ois.readObject();               
          }              
          finally {
               if (ois != null) ois.close();
          }
          return medico;
    }   
}