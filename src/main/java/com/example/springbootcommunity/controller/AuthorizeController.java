package com.example.springbootcommunity.controller;


import com.example.springbootcommunity.dto.AccessTokenDTO;
import com.example.springbootcommunity.dto.GitHubUser;
import com.example.springbootcommunity.entity.User;
import com.example.springbootcommunity.mapper.UserMapper;
import com.example.springbootcommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private GitHubProvider gitHubProvider;
    @Value("${github.client.id}")
    private String clientid;

    @Value("${github.client.secret}")
    private String client_secret;
    @Value("${github.redirect.uri}")
    private String redirect_uri;
    @GetMapping("/callback")
    public String callback(@RequestParam("name") String code,
                           @RequestParam("state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(client_secret);
        String getaccesstoken = gitHubProvider.getaccesstoken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(getaccesstoken);
        user.setName("joker");
        User user1 = new User();
        user1.setName("joker");
        user1.setGmt_create(System.currentTimeMillis());
        user1.setGmt_modified(user1.getGmt_create());
        userMapper.inset(user1);
        request.getSession().setAttribute("user",user);
        return "redirect:/";
    }
}



