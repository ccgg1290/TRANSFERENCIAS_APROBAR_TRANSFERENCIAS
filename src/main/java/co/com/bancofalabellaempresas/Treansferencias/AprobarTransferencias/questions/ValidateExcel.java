package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Slf4j
public class ValidateExcel {




    public static Boolean findValueToExcel(String[][] libroExcel,String valueCell) {

        int fil=1;
        int col=0;
        Boolean finded =false;

        System.out.println(libroExcel.length);
        System.out.println("entramos");
        for (int i = 0; i <fil ; i++) {

            for (int j = col; j <col ; j++) {

                System.out.println("dentro:"+i+j+libroExcel[i][j]);
                    if (libroExcel[i][j].equals(valueCell)) {
                        log.info("ARRAY fila: " + fil + " columna:" + col + " = " + libroExcel[i][j]);
                        finded= true;
                    }

            }
        }

        System.out.println("salimos");
        return finded;

    }
}








