package com.hesmar.app.api;

import com.hesmar.app.domain.Product;
import com.hesmar.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody Product product) {
        productService.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody Product product) {
        productService.update(product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/getProductByCategoryName/{name}")
    public ResponseEntity<List<Product>> getProductByCategoryName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProductByCategoryName(name));
    }

    @GetMapping("/getProductByBrandName/{name}")
    public ResponseEntity<List<Product>> getProductByBrandName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProductByBrandName(name));
    }

    @GetMapping("/getProductByMarketsName/{name}")
    public ResponseEntity<List<Product>> getProductByMarketsName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProductByMarketsName(name));
    }

    @GetMapping("/getProductByName/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/getProductByFavorite")
    public ResponseEntity<List<Product>> getProductByFavorite() {
        return ResponseEntity.ok(productService.getProductByFavorite());
    }

    @GetMapping("/getProductByBarcodeNumber/{number}")
    public ResponseEntity<List<Product>> getProductByBarcodeNumber(@PathVariable Long number) {
        return ResponseEntity.ok(productService.getProductByBarcodeNumber(number));
    }

    @GetMapping("/changeFavorite/{id}")
    public ResponseEntity<Product> changeFavorite(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.changeFavorite(id));
    }

}