package com.example.springbootcommunity.controller;


import com.example.springbootcommunity.dto.AccessTokenDTO;
import com.example.springbootcommunity.dto.GitHubUser;
import com.example.springbootcommunity.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

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
                           @RequestParam("state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(clientid);
        accessTokenDTO.setClient_secret(client_secret);
        String getaccesstoken = gitHubProvider.getaccesstoken(accessTokenDTO);
        GitHubUser user = gitHubProvider.getUser(getaccesstoken);
        user.setName("joker");
        System.out.println(user.getName());
        return "index";
    }
}



