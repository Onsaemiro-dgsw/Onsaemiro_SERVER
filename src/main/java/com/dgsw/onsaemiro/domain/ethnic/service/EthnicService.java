package com.dgsw.onsaemiro.domain.ethnic.service;

import com.dgsw.onsaemiro.domain.ethnic.exception.EthnicNotFoundException;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.request.EthnicRequest;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicListResponse;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicResponse;
import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.EthnicRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EthnicService {
    private final EthnicRepository ethnicRepository;

    // 민족 생성
    public Response createEthnic(EthnicRequest request){
        Ethnic ethnic = Ethnic.builder()
                .name(request.getName())
                .locate(request.getLocate())
                .content(request.getContent()).build();

        ethnicRepository.save(ethnic);
        return Response.ok("민족 정보 저장을 성공했습니다.");
    }

    // 민족 조회
    public ResponseData<EthnicResponse> findEthnic(Long id){
        Ethnic ethnic = ethnicRepository.findById(id).orElseThrow(
                () -> EthnicNotFoundException.EXCEPTION );
        return ResponseData.ok("민족 정보 조회를 성공했습니다.",EthnicResponse.of(ethnic));
    }

    public ResponseData<List<EthnicListResponse>> ethnicList(PageRequest request){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", ethnicRepository.ethnicList(request));
    }

    public ResponseData<List<EthnicListResponse>> ethnicList(PageRequest request,String name){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", ethnicRepository.ethnicList(request,name));
    }

}
