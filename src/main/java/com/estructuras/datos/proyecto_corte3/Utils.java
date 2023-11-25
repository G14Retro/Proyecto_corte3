/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import static com.estructuras.datos.proyecto_corte3.Constants.ARCHIVO;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.plaf.RootPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author camil
 */
public class Utils {
    private static CSVReader lectorArchivo = null;
    static int lengthCsv;
    private static JTableHeader tableHeader;
    private static TableColumnModel tableColumnModel;
    private static TableColumn tableColumn;
    private static DefaultTableModel modeloTabla = new DefaultTableModel();
    public static String[] getHeaderTable(){
        String[] resultado = null;
        try {
            lectorArchivo = new CSVReader(new FileReader(ARCHIVO));
            String[] fila = null;
            List<String> listRows = new ArrayList<>();
            while ((fila = lectorArchivo.readNext())!= null) {
                listRows.add(String.join(",", fila));
            }
            resultado = new String[listRows.size()];
            String[] dataFila = new String[listRows.size()];
            for (int i = 0; i < listRows.size(); i++) {
                dataFila = listRows.get(i).split(",");
                resultado[i] = String.join(",", dataFila);
            }
            lengthCsv = resultado.length;
            lectorArchivo.close();
            return resultado;
        } catch (CsvValidationException | IOException e) {
        }
       
        return resultado;
    }
    public static Boolean checkDataIsNumeric(DefaultTableModel modelTabel,JRootPane rootpane){
        List<Boolean> resultado = new ArrayList();
        for (int i = 0; i < modelTabel.getRowCount(); i++) {
            for (int j = 1; j < modelTabel.getColumnCount()-1; j++) {
                if(!modelTabel.getValueAt(i, j).toString().trim().matches("[0-9]*")){
                    JOptionPane.showMessageDialog(rootpane, "En la fila ("+(i+1)+"), columna (" + (j+1) +") el valor debe ser numerico" );
                    resultado.add(false);
                }
            }
        }
        for (int i = 0; i < resultado.size(); i++) {
            if(resultado.get(i).equals(false)){
                return false;
            }
        }
        return true;
    }
    public static Boolean checkDataIsNull(DefaultTableModel modelTabel,JRootPane rootpane){
        List<Boolean> resultado = new ArrayList();
        boolean rowIsEmpty = false;
        for (int i = 0; i < modelTabel.getRowCount(); i++) {
            for (int j = 0; j < modelTabel.getColumnCount(); j++) {
                if(modelTabel.getValueAt(i, j)==null){
                    rowIsEmpty = true;
                }
            }
            if (rowIsEmpty) {
                JOptionPane.showMessageDialog(rootpane, "Debe ingersar todos los datos en la fila ("+(i+1)+").");
                resultado.add(false);
            }
        }
        for (int i = 0; i < resultado.size(); i++) {
            if(resultado.get(i).equals(false)){
                return false;
            }
        }
        return true;
    }
    public static void writeCsv(List<String []> data){
        try {
            CSVWriter escribirArchivo = new CSVWriter(new FileWriter(ARCHIVO));
            escribirArchivo.writeAll(data);
            escribirArchivo.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void dropAllRows(JTable table, int columSize){
        table.updateUI();
        JTableHeader tableHeader;
        DefaultTableModel modeloTabla = new DefaultTableModel();
        tableHeader  = table.getTableHeader();
        tableHeader.getColumnModel();
        modeloTabla = (DefaultTableModel) table.getModel();
        String a = String.valueOf(modeloTabla.getRowCount());
        for (int i = modeloTabla.getRowCount() -1; i >=0 ; i--) {
            modeloTabla.removeRow(i);
        }
    }
    /*public static boolean checkDataIsNull(Vector data,JTable tableCosts){
        tableHeader  = tableCosts.getTableHeader();
        tableColumnModel = tableHeader.getColumnModel();
        modeloTabla = (DefaultTableModel) tableCosts.getModel();
        List<String[]> listData = new ArrayList<>();
        String[] castData = new String[modeloTabla.getColumnCount()];
        String[] dataStrings = new String[modeloTabla.getRowCount()];
        String[] finalData = new String[modeloTabla.getRowCount()];
        List<Boolean> resultado = new ArrayList();
        String b ="";
                for (int i = 0; i < data.size(); i++) {
            b = data.get(i).toString().trim();
            castData = b.split("],");
        }
        for (int i = 0; i < finalData.length; i++) {
            b = castData[i].trim().replace("[", "").replace("]", "");
            finalData[i] = b.trim();
            listData.add(finalData[i].split(","));
        }
        for (int i = 0; i < finalData.length; i++) {
            dataStrings = finalData[i].split(",");
            for (int j = 0; j < dataStrings.length; j++) {
                if(dataStrings[j].trim().equalsIgnoreCase("null") 
                        || dataStrings[j].isBlank()){
                    resultado.add(false);
                }
            }
        }
        for (int i = 0; i < resultado.size(); i++) {
            if (!resultado.get(i)) {
                return false;
            }
        }
        return true;
    }*/

}
