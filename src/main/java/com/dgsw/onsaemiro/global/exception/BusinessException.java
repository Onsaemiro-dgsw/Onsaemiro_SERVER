package com.dgsw.onsaemiro.global.exception;

import com.dgsw.onsaemiro.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessException extends RuntimeException {
    private final ErrorProperty error;
}
