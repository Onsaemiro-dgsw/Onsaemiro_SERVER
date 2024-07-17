package com.dgsw.onsaemiro.domain.word.domain;

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
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "tb_pictogram")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Pictogram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false,unique = true)
    private Long ethnicId;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer wordSeq;

}
