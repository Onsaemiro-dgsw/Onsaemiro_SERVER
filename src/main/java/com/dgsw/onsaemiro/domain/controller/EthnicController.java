package com.dgsw.onsaemiro.domain.controller;

import com.dgsw.onsaemiro.domain.dto.EthnicRequest;
import com.dgsw.onsaemiro.domain.dto.EthnicResponse;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dgsw.onsaemiro.domain.service.EthnicService;

@RestController
@RequiredArgsConstructor
public class EthnicController {

    private final EthnicService ethnicService;

    // 민족 등록
    @PostMapping("/ethnics")
    public Response createEthnic(@RequestBody EthnicRequest requestDto){
        return ethnicService.createEthnic(requestDto);
    }

    // 민족 조회
    @GetMapping("/ethnics/{id}")
    public ResponseData<EthnicResponse> getEthnic(@PathVariable Long id){
        return ethnicService.findEthnic(id);
    }
}
