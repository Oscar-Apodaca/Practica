//ABCconsultasGUI.java

package medea.gui;

import medea.dominio.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class ABCconsultasGUI extends Frame{

     Paciente pacienteMEDEA;
     ConsultaIterator consultaIterator;

     Consulta consultaActual;
     Consulta consultaNueva;

  
     Panel panelConsultas;

     Panel panelDatosConsultas;
     Panel panelControlesConsultas;

     Label labelFechaConsulta;
     Label labelPadecimientoConsulta;
     Label labelTratamientoConsulta;

     TextField textFieldFechaConsulta;
     TextField textFieldPadecimientoConsulta;
     TextField textFieldTratamientoConsulta; 

     Button buttonInsertarConsulta;
     Button buttonCursorConsultas;
     Button buttonActualizarConsulta; 
     Button buttonEliminarConsulta;     


     public ABCconsultasGUI(Paciente paciente) {
          super();

          this.pacienteMEDEA = paciente;
          consultaIterator = pacienteMEDEA.getColeccionConsultas().consultaIterator();

          this.consultaActual = null;
          consultaNueva = null;


          this.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente()); 
          this.addWindowListener(new CloseHandler(this)); 

          panelConsultas = new Panel();

          panelDatosConsultas = new Panel();
          panelControlesConsultas = new Panel(); 

          labelFechaConsulta    = new Label ("Fecha de la Consulta:");
          labelPadecimientoConsulta   = new Label ("Diagnóstico:");
          labelTratamientoConsulta = new Label ("Tratamiento:");

          textFieldFechaConsulta    = new TextField ();
          textFieldPadecimientoConsulta   = new TextField ();
          textFieldTratamientoConsulta = new TextField ();

          buttonInsertarConsulta = new Button("Nueva Consulta");
          buttonInsertarConsulta.addActionListener(new InsertarConsultaHandler(this));  

          buttonCursorConsultas = new Button("Ver Consultas");
          buttonCursorConsultas.addActionListener(new CursorConsultasHandler(this));  

          buttonEliminarConsulta = new Button("Eliminar Consulta");
          buttonEliminarConsulta.addActionListener(new EliminarConsultaHandler(this));  

          buttonActualizarConsulta = new Button("Actualizar Consulta");
          buttonActualizarConsulta.addActionListener(new ActualizarConsultaHandler(this));                   
          
     }


     public void launchFrame() {    
       
          panelDatosConsultas.setLayout(new GridLayout(3,2));
          
          panelDatosConsultas.add(labelFechaConsulta);
          panelDatosConsultas.add(textFieldFechaConsulta);
          panelDatosConsultas.add(labelPadecimientoConsulta);
          panelDatosConsultas.add(textFieldPadecimientoConsulta);
          panelDatosConsultas.add(labelTratamientoConsulta);
          panelDatosConsultas.add(textFieldTratamientoConsulta);
          
 
          panelControlesConsultas.setLayout(new FlowLayout());    
          
          panelControlesConsultas.add(buttonCursorConsultas);
          panelControlesConsultas.add(buttonActualizarConsulta);
          panelControlesConsultas.add(buttonEliminarConsulta);
          panelControlesConsultas.add(buttonInsertarConsulta);


          panelConsultas.setLayout(new BorderLayout());
          
          panelConsultas.add(panelDatosConsultas, BorderLayout.CENTER);
          panelConsultas.add(panelControlesConsultas, BorderLayout.NORTH);
          

          this.setLayout(new BorderLayout());
          this.add(panelConsultas, BorderLayout.CENTER);                             

          this.pack();
          this.setVisible(true);
     }  

     public Consulta getConsultaActual(){
          return this.consultaActual;
     }          
  
     public void desplegarDatosConsulta(Consulta consulta){
          if (consulta != null){                                             
               textFieldFechaConsulta.setText(consultaActual.getFechaConsulta());
               textFieldPadecimientoConsulta.setText(consultaActual.getPadecimientoConsulta());
               textFieldTratamientoConsulta.setText(consultaActual.getTratamientoConsulta());                    
          } else {
               textFieldFechaConsulta.setText("");
               textFieldPadecimientoConsulta.setText("");
               textFieldTratamientoConsulta.setText("");                
          } 
     }     
  
     private class CloseHandler extends WindowAdapter {
         ABCconsultasGUI frameABCconsultasGUI;

         public CloseHandler(ABCconsultasGUI frameABCconsultasGUI){
              this.frameABCconsultasGUI = frameABCconsultasGUI;
         }
         public void windowClosing(WindowEvent e) {  
              System.out.println("Hace invisible el objeto ABCconsultasGUI");            
              frameABCconsultasGUI.setVisible(false);
         }
     }


     private class InsertarConsultaHandler implements ActionListener {
          ABCconsultasGUI frameABCconsultasGUI;

          public InsertarConsultaHandler(ABCconsultasGUI frameABCconsultasGUI){
               this.frameABCconsultasGUI = frameABCconsultasGUI;
          }
          public void actionPerformed(ActionEvent e) { 

               if (consultaNueva == null){                     
                  
                    desplegarDatosConsulta(consultaNueva);                     
                    consultaActual = null;
                    consultaNueva = new Consulta(); 
                    buttonInsertarConsulta.setLabel("Grabar Consulta");     

                    frameABCconsultasGUI.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente() + " -> " + "Consulta Nuevo");                    
                                                           
               } else {                                           
                 
                    consultaNueva.setFechaConsulta(textFieldFechaConsulta.getText());                    
                    consultaNueva.setPadecimientoConsulta(textFieldPadecimientoConsulta.getText());
                    consultaNueva.setTratamientoConsulta(textFieldTratamientoConsulta.getText());

                    ListIterator listConsultaIterator = pacienteMEDEA.getColeccionConsultas().listIterator();
                    listConsultaIterator.add(consultaNueva);
                    consultaIterator = pacienteMEDEA.getColeccionConsultas().consultaIterator(); 
                    consultaActual = consultaIterator.nextConsulta();                            
  
                    consultaNueva = null; 
                    buttonInsertarConsulta.setLabel("Nueva Consulta "); 

                    frameABCconsultasGUI.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente() + " -> " + consultaActual.getFechaConsulta());
               }
          }   
     }  

     private class CursorConsultasHandler implements ActionListener {
          ABCconsultasGUI frameABCconsultasGUI;

          public CursorConsultasHandler(ABCconsultasGUI frameABCconsultasGUI){
               this.frameABCconsultasGUI = frameABCconsultasGUI;
          }
          public void actionPerformed(ActionEvent e) { 
            
               if( consultaIterator.hasNextConsulta() ){

                    consultaActual = consultaIterator.nextConsulta();
                    desplegarDatosConsulta(consultaActual);

                    frameABCconsultasGUI.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente() + " -> " + consultaActual.getFechaConsulta());
              
               }else {
                    consultaActual = null; 
                    desplegarDatosConsulta(consultaActual);
                    consultaIterator = pacienteMEDEA.getColeccionConsultas().consultaIterator();

                    frameABCconsultasGUI.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente() + " -> " + "Fin Colección");                                       
               }                              
          }   
     }
     
     private class EliminarConsultaHandler implements ActionListener {
          ABCconsultasGUI frameABCconsultasGUI;

          public EliminarConsultaHandler(ABCconsultasGUI frameABCconsultasGUI){
               this.frameABCconsultasGUI = frameABCconsultasGUI;
          }
          public void actionPerformed(ActionEvent e) { 
               if(consultaActual != null){
                    consultaIterator.removeConsulta();
                    consultaActual = null;
                    desplegarDatosConsulta(consultaActual);

                    frameABCconsultasGUI.setTitle("Colección Consultas: " + pacienteMEDEA.getNombrePaciente() + " -> " + "Consulta Eliminada");
               }                           
          }   
     }

     private class ActualizarConsultaHandler implements ActionListener {
          ABCconsultasGUI frameABCconsultasGUI;

          public ActualizarConsultaHandler(ABCconsultasGUI frameABCconsultasGUI){
               this.frameABCconsultasGUI = frameABCconsultasGUI;
          }
          public void actionPerformed(ActionEvent e) { 
               if(consultaActual != null){
                    consultaActual.setFechaConsulta(textFieldFechaConsulta.getText());
                    consultaActual.setPadecimientoConsulta(textFieldPadecimientoConsulta.getText());
                    consultaActual.setTratamientoConsulta(textFieldTratamientoConsulta.getText());      
               }                           
          }   
     }  
}











