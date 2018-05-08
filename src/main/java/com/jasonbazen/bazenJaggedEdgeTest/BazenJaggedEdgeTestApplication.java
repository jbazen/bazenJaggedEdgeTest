package com.jasonbazen.bazenJaggedEdgeTest;

import com.jasonbazen.bazenJaggedEdgeTest.config.BazenJaggedEdgeTestDbConfig;
import com.jasonbazen.bazenJaggedEdgeTest.service.BitMexService;
import com.jasonbazen.bazenJaggedEdgeTest.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BazenJaggedEdgeTestDbConfig.class})
public class BazenJaggedEdgeTestApplication {

    private static final Logger log = LoggerFactory.getLogger(BazenJaggedEdgeTestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BazenJaggedEdgeTestApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BitMexService bitMexService, CrudService crudService) {

        return args -> {
            crudService.seedNonceTable();

            bitMexService.getCurrentBidPrice("XBTUSD");

            bitMexService.streamCurrentBidPrice("XBTUSD");

            bitMexService.submitMarketOrder("XBTUSD");

            bitMexService.submitAndMonitorMarketOrder("XBTUSD");
        };

    }

}
