package com.group.carstats.controller;

import com.group.carstats.repository.BrandRepository;
import com.group.carstats.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    private final BrandRepository brandRepository;
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandRepository brandRepository, BrandService brandService) {
        this.brandRepository = brandRepository;
        this.brandService = brandService;
    }
}
