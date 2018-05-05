package com.jasonbazen.bazenJaggedEdgeTest.controller.rest;

import com.jasonbazen.bazenJaggedEdgeTest.service.BitMexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BazenJaggedEdgeTestRestController {

    public BitMexService bitMexService;

    @Autowired
    public BazenJaggedEdgeTestRestController(BitMexService bitMexService) {
        this.bitMexService = bitMexService;
    }

    @RequestMapping(path = "/task1", method = RequestMethod.GET)
    public String runTaskOne() {
        return bitMexService.getCurrentBidPrice("XBTUSD");
    }

    @RequestMapping(path = "/task2", method = RequestMethod.GET)
    public String runTaskTwo() {
        return bitMexService.streamCurrentBidPrice("XBTUSD");
    }

    @RequestMapping(path = "/stopStreamCurrentBidPrice", method = RequestMethod.GET)
    public String stopStreamCurrentBidPrice() {
        return bitMexService.stopStreamCurrentBidPrice();
    }

    @RequestMapping(path = "/task8", method = RequestMethod.GET)
    public String runTaskNine() {
        return bitMexService.submitAndMonitorMarketOrder("XBTUSD");
    }

}
