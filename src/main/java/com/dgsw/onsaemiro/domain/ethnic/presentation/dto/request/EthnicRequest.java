package com.dgsw.onsaemiro.domain.ethnic.presentation.dto.request;

import lombok.Getter;

@Getter
public class EthnicRequest {

    private String name; // 민족 이름
    private String locate; // 현재 위치
    private String content; // 설명

}
