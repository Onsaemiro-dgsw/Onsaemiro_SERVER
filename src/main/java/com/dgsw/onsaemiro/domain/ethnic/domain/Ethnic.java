package com.dgsw.onsaemiro.domain.ethnic.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_ethnic")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Ethnic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 민족 이름
    @Column(nullable = false)
    private String name;

    // 현재 위치
    @Column(nullable = false)
    private String locate;

    // 설명
    @Column(nullable = false)
    private String content;

}
