/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author g14_0
 */
public class main_menu extends javax.swing.JFrame {

    /**
     * Creates new form main_menu
     */
    private CSVReader lectorArchivo = null;
    private int ancho,alto;
    public main_menu() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension mainDimension = tk.getScreenSize();
        ancho = (int)mainDimension.getWidth() / 2;
        alto = (int)mainDimension.getHeight() / 2;
        this.setSize(ancho + 18, alto + 65);
        crearDirectorio();
    }
    
    private void crearDirectorio(){
        File directorio = new File("C:\\SysCost\\");
        File archivo = new File("C:\\SysCost\\SysCost.csv");
        String archCSV = "C:\\SysCost\\SysCost.csv";
        directorio.mkdir();
        try {
            if (!archivo.exists()) {
            archivo.createNewFile();
            CSVWriter escritorArchivo = new CSVWriter(new FileWriter(archCSV));
            String[] columns = {"Aréa","Costo Empleados","Costo indumentaria","Bonos","Caja menor","Fecha creación"};
            escritorArchivo.writeNext(columns);
            escritorArchivo.close();
            }else{
                System.out.println("El arhivo ya existe no es necesario crearlo.");
            }
        } catch (Exception e) {
                    System.out.println("Error encontrado"+e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopOperation = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        verInfo = new javax.swing.JMenuItem();
        addRegistro = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopOperationLayout = new javax.swing.GroupLayout(jDesktopOperation);
        jDesktopOperation.setLayout(jDesktopOperationLayout);
        jDesktopOperationLayout.setHorizontalGroup(
            jDesktopOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 964, Short.MAX_VALUE)
        );
        jDesktopOperationLayout.setVerticalGroup(
            jDesktopOperationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jMenu1.setText("Administración");

        jMenu3.setText("Costos");

        verInfo.setText("Visualizar información");
        verInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoActionPerformed(evt);
            }
        });
        jMenu3.add(verInfo);

        addRegistro.setText("Agregar Registro");
        jMenu3.add(addRegistro);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Salir");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopOperation)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopOperation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInfoActionPerformed
        // TODO add your handling code here:
        Visalizar_tabla viewTable = new Visalizar_tabla();
        jDesktopOperation.add(viewTable);
        viewTable.setSize(ancho, alto);
        viewTable.show();
    }//GEN-LAST:event_verInfoActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addRegistro;
    private javax.swing.JDesktopPane jDesktopOperation;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem verInfo;
    // End of variables declaration//GEN-END:variables
}
