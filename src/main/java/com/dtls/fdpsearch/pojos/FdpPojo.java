package com.dtls.fdpsearch.pojos;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Shamanou van Leeuwen
 */
public class FdpPojo {
    protected String hasVersion;
    @Id
    protected String identifier;
    protected String issued;
    protected String title;
    protected String modified;

    public String getHasVersion(){
        return this.hasVersion;
    }
    
    public void setHasVersion(String hasVersion){
        this.hasVersion = hasVersion;
    }
    
    public String getIdentifier(){
        return this.identifier;
    }
    
    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }
    
    public String getIssued(){
        return this.issued;
    }
    
    public void setIssued(String issued){
        this.issued = issued;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public String getModified(){
        return this.modified;
    }
    
    public void setModified(String modified){
        this.modified = modified;
    }
}
