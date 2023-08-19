package com.adinz.questionservice.service;


import com.adinz.questionservice.DTO.QuestionDTO;
import com.adinz.questionservice.DTO.ResponseDTO;
import com.adinz.questionservice.modal.Question;
import com.adinz.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST
        );


    }

    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try {
            return new ResponseEntity(questionRepository.findAllByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }




    public ResponseEntity<String> addQuestion(Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>(  "Record added succefully",HttpStatus.CREATED);
    }

    public ResponseEntity<List<Integer>> createQuize(String category, int noQ) {
        return new ResponseEntity<>(questionRepository.createRandomQuestionUsingTypeandNoQ(category,noQ),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionDTO>> getQuestionFromId(List<Integer> questionIds) {
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Integer questionId : questionIds){
            Question question = questionRepository.findById(questionId).get();
            QuestionDTO questionDTO = new QuestionDTO(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4());
            questionDTOList.add(questionDTO);
        }
        return new ResponseEntity<>(questionDTOList,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<ResponseDTO> responseDTOList) {

        int count=0;
        for(ResponseDTO responseDTO : responseDTOList){
            Question q = questionRepository.findById(responseDTO.getId()).get();
            if(responseDTO.getResponse().equals(q.getAnswer())){
                count++;
            }


        }
        return new ResponseEntity<>(count, HttpStatus.OK) ;

    }
}
