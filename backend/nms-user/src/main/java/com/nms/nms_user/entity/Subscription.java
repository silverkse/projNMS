package com.nms.nms_user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subscriptions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {

    @Id
    @Generated(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;   //구독한 사용자

    @Column(nullable = false)
    private String newsTitle;   //구독한 뉴스 제목
}
