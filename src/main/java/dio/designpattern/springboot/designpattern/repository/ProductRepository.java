package dio.designpattern.springboot.designpattern.repository;

import dio.designpattern.springboot.designpattern.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
