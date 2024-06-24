package com.api.systeme_de_gestion_de_ticket.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.api.systeme_de_gestion_de_ticket.modele.Notification;
import com.api.systeme_de_gestion_de_ticket.modele.Ticket;
import com.api.systeme_de_gestion_de_ticket.repository.NotificationRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationServiceImpl {

    private final NotificationRepository notificationRepository;
    private final JavaMailSender mailSender;

    public void envoyerNotification(Ticket ticket, String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTicket(ticket);
        notification.setApprenant(ticket.getApprenant());

        // Save the notification in the database
        notificationRepository.save(notification);

        // Send the email notification
        sendEmailNotification(ticket.getApprenant().getEmail(), message);
    }

    private void sendEmailNotification(String mail, String message) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(mail);
            helper.setSubject("Nouvelle Notification de Ticket");
            helper.setText(message, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
