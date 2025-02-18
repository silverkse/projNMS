package com.nms.nms_user.repository;

import com.nms.nms_user.entity.News;
import com.nms.nms_user.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<News> findByUsername(String username);
}
