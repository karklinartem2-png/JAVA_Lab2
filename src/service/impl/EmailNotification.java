package service.impl;
import service.NotificationService;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        if (!recipient.contains("@") || !recipient.contains(".")) {
            System.out.println("Получен некорректный адрес почты. Письмо не доставлено!");
        } else {
            System.out.printf("[EMAIL] На адрес <%s> отправлено письмо: %s%n", recipient, message);
        }
    }
}
