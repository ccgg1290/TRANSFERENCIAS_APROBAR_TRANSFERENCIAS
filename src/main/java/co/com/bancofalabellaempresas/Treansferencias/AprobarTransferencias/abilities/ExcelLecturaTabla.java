package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Slf4j
public class ExcelLecturaTabla {






//validar tamaño excel
	public static String[][] leerExcel(String rutaarchivo) {
		int fil=1;
		int col=0;
		int maxcol=0;
		File archivo = new File(rutaarchivo);
		try {
			InputStream input = new FileInputStream(archivo);
			XSSFWorkbook libro = new XSSFWorkbook(input);
			XSSFSheet hoja = libro.getSheetAt(0);
			Iterator<Row> filas = hoja.rowIterator();
			Iterator<Cell> columnas = null;
			List<List<Object>> cuadroExcel=new ArrayList<>();
			List<Object> lineaExcel=new ArrayList<>();
			String valor = null;
			Row filaActual = null;
			Cell columnaActual = null;
			while (filas.hasNext()) {
				filaActual = filas.next();
				columnas = filaActual.cellIterator();
				while (columnas.hasNext()) {
					columnaActual = columnas.next();
                    col++;
					maxcol=col;
					//System.out.println("fila: "+fil+" columna:"+ col+" = "+valor);
					//System.out.println("columna"+valor);
				}
                col=0;
				fil++;
			}
			
			input.close();
			libro.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}





//Leer archivo
		System.out.println("fila salio fila: "+fil+" columna salio:"+col+" maxcol"+maxcol);
		String[][] libroExcel = new String[fil-1][maxcol];
		System.out.println("tamanio"+libroExcel.length);
		fil=1;
		col=0;
		try {
			InputStream input = new FileInputStream(archivo);
			XSSFWorkbook libro = new XSSFWorkbook(input);
			XSSFSheet hoja = libro.getSheetAt(0);
			Iterator<Row> filas = hoja.rowIterator();
			Iterator<Cell> columnas = null;
			List<List<Object>> cuadroExcel=new ArrayList<>();
			List<Object> lineaExcel=new ArrayList<>();
			String valor = null;
			Row filaActual = null;
			Cell columnaActual = null;
			while (filas.hasNext()) {
				filaActual = filas.next();
				columnas = filaActual.cellIterator();
				while (columnas.hasNext()) {
					columnaActual = columnas.next();
					if(columnaActual.getCellType() == CellType.STRING) {
						valor = columnaActual.getStringCellValue();


						//System.out.println(valor);
					}
					if(columnaActual.getCellType() == CellType.NUMERIC) {
						valor = String.valueOf(columnaActual.getNumericCellValue());
						System.out.println("isnumeric"+valor);
					}
					if(columnaActual.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(columnaActual)) {
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						valor= String.valueOf(columnaActual.getDateCellValue());
						System.out.println("date"+formato.format(valor));
					}

					col++;
					libroExcel[fil-1][col-1]=valor;
					System.out.println("Guarda en array fila: "+fil+" columna:"+col+" = "+valor);

					//System.out.println("columna"+valor);
				}
				col=0;
				fil++;
			}

			input.close();
			libro.close();

		} catch (Exception e) {
			e.printStackTrace();
		}



		for (int i = 0; i <fil ; i++) {

			for (int j = col; j <col ; j++) {
				System.out.println("ARRAY fila: "+fil+" columna:"+col+" = "+libroExcel[i][j]);
			}
		}




      log.info("Se leyo el archivo fin");
      return libroExcel;

	}

}
