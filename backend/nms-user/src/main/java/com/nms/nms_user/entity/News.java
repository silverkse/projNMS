package com.nms.nms_user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name="News")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class News {

    @Id
    @Generated(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private LocalDate PublishedAt;

}
