package com.dgsw.onsaemiro.domain.word.domain.repository;

import com.dgsw.onsaemiro.domain.word.domain.Word;
import com.dgsw.onsaemiro.domain.word.domain.repository.querydsl.CustomWordRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long>, CustomWordRepo {
}
