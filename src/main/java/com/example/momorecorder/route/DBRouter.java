package com.example.momorecorder.route;

import com.example.momorecorder.service.MomoRecordsService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Component
public class DBRouter extends RouteBuilder {
    @Override
    public void configure() {
        from("{{route.save}}")
                .log("Received Body ${body}")
                .bean(MomoRecordsService.class, "save(${body})");

        from("{{route.findOneById}}")
                .log("finding specific transaction with id ${header.id}")
                .bean(MomoRecordsService.class, "findOneById(${header.id})");

        from("{{route.findAll}}")
                .bean(MomoRecordsService.class, "findAll");

        from("{{route.countDailyTransactions}}")
                .bean(MomoRecordsService.class, "countDailyTransactions");

        from("{{route.dailyCommission}}")
                .bean(MomoRecordsService.class, "getDailyCommission");

        from("{{route.monthlyCommission}}")
                .bean(MomoRecordsService.class, "getMonthlyCommission");

        from("{{route.findAllDailyTransaction}}")
                .bean(MomoRecordsService.class, "findAllDailyTransaction");

    }
}
