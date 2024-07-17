package com.dgsw.onsaemiro.domain.word.service;

import com.dgsw.onsaemiro.domain.word.domain.Word;
import com.dgsw.onsaemiro.domain.word.domain.repository.WordRepository;
import com.dgsw.onsaemiro.domain.word.presentation.dto.request.SaveWordListRequest;
import com.dgsw.onsaemiro.domain.word.presentation.dto.response.WordResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.dgsw.onsaemiro.global.common.dto.response.Response;
import com.dgsw.onsaemiro.global.common.dto.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository wordRepository;

    public Response saveWords(SaveWordListRequest request){
        // 단어를 하나씩 저장하는 로직
        request.getWords().stream()
                .forEach(word -> wordRepository.save(Word.builder()
                                .word(word.getWord())
                                .description(word.getDescription()).build()));

        return Response.created("단어 저장에 성공했습니다.");
    }

    public ResponseData<List<WordResponse>> wordList(PageRequest request){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", wordRepository.wordList(request));
    }

    public ResponseData<List<WordResponse>> wordList(PageRequest request, String word){
        return ResponseData.ok("민족 리스트 조회를 성공했습니다.", wordRepository.wordList(request,word));
    }

}
