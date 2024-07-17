package com.dgsw.onsaemiro.domain.service;

import com.dgsw.onsaemiro.domain.dto.EthnicRequest;
import com.dgsw.onsaemiro.domain.dto.EthnicResponse;
import com.dgsw.onsaemiro.domain.entity.Ethnic;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dgsw.onsaemiro.domain.repository.EthnicRepository;

@Service
@RequiredArgsConstructor
public class EthnicService {
    private final EthnicRepository ethnicRepository;

    // 민족 생성
    public Response createEthnic(EthnicRequest request){
        Ethnic ethnic = Ethnic.builder()
                .name(request.getName())
                .locate(request.getLocate())
                .history(request.getHistory()).build();
        ethnicRepository.save(ethnic);
        return Response.ok("민족 정보 저장을 성공했습니다.");
    }

    // 민족 조회
    public ResponseData<EthnicResponse> findEthnic(Long id){
        Ethnic ethnic = ethnicRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("조회 실패")
        );
        return ResponseData.ok("민족 정보 조회를 성공했습니다.",EthnicResponse.of(ethnic));
    }

}
