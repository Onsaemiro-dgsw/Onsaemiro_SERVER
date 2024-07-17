package com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl;

import com.dgsw.onsaemiro.domain.ethnic.presentation.dto.response.EthnicListResponse;
import com.dgsw.onsaemiro.global.common.dto.request.PageRequest;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.dgsw.onsaemiro.domain.ethnic.domain.QEthnic.ethnic;

@Repository
@RequiredArgsConstructor
public class CustomEthnicRepoImpl implements CustomEthnicRepo{
    private final JPAQueryFactory query;

    @Override
    public List<EthnicListResponse> ethnicList(PageRequest request) {
        return query.select(Projections.constructor(EthnicListResponse.class,
                        ethnic.id,
                        ethnic.name,
                        ethnic.content))
                .from(ethnic)
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(ethnic.id.desc())
                .fetch();
    }

    @Override
    public List<EthnicListResponse> ethnicList(PageRequest request, String name) {
        return query.select(Projections.constructor(EthnicListResponse.class,
                        ethnic.id,
                        ethnic.name,
                        ethnic.content))
                .from(ethnic)
                .where(ethnic.name.contains(name))
                .offset((request.getPage() - 1) * request.getSize())
                .limit(request.getSize())
                .orderBy(ethnic.id.desc())
                .fetch();
    }
}
