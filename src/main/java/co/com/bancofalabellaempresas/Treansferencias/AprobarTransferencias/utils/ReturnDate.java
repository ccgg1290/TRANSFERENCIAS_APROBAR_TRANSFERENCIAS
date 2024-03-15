package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
@Slf4j
public class ReturnDate {

    public static String returnDate() {

        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyyMMddHH");
        String newdate = hourdateFormat.format(date);
        log.info(newdate);
        return newdate;
    }


    public static String returnDate(String format, String separator) {

        Date date = new Date();
        DateFormat hourdateFormat = null;

        if(format.equalsIgnoreCase("y")){
            hourdateFormat=new SimpleDateFormat("yyyy");
        }
        else if (format.equalsIgnoreCase("ym")){
            hourdateFormat=new SimpleDateFormat("yyyy"+separator+"MM");
        }
        else if (format.equalsIgnoreCase("ymd")){
            hourdateFormat=new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd");
        }
        else if (format.equalsIgnoreCase("ymdh")){
            hourdateFormat=new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd"+separator+"HH");
        }
        else if (format.equalsIgnoreCase("ymdhs")){
            hourdateFormat=new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd"+separator+"HH"+separator+"ss");
        }
        //else if (format.equalsIgnoreCase("ymdhsms")){
         //   hourdateFormat=new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd"+separator+"HH");
       // }

        //hourdateFormat = new SimpleDateFormat("yyyy"+separator+"MM"+separator+"dd"+separator+"HH");
        String newdate = hourdateFormat.format(date);
        log.info(newdate);

        return newdate;
    }
}
