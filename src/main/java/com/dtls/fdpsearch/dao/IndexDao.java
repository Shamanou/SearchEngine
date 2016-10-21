package com.dtls.fdpsearch.dao;

import com.dtls.fdpsearch.pojos.FdpCatalogPojo;
import com.dtls.fdpsearch.pojos.FdpDatasetPojo;
import com.dtls.fdpsearch.pojos.FdpDistributionPojo;
import com.dtls.fdpsearch.pojos.FdpMainPojo;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Shamanou van Leeuwen
 */
@Repository
public class IndexDao {
    private final MongoTemplate mongoTemplate;
    
    public IndexDao( MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }
        
    public void save(Object o){
        this.mongoTemplate.save(o);
    }
    
    public List<FdpCatalogPojo> findCatalog(String query){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("language").regex(query),
            Criteria.where("hasVersion").regex(query),
            Criteria.where("issued").regex(query),
            Criteria.where("modified").regex(query),
            Criteria.where("title").regex(query),
            Criteria.where("modified").regex(query),
            Criteria.where("_id").regex(query)
        );
        Query q = new Query(criteria);        
        return this.mongoTemplate.find(q, FdpCatalogPojo.class);
    }
    
    public List<FdpDatasetPojo> findDataset(String query){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("language").regex(query),
                Criteria.where("_id").regex(query),
                Criteria.where("label").regex(query),
                Criteria.where("hasVersion").regex(query),
                Criteria.where("issued").regex(query),
                Criteria.where("title").regex(query),
                Criteria.where("modified").regex(query));
        Query q = new Query(criteria);
        return this.mongoTemplate.find(q, FdpDatasetPojo.class);
    }
    
    public List<FdpDistributionPojo> findDistribution(String query){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("license").regex(query),
                Criteria.where("_id").regex(query),
                Criteria.where("label").regex(query),
                Criteria.where("mediaType").regex(query),
                Criteria.where("hasVersion").regex(query),
                Criteria.where("issued").regex(query),
                Criteria.where("title").regex(query),
                Criteria.where("modified").regex(query));
        Query q = new Query(criteria);
        return this.mongoTemplate.find(q, FdpDistributionPojo.class);
    }

    public List<FdpMainPojo> findMain(String query){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("apiVersion").regex(query),
                Criteria.where("_id").regex(query),
                Criteria.where("contact").regex(query),
                Criteria.where("description").regex(query),
                Criteria.where("language").regex(query),
                Criteria.where("license").regex(query),
                Criteria.where("publisher").regex(query),
                Criteria.where("contains").regex(query),
                Criteria.where("hasVersion").regex(query),
                Criteria.where("title").regex(query),
                Criteria.where("modified").regex(query),
                Criteria.where("label").regex(query));
        Query q = new Query(criteria);
        return this.mongoTemplate.find(q, FdpMainPojo.class);
    }
}