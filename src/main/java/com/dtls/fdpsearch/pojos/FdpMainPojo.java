package com.dtls.fdpsearch.pojos;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Shamanou van Leeuwen
 */
@Document(collection = "fdps")
public class FdpMainPojo extends FdpPojo{
    private String apiVersion;
    private String contact;
    private String description;
    private String language;
    private String license;
    private String publisher;
    private String label;
    private String[] contains;
    
    public String getApiVersion(){
        return apiVersion;
    }
    
    public void setApiVersion(String apiVersion){
        this.apiVersion = apiVersion;
    }
    
    public String getContact(){
        return this.contact;
    }
    
    public void setContact(String contact){
        this.contact = contact;
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
    
    public String getLicense(){
        return this.license;
    }
    
    public void setLicense(String license){
        this.license = license;
    }
    
    public String getPublisher(){
        return this.publisher;
    }
    
    public void setPublisher(String publisher){
        this.publisher = publisher;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String[] getContains(){
        return this.contains;
    }
    
    public void setContains(String[] contains){
        this.contains = contains;
    }
}
