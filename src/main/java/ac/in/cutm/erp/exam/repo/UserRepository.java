package ac.in.cutm.erp.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.in.cutm.erp.exam.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
