package com.dgsw.onsaemiro.domain.word.service;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.ThumbnailResponse;
import com.dgsw.onsaemiro.domain.word.domain.Pictogram;
import com.dgsw.onsaemiro.domain.word.domain.Word;
import com.dgsw.onsaemiro.domain.word.domain.repository.PictogramRepository;
import com.dgsw.onsaemiro.domain.word.domain.repository.WordRepository;
import com.dgsw.onsaemiro.domain.word.presentation.dto.request.SavePictogramRequest;
import com.dgsw.onsaemiro.domain.word.presentation.dto.request.SaveWordListRequest;
import com.dgsw.onsaemiro.domain.word.presentation.dto.response.PictogramResponse;
import com.dgsw.onsaemiro.domain.word.presentation.dto.response.WordResponse;
import com.dgsw.onsaemiro.global.cloud.exception.FileUploadException;
import com.dgsw.onsaemiro.global.cloud.service.S3Util;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;
    private final PictogramRepository pictogramRepository;
    private final S3Util s3Util;

    public Response saveWords(SaveWordListRequest request){
        // 단어를 하나씩 저장하는 로직
        request.getWords().stream()
                .forEach(word -> wordRepository.save(Word.builder()
                                    .word(word.getWord())
                                    .description(word.getDescription())
                                    .seq(word.getSeq())
                                    .build()));

        return Response.created("단어 저장에 성공했습니다.");
    }

    public ResponseData<List<WordResponse>> wordList(PageRequest request){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", wordRepository.wordList(request));
    }

    public ResponseData<List<WordResponse>> wordList(PageRequest request, String word){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", wordRepository.wordList(request,word));
    }

    public Response savePictogram(List<SavePictogramRequest> requests, Long ethnicId) throws IOException {
        requests.stream()
                .forEach(request -> {
                    UUID uuid = UUID.randomUUID();
                    String url;
                    // 1. s3 저장
                    try {
                        url = s3Util.uploadFile(uuid, request.getMultipartFile().getInputStream());
                    } catch (IOException e) {
                        throw FileUploadException.EXCEPTION;
                    }
                    // 2. DB에 저장
                    String fileName = request.getMultipartFile().getOriginalFilename();
                    pictogramRepository.save(Pictogram.builder()
                            .name(fileName)
                            .size(request.getMultipartFile().getSize())
                            .extension(getExtension(fileName))
                            .ethnicId(ethnicId)
                            .url(url)
                            .wordSeq(request.getSeq())
                            .build());
                });
        return Response.created("픽토그램 저장에 성공했습니다.");
    }

    public ResponseData<List<PictogramResponse>> getPictograms(){
        List<PictogramResponse> pictogramList = pictogramRepository.findAll()
                .stream().map(id -> PictogramResponse.builder()
                        .url(id.getUrl())
                        .seq(id.getWordSeq())
                        .build())
                .collect(Collectors.toList());

        return ResponseData.ok("픽토그램 리스트 조회 성공", pictogramList);
    }

    /**
     * 파일 확장자를 추출합니다.
     * @return
     */
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
