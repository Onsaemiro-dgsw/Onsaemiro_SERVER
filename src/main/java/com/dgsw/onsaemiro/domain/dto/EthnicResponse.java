package com.dgsw.onsaemiro.domain.dto;

import com.dgsw.onsaemiro.domain.entity.Ethnic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class EthnicResponse {

    private String name;
    private String locate;
    private String history;

    public static EthnicResponse of(Ethnic ethnic){
        return EthnicResponse.builder()
                .name(ethnic.getName())
                .locate(ethnic.getLocate())
                .history(ethnic.getHistory()).build();
    }
}
