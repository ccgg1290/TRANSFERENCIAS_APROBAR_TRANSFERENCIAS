


@regresion
Feature: Yo como cliente corporativo quiero aprobar una transferencia

  @AprobarTransferenciaEndToEnd
  Scenario Outline: AprobarTrnasferencia
    Given El cliente se encuentra en el submodulo Transferencias_AprobarTransferencias
    When Consulta las transferencias que desea aprobar
      | TipoTransferencia |NumeroProceso |ProductoOrigen  |FechaCreacionEntre|FechaCreacionHasta|Creador|ProductoDestino|TotalTransferencias|Transferencias Seleccionadas|MontoTotal|ClaveToken|Descripcion|
      |<TipoTransferencia>|<NumeroProceso>|<ProductoOrigen>|<FechaCreacionEntre>|<FechaCreacionHasta>|<Creador>|<ProductoDestino>|<TotalTransferencias>|<Transferencias Seleccionadas>|<MontoTotal>|<ClaveToken>|<Descripcion>|
    When Aprueba la transaccion
      |ClaveToken|Descripcion|
      |<ClaveToken>|<Descripcion>|
    Then Se muestra el mensaje final <MensajeFinal>

    Examples:
      | TipoTransferencia | NumeroProceso |  ProductoOrigen | FechaCreacionEntre | FechaCreacionHasta|Creador| ProductoDestino | TotalTransferencias|Transferencias Seleccionadas|MontoTotal|ClaveToken|Descripcion|MensajeFinal|
      |                    |               |                 |                    |                   |       |                 |                    |                            |           |         |           |            |

#Transferencias Cliente Fic | Transferencias Cartera Colectiva | Transferencias Entre Cuentas Propias | -- SELECCIONE -- | Traslado Sebra|
#cristian camilo gualtero garcia
# CUENTA DE AHORRO - 116050057245 | CUENTA DE AHORRO - 116060084657
# CUENTA CORRIENTE - 146060023612 | CUENTA CORRIENTE - 146210000014

  @DescargarArchivo
  Scenario Outline: DescargarArchivo
    Given El cliente se encuentra en el submodulo Transferencias_AprobarTransferencias
    When Consulta las transferencias que desea aprobar
      | TipoTransferencias |NumeroProcesoValidar  |Paginas|NumeroProcesoBuscar|ProductoOrigen  |FechaCreacionEntre  |FechaCreacionHasta  |Creador  |ProductoDestino  |ListaPaginas|TotalTransferencias  |Transferencias Seleccionadas  |
      |<TipoTransferencias>|<NumeroProcesoValidar>|<Paginas>|<NumeroProcesoBuscar>|<ProductoOrigen>|<FechaCreacionEntre>|<FechaCreacionHasta>|<Creador>|<ProductoDestino>|<ListaPaginas>|<TotalTransferencias>|<Transferencias Seleccionadas>|
    Then Descarga el archivo
      |TipoDeArchivo|NumeroProcesoBuscar|
      |<TipoDeArchivo>|<NumeroProcesoBuscar>|


    Examples:
      | TipoTransferencias                  |NumeroProcesoValidar|Paginas| NumeroProcesoBuscar|ProductoOrigen             | FechaCreacionEntre | FechaCreacionHasta|Creador         | ProductoDestino         | ListaPaginas|TotalTransferencias|Transferencias Seleccionadas|TipoDeArchivo|
      | Transferencias Entre Cuentas Propias|                    | 2-3  |        2853-2826    |--SELECCIONE EL PRODUCTO--|    01/03/2024      |  12/03/2024       |-- SELECCIONE --|--SELECCIONE EL PRODUCTO--|             |       46          |              1             |    EXCEL    |
      | Transferencias Entre Cuentas Propias|                    | 1-1  |        2891-2883    |--SELECCIONE EL PRODUCTO--|    01/03/2024      |  12/03/2024       |-- SELECCIONE --|--SELECCIONE EL PRODUCTO--|             |       46          |              1             |    EXCEL    |
      | Transferencias Entre Cuentas Propias|                    |  3   |          2826       |--SELECCIONE EL PRODUCTO--|    01/03/2024      |  12/03/2024       |-- SELECCIONE --|--SELECCIONE EL PRODUCTO--|             |       46          |              1             |    EXCEL    |
      | Transferencias Entre Cuentas Propias|                    |      |          2826       |--SELECCIONE EL PRODUCTO--|    01/03/2024      |  12/03/2024       |-- SELECCIONE --|--SELECCIONE EL PRODUCTO--|             |       46          |              1             |    EXCEL    |
  @ValidarDetalle
  Scenario Outline: Validar Detalle de las tranacciones
    Given El cliente se encuentra en el submodulo Transferencias_AprobarTransferencias
    When Consulta las transferencias que desea aprobar
      | TipoTransferencias |NumeroProceso |ProductoOrigen  |FechaCreacionEntre|FechaCreacionHasta|Creador|ProductoDestino|TotalTransferencias|Transferencias Seleccionadas|MontoTotal|ClaveToken|Descripcion|
      |<TipoTransferencias>|<NumeroProceso>|<ProductoOrigen>|<FechaCreacionEntre>|<FechaCreacionHasta>|<Creador>|<ProductoDestino>|<TotalTransferencias>|<Transferencias Seleccionadas>|<MontoTotal>|<ClaveToken>|<Descripcion>|
    Then Puede ver el detalle de la transaccion
    Examples:
      | TipoTransferencias | NumeroProceso |  ProductoOrigen | FechaCreacionEntre | FechaCreacionHasta|Creador| ProductoDestino | TotalTransferencias|Transferencias Seleccionadas|MontoTotal|ClaveToken|Descripcion|TipoDeArchivo|
      |                    |               |                 |                    |                   |       |                 |                    |                            |          |          |           |             |