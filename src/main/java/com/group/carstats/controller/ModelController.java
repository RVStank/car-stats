package com.group.carstats.controller;

import com.group.carstats.converter.ModelConverter;
import com.group.carstats.dto.ModelDto;
import com.group.carstats.service.ModelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/model")
public class ModelController {

    private final ModelService modelService;
    private final ModelConverter modelConverter;

    public ModelController(ModelService modelService, ModelConverter modelConverter) {
        this.modelService = modelService;
        this.modelConverter = modelConverter;
    }

    @GetMapping()
    public ResponseEntity<List<ModelDto>> findAll() {
        return ResponseEntity.ok(modelService.findAll()
                .stream()
                .map(modelConverter::toModelDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ModelDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok
                (modelConverter.toModelDto(
                        modelService.findByName(name)));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ModelDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(
                modelConverter.toModelDto(
                        modelService.findById(id)));
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<ModelDto> findByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(
                modelConverter.toModelDto(
                        modelService.findByYear(year)));
    }

    @PostMapping
    public ResponseEntity<ModelDto> save(@RequestBody ModelDto modelDto) {
        return ResponseEntity.ok(
                modelConverter.toModelDto(
                        modelService.save(
                                modelConverter.toModel(modelDto))));
    }

}
