package com.hesmar.app.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ShoppingListCreatRequest {
    private String userId;
    private List<String> productId;
}
