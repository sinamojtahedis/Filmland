package com.example.Filmland.controller;

import com.example.Filmland.entity.Category;
import com.example.Filmland.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //http://localhost:8080/api/all
    @GetMapping("/all")
    public List<Category> getAllCategorys() {

        return this.categoryService.findAllCategory();
    }

    //  http://localhost:8080/api/create
    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return this.categoryService.createCategory(category);
    }

    @PostMapping("/update")
    public void updateCategory(@RequestBody Category category) {
        this.categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        this.categoryService.deleteCategory(id);
    }

    //http://localhost:8080/api/getcategorybyid/1
    @GetMapping("/getcategorybyid/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.findCategoryById(id);

        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
