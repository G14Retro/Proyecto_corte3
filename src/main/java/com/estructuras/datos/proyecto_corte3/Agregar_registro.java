/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import static com.estructuras.datos.proyecto_corte3.Constants.ARCHIVO;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author g14_0
 */
public class Agregar_registro extends javax.swing.JInternalFrame {
    JTableHeader tableHeader;
    TableColumnModel tableColumnModel;
    TableColumn tableColumn;
    private CSVReader lectorArchivo = null;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private int ancho,alto;
    /**
     * Creates new form Agregar_registro
     */
    public Agregar_registro() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension mainDimension = tk.getScreenSize();
        ancho = (int)mainDimension.getWidth() / 2;
        alto = (int)mainDimension.getHeight() / 2;
        addRow();

    }
    private void addRow(){
        tableHeader  = tableCosts.getTableHeader();
        tableColumnModel = tableHeader.getColumnModel();
        new Visalizar_tabla().LoadHeaderTable(tableCosts);
        //Vector<JTextField> textBoxs = new Vector<>();
        Object[] textBoxs = {""};
        modeloTabla = (DefaultTableModel) tableCosts.getModel();
        modeloTabla.addRow(textBoxs);   
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
            b = data.get(i).toString();
            castData = b.split("],");
        }
        for (int i = 0; i < finalData.length; i++) {
            b = castData[i].trim().replace("[", "").replace("]", "");
            finalData[i] = b;
            listData.add(finalData[i].split(","));
        }

        try {
            CSVWriter escribirArchivo = new CSVWriter(new FileWriter(ARCHIVO));
            escribirArchivo.writeAll(listData);
            escribirArchivo.close();
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

        BtnAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCosts = new javax.swing.JTable();
        BtnCancelar = new javax.swing.JButton();
        BtnGuardas = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agregar Datos");
        setPreferredSize(new java.awt.Dimension(872, 333));

        BtnAceptar.setText("Agregar");
        BtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAceptarActionPerformed(evt);
            }
        });

        tableCosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCosts);

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnGuardas.setText("Guardar");
        BtnGuardas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(BtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(BtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(BtnGuardas, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAceptar)
                    .addComponent(BtnCancelar)
                    .addComponent(BtnGuardas))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAceptarActionPerformed
        addRow();
    }//GEN-LAST:event_BtnAceptarActionPerformed

    private void BtnGuardasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardasActionPerformed
        Vector datos = new Vector();
        datos.add(modeloTabla.getDataVector());
        addData(datos);
    }//GEN-LAST:event_BtnGuardasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAceptar;
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnGuardas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCosts;
    // End of variables declaration//GEN-END:variables
}
