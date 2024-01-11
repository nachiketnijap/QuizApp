package com.nachiket.quiz.service;

import com.nachiket.quiz.Repository.QuestionRepository;
import com.nachiket.quiz.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK) ;
        }
        catch (Exception  e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try{
            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK) ;
        }
        catch (Exception  e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionRepository.save(question);
        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteByQuestionId(Integer id) {
        questionRepository.deleteById(id);
        return  new ResponseEntity<>("Deleted Successfully !",HttpStatus.OK);
    }

    public ResponseEntity<String> updateQuestionById(Integer id,Question question) {
        Question q=questionRepository.findById(id).get();
        if (Objects.nonNull(question.getQuestionTitle()) &&
                !"".equalsIgnoreCase(question.getQuestionTitle())){
            q.setQuestionTitle(question.getQuestionTitle());
        }
        questionRepository.save(q);

        return new ResponseEntity<>("Updated Successfully!",HttpStatus.OK);
    }
}
