//ABCpacientesGUI.java

package medea.gui;

import medea.dominio.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ABCpacientesGUI extends Frame{

     Medico medicoMEDEA;
     PacienteIterator pacienteIterator;

     Paciente pacienteActual;
     Paciente pacienteNuevo;

  
     Panel panelPacientes;

     Panel panelDatosPacientes;
     Panel panelControlesPacientes;

     Panel panelRegistroDatosPacientes;
     Panel panelImagenDatosPacientes;

     Label labelClavePaciente;
     Label labelNombrePaciente;
     Label labelRutaFotoPaciente;

     TextField textFieldClavePaciente;
     TextField textFieldNombrePaciente;
     TextField textFieldRutaFotoPaciente; 

     JLabel jLabelFotoPaciente;

     Button buttonInsertarPaciente;
     Button buttonCursorPacientes;
     Button buttonActualizarPaciente; 
     Button buttonEliminarPaciente;     


     public ABCpacientesGUI(Medico medico) {
          super();

          this.medicoMEDEA = medico;
          pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();

          this.pacienteActual = null;
          pacienteNuevo = null;


          this.setTitle("Colección de Pacientes"); 
          this.addWindowListener(new CloseHandler(this)); 

          panelPacientes = new Panel();

          panelDatosPacientes = new Panel();
          panelControlesPacientes = new Panel(); 

          panelRegistroDatosPacientes = new Panel();
          panelImagenDatosPacientes = new Panel();

          labelClavePaciente    = new Label ("Clave del Paciente:");
          labelNombrePaciente   = new Label ("Nombre del Paciente:");
          labelRutaFotoPaciente = new Label ("Fotografía del Paciente:");

          textFieldClavePaciente    = new TextField ();
          textFieldNombrePaciente   = new TextField ();
          textFieldRutaFotoPaciente = new TextField ();
          textFieldRutaFotoPaciente.addActionListener(new RutaFotoPacienteHandler(this));

          jLabelFotoPaciente = new JLabel(new ImageIcon("C:/DAPonLine/fotos/pacientes/T0.gif"));
          jLabelFotoPaciente.setPreferredSize(new Dimension (75,75));

          buttonInsertarPaciente = new Button("Nuevo Paciente");
          buttonInsertarPaciente.addActionListener(new InsertarPacienteHandler(this));  

          buttonCursorPacientes = new Button("Ver Pacientes");
          buttonCursorPacientes.addActionListener(new CursorPacientesHandler(this));  

          buttonEliminarPaciente = new Button("Eliminar Paciente");
          buttonEliminarPaciente.addActionListener(new EliminarPacienteHandler(this));  

          buttonActualizarPaciente = new Button("Actualizar Paciente");
          buttonActualizarPaciente.addActionListener(new ActualizarPacienteHandler(this));                   
          
     }


     public void launchFrame() {    
       
          panelRegistroDatosPacientes.setLayout(new GridLayout(3,2));
          
          panelRegistroDatosPacientes.add(labelClavePaciente);
          panelRegistroDatosPacientes.add(textFieldClavePaciente);
          panelRegistroDatosPacientes.add(labelNombrePaciente);
          panelRegistroDatosPacientes.add(textFieldNombrePaciente);
          panelRegistroDatosPacientes.add(labelRutaFotoPaciente);
          panelRegistroDatosPacientes.add(textFieldRutaFotoPaciente);
          

          panelImagenDatosPacientes.setLayout(new FlowLayout());
          
          panelImagenDatosPacientes.add(jLabelFotoPaciente);


          panelDatosPacientes.setLayout(new BorderLayout());

          panelDatosPacientes.add(panelRegistroDatosPacientes, BorderLayout.CENTER);
          panelDatosPacientes.add(panelImagenDatosPacientes, BorderLayout.EAST);
          

          panelControlesPacientes.setLayout(new FlowLayout());
          
          
          panelControlesPacientes.add(buttonCursorPacientes);
          panelControlesPacientes.add(buttonActualizarPaciente);
          panelControlesPacientes.add(buttonEliminarPaciente);
          panelControlesPacientes.add(buttonInsertarPaciente);


          panelPacientes.setLayout(new BorderLayout());
          
          panelPacientes.add(panelDatosPacientes, BorderLayout.CENTER);
          panelPacientes.add(panelControlesPacientes, BorderLayout.NORTH);
          

          this.setLayout(new BorderLayout());
          this.add(panelPacientes, BorderLayout.CENTER);                             

          this.pack();
          this.setVisible(true);
     }  

     public Paciente getPacienteActual(){
          return this.pacienteActual;
     }          
  
     public void desplegarDatosPaciente(Paciente paciente){
          if (paciente != null){               

               Integer intClavePaciente = new Integer(pacienteActual.getClavePaciente());                    
               textFieldClavePaciente.setText(intClavePaciente.toString());
               textFieldNombrePaciente.setText(pacienteActual.getNombrePaciente());
               textFieldRutaFotoPaciente.setText(pacienteActual.getRutaFotoPaciente());
                     
               jLabelFotoPaciente.setIcon(new ImageIcon(pacienteActual.getRutaFotoPaciente()));

          } else {
               textFieldClavePaciente.setText("");
               textFieldNombrePaciente.setText("");
               textFieldRutaFotoPaciente.setText(""); 
               jLabelFotoPaciente.setIcon(new ImageIcon("C:/DAPonLine/fotos/pacientes/T0.gif"));

          } 
     }     
  
     private class CloseHandler extends WindowAdapter {
         ABCpacientesGUI frameABCpacientesGUI;

         public CloseHandler(ABCpacientesGUI frameABCpacientesGUI){
              this.frameABCpacientesGUI = frameABCpacientesGUI;
         }
         public void windowClosing(WindowEvent e) {  
              System.out.println("Hace invisible el objeto ABCpacientesGUI");            
              frameABCpacientesGUI.setVisible(false);
         }
     }

     private class RutaFotoPacienteHandler implements ActionListener {
         ABCpacientesGUI frameABCpacientesGUI;

         public RutaFotoPacienteHandler(ABCpacientesGUI frameABCpacientesGUI){
              this.frameABCpacientesGUI = frameABCpacientesGUI;
         }
          public void actionPerformed(ActionEvent e) { 
               FileDialog fileDlgFotoPaciente = new FileDialog(frameABCpacientesGUI, "Ruta Foto Pacientes");
               fileDlgFotoPaciente.setVisible(true);
               textFieldRutaFotoPaciente.setText(fileDlgFotoPaciente.getDirectory() + fileDlgFotoPaciente.getFile() );
               jLabelFotoPaciente.setIcon(new ImageIcon(fileDlgFotoPaciente.getDirectory() + fileDlgFotoPaciente.getFile()));                
                                         
          }   
     }

     private class InsertarPacienteHandler implements ActionListener {
          ABCpacientesGUI frameABCpacientesGUI;

          public InsertarPacienteHandler(ABCpacientesGUI frameABCpacientesGUI){
               this.frameABCpacientesGUI = frameABCpacientesGUI;
          }
          public void actionPerformed(ActionEvent e) { 

               Integer intClavePaciente = new Integer(medicoMEDEA.getColeccionPacientes().sizeColeccionPacientes());
               intClavePaciente = new Integer( intClavePaciente.intValue() + 1);

               if (pacienteNuevo == null){                     
                  
                    desplegarDatosPaciente(pacienteNuevo); 
                    textFieldClavePaciente.setText(intClavePaciente.toString());
                    pacienteActual = null;
                    pacienteNuevo = new Paciente(); 
                    buttonInsertarPaciente.setLabel("Grabar Paciente");     

                    frameABCpacientesGUI.setTitle("Colección de Pacientes -> " + "Paciente Nuevo");                    
                                                           
               } else {                                           
                 
                    pacienteNuevo.setClavePaciente(intClavePaciente.intValue());                    
                    pacienteNuevo.setNombrePaciente(textFieldNombrePaciente.getText());
                    pacienteNuevo.setRutaFotoPaciente(textFieldRutaFotoPaciente.getText()); 
                    pacienteNuevo.setColeccionConsultas(new ColeccionConsultas());

                    ListIterator listPacienteIterator = medicoMEDEA.getColeccionPacientes().listIterator();
                    listPacienteIterator.add(pacienteNuevo);
                    pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator(); 
                    pacienteActual = pacienteIterator.nextPaciente();                            
  
                    pacienteNuevo = null; 
                    buttonInsertarPaciente.setLabel("Nuevo Paciente "); 

                    frameABCpacientesGUI.setTitle("Colección de Pacientes -> " + pacienteActual.getNombrePaciente());
               }
          }   
     }  

     private class CursorPacientesHandler implements ActionListener {
          ABCpacientesGUI frameABCpacientesGUI;

          public CursorPacientesHandler(ABCpacientesGUI frameABCpacientesGUI){
               this.frameABCpacientesGUI = frameABCpacientesGUI;
          }
          public void actionPerformed(ActionEvent e) { 
            
               if( pacienteIterator.hasNextPaciente() ){

                    pacienteActual = pacienteIterator.nextPaciente();
                    desplegarDatosPaciente(pacienteActual);

                    frameABCpacientesGUI.setTitle("Colección de Pacientes -> " + pacienteActual.getNombrePaciente());
              
               }else {
                    pacienteActual = null; 
                    desplegarDatosPaciente(pacienteActual);
                    pacienteIterator = medicoMEDEA.getColeccionPacientes().pacienteIterator();

                    frameABCpacientesGUI.setTitle("Colección de Pacientes -> " + "Fin Colección");                                       
               }                              
          }   
     }
     
     private class EliminarPacienteHandler implements ActionListener {
          ABCpacientesGUI frameABCpacientesGUI;

          public EliminarPacienteHandler(ABCpacientesGUI frameABCpacientesGUI){
               this.frameABCpacientesGUI = frameABCpacientesGUI;
          }
          public void actionPerformed(ActionEvent e) { 
               if(pacienteActual != null){
                    pacienteIterator.removePaciente();
                    pacienteActual = null;
                    desplegarDatosPaciente(pacienteActual);

                    frameABCpacientesGUI.setTitle("Colección de Pacientes -> " + "Paciente Eliminado");
               }                           
          }   
     }

     private class ActualizarPacienteHandler implements ActionListener {
          ABCpacientesGUI frameABCpacientesGUI;

          public ActualizarPacienteHandler(ABCpacientesGUI frameABCpacientesGUI){
               this.frameABCpacientesGUI = frameABCpacientesGUI;
          }
          public void actionPerformed(ActionEvent e) { 
               if(pacienteActual != null){
                    Integer intClavePaciente = new Integer(textFieldClavePaciente.getText());
                    pacienteActual.setClavePaciente(intClavePaciente.intValue());
                    pacienteActual.setNombrePaciente(textFieldNombrePaciente.getText());
                    pacienteActual.setRutaFotoPaciente(textFieldRutaFotoPaciente.getText());      
               }                           
          }   
     }  
}











