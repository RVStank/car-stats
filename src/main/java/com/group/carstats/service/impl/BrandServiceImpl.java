package com.group.carstats.service.impl;

import com.group.carstats.exception.ResourceNotFoundException;
import com.group.carstats.model.Brand;
import com.group.carstats.repository.BrandRepository;
import com.group.carstats.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Brand with id %d does not exist.", id)));
    }

    @Override
    public Brand findByName(String name) {
        return brandRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Brand with name %s does not exist.", name)));
    }

    @Override
    public Brand update(Brand brand, Long id) {
        Brand foundBrand = findById(id);
        Brand updatedBrand = Brand.builder()
                .id(foundBrand.getId())
                .name(brand.getName())
                .build();
        return brandRepository.save(updatedBrand);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }
}
