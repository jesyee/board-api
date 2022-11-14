package com.board.api.common.dto;

import com.board.api.common.exception.CommonException;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto implements Serializable {
    private String code;
    private String message;
    private Object data;

    public ApiResponseDto (CommonException e) {
        this.code = e.getErrorCode();
        this.message = e.getErrorMessage();
    }

    public ApiResponseDto (Object object) {
        setSuccess();
        this.data = object;
    }

    public ApiResponseDto (List<Object> listObject) {
        setSuccess();
        this.data = listObject;
    }

    private void setSuccess() {
        this.code = "000000";
        this.message = "";
    }
}
