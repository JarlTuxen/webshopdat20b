package dk.kea.webshopdat20b.repository;

import dk.kea.webshopdat20b.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAProductRepository extends CrudRepository<Product, Integer> {
}
