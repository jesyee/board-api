package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryUpdateRequestDto {
    private Long categoryId;
    private String code;
    private String name;
    private Boolean useYn;
}
