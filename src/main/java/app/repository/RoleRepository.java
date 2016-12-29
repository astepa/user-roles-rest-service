package app.repository;

import app.model.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository
        extends CrudRepository<Role, Long>,
        JpaSpecificationExecutor<Role> {
}