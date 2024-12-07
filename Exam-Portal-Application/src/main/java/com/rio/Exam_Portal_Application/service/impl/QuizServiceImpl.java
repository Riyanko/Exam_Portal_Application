package com.rio.Exam_Portal_Application.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.rio.Exam_Portal_Application.dto.QuestionDto;
import com.rio.Exam_Portal_Application.model.ExamHistory;
import com.rio.Exam_Portal_Application.model.Question;
import com.rio.Exam_Portal_Application.model.Quiz;
import com.rio.Exam_Portal_Application.model.ResponseQuiz;
import com.rio.Exam_Portal_Application.model.Users;
import com.rio.Exam_Portal_Application.repository.ExamHistroyRepository;
import com.rio.Exam_Portal_Application.repository.QuestionRepository;
import com.rio.Exam_Portal_Application.service.CustomUserDetailsService;
import com.rio.Exam_Portal_Application.service.QuizService;
import com.rio.Exam_Portal_Application.repository.QuizRepository;
import com.rio.Exam_Portal_Application.repository.UserRepository;
import com.rio.Exam_Portal_Application.securityConfig.UserPrincipal;

@Service
public class QuizServiceImpl implements QuizService{
	@Autowired
	QuizRepository quizrepo;
	
	@Autowired
	QuestionRepository questionRepo;
	
	@Autowired
	ExamHistroyRepository examHistroy;
	
	@Autowired
	UserRepository userRepo;
	
	
	

	@Override
	public ResponseEntity<String> createQuiz(String category, int nQues, String title) {
		// TODO Auto-generated method stub
		List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,nQues);
		
		
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizrepo.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	@Override
	public List<QuestionDto> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizrepo.findById(id);
		List<Question> questionsFromDB=quiz.get().getQuestions();
		
		List<QuestionDto> questionsForUser=new ArrayList<>();
		
		for(Question q:questionsFromDB) {
			QuestionDto ques=new QuestionDto(
					q.getId(),
					q.getQuestionTitle(),
					q.getOption1(),
					q.getOption2(),
					q.getOption3(),
					q.getOption4(),
					q.getCategory()
			);
			questionsForUser.add(ques);
		}
		return questionsForUser;
	}

	@Override
	public float calculateResult(Integer id, List<ResponseQuiz> responsequiz) {
		Quiz quiz=quizrepo.findById(id).get();
		
		List<Question> questions = quiz.getQuestions();
		int size=questions.size();
		int i=0;
		int result=0;
		for(ResponseQuiz rq: responsequiz) {
			if(rq.getResponse().equals(questions.get(i).getRightAnswer())) {
				result++;
			}
			i++;
		}
		float percentage=(((float)result/(float)size)*100);
		ExamHistory history=new ExamHistory();
		history.setExamId(id);
		history.setExamName(quiz.getTitle());
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		Users user=userRepo.findByEmail(authentication.getName());
		
		history.setExamSubmittedBy(user.getRollNumber());;
		history.setExamSubmittedAt(LocalDateTime.now());
		history.setScore(result);
		history.setPercentage(percentage);
		history.setUsers(user);
		examHistroy.save(history);
		return percentage;
	}
}
	
