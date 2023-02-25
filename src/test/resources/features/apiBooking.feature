Feature: Automatizar los endpoints CreateBooking, GetBooking y UpdateBooking.

  @GenerarToken
  Scenario: Generar token exitosamente
    Given Sergio se loguea en el aplicativo booking
    Then  el valida que la respuesta del servicio sea: 200

  @CrearReserva
  Scenario: Crear una reserva de forma exitosa
    Given Sergio ingresa los datos para la creacion de una reserva
    Then el valida que la respuesta del servicio sea: 200

  @ActualizarReserva
  Scenario: Actualizar reserva de forma exitosa
    Given Sergio se loguea en el aplicativo booking
    When el ingresa los datos para actualizar la reserva : 2694
    Then el valida que la respuesta del servicio sea: 200

  @ListarReservas
  Scenario: Consultar una reserva existente de forma exitosa
    Given Sergio quiere consultar la reserva: 2694
    Then el valida que la respuesta del servicio sea: 200