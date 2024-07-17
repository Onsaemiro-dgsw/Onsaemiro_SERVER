package com.dgsw.onsaemiro.domain.word.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PictogramResponse {
    private String url;
    private Integer seq;
}
