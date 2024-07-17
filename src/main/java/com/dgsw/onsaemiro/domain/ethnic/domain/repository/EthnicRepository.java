package com.dgsw.onsaemiro.domain.ethnic.domain.repository;

import com.dgsw.onsaemiro.domain.ethnic.domain.Ethnic;
import com.dgsw.onsaemiro.domain.ethnic.domain.repository.querydsl.CustomEthnicRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EthnicRepository extends JpaRepository<Ethnic,Long>, CustomEthnicRepo {
}
