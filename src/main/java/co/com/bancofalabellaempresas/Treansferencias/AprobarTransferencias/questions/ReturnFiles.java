package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReturnFiles {


  public static List<String> returnNameFiles(String ruta) {

      List<String> lista =new ArrayList<>();
      File folder=new File(ruta);
      //guarda en un array los archivos
      File[] listaofFiles=folder.listFiles();

      for (File archivo:listaofFiles){
          log.info("Nombre archivo retornado: "+archivo.getName());
          //guarda en una lista los nombres de los archivos
          lista.add(archivo.getName());

      }
      log.info("Numero de archivos retornados= "+listaofFiles.length);
      return lista;

  }

}
