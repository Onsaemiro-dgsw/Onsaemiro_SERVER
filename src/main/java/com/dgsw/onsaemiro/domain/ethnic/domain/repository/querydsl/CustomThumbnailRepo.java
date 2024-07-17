package com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.ThumbnailResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;

import java.util.List;

public interface CustomThumbnailRepo {
    List<ThumbnailResponse> thumbnailList(PageRequest pageRequest);
}
