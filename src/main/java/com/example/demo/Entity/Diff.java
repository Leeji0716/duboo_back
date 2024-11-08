package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Diff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long floor;

    @Column(nullable = false)
    private Long num;

    @Column(nullable = false)
    private BigDecimal ref;

    @Column(nullable = false)
    private BigDecimal las;

    @Column(nullable = false)
    private BigDecimal diff;
}
