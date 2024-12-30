package com.example.pricing.infrastructure.adapters.out.adapter;

import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceDataJpaRepository extends JpaRepository<PriceEntity, Long> {}
