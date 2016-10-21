package com.dtls.fdpsearch.pojos;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Shamanou van Leeuwen
 */
@Document(collection = "datasets")
public class FdpDatasetPojo extends FdpPojo{
    private String[] creator;
    private String description;
    private String language;
    private String[] publisher;
    private String label;
    private String[] keyword;
    private String[] distribution;
    
    public String[] getCreator(){
        return this.creator;
    }
    
    public void setCreator(String[] creator){
        this.creator = creator;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getLanguage(){
        return this.language;
    }
    
    public void setLanguage(String language){
       this.language = language;
    }
    
    public String[] getPublisher(){
        return this.publisher;
    }
    
    public void setPublisher(String[] publisher){
        this.publisher = publisher;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String[] getKeyword(){
        return this.keyword;
    }
    
    public void setKeyword(String[] keyword){
        this.keyword = keyword;
    }
    
    public String[] getDistribution(){
        return this.distribution;
    }
    
    public void setDistribution(String[] distribution){
        this.distribution = distribution;
    } 
}
