package com.nms.nms_user.repository;

import java.util.List;

public interface NewsRepository {
    List<String> findTop10ByOrderByPublishedAtDesc();
}
