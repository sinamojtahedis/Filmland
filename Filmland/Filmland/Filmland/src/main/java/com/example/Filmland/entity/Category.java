package com.example.Filmland.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull
    @Size(max = 200)
    private String name;

    @NotNull
    @Size(max = 10)
    private Integer availableContent;

    @NotNull
    private Double price;

    public Category(String name, Integer availableContent, Double price) {
        this.name = name;
        this.availableContent = availableContent;
        this.price = price;
    }
}

