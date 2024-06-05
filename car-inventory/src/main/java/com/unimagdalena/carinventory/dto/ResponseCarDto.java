package com.unimagdalena.carinventory.dto;

public record ResponseCarDto(
    String id,
    String model,
    String maker,
    Boolean available
    ) {}
