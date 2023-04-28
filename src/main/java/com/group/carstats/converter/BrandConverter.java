package com.group.carstats.converter;

import com.group.carstats.dto.BrandDto;
import com.group.carstats.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    public BrandDto toBrandDto(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }

    public Brand toBrand(BrandDto brandDto) {
        return Brand.builder()
                .id(brandDto.getId())
                .name(brandDto.getName())
                .build();
    }
}
