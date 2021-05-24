package CourseWork.Autoservice.repo;

import CourseWork.Autoservice.models.ProductType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends CrudRepository<ProductType, Long>
{

}
