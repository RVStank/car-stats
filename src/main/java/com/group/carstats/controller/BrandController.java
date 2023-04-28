package com.group.carstats.controller;

import com.group.carstats.converter.BrandConverter;
import com.group.carstats.dto.BrandDto;
import com.group.carstats.model.Brand;
import com.group.carstats.repository.BrandRepository;
import com.group.carstats.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    private final BrandRepository brandRepository;
    private final BrandService brandService;
    private final BrandConverter brandConverter;

    @Autowired
    public BrandController(BrandRepository brandRepository, BrandService brandService, BrandConverter brandConverter) {
        this.brandRepository = brandRepository;
        this.brandService = brandService;
        this.brandConverter = brandConverter;
    }

    @GetMapping
    public ResponseEntity<List<BrandDto>> findAll() {

        return ResponseEntity.ok(brandService
                .findAll()
                .stream()
                .map(brandConverter::toBrandDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BrandDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(brandConverter.toBrandDto(brandService.findById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<BrandDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(
                brandConverter.toBrandDto(
                        brandService.findByName(name)));
    }

    @PostMapping
    public ResponseEntity<BrandDto> save(@RequestBody BrandDto brandDto) {
        return ResponseEntity.ok(
                brandConverter.toBrandDto(
                        brandService.save(
                                brandConverter.toBrand(brandDto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDto> update(@RequestBody @Valid BrandDto brandDto, @PathVariable Long id) {
        Brand brand = brandConverter.toBrand(brandDto);
        Brand updatedBrand = brandService.update(brand, id);
        return ResponseEntity.ok(brandConverter.toBrandDto(updatedBrand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        brandService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
