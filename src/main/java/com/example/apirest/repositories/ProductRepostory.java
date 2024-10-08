package com.example.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.apirest.entities.Products;
import jakarta.transaction.Transactional;

@Transactional
public interface ProductRepostory extends JpaRepository<Products,Long>{

}
