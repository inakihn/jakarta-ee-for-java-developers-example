package com.example.hello.jakarta.rest.cdi.decorator;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Path("/profit")
@Singleton
public class ProfitController {

    @Inject
    private ProfitCalculator profitCalculator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response appendMessage(@QueryParam("income") String incomeString,
                                  @QueryParam("spent") String spentString) {

        BigDecimal income = BigDecimal.valueOf(Double.parseDouble(incomeString)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal spent = BigDecimal.valueOf(Double.parseDouble(spentString)).setScale(2, RoundingMode.HALF_UP);

        BigDecimal profit = profitCalculator.calculate(income, spent);

        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("profit", profit);
        return Response.ok(successResponse)
                .build();
    }


}
