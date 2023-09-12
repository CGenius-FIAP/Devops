package br.com.fiap.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cg.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
