package com.dgsw.onsaemiro.domain.word.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SaveWordListRequest {
    private List<SaveWordRequest> words;
}
