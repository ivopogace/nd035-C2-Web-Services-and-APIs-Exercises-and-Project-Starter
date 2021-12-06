package com.udacity.vehicles.client.prices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="pricing-service")
public interface PriceProxy {

    @GetMapping("/prices/search/findByVehicleId")
    Price getPrice(@RequestParam Long vehicleId);

    @PostMapping("/prices")
    Price savePrice(@RequestBody Price price);

    @DeleteMapping("/prices/{id}")
    Price deletePrice(@PathVariable Long id);
}
