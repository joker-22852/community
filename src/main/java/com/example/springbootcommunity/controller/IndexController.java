package com.example.springbootcommunity.controller;

import com.example.springbootcommunity.dto.PaginationDTO;
import com.example.springbootcommunity.dto.QuestionDTO;
import com.example.springbootcommunity.entity.Question;
import com.example.springbootcommunity.mapper.QuestionMapper;
import com.example.springbootcommunity.mapper.UserMapper;
import com.example.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Map<String,Object> map,
                         @RequestParam(name = "page",defaultValue = "1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        PaginationDTO pagniation = questionService.list(page,size);
        map.put("pagniation",pagniation);
        map.put("totoalpage",3);
        return "index";
    }


}
