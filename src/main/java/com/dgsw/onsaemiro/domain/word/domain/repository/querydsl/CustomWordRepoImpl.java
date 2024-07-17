package com.dgsw.onsaemiro.domain.word.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.word.presentation.dto.response.WordResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dgsw.onsaemiro.domain.word.domain.QWord.word1;

@Repository
@RequiredArgsConstructor
public class CustomWordRepoImpl implements CustomWordRepo {

    private final JPAQueryFactory query;

    @Override
    public List<WordResponse> wordList(PageRequest request) {
        return query.select(Projections.constructor(WordResponse.class,
                        word1.id,
                        word1.word,
                        word1.description))
                .from(word1)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(word1.id.desc())
                .fetch();
    }

    @Override
    public List<WordResponse> wordList(PageRequest request, String q) {
        return query.select(Projections.constructor(WordResponse.class,
                        word1.id,
                        word1.word,
                        word1.description))
                .from(word1)
                .where(word1.word.contains(q))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(word1.id.desc())
                .fetch();
    }
}
