package com.hesmar.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Market {
    private String name;
    private Double unitPrice;
}