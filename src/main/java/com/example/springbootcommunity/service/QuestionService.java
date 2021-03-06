package com.example.springbootcommunity.service;

import com.example.springbootcommunity.dto.PaginationDTO;
import com.example.springbootcommunity.dto.QuestionDTO;
import com.example.springbootcommunity.entity.Question;
import com.example.springbootcommunity.entity.User;
import com.example.springbootcommunity.mapper.QuestionMapper;
import com.example.springbootcommunity.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionMapper questionMapper;
    public PaginationDTO list(Integer page, Integer size) {
        Integer offset=size*(page-1);
        List<Question> list = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOS=new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for(Question question:list){
            User byId = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(byId);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        Integer count = questionMapper.count();
        paginationDTO.setPagination(count,page,size);
        return paginationDTO;
    }

    public PaginationDTO list(Integer i, Integer page, Integer size) {
        Integer offset=size*(page-1);
        List<Question> list = questionMapper.list2(1,offset,size);
        List<QuestionDTO> questionDTOS=new ArrayList<>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for(Question question:list){
            User byId = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(byId);
            questionDTOS.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOS);
        Integer count = questionMapper.count();
        paginationDTO.setPagination(count,page,size);
        return paginationDTO;
    }

    public QuestionDTO getbyId(Integer id) {
        Question question=questionMapper.getbyId(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        return questionDTO;
    }

    public void incView(Integer id) {
        Question question1 = questionMapper.getbyId(id);

        Question question=new Question();
        question.setView_count(question1.getView_count()+1);
        questionMapper.update(question.getView_count(),id);
    }
}
