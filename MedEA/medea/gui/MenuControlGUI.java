//MenuControlGUI.java

package medea.gui;

import medea.dominio.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class MenuControlGUI {

     /////////////////////////////////////////////
     // Referencias de Control de la Base de Datos
     /////////////////////////////////////////////

     Medico medicoMEDEA;

     Paciente pacienteActual;
     Consulta consultaActual;
  
        
     /////////////////////////////////////////////
     // Objetos Visuales 
     /////////////////////////////////////////////
     
     /////////////////////////////////////////////
     // Frames para contener las distintas GUIs
     /////////////////////////////////////////////

     Frame frameMenuControl; 
     ABCpacientesGUI frameABCpacientesGUI;
     ABCconsultasGUI frameABCconsultasGUI;
           

     /////////////////////////////////////////////
     // Objetos del Menu de Control 
     /////////////////////////////////////////////

     MenuBar   infoMenuBar;
     
     Menu      pacientesMenu;
     Menu      consultasMenu;
     Menu      dBaseMenu;

     MenuItem  frameABCpacientesGUIMenuItem;
     MenuItem  sortClavePacienteMenuItem;
     MenuItem  sortNombrePacienteMenuItem;

     MenuItem  frameABCconsultasGUIMenuItem;
     MenuItem  sortFechaConsultaMenuItem;
     MenuItem  sortPadecimientoConsultaMenuItem;     

     MenuItem  nuevaDBaseMenuItem;
     MenuItem  guardarDBaseMenuItem;     

     //////////////////////////////////////////////////////

     public MenuControlGUI() {
          
          ////////////////////////////////////////////////////// 

          medicoMEDEA = abrirDBaseMEDEA();

          pacienteActual = null;
          consultaActual = null;
         
          ////////////////////////////////////////////////////// 
          
          infoMenuBar = new MenuBar();
             
          pacientesMenu = new Menu("Pacientes");
          consultasMenu = new Menu("Consultas");
          dBaseMenu = new Menu("DBase");  
          


          frameABCpacientesGUIMenuItem = new MenuItem("Colección Pacientes");
          frameABCpacientesGUIMenuItem.addActionListener(new ABCpacientesGUIHandler());    

          sortClavePacienteMenuItem = new MenuItem("Clasificar por Clave");
          sortClavePacienteMenuItem.addActionListener(new SortClavePacienteHandler());
    
          sortNombrePacienteMenuItem = new MenuItem("Clasificar por Nombre");  
          sortNombrePacienteMenuItem.addActionListener(new SortNombrePacienteHandler());



          frameABCconsultasGUIMenuItem = new MenuItem("Coleccion Consultas");
          frameABCconsultasGUIMenuItem.addActionListener(new ABCconsultasGUIHandler()); 

          sortFechaConsultaMenuItem = new MenuItem("Clasificar por Fecha");
          sortFechaConsultaMenuItem.addActionListener(new SortFechaConsultaHandler());
    
          sortPadecimientoConsultaMenuItem = new MenuItem("Clasificar por Diagnóstico");  
          sortPadecimientoConsultaMenuItem.addActionListener(new SortPadecimientoConsultaHandler());   



          guardarDBaseMenuItem = new MenuItem("Guardar Base de Datos"); 
          guardarDBaseMenuItem.addActionListener(new GuardarDBaseHandler());         

          nuevaDBaseMenuItem = new MenuItem("Nueva Base de Datos"); 
          nuevaDBaseMenuItem.addActionListener(new NuevaDBaseHandler());     

          //////////////////////////////////////////////////////

          frameMenuControl = new Frame("MedEA: Medical Enterprise Automation");           
          frameMenuControl.addWindowListener(new CloseHandler());  

          frameABCpacientesGUI = null;
          frameABCconsultasGUI = null;   

          //////////////////////////////////////////////////////
           
     }


     public void launchFrame() {    
       
          ////////////////////////////////////////////////////// 
           
          infoMenuBar.add(pacientesMenu);
          infoMenuBar.add(consultasMenu);
          infoMenuBar.add(dBaseMenu);    
      
          pacientesMenu.add(frameABCpacientesGUIMenuItem);
          pacientesMenu.add(sortClavePacienteMenuItem);
          pacientesMenu.add(sortNombrePacienteMenuItem);

          consultasMenu.add(frameABCconsultasGUIMenuItem);
          consultasMenu.add(sortFechaConsultaMenuItem);
          consultasMenu.add(sortPadecimientoConsultaMenuItem);

          dBaseMenu.add(guardarDBaseMenuItem);
          dBaseMenu.add(nuevaDBaseMenuItem);                      
            
          ////////////////////////////////////////////////////// 

          frameMenuControl.setMenuBar(infoMenuBar);
          frameMenuControl.setSize(500,50);
          frameMenuControl.setResizable(false);                     
          frameMenuControl.setVisible(true);
          
          ////////////////////////////////////////////////////// 
     }
     

     //////////////////////////////////////////////////////////////////////////////////
     // DBase IO
     //////////////////////////////////////////////////////////////////////////////////
         
     public Medico abrirDBaseMEDEA(){
          Medico medico = new Medico();                    
          try {
               medico = medico.loadMedico("C:/DAPonLine/DBase/DBaseOOmedea.dat");
          } catch(Exception e){
               System.out.println("Error en loadMedico() " + e.getMessage());
          } 
          return medico;
     } 

     public void cerrarDBaseMEDEA(Medico medico){                
          try {
               medico.saveMedico("C:/DAPonLine/DBase/DBaseOOmedea.dat");
          } catch(Exception e){
               System.out.println("Error en saveMedico() " + e.getMessage());
          }         
     }         

     private class CloseHandler extends WindowAdapter {
         public void windowClosing(WindowEvent e) {
              cerrarDBaseMEDEA(medicoMEDEA);
              System.exit(0);
         }
     }


     //////////////////////////////////////////////////////////////////////////////////
     // Monitoreo de la Coleccion de Pacientes
     //////////////////////////////////////////////////////////////////////////////////
         

     private class ABCpacientesGUIHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) {  
               if(frameABCpacientesGUI == null){               
                    frameABCpacientesGUI = new ABCpacientesGUI(medicoMEDEA);                    
                    frameABCpacientesGUI.launchFrame();                                     
               } else {
                    frameABCpacientesGUI.setVisible(true);
               }
          }   
     }           

     private class SortClavePacienteHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) { 
               medicoMEDEA.getColeccionPacientes().sortColeccionPacientes("clavePaciente");                                 
          }   
     }

     private class SortNombrePacienteHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) { 
               medicoMEDEA.getColeccionPacientes().sortColeccionPacientes("nombrePaciente");                                 
          }   
     }



     //////////////////////////////////////////////////////////////////////////////////
     // Monitoreo de la Coleccion de Consultas
     //////////////////////////////////////////////////////////////////////////////////
         

     private class ABCconsultasGUIHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) {                                
               if(frameABCpacientesGUI != null){ 

                    pacienteActual = frameABCpacientesGUI.getPacienteActual();
                    
                    if(pacienteActual != null){
                         System.out.println("pacienteActual --> " + pacienteActual);

                         if(frameABCconsultasGUI != null){
                              frameABCconsultasGUI.dispose();                              
                         }

                         frameABCconsultasGUI = new ABCconsultasGUI(pacienteActual);                    
                         frameABCconsultasGUI.launchFrame();
                       
                    } else {
                         System.out.println("pacienteActual --> null ");
                    }
               } else {
                    System.out.println("frameABCpacientesGUI --> null");
               }
          }   
     }           

     private class SortFechaConsultaHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) { 
               if(pacienteActual != null){
                    pacienteActual.getColeccionConsultas().sortColeccionConsultas("fechaConsulta");
               }                                 
          }   
     }

     private class SortPadecimientoConsultaHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) { 
               if(pacienteActual != null){
                    pacienteActual.getColeccionConsultas().sortColeccionConsultas("padecimientoConsulta");
               }                                
          }   
     }



     //////////////////////////////////////////////////////////////////////////////////
     // Monitoreo de los Servicios DBase
     //////////////////////////////////////////////////////////////////////////////////
         

     private class NuevaDBaseHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) {                
               medicoMEDEA.setNombreMedico("Dr. Medea");
               medicoMEDEA.setClaveMedico(1);          
               medicoMEDEA.setColeccionPacientes(new ColeccionPacientes()); 

               pacienteActual = null;
               consultaActual = null;                                         
          }   
     }

     private class GuardarDBaseHandler implements ActionListener {
          public void actionPerformed(ActionEvent e) {
               cerrarDBaseMEDEA(medicoMEDEA);
          }   
     }
    

}











