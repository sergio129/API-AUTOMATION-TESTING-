Feature: Automatizacion de las siguientes Apis CreateBooking, GetBooking, UpdateBooking

  @GenerarToken
  Scenario: Quiero generar token existosamente
    Given Me autentico en en la api Auth - CreateToken
    When Ingreso los datos de usuario y contraseña
    Then Resultado del servicio debe ser estatus: 200

  @CrearReserva
  Scenario: Quiero crear una reserva de forma exitosa
    Given Escribo los datos para la creacion de la reserva
    Then Resultado del servicio debe ser estatus: 200

  @ActualizarReserva
  Scenario: Quiero actualizar una reserva de forma exitosa
    Given Dato que tengo la reserva: 2694 y escribo los datos para la Actualizacion de la reserva
    Then Resultado del servicio debe ser estatus: 200

  @BuscarPruebas
  Scenario: Quiero consultar una reserva existente de forma exitosa
    Given Actualizar reserva : 2694 y deseo consultar los datos
    Then Resultado del servicio debe ser estatus: 200