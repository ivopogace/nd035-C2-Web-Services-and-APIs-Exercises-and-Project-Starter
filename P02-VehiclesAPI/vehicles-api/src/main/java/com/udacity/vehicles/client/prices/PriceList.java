package com.udacity.vehicles.client.prices;

import java.util.List;

public class PriceList {
    private List<Price> prices;

    public PriceList() {
    }

    public PriceList(List<Price> prices) {
        this.prices = prices;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }
}
