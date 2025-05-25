#language: es
#Author: nicole.chavez
Característica: Verificar la correcta funcionalidad de la compra de tres productos en DemoBlaze

  COMO usuario de la plataforma DemoBlaze
  QUIERO realizar la compra de tres productos
  PARA validar la correcta funcionalidad de la compra de productos

  Antecedentes:
    Dado que usuario ingresa a la página web


  #Escenario 1
  @CompraDosProductos
  Esquema del escenario: Validar el correcto ingreso al sistema
    Dado usuario selecciona un <nombre_producto1>
    Y usuario navega a la pagina de inicio
    Y usuario selecciona un <nombre_producto2>
    Y usuario selecciona comprar para llenar los datos
    Y usuario llena datos <nombre>, <pais>, <cuidad>, <tarjeta_credito>, <mes_expiracion>, <anio_expiracion>
    Y da click en  comprar para finalizar
    Entonces verifica que se creo correctamente la compra

    Ejemplos:
      | nombre_producto1    | nombre_producto2    | nombre  |  pais | cuidad | tarjeta_credito | mes_expiracion | anio_expiracion |
      | 'Samsung galaxy s6' | 'Nokia lumia 1520'  | 'Nicole Chávez'  | 'Ecuador'| 'Quito'  | '123' | '02/12' | '123'|