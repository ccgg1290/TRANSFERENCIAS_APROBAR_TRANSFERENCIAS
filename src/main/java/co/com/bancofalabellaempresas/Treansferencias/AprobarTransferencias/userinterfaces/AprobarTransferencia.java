package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AprobarTransferencia {

    public static MenuWeb menuWeb;
    public static final Target LABELMAIN= Target.the("Transferencias").located(By.id("lblMasterTitulo"));


    //Pantalla1

    public static final Target TIPOTRANSFERENCIA= Target.the("Tipo transferencia").located(By.id("cphCuerpo_ddlTipoPago"));
    public static final Target NUMEROPROCESO = Target.the("Numero proceso").located(By.id("cphCuerpo_tbNumeroProceso"));
    public static final Target LISTAPRODUCTOORIGEN = Target.the("Lista producto origen").located(By.id("cphCuerpo_ddlProductoOrigen"));
    public static final Target FECHACREACIONENTRE = Target.the("Fecha entre").located(By.id("cphCuerpo_tbFechaCreacionInicial"));
    public static final Target FECHACREACIONHASTA = Target.the("Fecha hasta").located(By.id("cphCuerpo_tbFechaCreacionFinal"));
    public static final Target LISTACREADOR = Target.the("lista creador").located(By.id("cphCuerpo_ddlCreador"));
    public static final Target LISTAPRODUCTODESTINO = Target.the("Lista productodestino").located(By.id("cphCuerpo_ddlProductoDestino"));
    public static final Target BTNBUSCARPROCESOS = Target.the("Buscar proceso").located(By.id("cphCuerpo_btBuscar"));
    //PANTALLA2
    public static final Target TOTALTRANSFERENCIAS = Target.the("Total transferencias").located(By.id("cphCuerpo_lblCantidadDeRegistros"));
    public static final Target TABLAGRILLA = Target.the("Tabla grilla").located(By.id("cphCuerpo_gvProcesosPago"));

    public static final Target TRASNFERENCIASSELECCIONADAS= Target.the("TOTAL TRANSFERENCIAS SELECCIONADAS").located(By.id("cphCuerpo_lblContadorProductos"));
    public static final Target MONTO= Target.the("Monto").located(By.id("cphCuerpo_lblValorTotalProductos"));



    public static final Target DESCARGAEXCEL = Target.the("Boton descargar excel").located(By.id("cphCuerpo_lnkExcelConsultar"));
    public static final Target DESCARGAPDF= Target.the("Boton descargar pdf").located(By.id("cphCuerpo_lnkPDFConsultar"));
    public static final Target SELECCIONARTODO = Target.the("Seleccionat todas las trasnferencias").located(By.id("cphCuerpo_gvProcesosPago_ckbSelecTodo"));
    public static final Target CHECKBOX = Target.the("Transaccion check").located(By.id("cphCuerpo_gvProcesosPago_CkbAprobar_0"));
    public static final Target CLAVETOKEN= Target.the("clave token ").located(By.id("cphCuerpo_tbxClaveToken"));
    public static final Target BTNAPROBAR= Target.the("boton aprobar").located(By.id("cphCuerpo_BtnAprobar"));
    public static final Target BTNRECHAZAR= Target.the("boton rechazar").located(By.id("cphCuerpo_btnRechazar"));

    //QUESTION

    public static final Target LABELQUESTIONS= Target.the("Transferencias Entre Cuentas Propias").located(By.id("lblMasterAlerta"));

}
