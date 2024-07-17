package com.dgsw.onsaemiro.domain.ethnic.domain.repository;

import com.dgsw.onsaemiro.domain.ethnic.domain.Thumbnail;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl.CustomThumbnailRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long>, CustomThumbnailRepo {
    @Query("SELECT u.url FROM Thumbnail u WHERE u.id = :id")
    String findUrlById(Long id);
}
