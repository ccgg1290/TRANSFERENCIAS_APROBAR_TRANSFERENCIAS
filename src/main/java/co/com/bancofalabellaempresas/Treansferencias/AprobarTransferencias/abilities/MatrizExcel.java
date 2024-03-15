package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities;

import jxl.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MatrizExcel {


    public static void leerArchivoExcel(String archivoDestino) {


        try {

            System.out.println("\n \n empezamos");
            Workbook archivoExcel = Workbook.getWorkbook(new File(archivoDestino));
            System.out.println("Número de Hojas\t" + archivoExcel.getNumberOfSheets());
            //for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++){
            Sheet hoja = archivoExcel.getSheet(0);
            int numColumnas = hoja.getColumns();
            int numFilas = hoja.getRows();
            Object[][] matriz = new Object[hoja.getColumns()][hoja.getRows()];
            System.out.println("numerofilas: " + numFilas + "numero columnas" + numColumnas);
            System.out.println("tamanio matriz"+matriz.length);


            String data;
            System.out.println("Nombre de la Hoja\t" + archivoExcel.getSheet(0).getName());
            for (int fila = 0; fila < numFilas; fila++) {
                // Recorre cada fila
                for (int columna = 0; columna < numColumnas; columna++) { // Recorre
                    data = hoja.getCell(columna, fila).getContents();
                    System.out.print(data + " ");
                    matriz[fila][columna] = data;
                    System.out.println("Matriz fila: "+fila+" columna: "+columna+" =="+matriz[fila][columna]);

                }
                System.out.println("\n");
            }


        } catch (Exception ioe) {
            ioe.printStackTrace();
        }


    }
}
