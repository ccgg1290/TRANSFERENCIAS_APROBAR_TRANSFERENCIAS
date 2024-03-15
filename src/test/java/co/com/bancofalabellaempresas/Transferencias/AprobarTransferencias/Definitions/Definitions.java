package co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.Definitions;


import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities.FindExcelLecturaTabla;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.interactions.Refresh;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.models.LibroExcel;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.ValidateExcel;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils.SubStringFeature;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.models.LibroExcel;


import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities.ReadPdf;
import co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.userinterfaces.MenuWeb;
import org.openqa.selenium.WebElement;

import static co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.Hooks.Hook.downloadFolder;
import static co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.Hooks.Hook.downloadFolderCopyPaste;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.abilities.ExcelLecturaTabla.leerExcel;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.AssertThat.theElementIsPresent;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.AssertThat.theTextOfTheElementIs;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.IsPresentFile.isPresentFile;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.ReturnFiles.returnNameFiles;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.questions.ValidateExcel.findValueToExcel;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.userinterfaces.AprobarTransferencia.*;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils.ManagmedFile.moveFile;
import static co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.utils.ReturnDate.returnDate;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.pages.components.HtmlTable.filterRows;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@Slf4j
public class Definitions extends PageComponent {

    Actor user;


    @Given("El cliente se encuentra en el submodulo Transferencias_AprobarTransferencias")
    public void queElClienteSeEncuentraEnElModuloDeTransferenciasAprobarTransferencias() throws InterruptedException, IOException {
        user = theActorInTheSpotlight();

        //ReadExcel.getText("c:\\Users\\ccgualterosg\\Documents\\proyecto_Automatizacion\\proyectos\\Transferencias\\AprobarTransferencias\\src\\test\\resources\\archivos\\20240313175334.xlsx");
        user.attemptsTo(WaitUntil.the(MenuWeb.TRANSFERENCIAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Click.on(MenuWeb.TRANSFERENCIAS),
                WaitUntil.the(MenuWeb.APROBARTRANSFERENCIAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Click.on(MenuWeb.APROBARTRANSFERENCIAS)
        );

        user.should(
                seeThat("El titulo ", theTextOfTheElementIs(LABELMAIN), equalTo("Aprobar Procesos de Transferencias"))
        );

    }


    @When("Consulta las transferencias que desea aprobar")
    public void consultaLasTransferenciasQueDeseaAprobar(DataTable dataFeature) throws InterruptedException, IOException {
        List<Map<String, String>> data = dataFeature.asMaps();


        user.attemptsTo(

                WaitUntil.the(FECHACREACIONENTRE, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(data.get(0).get("FechaCreacionEntre")).into(FECHACREACIONENTRE),
                WaitUntil.the(FECHACREACIONHASTA, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(data.get(0).get("FechaCreacionHasta")).into(FECHACREACIONHASTA),
                WaitUntil.the(TIPOTRANSFERENCIA, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("TipoTransferencias")).from(TIPOTRANSFERENCIA),
                WaitUntil.the(NUMEROPROCESO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(data.get(0).get("NumeroProceso")).into(NUMEROPROCESO),
                WaitUntil.the(LISTAPRODUCTOORIGEN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("ProductoOrigen")).from(LISTAPRODUCTOORIGEN),
                WaitUntil.the(LISTACREADOR, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("Creador")).from(LISTACREADOR),
                WaitUntil.the(LISTAPRODUCTODESTINO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SelectFromOptions.byVisibleText(data.get(0).get("ProductoDestino")).from(LISTAPRODUCTODESTINO)


                //Refresh.thePage(),
                //WaitUntil.the(BTNAPROBAR, isCurrentlyVisible()).forNoMoreThan(60).seconds()


        );

        Thread.sleep(10000);

        user.attemptsTo(
                WaitUntil.the(BTNBUSCARPROCESOS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTNBUSCARPROCESOS),
                WaitUntil.the(TABLAGRILLA, isCurrentlyVisible()).forNoMoreThan(60).seconds()


        );

        List<String> listaCheck = SubStringFeature.subStringFeature(data.get(0).get("NumeroProcesoBuscar"));
        List<String> listaPag = SubStringFeature.subStringFeature(data.get(0).get("Paginas"));
        //td[contains(text(), "2891")]//..//span//input
        //   for (String check : listaCheck) {
        for (int i = 0; i < listaCheck.size(); i++) {
            log.info("chekeamos la fila con id" + listaCheck.get(i));
            Thread.sleep(5000);

            int pag = Integer.parseInt(listaPag.get(i));
            System.out.println("pagina: " + pag);
            for (int j = 0; j < pag - 1; j++) {
                user.attemptsTo(Click.on(By.id("cphCuerpo_lkSiguiente")));
                Thread.sleep(5000);
            }

            user.attemptsTo(
                    WaitUntil.the(CHECKBOX, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Click.on(By.xpath("//td[contains(text(), " + listaCheck.get(i) + ")]//..//span//input"))
            );

            for (int j = 0; j < pag - 1; j++) {
                user.attemptsTo(Click.on(By.id("cphCuerpo_lkAnterior")));
                Thread.sleep(5000);
            }


        }

        Thread.sleep(5000);


    }


    @When("Aprueba la transaccion")
    public void apruebaLaTransaccion(DataTable dataFeature) throws InterruptedException, IOException {
        List<Map<String, String>> data = dataFeature.asMaps();

        user.should(seeThat("El la grilla ", theElementIsPresent(TABLAGRILLA)));
        user.should(seeThat("El total de transferencias ", theTextOfTheElementIs(TOTALTRANSFERENCIAS), equalTo(data.get(0).get("TotalTransferencias"))));
        user.should(seeThat("las transferencias seleccionadas ", theTextOfTheElementIs(TRASNFERENCIASSELECCIONADAS), equalTo(data.get(0).get("Transferencias Seleccionadas"))));
        user.should(seeThat("El monto es", theTextOfTheElementIs(MONTO), equalTo(data.get(0).get("Monto"))));

        user.attemptsTo(
                WaitUntil.the(CLAVETOKEN, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(data.get(0).get("ClaveToken")).into(CLAVETOKEN),
                WaitUntil.the(BTNAPROBAR, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTNAPROBAR)

        );

    }


    @Then("^Se muestra el mensaje final (.*)$")
    public void apruebaLaTransaccion(String mensajeFinal) throws InterruptedException, IOException {

        user.attemptsTo(

                WaitUntil.the(BTNAPROBAR, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTNAPROBAR)
        );

        user.should(seeThat("El mensaje final: ", theTextOfTheElementIs(LABELQUESTIONS), equalTo(mensajeFinal)));


    }


    @Then("Descarga el archivo")
    public void descargaElArchivo(DataTable dataFeature) throws InterruptedException, IOException {
        List<Map<String, String>> data = dataFeature.asMaps();

        System.out.println(data.get(0).get("TipoDeArchivo"));
        System.out.println(data.get(0).get("NumeroProcesoBuscar"));


        if (data.get(0).get("TipoDeArchivo").equals("PDF")) {
            user.should(seeThat("El mensaje; ", theElementIsPresent(DESCARGAPDF)));
            user.attemptsTo(Click.on(DESCARGAPDF));
            moveFile(downloadFolder, downloadFolderCopyPaste);
            assertTrue("No se descargo correctamente", isPresentFile(1, downloadFolderCopyPaste));

            List<String> files = returnNameFiles(downloadFolderCopyPaste);
            String completePath = String.format("%s%s%s", downloadFolderCopyPaste, "\\", files.get(0));
            user.whoCan(ReadPdf.downloadedInPath(completePath));

            //user.should(seeThat("El valor fue encontrado en el Excel  ", ReadPdf.as(user).findText(data.get(0).get("NumeroProceso"))));
            boolean findText = ReadPdf.as(user).findText(data.get(0).get("NumeroProcesoBuscar"));
            assertTrue("No se Encontro La cadena Buscada", findText);

        } else if (data.get(0).get("TipoDeArchivo").equals("EXCEL")) {

            user.attemptsTo(
                    WaitUntil.the(DESCARGAEXCEL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Click.on(DESCARGAEXCEL));


            List<String> listaCheck = SubStringFeature.subStringFeature(data.get(0).get("NumeroProcesoBuscar"));
            //td[contains(text(), "2891")]//..//span//input
            for (String numeroProceso : listaCheck) {
                moveFile(downloadFolder, downloadFolderCopyPaste);
                assertTrue("No se descargo correctamente", isPresentFile(1, downloadFolderCopyPaste));
                List<String> files = returnNameFiles(downloadFolderCopyPaste);
                String completePath = String.format("%s%s%s", downloadFolderCopyPaste, "\\", files.get(0));
                System.out.println("archivo excel a validar" + completePath);
                user.attemptsTo(Ensure.that(FindExcelLecturaTabla.leerExcel(completePath, numeroProceso)).isEqualTo(true));
                assertTrue("No se encontro el dato en el archivo excel", FindExcelLecturaTabla.leerExcel(completePath, numeroProceso));
            }

        }
    }


    @Then(" Puede ver el detalle de la transaccion")
    public void PuedeVerElDetalleDeLaTransaccion() throws InterruptedException, IOException {


    }


}







