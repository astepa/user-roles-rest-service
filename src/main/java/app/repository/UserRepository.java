package app.repository;

import app.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
        extends CrudRepository<User, Long>,
        JpaSpecificationExecutor<User> {
}