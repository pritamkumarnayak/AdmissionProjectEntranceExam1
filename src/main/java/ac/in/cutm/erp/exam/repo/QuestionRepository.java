package ac.in.cutm.erp.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.in.cutm.erp.exam.model.exam.Question;
import ac.in.cutm.erp.exam.model.exam.Quiz;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
