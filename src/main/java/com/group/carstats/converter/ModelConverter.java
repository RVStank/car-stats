package com.group.carstats.converter;

import com.group.carstats.dto.ModelDto;
import com.group.carstats.model.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelConverter {

    public ModelDto toModelDto(Model model) {
        return ModelDto.builder()
                .id(model.getId())
                .name(model.getName())
                .yearMade(model.getYearMade())
                .build();
    }

    public Model toModel(ModelDto modelDto) {
        return Model.builder()
                .id(modelDto.getId())
                .name(modelDto.getName())
                .yearMade(modelDto.getYearMade())
                .build();
    }
}
