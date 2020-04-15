// ABCmedea.java

package medea.gui;
import medea.dominio.*;
import java.io.*;

public class ABCmedea{

     public static void desplegarColecccionPacientes(Medico medicoMEDEA){   

          PacienteIterator pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
          Paciente objetoPaciente;
           
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();
               System.out.print(objetoPaciente.getClavePaciente() + " ) ");
               System.out.print(objetoPaciente.getNombrePaciente());
               System.out.println(" --->> " +
                  objetoPaciente.getMedico().getNombreMedico() );   
          }           
     }

     public static void altaMedico(Medico medico, int claveMedico, String nombreMedico, ColeccionPacientes coleccionPacientes) {
          medico.setClaveMedico(claveMedico);
          medico.setNombreMedico(nombreMedico);
          medico.setColeccionPacientes(coleccionPacientes);          
     }
     
     public static void altaPaciente(Paciente paciente , int clavePaciente, String nombrePaciente, String rutaFotoPaciente, ColeccionConsultas consultas, Medico medico){          
          paciente.setClavePaciente(clavePaciente); 
          paciente.setNombrePaciente(nombrePaciente);
          paciente.setRutaFotoPaciente(rutaFotoPaciente);
          paciente.setColeccionConsultas(consultas);          
          paciente.setMedico(medico);


          medico.getColeccionPacientes().addPaciente(paciente); 
     }
     
     public static void bajaPaciente(Paciente paciente){

          paciente.getMedico().getColeccionPacientes().removePaciente(paciente); 
      
     }
 
     public static void cambioPaciente(Paciente paciente, Paciente nuevoPaciente){

          paciente.setClavePaciente(nuevoPaciente.getClavePaciente());
          paciente.setNombrePaciente(nuevoPaciente.getNombrePaciente());
     
     }

     public static Paciente busquedaPaciente(String nombrePacienteBuscado, Medico medico){

          Paciente paciente = null;
          PacienteIterator pacienteIterator = medico.getColeccionPacientes().pacienteIterator();
                 
          if ( pacienteIterator.hasNextPaciente() ){ 
              do {
                  paciente = pacienteIterator.nextPaciente(); 
                  if(paciente.getNombrePaciente().equals(nombrePacienteBuscado) ){                       
                       return paciente;
                  } else {
                       paciente = null;
                  }        
              } while( ( paciente == null ) && ( pacienteIterator.hasNextPaciente() ) );  
          }
          
          return paciente;
     }

     //////////////////////////////////////////////////////////////////////////////////////

     public static void desplegarColecccionConsultas(Paciente paciente){   

          ConsultaIterator consultaIterator = paciente.getColeccionConsultas().consultaIterator();
          Consulta objetoConsulta;
           
          while( consultaIterator.hasNextConsulta() ){
               objetoConsulta = consultaIterator.nextConsulta();
               System.out.print(objetoConsulta.getFechaConsulta() + " > ");
               System.out.print(objetoConsulta.getPadecimientoConsulta());
               System.out.println(" --->> " +
                  objetoConsulta.getPaciente().getNombrePaciente() );   
          }           
     }


     public static void altaConsulta(Consulta consulta , String fechaConsulta, String padecimientoConsulta, String tratamientoConsulta,Paciente paciente){          
          consulta.setFechaConsulta(fechaConsulta); 
          consulta.setPadecimientoConsulta(padecimientoConsulta);
          consulta.setTratamientoConsulta(tratamientoConsulta);
          consulta.setPaciente(paciente);

          paciente.getColeccionConsultas().addConsulta(consulta); 
     }
     
     public static void bajaConsulta(Consulta consulta){

          consulta.getPaciente().getColeccionConsultas().removeConsulta(consulta); 
      
     }
 
     public static void cambioConsulta(Consulta consulta, Consulta nuevaConsulta){

          consulta.setFechaConsulta(nuevaConsulta.getFechaConsulta());
          consulta.setPadecimientoConsulta(nuevaConsulta.getPadecimientoConsulta());
     
     }

     public static Consulta busquedaConsulta(String fechaConsultaBuscada, Paciente paciente){

          Consulta consulta = null;
          ConsultaIterator consultaIterator = paciente.getColeccionConsultas().consultaIterator();
                 
          if ( consultaIterator.hasNextConsulta() ){ 
              do {
                  consulta = consultaIterator.nextConsulta(); 
                  if(consulta.getFechaConsulta().equals(fechaConsultaBuscada) ){                       
                       return consulta;
                  } else {
                       consulta = null;
                  }        
              } while( ( consulta == null ) && ( consultaIterator.hasNextConsulta() ) );  
          }
          
          return consulta;
     }


}



