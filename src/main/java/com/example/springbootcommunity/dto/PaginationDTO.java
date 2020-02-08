package com.example.springbootcommunity.dto;

import java.util.ArrayList;
import java.util.List;

public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Boolean showPre;
    private Boolean showFirst;
    private Boolean showNext;
    private Boolean showEnd;
    private Integer currentPage;
    private List<Integer> pages=new ArrayList<>();

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public Boolean getShowPre() {
        return showPre;
    }

    public void setShowPre(Boolean showPre) {
        this.showPre = showPre;
    }

    public Boolean getShowFirst() {
        return showFirst;
    }

    public void setShowFirst(Boolean showFirst) {
        this.showFirst = showFirst;
    }

    public Boolean getShowNext() {
        return showNext;
    }

    public void setShowNext(Boolean showNext) {
        this.showNext = showNext;
    }

    public Boolean getShowEnd() {
        return showEnd;
    }

    public void setShowEnd(Boolean showEnd) {
        this.showEnd = showEnd;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<Integer> getPages() {
        return pages;
    }

    public void setPages(List<Integer> pages) {
        this.pages = pages;
    }

    public void setPagination(Integer count, Integer page, Integer size) {

        Integer totalpage=0;
        if(count%size==0){
            totalpage=count/size;
        }else{
            totalpage=count/size+1;
        }
        if(page<1){
            page=1;
        }

        if(page>totalpage){
            page=totalpage;
        }
        this.currentPage = page;
         pages.add(page);
        for(int i=1;i<=3;i++){
            if(page-i>0){
                pages.add(0,page-i);
            }
            if(page+i<=totalpage){
                pages.add(page+i);
            }
        }

        if(page==1){
            showPre=false;
        }else {
            showPre=true;
        }
        if(page==totalpage){
            showNext=false;
        }else {
            showNext=true;
        }
        if(pages.contains(1)){
          showFirst=false;
        }else{
            showFirst=true;
        }
        if(pages.contains(totalpage)){
            showEnd=false;
        }else{
            showEnd=true;
        }
    }
}
