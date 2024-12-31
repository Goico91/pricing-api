package com.example.pricing.infrastructure.config;

import com.example.pricing.domain.exception.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalExceptionHandlerTest {

  private final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

  @Test
  void shouldHandlePriceNotFoundException() {
    // Given
    final PriceNotFoundException exception = new PriceNotFoundException("Price not found");

    // When
    final ResponseEntity<GlobalExceptionHandler.ErrorResponse> response =
        globalExceptionHandler.handlePriceNotFoundException(exception);

    // Then
    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    assertEquals("Price not found", Objects.requireNonNull(response.getBody()).message());
  }
}
