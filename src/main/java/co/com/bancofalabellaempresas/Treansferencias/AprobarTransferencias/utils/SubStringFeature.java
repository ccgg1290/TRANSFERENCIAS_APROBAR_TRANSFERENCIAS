package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils;

import java.util.Arrays;
import java.util.List;

public class SubStringFeature {


    public  static List<String> subStringFeature(String valueToSplit){


        String[] parts = valueToSplit.split("-");
        System.out.println("Valor del array valueToSplit "+ parts.length);
        List<String> partsList = Arrays.stream(parts).toList();
        partsList.forEach(System.out::println);
        return partsList;


    }







}
