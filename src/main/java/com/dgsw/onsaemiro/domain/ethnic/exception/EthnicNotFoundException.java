package com.dgsw.onsaemiro.domain.ethnic.exception;

import com.dgsw.onsaemiro.domain.ethnic.exception.error.EthnicErrorProperty;
import com.dgsw.onsaemiro.global.exception.BusinessException;

public class EthnicNotFoundException extends BusinessException {
    public static final EthnicNotFoundException EXCEPTION = new EthnicNotFoundException();

    private EthnicNotFoundException(){
        super(EthnicErrorProperty.ETHNIC_NOT_FOUND);
    }
}
