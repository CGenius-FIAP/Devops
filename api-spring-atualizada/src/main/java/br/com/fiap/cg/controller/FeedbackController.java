package br.com.fiap.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cg.exceptions.ResourceNotFoundException;
import br.com.fiap.cg.model.Feedback;
import br.com.fiap.cg.repository.FeedbackRepository;


@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@GetMapping("/")
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@PostMapping("/")
	public Feedback createFeedback(@RequestBody Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@GetMapping("/{id}")
	public Feedback getFeedbackById(@PathVariable Long id) {
		return feedbackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Feedback", "id", id));
	}

}