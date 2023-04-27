package com.group.carstats.service.impl;

import com.group.carstats.exception.ResourceNotFoundException;
import com.group.carstats.model.Model;
import com.group.carstats.repository.ModelRepository;
import com.group.carstats.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model save(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Model with id %d doesn't exist", id)));
    }

    @Override
    public Model update(Model model, Long id) {
        Model foundModel = findById(id);
        Model updatedModel = Model.builder()
                .id(foundModel.getId())
                .modelName(model.getModelName())
                .yearMade(model.getYearMade())
                .build();

        return save(updatedModel);
    }

    @Override
    public void deleteById(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<Model> findAll() {
        return modelRepository.findAll();
    }
}