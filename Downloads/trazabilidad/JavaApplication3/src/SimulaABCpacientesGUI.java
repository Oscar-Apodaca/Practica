// TestABC.java

import medea.dominio.*;
import medea.gui.*;
import java.io.*;

public class SimulaABCpacientesGUI{

     

     public static void main(String [] args){
            
                  
          Medico             medicoMEDEA    = new Medico();
          ColeccionPacientes pacientesMEDEA = new ColeccionPacientes();
          Paciente           objetoPaciente = new Paciente();  

          ////////////////////////////////////////////////////
          //ALTA --> Medico

          ABCmedea.altaMedico(medicoMEDEA = new Medico(), 1, "Dra. Medea", pacientesMEDEA = new ColeccionPacientes());           

          ////////////////////////////////////////////////////       
          // Procesamiento de los Pacientes del Medico
          ////////////////////////////////////////////////////       

          pacientesMEDEA = medicoMEDEA.getColeccionPacientes();

          ////////////////////////////////////////////////////
          //ALTAS --> Pacientes
          
          ABCmedea.altaPaciente(new Paciente(), 1, "Sofia Loren",     "C:/DAPonLine/fotos/pacientes/T14.gif", new ColeccionConsultas(), medicoMEDEA);         
          ABCmedea.altaPaciente(new Paciente(), 2, "Alain Delon",     "C:/DAPonLine/fotos/pacientes/T1.gif", new ColeccionConsultas(), medicoMEDEA);
          ABCmedea.altaPaciente(new Paciente(), 3, "Victoria Mayo",   "C:/DAPonLine/fotos/pacientes/T7.gif", new ColeccionConsultas(), medicoMEDEA);
          ABCmedea.altaPaciente(new Paciente(), 4, "Anthony Perkins", "C:/DAPonLine/fotos/pacientes/T4.gif", new ColeccionConsultas(), medicoMEDEA);
          ABCmedea.altaPaciente(new Paciente(), 5, "EEEEEEEEEEEEEEE", "C:/DAPonLine/fotos/pacientes/T5.gif", new ColeccionConsultas(), medicoMEDEA); 
          ABCmedea.altaPaciente(new Paciente(), 6, "AAAAAAAAAAAAAAA", "C:/DAPonLine/fotos/pacientes/T6.gif", new ColeccionConsultas(), medicoMEDEA);         

                   
          ////////////////////////////////////////////////////
          // BAJAS  --> 
          
          // Eliminacion de un Paciente: /////////////////////////                    
          
                                      
          ABCmedea.bajaPaciente(ABCmedea.busquedaPaciente("EEEEEEEEEEEEEEE", medicoMEDEA));                   

          
          ////////////////////////////////////////////////////
          // CAMBIOS  --> Paciente
          
          // Sustituion de los datos de un Paciente: /////////////////////////                             
          
          objetoPaciente = new Paciente();
          objetoPaciente.setNombrePaciente("Jhon Wayne");
          objetoPaciente.setClavePaciente(5); 
         
          ABCmedea.cambioPaciente(ABCmedea.busquedaPaciente("AAAAAAAAAAAAAAA", medicoMEDEA), objetoPaciente); 
                                 
          ////////////////////////////////////////////////////
          // CONSULTAS  --> Iteracion de Pacientes          

          PacienteIterator pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();
          
          ////////////////////////////////////////////////////          
          // SORTS --> Pacientes (default)

          medicoMEDEA.getColeccionPacientes().sortColeccionPacientes();

          
          ////////////////////////////////////////////////////
          // SORTS --> Pacientes (nombrePaciente) 

          medicoMEDEA.getColeccionPacientes().sortColeccionPacientes("nombrePaciente");

          
          ////////////////////////////////////////////////////
          // SORTS --> Pacientes (clavePaciente) 

          medicoMEDEA.getColeccionPacientes().sortColeccionPacientes("clavePaciente");

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
          // PERSISTENCIA --> Recuperacion de la Base de Datos OO

          System.out.println("\n\nCreacion de DBaseOOmedea --->> \nSimula el trabajo con 5 pacientes en la base de datos OO:  \n\n");
          ABCmedea.desplegarColecccionPacientes(medicoMEDEA);
          
          
     }              

}



