package edu.zipcloud.cloudstreetmarket.portal.controllers;

import edu.zipcloud.cloudstreetmarket.core.market.service.IMarketService;
import edu.zipcloud.cloudstreetmarket.core.user.service.ICommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController extends CloudstreetWebAppWCI {

    @Autowired
    @Qualifier("marketServiceImpl")
    private IMarketService marketService;

    @Autowired
    @Qualifier("communityServiceImpl")
    private ICommunityService communityService;

    @RequestMapping(value="/*", method={RequestMethod.GET,RequestMethod.HEAD})
    public String fallback(Model model) {
        return "index";
    }
}