package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLOutput;

import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils.ReturnDate.returnDate;


@Slf4j
public class ManagmedFile {


    public static void moveFile(String origen, String destino) throws IOException {
     /*   System.out.println("RUTA origen:" + origen);
        System.out.println("RUTA destino:" + destino);
        Path origenPath = FileSystems.getDefault().getPath(origen);
        Path destinoPath = FileSystems.getDefault().getPath(destino);
        System.out.println("RUTA:" + origenPath);
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception ex) {
            System.out.println("ERROR RUTA+" + origenPath+ex);
        }
      */
        String nameFile = returnDate();

        log.info("nombre archivo construido " + nameFile);
        // System.out.println("RUTA origen:" + origen);
        // System.out.println("RUTA destino:" + destino);
        //apunte al ruta del directorio
        File folder = new File(origen);
        //recupere los archivos del directorio en un array
        File[] listaofFiles = folder.listFiles();
        //recorra cada archivo
        for (File archivo : listaofFiles) {
            //si el archivo tiene en el nombre la caeena EXT$fechs$
            if (archivo.getName().contains(nameFile)) {
                log.info("nombre archivo a mover: " + archivo.getName());
                //guarde en una variable la ruta con el nombre de archivo a copiar
                String archivoAMover = origen.concat(archivo.getName());
                //guarde en una variable la ruta con el nombre de archivo a mover
                String rutaAMover = destino.concat(archivo.getName());
                log.info("ruta archivo origen: " + archivoAMover);
                log.info("ruta archivo destino: " + rutaAMover);
                //guarde rutas a copiar y mover en variables tipo path
                Path origenPath = FileSystems.getDefault().getPath(archivoAMover);
                Path destinoPath = FileSystems.getDefault().getPath(rutaAMover);
                //mueva el archivo
                Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
                //log.info("Nombre archivo: " + archivo.getName());
            }

        }


    }


}
