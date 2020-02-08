package com.example.springbootcommunity.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String accountId;
    private String token;
    private long gmt_create;
    private long gmt_modified;
    private String avatar_url;


}
