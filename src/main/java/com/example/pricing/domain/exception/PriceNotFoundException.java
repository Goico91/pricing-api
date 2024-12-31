package com.example.pricing.domain.exception;

/** Custom Price Exception */
public class PriceNotFoundException extends RuntimeException {
  public PriceNotFoundException(String message) {
    super(message);
  }
}
