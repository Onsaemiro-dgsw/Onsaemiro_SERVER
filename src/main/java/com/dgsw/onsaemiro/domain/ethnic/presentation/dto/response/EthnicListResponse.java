package com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response;

import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EthnicListResponse {

    private Long id;
    private String name;
    private String content;

    public static EthnicListResponse of(Ethnic ethnic){
        return EthnicListResponse.builder()
                .id(ethnic.getId())
                .name(ethnic.getName())
                .content(ethnic.getContent()).build();
    }
}
