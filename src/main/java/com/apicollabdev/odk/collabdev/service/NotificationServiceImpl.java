package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Notification;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private AdministrateurRepository administrateurRepository;



    @Override
    public Notification createNotification(Notification notification,long id_administrateur) {
        Administrateur a = administrateurRepository.findById(id_administrateur).orElseThrow(() -> new RuntimeException("Administrateur non trouv<UNK>"));
        notification.setDateNotification(notification.getDateNotification());
        notification.setDescription(notification.getDescription());
        notification.setEnumType(notification.getEnumType());
        notification.setEtat(notification.isEtat());
        notification.setAdministrateur(a);
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification getById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification non trouvée"));
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);
    }
}
