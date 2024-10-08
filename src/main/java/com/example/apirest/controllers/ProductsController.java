package com.example.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.apirest.entities.Products;
import com.example.apirest.repositories.ProductRepostory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/Products")
public class ProductsController {

    @Autowired
    private ProductRepostory productRepostory;

    /// OK
    @GetMapping("/getProductAll")
    public List<Products> getAllProducts() {
        return productRepostory.findAll();
    }

    // OK
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Products product = productRepostory.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

            return ResponseEntity.ok(product); // Retorna el producto si se encuentra
        } catch (RuntimeException e) {
            // Captura la excepción y devuelve un 404 Not Found con el mensaje de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // OK
    @PutMapping("/UpdateProducts/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Long id, @RequestBody Products body) {

        try {
            Products producto = productRepostory.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

            producto.setCategoria(body.getCategoria());
            producto.setDescpription(body.getDescpription());
            producto.setPrice(body.getPrice());
            producto.setName(body.getName());

            productRepostory.save(producto);

            return ResponseEntity.ok(producto); // Retorna el producto si se encuentra
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // OK
    @PostMapping("/createProducts")
    public ResponseEntity<?> postMethodName(@RequestBody Products body) {
        try {
            Products ProductUpdate = productRepostory.save(body);       
            return ResponseEntity.ok(ProductUpdate);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

    // OK
    @DeleteMapping("/deleteProducts/{id}")
    public String deleteMethodName(@PathVariable Long id) {

        try {
            Products Producto = productRepostory.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

            productRepostory.delete(Producto);

            return "El producto " + id + " fue eliminado ";
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }

    }

}
