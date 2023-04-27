package com.group.carstats.service;

import com.group.carstats.model.Model;

import java.util.List;

public interface ModelService {

    Model save(Model model);

    Model findById(Long id);

    Model update(Model model, Long id);

    void deleteById(Long id);

    List<Model> findAll();
}
