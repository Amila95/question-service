package com.adinz.questionservice.repository;

import com.adinz.questionservice.modal.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findAllByCategory(String category);
    @Query(value = "SELECT q.id FROM question q Where q.category=:category LIMIT :noQ", nativeQuery = true)
    List<Integer> createRandomQuestionUsingTypeandNoQ(String category, int noQ);
}
