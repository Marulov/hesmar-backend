package com.hesmar.app.repository;

import com.hesmar.app.domain.ShoppingList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository extends MongoRepository<ShoppingList, String> {

    Optional<List<ShoppingList>> findShoppingListByUser_Id(String userId);

}