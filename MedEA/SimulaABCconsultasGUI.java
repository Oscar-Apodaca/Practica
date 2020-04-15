// TestABCconsultas.java

import medea.dominio.*;
import medea.gui.*;
import java.io.*;

public class SimulaABCconsultasGUI{

     

     public static void main(String [] args){
            
          ////////////////////////////////////////////////////

                    
          Medico             medicoMEDEA;
          ColeccionPacientes pacientesMEDEA;
          Paciente           objetoPaciente; 
          Consulta           objetoConsulta;
          ColeccionConsultas consultasMEDEA; 

          ////////////////////////////////////////////////////                   
          // RECUPERACION  --> objeto Medico

          medicoMEDEA = new Medico();
          
          try {
               medicoMEDEA = medicoMEDEA.loadMedico("C:/DAPonLine/DBase/DBaseOOmedea.dat");
          } catch(Exception e){
               System.out.println("Error en loadMedico() " + e.getMessage());
          }          
  
          ////////////////////////////////////////////////////
          // ALTAS--> Insercion de consultas          

          PacienteIterator pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
          
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();
               ABCmedea.altaConsulta(new Consulta(), "2003/Feb/01", "Laringitis", "Penicilina X", objetoPaciente);
               ABCmedea.altaConsulta(new Consulta(), "2003/Feb/10", "Faringitis", "Penprocilo Z", objetoPaciente);
               ABCmedea.altaConsulta(new Consulta(), "2003/Feb/20", "XXXXXXXXXX", "Aspirina",     objetoPaciente);
               ABCmedea.altaConsulta(new Consulta(), "2003/Feb/25", "AAAAAAAAAA", "Mejoral",      objetoPaciente);
          }
                     
          ////////////////////////////////////////////////////
          // BAJAS--> Insercion de consultas          

          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
          
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();                             
               ABCmedea.bajaConsulta(ABCmedea.busquedaConsulta("2003/Feb/20", objetoPaciente));                   
          }
          
          ////////////////////////////////////////////////////
          // CAMBIOS  --> 
          
          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
          
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();  
                           
               objetoConsulta = new Consulta();
               objetoConsulta.setFechaConsulta("2003/Feb/25");
               objetoConsulta.setPadecimientoConsulta("Catarro   "); 
         
               ABCmedea.cambioConsulta(ABCmedea.busquedaConsulta("2003/Feb/25", objetoPaciente), objetoConsulta);                                                     
          }        
          
          ////////////////////////////////////////////////////
 
          ////////////////////////////////////////////////////
          // ALMACENAMIENTO --> objeto Medico

          try {
               medicoMEDEA.saveMedico("C:/DAPonLine/DBase/DBaseOOmedea.dat");
          } catch(Exception e){
               System.out.println("Error en saveMedico() " +  e.getMessage());
          }
          
          ////////////////////////////////////////////////////                   
          // RECUPERACION  --> objeto Medico

          medicoMEDEA = new Medico();
          
          try {
               medicoMEDEA = medicoMEDEA.loadMedico("C:/DAPonLine/DBase/DBaseOOmedea.dat");
          } catch(Exception e){
               System.out.println("Error en loadMedico() " + e.getMessage());
          }
                               
          ////////////////////////////////////////////////////          
          // SORTS --> Pacientes (padecimiento)

          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
                    
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();
               objetoPaciente.getColeccionConsultas().sortColeccionConsultas("padecimientoConsulta");               
          }
                    
          ////////////////////////////////////////////////////          
          // SORTS --> Pacientes (fecha)

          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
                    
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();
               objetoPaciente.getColeccionConsultas().sortColeccionConsultas("fechaConsulta");
               ABCmedea.desplegarColecccionConsultas(objetoPaciente);               
          }
          
          
          ////////////////////////////////////////////////////          
          // SORTS --> Pacientes (default)

          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
                   
          while( pacienteIterator.hasNextPaciente() ){
               objetoPaciente = pacienteIterator.nextPaciente();
               System.out.println(objetoPaciente.getNombrePaciente());
               objetoPaciente.getColeccionConsultas().sortColeccionConsultas();
               ABCmedea.desplegarColecccionConsultas(objetoPaciente);               
          }

         System.out.println("\n\nOperaciones en DBaseOOmedea --->> \nSe simulo el registro de diagnosticos para los pacientes en la base de datos OO.  \n\n");
                    
     }              

}



