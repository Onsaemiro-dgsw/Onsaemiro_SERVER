package com.dgsw.onsaemiro.domain.ethnic.presentation;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.request.EthnicRequest;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicListResponse;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicResponse;
import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.ThumbnailResponse;
import com.dgsw.onsaemiro.global.cloud.exception.FileUploadException;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dgsw.onsaemiro.domain.ethnic.service.EthnicService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/ethnics")
@RequiredArgsConstructor
@Tag(name = "민족", description = "민족 API")
public class EthnicController {

    private final EthnicService ethnicService;

    // 민족 등록
    @PostMapping("")
    @Operation(summary = "민족 저장", description = "민족 정보를 저장합니다.")
    public Response createEthnic(@RequestBody EthnicRequest requestDto){
        return ethnicService.createEthnic(requestDto);
    }

    // 민족 조회
    @GetMapping("/{id}")
    @Operation(summary = "민족 조회", description = "id로 민족 정보를 조회합니다.")
    public ResponseData<EthnicResponse> getEthnic(@PathVariable Long id){
        return ethnicService.findEthnic(id);
    }

    @GetMapping("")
    @Operation(summary = "민족 리스트 조회", description = "민족 리스트를 조회합니다.")
    public ResponseData<List<EthnicListResponse>> ethnicList(@ModelAttribute PageRequest request){
        return ethnicService.ethnicList(request);
    }

    @GetMapping("/name")
    @Operation(summary = "민족 검색", description = "민족명으로 민족을 검색합니다.")
    public ResponseData<List<EthnicListResponse>> ethnicListByName(
            @ModelAttribute PageRequest request,
            @RequestParam String name
    ){
        return ethnicService.ethnicList(request,name);
    }

    @PostMapping("/{id}/thumbnail")
    @Operation(summary = "썸네일 저장", description = "민족 썸네일을 저장합니다.")
    public Response fileUpload(
            @RequestParam("file") MultipartFile file,
            @PathVariable Long id
    ) {
        try {
            return ethnicService.saveThumbnail(file, id);
        } catch (IOException e) {
            throw FileUploadException.EXCEPTION;
        }
    }

    @GetMapping("/thumbnail")
    @Operation(summary = "썸네일 리스트 조회", description = "썸네일 리스트를 조회합니다.")
    public ResponseData<List<ThumbnailResponse>> getThumbnails(@ModelAttribute PageRequest request){
        return ethnicService.getThumbnails(request);
    }

    @GetMapping("/{id}/thumbnail")
    @Operation(summary = "썸네일 리스트 조회", description = "썸네일 리스트를 조회합니다.")
    public ResponseData<List<ThumbnailResponse>> getThumbnailsById(@ModelAttribute List<Long> idList){
        return ethnicService.getThumbnails(idList);
    }

}
