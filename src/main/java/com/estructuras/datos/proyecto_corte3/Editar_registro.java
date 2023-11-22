/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import com.opencsv.CSVReader;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Editar_registro extends javax.swing.JInternalFrame {
    JTableHeader tableHeader;
    TableColumnModel tableColumnModel;
    TableColumn tableColumn;
    private CSVReader lectorArchivo = null;
    private DefaultTableModel modeloTabla = new DefaultTableModel();
    private int ancho,alto;
    private int idexUpdate;

    public int getIdexUpdate() {
        return idexUpdate;
    }

    public void setIdexUpdate(int idexUpdate) {
        this.idexUpdate = idexUpdate;
    }
    /**
     * Creates new form Editar_registro
     */
    public Editar_registro() {
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension mainDimension = tk.getScreenSize();
        ancho = (int)mainDimension.getWidth() / 2;
        alto = (int)mainDimension.getHeight() / 2;
        tableHeader  = tableCosts.getTableHeader();
        tableColumnModel = tableHeader.getColumnModel();
        modeloTabla = (DefaultTableModel) tableCosts.getModel();
        new Visalizar_tabla().LoadTable(tableCosts);
        BtnModificar.setEnabled(false);
    }
    
    public void editarRegistros(Vector data){
        String exit = "Si";
        int index = getIdexUpdate();
        String [] castData = new String[modeloTabla.getColumnCount()];
        String [] dataCsv = new String[Utils.getHeaderTable().length];
        String[] dataFinal = new String[modeloTabla.getColumnCount()];
        List<String[]> listDataTabel = new ArrayList();
        List<String[]> listDataCsv = new ArrayList();
        String infoData;
        infoData = data.get(0).toString();
        castData = infoData.trim().split("],");
        infoData = castData[0].trim().replace("[", "").
        replace("]", "");
        castData[0] = infoData.trim();
        dataFinal = castData[0].split(",");
        for (int i = 0; i < dataFinal.length; i++) {
            dataFinal[i] = dataFinal[i].trim();
        }
        castData[0] = String.join(",", dataFinal);
        listDataTabel.add(castData[0].split(","));
        dataCsv = Utils.getHeaderTable();
        for (int i = 0; i < dataCsv.length; i++) {
            listDataCsv.add(dataCsv[i].trim().split(","));
        }
        dataFinal[0] = Arrays.toString(listDataTabel.get(
                0)).replace("[", "").replace("]", "").trim();
        listDataCsv.set(index+1,dataFinal[0].trim().split(","));
        Utils.writeCsv(listDataCsv);
        exit = JOptionPane.showInputDialog(rootPane, """
                                                     Datos actualizados exitosamente 
                                                     Sigita Si para modificar y No para Salir""");  
        while((exit.isEmpty() || exit.isBlank()) || 
                !(exit.equalsIgnoreCase("si"))&&
                !(exit.equalsIgnoreCase("no"))){
            if((exit.isEmpty() || exit.isBlank()) || 
                !(exit.equalsIgnoreCase("si"))&&
                !(exit.equalsIgnoreCase("no"))){
                JOptionPane.showMessageDialog(rootPane, "Debe digitar si para continuar o no para salir");  
                exit = JOptionPane.showInputDialog(rootPane, """
                                                 Datos actualizados exitosamente 
                                                 Sigita Si para modificar y No para Salir""");
            }
        }
        if (exit.equalsIgnoreCase("si")) {
            inputSearch.setText(null);
            modeloTabla.removeRow(0);
            tableHeader  = tableCosts.getTableHeader();
            tableColumnModel = tableHeader.getColumnModel();
            modeloTabla = (DefaultTableModel) tableCosts.getModel();
            new Visalizar_tabla().LoadTable(tableCosts);
            BtnModificar.setEnabled(false);
            new Editar_registro();
        }else{
            inputSearch.setText(null);
            inputSearch.setEditable(false);
            BtnModificar.setEnabled(false);
            btnBuscar.setEnabled(false);
        }
    }
    public List<Integer> getIndex(){
        List<Integer> index = new ArrayList<>();
        
        return index;
    }
    public void searchData(Vector dataTable){
        String index = String.valueOf(Integer.parseInt(inputSearch.getText()) -1);
        List<String[]> listDataTable = new ArrayList<>();
        String data;
        String[] castData = new String[modeloTabla.getRowCount()];
        String[] dataFinal = new String[modeloTabla.getRowCount()];
        Utils.getHeaderTable();
        for (int i = 0; i <dataTable.size() ; i++) {
            data = dataTable.get(i).toString();
            castData = data.trim().split("],");
        }
        for (int i = 0; i < castData.length; i++) {
            data = castData[i].replace("[", "").replace("]","").trim();
            dataFinal[i] = data;
            listDataTable.add(dataFinal[i].split(","));
        }
        
        listDataTable.get(Integer.parseInt(index));
        modeloTabla.setNumRows(1);
        new Visalizar_tabla().LoadHeaderTable(tableCosts);
        castData = listDataTable.get(Integer.parseInt(index));
        //dataFinal = castData.split("],");
        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                modeloTabla.setValueAt(castData[j],i,j);
            }
        }
        setIdexUpdate(Integer.parseInt(index));
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
        BtnModificar = new javax.swing.JButton();
        inputSearch = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BtnCancelar = new javax.swing.JButton();

        tableCosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableCosts);

        BtnModificar.setText("Modificar");
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por ID");

        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(141, 141, 141)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnCancelar)
                .addGap(150, 150, 150)
                .addComponent(BtnModificar)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificar)
                    .addComponent(BtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
        Vector datos = new Vector();
        datos.add(modeloTabla.getDataVector());
        if(!Utils.checkDataIsNull(datos,tableCosts)){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar todos los campos");
        }else{
            editarRegistros(datos);
        }
    }//GEN-LAST:event_BtnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Vector data = new Vector();
        data.add(modeloTabla.getDataVector());
        if (inputSearch.getText().isBlank() || inputSearch.getText().isEmpty()
                || !inputSearch.getText().matches("[0-9]")) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un valor númerico");
        }else if(Integer.parseInt(inputSearch.getText())<1){
                        JOptionPane.showMessageDialog(rootPane, "index ingresado debajo del rango minimo");
        }else if (Integer.parseInt(inputSearch.getText())> modeloTabla.getRowCount()){
            JOptionPane.showMessageDialog(rootPane, "index ingresado por encima del rango maximo");
        }
        else{
            searchData(data);
            BtnModificar.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnModificar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JTextField inputSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCosts;
    // End of variables declaration//GEN-END:variables
}
