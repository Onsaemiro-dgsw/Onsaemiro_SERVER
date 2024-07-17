package com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.ThumbnailResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dgsw.onsaemiro.domain.ethnic.domain.QThumbnail.thumbnail;

@Repository
@RequiredArgsConstructor
public class CustomThumbnailRepoImpl implements CustomThumbnailRepo {

    private final JPAQueryFactory query;

    @Override
    public List<ThumbnailResponse> thumbnailList(PageRequest request) {
        return query.select(Projections.constructor(ThumbnailResponse.class,
                        thumbnail.url))
                .from(thumbnail)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(thumbnail.id.desc())
                .fetch();
    }
}
