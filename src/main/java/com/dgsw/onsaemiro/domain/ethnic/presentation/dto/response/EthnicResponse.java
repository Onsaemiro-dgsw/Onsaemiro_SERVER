package com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response;

import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EthnicResponse {

    private String name;
    private String locate;
    private String content;

    public static EthnicResponse of(Ethnic ethnic){
        return EthnicResponse.builder()
                .name(ethnic.getName())
                .locate(ethnic.getLocate())
                .content(ethnic.getContent()).build();
    }
}
