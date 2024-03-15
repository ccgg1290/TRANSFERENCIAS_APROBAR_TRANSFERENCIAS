package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.interactions;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.pages.components.HtmlTable.rowsFrom;

public class SearchResultsPage extends PageObject {

    WebElement resultTable;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<Map<Object, String>> getSearchResults() {
        return rowsFrom(resultTable);
    }
}
