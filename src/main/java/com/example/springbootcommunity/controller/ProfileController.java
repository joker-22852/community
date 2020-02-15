package com.example.springbootcommunity.controller;

import com.example.springbootcommunity.dto.PaginationDTO;
import com.example.springbootcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable("action") String action,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1") Integer page,
                          @RequestParam(name = "size",defaultValue = "5") Integer size){
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if("repies".equals(action)){
            model.addAttribute("section","repies");
            model.addAttribute("sectionName","我的回复");
        }
        PaginationDTO pagniation = questionService.list(1,page, size);
        model.addAttribute("pagniation",pagniation);
        model.addAttribute("totoalpage",3);
        return "profile";
    }
}
