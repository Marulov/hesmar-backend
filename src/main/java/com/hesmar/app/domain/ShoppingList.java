package com.hesmar.app.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class ShoppingList {
    @Id
    private String id;
    private User user;
    private List<Product> products;

}
