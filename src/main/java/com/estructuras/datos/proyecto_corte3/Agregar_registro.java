/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import static com.estructuras.datos.proyecto_corte3.Utils.dropAllRows;
import com.opencsv.CSVReader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author g14_0
 */
public class Agregar_registro extends javax.swing.JInternalFrame {
    private final main_menu mn;
    JTableHeader tableHeader;
    TableColumnModel tableColumnModel;
    TableColumn tableColumn;
    private CSVReader lectorArchivo = null;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private final int ancho;
    private final int alto;
    /**
     * Creates new form Agregar_registro
     */
    public Agregar_registro() {
        mn = new main_menu();
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension mainDimension = tk.getScreenSize();
        this.tableHeader  = tableCosts.getTableHeader();
        this.tableColumnModel = tableHeader.getColumnModel();
        this.modeloTabla = (DefaultTableModel) tableCosts.getModel();
        new Visalizar_tabla().LoadHeaderTable(tableCosts);
        ancho = (int)mainDimension.getWidth() / 2;
        alto = (int)mainDimension.getHeight() / 2;
        addRow();
    }
    private void addRow(){
        tableHeader  = tableCosts.getTableHeader();
        tableHeader.getColumnModel();
        new Visalizar_tabla().LoadHeaderTable(tableCosts);
        //Vector<JTextField> textBoxs = new Vector<>();
        Object[] textBoxs = {""};
        modeloTabla = (DefaultTableModel) tableCosts.getModel();
        modeloTabla.addRow(textBoxs);   
    }
        private void rmRow(){
        tableHeader  = tableCosts.getTableHeader();
        tableHeader.getColumnModel();
        new Visalizar_tabla().LoadHeaderTable(tableCosts);
        //Vector<JTextField> textBoxs = new Vector<>();
        Object[] textBoxs = {""};
        modeloTabla = (DefaultTableModel) tableCosts.getModel();
        modeloTabla.removeRow(modeloTabla.getRowCount()-1);   
    }
    private void addData(Vector data){
        List<String[]> listData = new ArrayList<>();
        String[] castData = new String[modeloTabla.getColumnCount()];
        String[] finalData = new String[modeloTabla.getRowCount()];
        String[] dataCsv = new String[Utils.getHeaderTable().length];
        String b;
        dataCsv = Utils.getHeaderTable();
        for (int i = 0; i< dataCsv.length; i++) {
            listData.add(dataCsv[i].split(","));
        }
        for (int i = 0; i < data.size(); i++) {
            b = data.get(i).toString().trim();
            castData = b.split("],");
        }
        for (int i = 0; i < finalData.length; i++) {
            b = castData[i].trim().replace("[", "").replace("]", "");
            finalData[i] = b.trim();
            listData.add(finalData[i].split(","));
        }

        try {
            Utils.writeCsv(listData);
        } catch (Exception e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableCosts = new javax.swing.JTable();
        BtnEliminar = new javax.swing.JButton();
        BtnGuardas = new javax.swing.JButton();
        BtnAceptar = new javax.swing.JButton();
        BtnCancelar1 = new javax.swing.JButton();

        setName("Agregar Datos"); // NOI18N

        tableCosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCosts);

        BtnEliminar.setText("Eliminar Fila");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnGuardas.setText("Guardar");
        BtnGuardas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardasActionPerformed(evt);
            }
        });

        BtnAceptar.setText("Agregar Fila");
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        BtnCancelar1.setText("Cancelar");
        BtnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(BtnCancelar1)
                .addGap(86, 86, 86)
                .addComponent(BtnEliminar)
                .addGap(88, 88, 88)
                .addComponent(BtnAceptar)
                .addGap(94, 94, 94)
                .addComponent(BtnGuardas)
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardas)
                    .addComponent(BtnAceptar)
                    .addComponent(BtnEliminar)
                    .addComponent(BtnCancelar1))
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        addRow();
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnGuardasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardasActionPerformed
        Vector datos = new Vector();
        datos.add(modeloTabla.getDataVector());
        if(modeloTabla.getRowCount() == 0){
            JOptionPane.showMessageDialog(rootPane, "No hay filas por agregar");
                new Agregar_registro(); 
        }else if(!Utils.checkDataIsNull(datos,tableCosts)){
                JOptionPane.showMessageDialog(rootPane, "Debe ingresar todos los campos");
                new Agregar_registro();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Datos ingresados exitosamente");
            addData(datos);
            dropAllRows(tableCosts);
        }
    }//GEN-LAST:event_BtnGuardasActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        if(modeloTabla.getRowCount()>0){
            rmRow();
        }else{
            JOptionPane.showMessageDialog(rootPane, "No hay filas para eliminar");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelar1ActionPerformed
        mn.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnCancelar1;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JButton BtnGuardas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCosts;
    // End of variables declaration//GEN-END:variables
}
