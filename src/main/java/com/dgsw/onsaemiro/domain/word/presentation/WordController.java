package com.dgsw.onsaemiro.domain.word.presentation;

import com.dgsw.onsaemiro.domain.word.presentation.dto.request.SaveWordListRequest;
import com.dgsw.onsaemiro.domain.word.presentation.dto.response.WordResponse;
import com.dgsw.onsaemiro.domain.word.service.WordService;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/words")
@RequiredArgsConstructor
@Tag(name = "단어", description = "단어 API")
public class WordController {

    private final WordService wordService;

    @PostMapping("")
    @Operation(summary = "단어 리스트 저장", description = "단어 리스트를 저장합니다.")
    public Response saveWords(@RequestBody SaveWordListRequest request) {
        return wordService.saveWords(request);
    }

    @GetMapping("")
    @Operation(summary = "단어 리스트 조회", description = "단어 리스트를 조회합니다.")
    public ResponseData<List<WordResponse>> wordList(
            @ModelAttribute PageRequest request
    ){
        return wordService.wordList(request);
    }

    @GetMapping("/q")
    @Operation(summary = "단어 검색", description = "단어 검색해서 결과를 조회합니다.")
    public ResponseData<List<WordResponse>> ethnicListByName(
            @ModelAttribute PageRequest request,
            @RequestParam String word
    ){
        return wordService.wordList(request,word);
    }

}
