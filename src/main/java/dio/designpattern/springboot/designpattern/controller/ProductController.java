package dio.designpattern.springboot.designpattern.controller;


import dio.designpattern.springboot.designpattern.entity.Product;
import dio.designpattern.springboot.designpattern.repository.ProductRepository;
import dio.designpattern.springboot.designpattern.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product existingProduct = service.getProductById(id);

        if(existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            return service.saveProduct(existingProduct);
        } else {
            return null;
        }

    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
    }

}
