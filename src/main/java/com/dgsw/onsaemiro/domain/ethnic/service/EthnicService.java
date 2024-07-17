package com.dgsw.onsaemiro.domain.ethnic.service;

import com.dgsw.onsaemiro.domain.ethnic.domain.Thumbnail;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.ThumbnailRepository;
import com.dgsw.onsaemiro.domain.ethnic.exception.EthnicNotFoundException;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.request.EthnicRequest;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicListResponse;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicResponse;
import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.ThumbnailResponse;
import com.dgsw.onsaemiro.global.cloud.service.S3Util;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.EthnicRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EthnicService {
    private final EthnicRepository ethnicRepository;
    private final S3Util s3Util;
    private final ThumbnailRepository thumbnailRepository;

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

    public Response saveThumbnail(MultipartFile file, Long ethnicId) throws IOException {
        UUID uuid = UUID.randomUUID();
        String url = s3Util.uploadFile(uuid,file.getInputStream());

        String fileName = file.getOriginalFilename();
        thumbnailRepository.save(Thumbnail.builder()
                .name(fileName)
                .size(file.getSize())
                .extension(fileName.substring(fileName.lastIndexOf(".") + 1))
                .ethnicId(ethnicId)
                .url(url).build());
        return Response.ok("파일 업로드 성공");
    }

    public ResponseData<List<ThumbnailResponse>> getThumbnails(PageRequest request) {
        List<ThumbnailResponse> thumbnailList = thumbnailRepository.thumbnailList(request);

        return ResponseData.ok("썸네일 리스트 조회 성공", thumbnailList);
    }

    public ResponseData<List<ThumbnailResponse>> getThumbnails(List<Long> idList) {
        List<ThumbnailResponse> thumbnailList = idList.stream()
                .map(id -> ThumbnailResponse.builder()
                        .url(thumbnailRepository.findUrlById(id))
                        .build())
                .collect(Collectors.toList());

        return ResponseData.ok("썸네일 리스트 조회 성공", thumbnailList);
    }

}
