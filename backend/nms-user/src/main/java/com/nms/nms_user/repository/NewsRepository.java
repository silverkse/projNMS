package com.nms.nms_user.repository;

import com.nms.nms_user.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News,Long> {
    List<News> findTop10ByOrderByPublishedAtDesc();
}
