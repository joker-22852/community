package com.example.springbootcommunity.controller;

import com.example.springbootcommunity.dto.QuestionDTO;
import com.example.springbootcommunity.mapper.QuestionMapper;
import com.example.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {

    /**
     *
     */
    @Autowired
    private QuestionService questionService;
    @GetMapping("question/{id}")
    public String question(@PathVariable("id") Integer id, Model model){

        QuestionDTO questionDTO=questionService.getbyId(id);
        questionService.incView(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
