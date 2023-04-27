package com.group.carstats.service;

import com.group.carstats.model.Brand;

import java.util.List;

public interface BrandService {

    Brand save(Brand brand);

    Brand findById(Long id);

    Brand findByName(String name);

    Brand update(Brand brand, Long id);

    void deleteById(Long id);

    List<Brand> findAll();
}
