/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras.datos.proyecto_corte3;

import static com.estructuras.datos.proyecto_corte3.Constants.ARCHIVO;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camil
 */
public class Utils {
    private static CSVReader lectorArchivo = null;
    static int lengthCsv;
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
        } catch (Exception e) {
        }
       
        return resultado;
    }
}
