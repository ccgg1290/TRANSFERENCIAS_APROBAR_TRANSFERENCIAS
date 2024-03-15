package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities;


import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.models.LibroExcel;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReadExcel  {

    public static List<LibroExcel> getText(String rutaarchivo) throws IOException {
        File archivoaleer;
        List<LibroExcel> libroExcel;
        archivoaleer = new File(rutaarchivo);
        //InputStream input=new FileInputStream(archivoaleer);

       // FileInputStream input = new FileInputStream(archivoaleer);

        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings().build();
//                .settings()
////		        .sheetIndex(0) 		  // Indice de hoja
//                .sheetName("Personas") // Nombre de hoja
////				.skip(3)				  // Salto de filas
////				.limit(6)			  // Limite de registros
//                .trimCellValue(true)   // Eliminar espacios en blanco
//                .password("1234")      // Contrasenia del archivo
//                .build();
        libroExcel = Poiji.fromExcel(archivoaleer, LibroExcel.class,options);
        //libroExcel.forEach(System.out::println);
        return libroExcel;
    }

}
/* ****** Esta es la Forma de implemntar la Ability
theActorInTheSpotlight().whoCan(ReadExcel.downloadedInPath("PruebaExcel.xlsx"));
List<LibroExcel> libro1 = ReadExcel.asExcel(theActorInTheSpotlight()).getText();
libro1.forEach(System.out::println);



*/