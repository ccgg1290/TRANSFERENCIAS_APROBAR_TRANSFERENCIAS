package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;


import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.IsPresentFile.isPresentFile;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.ReturnFiles.returnNameFiles;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.userinterfaces.AprobarTransferencia.DESCARGAPDF;

public class AprobarTransferenciasTask {


    public static Performable called(Actor actor) {


        return Task.where("{0} adds a todo item called: #thingToDo",
               Click.on(DESCARGAPDF));

    }



}
