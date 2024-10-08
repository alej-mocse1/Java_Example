package com.example.apirest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Products {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String Categoria;
    private String Descpription;
    private int Price;
    private String Name;



    ///getters and setters
    public String getCategoria() {
        return Categoria;
    }
    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
    public String getDescpription() {
        return Descpription;
    }
    public void setDescpription(String descpription) {
        Descpription = descpription;
    }
    public int getPrice() {
        return Price;
    }
    public void setPrice(int price) {
        Price = price;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }


    
}
