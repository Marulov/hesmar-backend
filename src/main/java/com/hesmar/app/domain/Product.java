package com.hesmar.app.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Product {
    @Id
    private String id;
    private Category category;
    private Brand brand;
    private Barcode barcode;
    private List<Market> markets;
    private String name;
    private int unitsInStock;
    private boolean favorite;

}