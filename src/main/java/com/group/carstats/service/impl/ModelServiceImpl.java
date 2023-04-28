package com.group.carstats.service.impl;

import com.group.carstats.exception.DuplicateEntryException;
import com.group.carstats.exception.ResourceNotFoundException;
import com.group.carstats.model.Model;
import com.group.carstats.repository.ModelRepository;
import com.group.carstats.service.ModelService;
import org.springframework.dao.DataIntegrityViolationException;
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
        try {
            return modelRepository.save(model);
        }
        catch (DataIntegrityViolationException e) {
            throw new DuplicateEntryException("Model already exists.");
        }
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Model with id %d doesn't exist", id)));
    }

    @Override
    public Model findByName(String name) {
        return modelRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Model with name %s does not exist", name)));
    }

    @Override
    public Model findByYear(Integer year) {
        return modelRepository.findByYear(year)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Model with year %d does not exist", year)));
    }

    @Override
    public Model update(Model model, Long id) {
        Model foundModel = findById(id);
        Model updatedModel = Model.builder()
                .id(foundModel.getId())
                .name(model.getName())
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
