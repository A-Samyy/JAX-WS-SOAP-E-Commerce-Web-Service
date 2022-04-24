package gov.iti.jets.repository;

import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.enums.Category;
import gov.iti.jets.domain.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductRepository extends AbstractRepository<Product> {
    public ProductRepository(EntityManager entityManager) {
        super(entityManager);
        this.setClazz(Product.class);
    }
//Category category = Category.valueOf( req.getParameter( "category" ) );
    public List<Product> findProductsByCategory(Category productCategory) {
        List<Product> products = new ArrayList<>();
        TypedQuery<Product> queryByCategory = entityManager
                .createQuery("SELECT p FROM Product  p WHERE (p.category = :category)", Product.class);
        products = queryByCategory.setParameter("category", productCategory).getResultList();
        return products;
    }


}
