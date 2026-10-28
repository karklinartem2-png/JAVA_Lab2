package service.impl;
import service.NotificationService;

public class SmsNotification implements NotificationService {
    @Override
    public void sendNotification(String message, String recipient) {
        if(recipient.charAt(0)=='8' || (recipient.charAt(0)=='+' && recipient.charAt(1)=='7')) {
            System.out.printf("[SMS] На номер [%s] отправлено сообщение: %s%n", recipient, message);
        }
        else{
            System.out.println("Получен некорректный телефон. [SMS] не было доставлено!");
        }
    }
}