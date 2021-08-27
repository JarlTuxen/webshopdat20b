package dk.kea.webshopdat20b.Repository;

import dk.kea.webshopdat20b.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> findAll()
    {
        String sql = "SELECT * FROM product";
        RowMapper<Product> productRowMapper = new BeanPropertyRowMapper<>(Product.class);

        return jdbcTemplate.query(sql, productRowMapper);
    }

    public void createProduct(Product product)
    {
        String sql = "INSERT INTO product (id, name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice());
    }

    public void deleteProduct(int id)
    {
        String sql = "DELETE FROM product WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    public Product findProductById(int id)
    {
        String sql = "SELECT * FROM product WHERE id=?";
        RowMapper<Product> productRowMapper = new BeanPropertyRowMapper<>(Product.class);
        return jdbcTemplate.queryForObject(sql, productRowMapper, id);
    }

    public void updateProduct(Product product)
    {
        String sql = "UPDATE product set name=?, price=? WHERE id=?";
        jdbcTemplate.update(sql, product.getName(), product.getPrice(), product.getId());
    }
}
