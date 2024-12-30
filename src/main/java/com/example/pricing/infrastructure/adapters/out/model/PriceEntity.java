package com.example.pricing.infrastructure.adapters.out.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long priceId;

  private Long brandId;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private Integer priceList;
  private Long productId;
  private Integer priority;
  private Double price;
  private String currency;
}
