package com.udacity.pricing.api;

import com.google.common.collect.Lists;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingServiceUnitTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PriceRepository priceRepository;

    private final MediaType contentType = new MediaType("application", "hal+json", StandardCharsets.UTF_8);

    @Test
    public void getVehiclePrice() throws Exception {
        mvc.perform(get("/prices/101"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.currency").value("USD"))
                .andExpect(jsonPath("$.price").value(21900));
    }

    @Test
    public void getVehiclePrices() throws Exception {
        mvc.perform(get("/prices/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$._embedded.prices", hasSize(20)))
                .andExpect(content().json("{}"));
    }

    @Test
    public void testFindAllPrices() {
        Iterable<Price> prices = priceRepository.findAll();
        ArrayList<Price> actualList = Lists.newArrayList(prices);
        assertEquals(20, actualList.size());
        assertNotNull(prices);
    }
}
