package com.example.Filmland.service;

import com.example.Filmland.entity.Category;


import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategory();

    Category createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Long id);

    Optional<Category> findCategoryById(Long id);
}
