package com.dtls.fdpsearch.pojos;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Shamanou van Leeuwen
 */
@Document(collection = "catalogs")
public class FdpCatalogPojo extends FdpPojo{
    private String language;
    private String label;
    private String[] dataset;
    
    public void setDataset(String[] dataset){
        this.dataset = dataset;
    }
    
    public String[] getDataset(){
        return this.dataset;
    }
    
    public void setLanguage(String language){
        this.language = language;
    }
    
    public String getLanguage(){
        return this.language;
    }
    
    public void setLabel(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return this.label;
    }    
}
