package com.hesmar.app.api;

import com.hesmar.app.domain.ShoppingList;
import com.hesmar.app.dto.request.ShoppingListCreatRequest;
import com.hesmar.app.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/shoppingLists")
@RequiredArgsConstructor
public class ShoppingListController {
    private final ShoppingListService shoppingListService;

    @PostMapping()
    public ResponseEntity<Void> add(@RequestBody ShoppingListCreatRequest shoppingListCreatRequest) {
        shoppingListService.add(shoppingListCreatRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Void> update(@RequestBody ShoppingList shoppingList) {
        shoppingListService.update(shoppingList);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        shoppingListService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping()
    public ResponseEntity<List<ShoppingList>> getAll() {
        return ResponseEntity.ok(shoppingListService.getAll());
    }


    @GetMapping("/getShoppingListByUserId/{id}")
    public ResponseEntity<List<ShoppingList>> getShoppingListByUserId(@PathVariable("id") String id) {

        return ResponseEntity.ok(shoppingListService.getShoppingListByUserId(id));

    }
    
    @GetMapping("/getShoppingListById/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable("id") String id) {
        return ResponseEntity.ok(shoppingListService.getShoppingListById(id));
    }
}