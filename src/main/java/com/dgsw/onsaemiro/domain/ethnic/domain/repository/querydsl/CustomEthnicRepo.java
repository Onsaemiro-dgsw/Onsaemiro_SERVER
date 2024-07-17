package com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicListResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;

import java.util.List;

public interface CustomEthnicRepo {
    List<EthnicListResponse> ethnicList(PageRequest request);
    List<EthnicListResponse> ethnicList(PageRequest request,String name);
}
