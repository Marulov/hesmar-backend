package com.hesmar.app.service;

import com.hesmar.app.domain.Product;
import com.hesmar.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void add(Product product) {
        productRepository.save(product);
    }

    public void update(Product product) {
        Product savedProduct = productRepository.findById(product.getId()).orElseThrow(
                () -> new RuntimeException("Cannot find product by id " + product.getId())
        );

        savedProduct.setBarcode(product.getBarcode());
        savedProduct.setBrand(product.getBrand());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setMarkets(product.getMarkets());
        savedProduct.setName(product.getName());
        savedProduct.setUnitsInStock(product.getUnitsInStock());
        savedProduct.setFavorite(product.isFavorite());
        savedProduct.setImageUrl(product.getImageUrl());

        productRepository.save(savedProduct);
    }

    public void delete(String id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find product by id " + id));
    }

    public List<Product> getProductByCategoryName(String name) {
        return productRepository.findProductByCategoryName(name).orElseThrow(
                () -> new RuntimeException("Cannot find product by category name " + name));
    }

    public List<Product> getProductByBrandName(String name) {
        return productRepository.findProductByBrandName(name).orElseThrow(
                () -> new RuntimeException("Cannot find product by brand name " + name));
    }

    public List<Product> getProductByMarketsName(String name) {
        return productRepository.findProductByMarketsName(name).orElseThrow(
                () -> new RuntimeException("Cannot find product by markets name " + name));
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findProductByNameLike(name).orElseThrow(
                () -> new RuntimeException("Cannot find product by name " + name));
    }

    public List<Product> getProductByFavorite() {
        return productRepository.findProductByFavoriteTrue().orElseThrow(
                () -> new RuntimeException("Cannot find favorite product by name "));
    }

    public Product changeFavorite(String id){
        Product savedProduct = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find product by id " + id)
        );

        savedProduct.setFavorite(!savedProduct.isFavorite());

        productRepository.save(savedProduct);

        return savedProduct;
    }
}