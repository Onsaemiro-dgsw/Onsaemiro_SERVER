package com.dgsw.onsaemiro.domain.ethnic.exception.error;

import com.dgsw.onsaemiro.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum EthnicErrorProperty implements ErrorProperty {
    ETHNIC_NOT_FOUND(HttpStatus.NOT_FOUND, "민족을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
