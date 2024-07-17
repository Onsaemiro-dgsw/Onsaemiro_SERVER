package com.dgsw.onsaemiro.domain.word.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SaveWordRequest {
    private Integer seq;
    private String word;
    private String description;
}
