package com.dgsw.onsaemiro.domain.ethnic.domain.repository;

import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl.CustomEthnicRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EthnicRepository extends JpaRepository<Ethnic,Long>, CustomEthnicRepo {
    @Query("SELECT MAX(e.id) FROM Ethnic e")
    Long findMaxId();
}
