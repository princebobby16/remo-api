package com.example.momorecorder.route;

import com.example.momorecorder.request.MomoRecordsDto;
import com.example.momorecorder.response.HealthCheckResponse;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRouter extends RouteBuilder {

    private JacksonDataFormat getJacksonDataFormat() {
        JacksonDataFormat format = new JacksonDataFormat();
        format.setUnmarshalType(MomoRecordsDto.class);
        return format;
    }

    @Override
    public void configure() {
        restConfiguration()
                .component("servlet")
                .enableCORS(true)
                .corsHeaderProperty("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                .bindingMode(RestBindingMode.json);

        rest()
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)


                .get("/").route().bean(HealthCheckResponse.class)
                .endRest()

                .get("/records").route()
                .to("{{route.findAll}}")
                .endRest()

                .get("/records/today").route()
                .to("{{route.findAllDailyTransaction}}")
                .endRest()

                .get("/records/today/count").route()
                .to("{{route.countDailyTransactions}}")
                .endRest()

                .post("/records")
                .route()
                .marshal().json()
                .unmarshal(getJacksonDataFormat())
                .to("{{route.save}}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
                .endRest()

                // commissions
                .get("/commission/daily").route()
                .to("{{route.dailyCommission}}")
                .endRest()

                .get("/commission/monthly").route()
                .to("{{route.monthlyCommission}}")
                .endRest();
    }
}
