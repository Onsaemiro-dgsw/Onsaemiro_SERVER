package com.dgsw.onsaemiro.domain.word.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
public class SavePictogramRequest {
    private Integer seq;
    private MultipartFile multipartFile;
}
