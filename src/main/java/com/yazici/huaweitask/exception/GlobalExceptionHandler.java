package com.yazici.huaweitask.exception;

import com.yazici.huaweitask.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {ParkingAreaException.class})
  protected ResponseEntity<ErrorResponse> handleParkingAreaException(ParkingAreaException ex) {
    return ResponseEntity.status(ex.getParkingAreaError().getHttpStatus())
        .body(
            ErrorResponse.builder()
                .code(ex.getParkingAreaError().getErrorCode())
                .message(ex.getParkingAreaError().getMessage())
                .build());
  }

  @ExceptionHandler(value = {PriceListException.class})
  protected ResponseEntity<ErrorResponse> handleParkingListException(PriceListException ex) {
    return ResponseEntity.status(ex.getPriceListError().getHttpStatus())
        .body(
            ErrorResponse.builder()
                .code(ex.getPriceListError().getErrorCode())
                .message(ex.getPriceListError().getMessage())
                .build());
  }

  @ExceptionHandler(value = {ParkException.class})
  protected ResponseEntity<ErrorResponse> handleParkException(ParkException ex) {
    return ResponseEntity.status(ex.getParkError().getHttpStatus())
        .body(
            ErrorResponse.builder()
                .code(ex.getParkError().getErrorCode())
                .message(ex.getParkError().getMessage())
                .build());
  }

  @ExceptionHandler(value = {VehicleException.class})
  protected ResponseEntity<ErrorResponse> handleVehicleException(VehicleException ex) {
    return ResponseEntity.status(ex.getVehicleError().getHttpStatus())
        .body(
            ErrorResponse.builder()
                .code(ex.getVehicleError().getErrorCode())
                .message(ex.getVehicleError().getMessage())
                .build());
  }
}
