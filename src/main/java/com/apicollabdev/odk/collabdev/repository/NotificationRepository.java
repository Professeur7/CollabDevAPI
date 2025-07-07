package com.apicollabdev.odk.collabdev.repository;

import com.apicollabdev.odk.collabdev.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {}
