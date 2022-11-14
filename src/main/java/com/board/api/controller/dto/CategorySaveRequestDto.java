package com.board.api.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySaveRequestDto {
    private String code;
    private String name;
    private Boolean useYn;

    public CategorySaveRequestDto() {
        this.code = "FREE";
        this.useYn = true;

    }
}
