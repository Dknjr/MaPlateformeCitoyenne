/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.defictech.AlertCommune.service;

import com.defictech.AlertCommune.dao.NotificationRepository;
import com.defictech.AlertCommune.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Serge
 */


@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Optional<Notification> findById(Integer id) {
        return notificationRepository.findById(id);
    }

    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    public void deleteById(Integer id) {
        notificationRepository.deleteById(id);
    }

    // Additional methods can be implemented here
}

