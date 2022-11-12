package com.mjc.stage2;

import com.mjc.stage2.impl.ManufactureFilteringStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ShopStock {
    private final List<Product> productList;

    public ShopStock(List<Product> productList) {
        this.productList = productList;
    }

    List<Product> executeFilteringStrategy(FilteringStrategy filteringStrategy){
        return productList.stream().filter(filteringStrategy::filter).collect(Collectors.toList());
    }
}
