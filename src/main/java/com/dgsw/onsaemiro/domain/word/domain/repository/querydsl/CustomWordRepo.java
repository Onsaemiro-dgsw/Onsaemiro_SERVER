package com.dgsw.onsaemiro.domain.word.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.word.presentation.dto.response.WordResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;

import java.util.List;

public interface CustomWordRepo {
    List<WordResponse> wordList(PageRequest request);
    List<WordResponse> wordList(PageRequest request, String word);
}
