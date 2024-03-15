package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuWeb {

    public static final Target TRANSFERENCIAS= Target.the("Transferencias")
            .located(By.linkText("Transferencias"));
    public static final Target TRANSFERENCIASENTRECUENTASPROPIAS = Target.the("Transferencias Entre Cuentas Propias")
            .located(By.linkText("Transferencias Entre Cuentas Propias"));

    public static final Target APROBARTRANSFERENCIAS= Target.the("Aprobar Transferencias")
            .located(By.linkText("Aprobar Transferencias"));



}
