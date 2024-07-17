package com.dgsw.onsaemiro.global.common.dto.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ResponseData<T> extends Response {

    private final T data;

    private ResponseData(HttpStatus status, String message, T data) {
        super(status.value(), message);
        this.data = data;
    }

    public static <T> ResponseData<T> of(HttpStatus status, String message, T data) {
        return new ResponseData<>(status, message, data);
    }

    public static <T> ResponseData<T> ok(String message, T data) {
        return new ResponseData<>(HttpStatus.OK, message, data);
    }

    public static <T> ResponseData<T> created(String message, T data) {
        return new ResponseData<>(HttpStatus.CREATED, message, data);
    }
}
