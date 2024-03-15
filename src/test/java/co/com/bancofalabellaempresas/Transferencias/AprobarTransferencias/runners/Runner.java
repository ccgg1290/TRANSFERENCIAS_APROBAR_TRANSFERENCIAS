package co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.runners;

import io.cucumber.java.BeforeAll;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/feature.feature",
        glue = {"co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.Hooks",
                "co.com.bancofalabellaempresas.Transferencias.AprobarTransferencias.Definitions"},
        tags = "@DescargarArchivo",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {








}
