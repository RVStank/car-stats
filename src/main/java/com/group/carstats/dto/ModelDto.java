package com.group.carstats.dto;

import com.group.carstats.model.Brand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ModelDto {

    private Long id;
    private String name;
    private Integer yearMade;
    private Brand brand;
}
