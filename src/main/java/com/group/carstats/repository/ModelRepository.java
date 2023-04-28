package com.group.carstats.repository;

import com.group.carstats.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {
    Optional<Model> findByName(String name);

    Optional<Model> findByYear(Integer year);
}
