Feature: Automatizacion de las siguientes Apis CreateBooking, GetBooking, UpdateBooking

  @GenerarToken
  Scenario: Quiero generar token existosamente
    Given Me autentico en en la api Auth - CreateToken
    When Ingreso los datos de usuario y contraseña
    Then Se genera el token y el resultado del servicio debe ser estatus: "200"
