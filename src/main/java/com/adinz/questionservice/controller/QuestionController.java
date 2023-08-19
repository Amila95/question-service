package com.adinz.questionservice.controller;


import com.adinz.questionservice.DTO.QuestionDTO;
import com.adinz.questionservice.DTO.ResponseDTO;
import com.adinz.questionservice.modal.Question;
import com.adinz.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @RequestMapping("allQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();

    }

    @RequestMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return  questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String category, @RequestParam Integer numQuestions){
        return  questionService.createQuize(category,numQuestions);
    }

    @PostMapping("getQuestion")
    public ResponseEntity<List<QuestionDTO>> getQustionFromId(@RequestBody List<Integer> questionId){
        return questionService.getQuestionFromId(questionId);

    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseDTO> responseDTOList){
        return questionService.getScore(responseDTOList);
    }
}
