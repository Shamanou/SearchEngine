package com.dtls.fdpsearch.pojos;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Shamanou van Leeuwen
 */
@Document(collection = "distributions")
public class FdpDistributionPojo extends FdpPojo{
    private String license;
    private String label;
    private String accessUrl;
    private String mediaType;
    
    public String getLicense(){
        return license;
    }
    
    public void setLicense(String license){
        this.license = license;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String getAccessUrl(){
        return this.accessUrl;
    }
    
    public void setAccessUrl(String accessUrl){
        this.accessUrl = accessUrl;
    }
    
    public String getMediaType(){
        return this.mediaType;
    }
    
    public void setMediaType(String mediaType){
        this.mediaType = mediaType;
    }
}
