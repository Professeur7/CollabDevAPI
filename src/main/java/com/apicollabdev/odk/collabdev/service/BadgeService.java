package com.apicollabdev.odk.collabdev.service;

import com.apicollabdev.odk.collabdev.entity.Badge;

import java.util.List;

public interface BadgeService {
    Badge createBadge(Badge badge);
    List<Badge> getAllBadges();
    Badge getById(Long id);
    void deleteById(Long id);
}
