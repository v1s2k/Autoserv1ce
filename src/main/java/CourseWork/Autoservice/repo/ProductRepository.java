package CourseWork.Autoservice.repo;

import CourseWork.Autoservice.models.Product;
import CourseWork.Autoservice.models.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findByProductType(ProductType productType); // находит все продукты данного типа.

}
