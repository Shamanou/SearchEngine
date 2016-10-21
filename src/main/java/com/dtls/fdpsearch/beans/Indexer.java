package com.dtls.fdpsearch.beans;

import com.dtls.fdpsearch.dao.IndexDao;
import com.dtls.fdpsearch.pojos.FdpCatalogPojo;
import com.dtls.fdpsearch.pojos.FdpDatasetPojo;
import com.dtls.fdpsearch.pojos.FdpDistributionPojo;
import com.dtls.fdpsearch.pojos.FdpMainPojo;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdfxml.xmlinput.JenaReader;

/**
 *
 * @author Shamanou van Leeuwen
 */
public class Indexer {
    private final IndexDao dao;
    
    public Indexer(IndexDao dao){
        this.dao = dao;
    }
    
    public void indexLocalhost() throws MalformedURLException, IOException{
        JenaReader reader = new JenaReader();
        final String url = "http://localhost:8083/fdp";
        Model model = ModelFactory.createDefaultModel();
        model.read(new URL(url).openStream(),null,"TTL");
        StmtIterator iter = model.listStatements();
        FdpMainPojo fdpPojo = new FdpMainPojo();
        ArrayList<String> containsUris = new ArrayList<>();
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();
            Property  predicate = stmt.getPredicate();
            RDFNode   object    = stmt.getObject();
            
            switch(predicate.getURI()){
                case "http://localhost:8083/fdp/APIVersion":
                    fdpPojo.setApiVersion(object.toString());
                    break;
                case "http://localhost:8083/fdp/contact":
                    fdpPojo.setContact(object.toString());
                    break;
                case "http://purl.org/dc/terms/description":
                    fdpPojo.setDescription(object.toString());
                    break;
                case "http://purl.org/dc/terms/hasVersion":
                    fdpPojo.setHasVersion(object.toString());
                    break;
                case "http://purl.org/dc/terms/identifier":
                    fdpPojo.setIdentifier(object.toString());
                    break;
                case "http://purl.org/dc/terms/issued":
                    fdpPojo.setIssued(object.toString());
                    break;
                case "http://purl.org/dc/terms/language":
                    fdpPojo.setLanguage(object.toString());
                    break;
                case "http://purl.org/dc/terms/license":
                    fdpPojo.setLicense(object.toString());
                    break;
                case "http://purl.org/dc/terms/modified":
                    fdpPojo.setModified(object.toString());
                    break;
                case "http://purl.org/dc/terms/publisher":
                    fdpPojo.setPublisher(object.toString());
                    break;
                case "http://purl.org/dc/terms/title":
                    fdpPojo.setTitle(object.toString());
                    break;
                case "http://www.w3.org/2000/01/rdf-schema#label":
                    fdpPojo.setLabel(object.toString());
                    break;
                case "http://www.w3.org/ns/ldp#contains":
                    containsUris.add(object.toString());
                    break;
            }
        }
        fdpPojo.setContains(containsUris.toArray(new String[containsUris.size()]));
        dao.save(fdpPojo);
        for (String uri: containsUris){
            FdpCatalogPojo fdpCatalog = new FdpCatalogPojo();
            ArrayList<String> datasetUris = new ArrayList<>();
            model = ModelFactory.createDefaultModel();
            model.read(new URL(uri).openStream(),null,"TTL");
            iter = model.listStatements();
            while (iter.hasNext()) {
                Statement stmt      = iter.nextStatement();
                Property  predicate = stmt.getPredicate();
                RDFNode   object    = stmt.getObject();
                switch(predicate.getURI()){
                    case "http://purl.org/dc/terms/hasVersion":
                        fdpCatalog.setHasVersion(object.toString());
                        break;
                    case "http://purl.org/dc/terms/identifier":
                        fdpCatalog.setIdentifier(object.toString());
                        break;
                    case "http://purl.org/dc/terms/issued":
                        fdpCatalog.setIssued(object.toString());
                        break;
                    case "http://purl.org/dc/terms/language":
                        fdpCatalog.setLanguage(object.toString());
                        break;
                    case "http://purl.org/dc/terms/modified":
                        fdpCatalog.setModified(object.toString());
                        break;
                    case "http://purl.org/dc/terms/title":
                        fdpCatalog.setTitle(object.toString());
                        break;
                    case "http://www.w3.org/2000/01/rdf-schema#label":
                        fdpCatalog.setLabel(object.toString());
                        break;
                    case "http://www.w3.org/ns/dcat#dataset":
                        datasetUris.add(object.toString());
                        break;
                }
            }
            fdpCatalog.setDataset(datasetUris.toArray(new String[datasetUris.size()]));
            dao.save(fdpCatalog);
            for (String datasetUri: datasetUris){
                model = ModelFactory.createDefaultModel();
                model.read(new URL(datasetUri).openStream(),null,"TTL");
                iter = model.listStatements();
                FdpDatasetPojo fdpDataset = new FdpDatasetPojo();
                ArrayList<String> datasetCreators = new ArrayList<>();
                ArrayList<String> datasetPublishers = new ArrayList<>();
                ArrayList<String> datasetDistributions = new ArrayList<>();
                ArrayList<String> datasetKeywords = new ArrayList<>();
                while (iter.hasNext()) {
                    Statement stmt      = iter.nextStatement();
                    Property  predicate = stmt.getPredicate();
                    RDFNode   object    = stmt.getObject();
                    switch(predicate.getURI()){
                        case "http://purl.org/dc/terms/creator":
                            datasetCreators.add(object.toString());
                            break;
                        case "http://purl.org/dc/terms/description":
                            fdpDataset.setDescription(object.toString());
                            break;
                        case "http://purl.org/dc/terms/hasVersion":
                            fdpDataset.setHasVersion(object.toString());
                            break;
                        case "http://purl.org/dc/terms/identifier":
                            fdpDataset.setIdentifier(object.toString());
                            break;
                        case "http://purl.org/dc/terms/issued":
                            fdpDataset.setIssued(object.toString());
                            break;
                        case "http://purl.org/dc/terms/language":
                            fdpDataset.setLanguage(object.toString());
                            break;                
                        case "http://purl.org/dc/terms/modified":
                            fdpDataset.setModified(object.toString());
                            break;
                        case "http://purl.org/dc/terms/publisher":
                            datasetPublishers.add(object.toString());
                            break;
                        case "http://purl.org/dc/terms/title":
                            fdpDataset.setTitle(object.toString());
                            break;
                        case "http://www.w3.org/2000/01/rdf-schema#label":
                            fdpDataset.setLabel(object.toString());
                            break;
                        case "http://www.w3.org/ns/dcat#distribution":
                            datasetDistributions.add(object.toString());
                            break;
                        case "http://www.w3.org/ns/dcat#keyword":
                            datasetKeywords.add(object.toString());
                            break;                                                  
                    }
                }
                fdpDataset.setCreator(datasetCreators.toArray(new String[datasetCreators.size()]));
                fdpDataset.setPublisher(datasetPublishers.toArray(new String[datasetPublishers.size()]));
                fdpDataset.setDistribution(datasetDistributions.toArray(new String[datasetDistributions.size()]));
                fdpDataset.setKeyword(datasetKeywords.toArray(new String[datasetKeywords.size()]));
                dao.save(fdpDataset);
                for (String distributionUri: datasetDistributions){
                    model = ModelFactory.createDefaultModel();
                    model.read(new URL(distributionUri).openStream(),null,"TTL");
                    iter = model.listStatements();
                    FdpDistributionPojo fdpDistribution = new FdpDistributionPojo();
                    while (iter.hasNext()) {
                        Statement stmt      = iter.nextStatement();
                        Property  predicate = stmt.getPredicate();
                        RDFNode   object    = stmt.getObject();
                        switch(predicate.getURI()){
                            case "http://purl.org/dc/terms/hasVersion":
                                fdpDistribution.setHasVersion(object.toString());
                                break; 
                            case "http://purl.org/dc/terms/identifier":
                                fdpDistribution.setIdentifier(object.toString());
                                break;
                            case "http://purl.org/dc/terms/issued":
                                fdpDistribution.setIssued(object.toString());
                                break;
                            case "http://purl.org/dc/terms/license":
                                fdpDistribution.setLicense(object.toString());
                                break;
                            case "http://purl.org/dc/terms/modified":
                                fdpDistribution.setModified(object.toString());
                                break;                     
                            case "http://purl.org/dc/terms/title":
                                fdpDistribution.setTitle(object.toString());
                                break;
                            case "http://www.w3.org/2000/01/rdf-schema#label":
                                fdpDistribution.setLabel(object.toString());
                                break;
                            case "http://www.w3.org/ns/dcat#accessURL":
                                fdpDistribution.setAccessUrl(object.toString());
                                break;
                            case "http://www.w3.org/ns/dcat#mediaType":
                                fdpDistribution.setMediaType(object.toString());
                                break;                            
                        }
                    }
                    dao.save(fdpDistribution);
                }
            }
        }
    }
}