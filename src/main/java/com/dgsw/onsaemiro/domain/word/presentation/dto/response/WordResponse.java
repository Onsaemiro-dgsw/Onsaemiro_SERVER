package com.dgsw.onsaemiro.domain.word.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WordResponse {
    private Long id;
    private String word;
    private String description;
}
