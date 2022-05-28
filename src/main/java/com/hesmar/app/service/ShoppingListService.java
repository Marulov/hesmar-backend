package com.hesmar.app.service;

import com.hesmar.app.domain.Market;
import com.hesmar.app.domain.Product;
import com.hesmar.app.domain.ShoppingList;
import com.hesmar.app.domain.User;
import com.hesmar.app.dto.request.ShoppingListCreatRequest;
import com.hesmar.app.repository.ProductRepository;
import com.hesmar.app.repository.ShoppingListRepository;
import com.hesmar.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public Double add(ShoppingListCreatRequest shoppingListCreatRequest) {
        List<Product> products = new ArrayList<>();
        double amount = 0.0;

        User user = userRepository.findById(shoppingListCreatRequest.getUserId()).orElseThrow(() ->
                new RuntimeException("Cannot find user by id " + shoppingListCreatRequest.getUserId()));

        for (String productId : shoppingListCreatRequest.getProductId()) {
            Product product = productRepository.findById(productId).orElseThrow(() ->
                    new RuntimeException("Cannot find product by id " + shoppingListCreatRequest.getProductId()));
            amount = amount + product.getMarkets().stream().mapToDouble(Market::getUnitPrice).min().getAsDouble();

            products.add(product);
        }

        ShoppingList saveShoppingList = new ShoppingList();
        saveShoppingList.setUser(user);
        saveShoppingList.setProducts(products);
        shoppingListRepository.save(saveShoppingList);
        return amount;
    }

    public void update(ShoppingList shoppingList) {
        ShoppingList savedShoppingList = shoppingListRepository.findById(shoppingList.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find Shopping list by id " + shoppingList.getId())
        );

        savedShoppingList.setProducts(shoppingList.getProducts());
        savedShoppingList.setUser(shoppingList.getUser());

        shoppingListRepository.save(savedShoppingList);
    }

    public List<ShoppingList> getShoppingListByUserId(String userId) {
        return shoppingListRepository.findShoppingListByUser_Id(userId).orElseThrow(() -> new RuntimeException("Cannot find user by id " + userId));
    }

    public void delete(String id) {
        shoppingListRepository.deleteById(id);
    }

    public List<ShoppingList> getAll() {
        return shoppingListRepository.findAll();
    }

    public ShoppingList getShoppingListById(String id) {
        return shoppingListRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find product by id " + id));
    }
}