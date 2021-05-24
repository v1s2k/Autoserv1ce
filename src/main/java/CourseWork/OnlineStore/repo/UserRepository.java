package CourseWork.OnlineStore.repo;

//
//import CourseWork.OnlineStore.models.User;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends CrudRepository<User, Long> {
//    Optional<User> findByUsername(String username);
//}

import CourseWork.OnlineStore.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
