package com.example.demo.DTO;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record DiffResponseDTO(Long num, BigDecimal ref, BigDecimal las, BigDecimal diff) {
}
