package ac.in.cutm.erp.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.in.cutm.erp.exam.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
