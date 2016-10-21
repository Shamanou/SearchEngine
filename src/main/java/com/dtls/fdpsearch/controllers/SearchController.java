package com.dtls.fdpsearch.controllers;

import static com.dtls.fdpsearch.controllers.SearchController.log;
import com.dtls.fdpsearch.dao.IndexDao;
import com.dtls.fdpsearch.pojos.FdpCatalogPojo;
import com.dtls.fdpsearch.pojos.FdpDatasetPojo;
import com.dtls.fdpsearch.pojos.FdpDistributionPojo;
import com.dtls.fdpsearch.pojos.FdpMainPojo;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {
    static Logger log = Logger.getLogger(SearchController.class.getName());
    
    @Autowired
    IndexDao indexDao;
    
    @RequestMapping("/")
    public String main() {
        return "index";
    }
    
    @RequestMapping(value="/search")
    public ModelMap search(ModelMap model, @RequestParam(value="query") String search) {
        List<FdpCatalogPojo> fdpCatalogPojos = indexDao.findCatalog(search);
        List<FdpDatasetPojo> fdpDatasetPojos = indexDao.findDataset(search);
        List<FdpDistributionPojo> fdpDistributionPojos = indexDao.findDistribution(search);
        List<FdpMainPojo> fdpMainPojos = indexDao.findMain(search);
           
        log.debug(String.valueOf(fdpDatasetPojos.size() + fdpCatalogPojos.size() + fdpDistributionPojos.size() + fdpMainPojos.size()));
        model.addAttribute("catalogs",fdpCatalogPojos);
        model.addAttribute("datasets",fdpDatasetPojos);
        model.addAttribute("distributions",fdpDistributionPojos);
        model.addAttribute("fdps",fdpMainPojos);
        return model;
    }
}

