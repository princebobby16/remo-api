package com.example.momorecorder.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CronRouter extends RouteBuilder {
    @Override
    public void configure() {
        // sends email everyday
        from("cron:tab?schedule={{cron.schedule}}")
                .log("{{cron.schedule}}")
                .to("{{route.dailyCommission}}")
                .setHeader("subject", constant("Momo Business Daily Report"))
                .setHeader("to", simple("princebobby506@gmail.com"))
//                .to("smtps://smtp.gmail.com:465?username={{gmail.app.username}}&password={{gmail.app.password}}")
                .log("${body}");

    }
}
