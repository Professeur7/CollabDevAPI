package com.apicollabdev.odk.collabdev.service;


import com.apicollabdev.odk.collabdev.entity.Administrateur;
import com.apicollabdev.odk.collabdev.entity.Notification;
import com.apicollabdev.odk.collabdev.repository.AdministrateurRepository;
import com.apicollabdev.odk.collabdev.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private NotificationRepository notificationRepository;
    private AdministrateurRepository administrateurRepository;
    private Administrateur administrateur;

    @Override
    public Notification createNotification(Notification notification,long idAdmin) {
        Administrateur a = administrateurRepository.findById(idAdmin).orElseThrow(() -> new RuntimeException("Administrateur non trouv<UNK>"));
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
