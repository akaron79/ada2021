/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package streamsgui;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

/**
 *
 * @author vicente
 */
public class StreamsGUI extends javax.swing.JFrame {

    /**
     * Creates new form StreamsGUI
     */
    public StreamsGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tar_texto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mit_archivo_abrir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tar_texto.setEditable(false);
        tar_texto.setColumns(20);
        tar_texto.setRows(5);
        jScrollPane1.setViewportView(tar_texto);

        jMenu1.setText("Archivo");

        mit_archivo_abrir.setText("Abrir...");
        mit_archivo_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mit_archivo_abrirActionPerformed(evt);
            }
        });
        jMenu1.add(mit_archivo_abrir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mit_archivo_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mit_archivo_abrirActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
        //Aquí podemos trabajar con el File como de costumbre
            //System.out.println("Abriendo fichero: " + file.getName() + ".");
            //System.out.println(file.toString());
        //Aquí tenemos que procesar el fichero seleccionado
        Path path1 = Path.of(file.toString());
        try {
            ArrayList<String> lineas;
            lineas = (ArrayList<String>) Files.readAllLines(path1, StandardCharsets.UTF_8);
            for (Iterator<String> it = lineas.iterator(); it.hasNext();) {
                tar_texto.append(it.next()+"\n");                
                //String linea = it.next();
                //System.out.println(linea);
                //tar_texto.setText(lineas.toString());
                //tar_texto.append(linea);
            }
     
        } catch (IOException ex) {
            Logger.getLogger(StreamsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            
           
        } else {
            System.out.println("El usuario no le dio al botón aceptar.");
        }
        
    }//GEN-LAST:event_mit_archivo_abrirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StreamsGUI().setVisible(true);
            }
        });
        
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mit_archivo_abrir;
    private javax.swing.JTextArea tar_texto;
    // End of variables declaration//GEN-END:variables
}
