package ac.in.cutm.erp.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.in.cutm.erp.exam.model.exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
