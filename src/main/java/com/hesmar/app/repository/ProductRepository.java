package com.hesmar.app.repository;

import com.hesmar.app.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<List<Product>> findProductByBrandName(String name);

    Optional<List<Product>> findProductByCategoryName(String name);

    Optional<List<Product>> findProductByMarketsName(String name);

    Optional<List<Product>> findProductByName(String name);

    Optional<List<Product>> findProductByNameLike(String name);

    Optional<List<Product>> findProductByFavoriteTrue();

}