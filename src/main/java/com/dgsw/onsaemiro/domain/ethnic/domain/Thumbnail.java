package com.dgsw.onsaemiro.domain.ethnic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_thumbnail")
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Thumbnail {

    @Id
    private String url;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String extension;

    @Column(nullable = false,unique = true)
    private Long ethnicId;

}
