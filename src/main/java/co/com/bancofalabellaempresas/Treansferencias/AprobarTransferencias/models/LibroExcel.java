package co.com.bancofalabellaempresas.Treansferencias.AprobarTransferencias.models;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelSheet;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ExcelSheet("Hoja 1")
public class LibroExcel {

    @ExcelCellName("TipoPago")
    private String tipoDePago;
    @ExcelCellName("Nro.Proceso")
    private String nroProceso;
    @ExcelCellName("fechaCreacion")
    private String fechaDeCreacion;
    @ExcelCellName("Estado")
    private String estado;
    @ExcelCellName("ProductoOrigen")
    private String productoOrigen;
    @ExcelCellName("ProductoDestino")
    private String productoDestino;
    @ExcelCellName("ValorPago")
    private String valorPago;
    @ExcelCellName("Descripcion")
    private String descripcion;

    @Override
    public String toString() {
        return "LibroExcel{" +
                "tipoDePago='" + tipoDePago + '\'' +
                ", nroProceso='" + nroProceso + '\'' +
                ", fechaDeCreacion='" + fechaDeCreacion + '\'' +
                ", estado='" + estado + '\'' +
                ", productoOrigen='" + productoOrigen + '\'' +
                ", productoDestino='" + productoDestino + '\'' +
                ", valorPago='" + valorPago + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }




    public LibroExcel(String tipoDePago, String nroProceso, String fechaDeCreacion, String estado,  String productoOrigen, String productoDestino, String valorPago,String descripcion) {
        this.tipoDePago = tipoDePago;
        this.nroProceso = nroProceso;
        this.fechaDeCreacion = fechaDeCreacion;
        this.estado = estado;
        this.productoOrigen = productoOrigen;
        this.productoDestino = productoDestino;
        this.valorPago = valorPago;
        this.descripcion = descripcion;
    }

}
