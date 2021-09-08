package dk.kea.webshopdat20b.service;

import dk.kea.webshopdat20b.model.Product;
import dk.kea.webshopdat20b.repository.JPAProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    JPAProductRepository productRepository;

    public List<Product> getAll()
    {
        List<Product> products = new ArrayList<>();
        for (Product product:productRepository.findAll())
        {
            products.add(product);
        }
        return products;
    }

    public void createProduct(Product product)
    {
        //productRepository.createProduct(product);
        productRepository.save(product);
    }

    public void deleteProduct(int id)
    {
        productRepository.deleteById(id);
    }

    public Optional<Product> findProductById(int id)
    {
        return productRepository.findById(id);
    }

    public void updateProduct(Product product)
    {
        productRepository.save(product);
    }
}
