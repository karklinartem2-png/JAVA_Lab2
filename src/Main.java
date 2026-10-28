import model.*;
import service.NotificationService;
import service.impl.*;
import logistics.VanLogistics;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Запуск системы каршеринга грузовиков ---\n");

        // 1. Создаем разные стратегии уведомлений
        NotificationService smsService = new SmsNotification();
        NotificationService emailService = new EmailNotification();

        // 2. Создаем первый заказ с внедрением SMS-сервиса
        VanLogistics smsVanLogistics = new VanLogistics(smsService);

        // Оформляем обычный заказ физ. лица
        VanService userOrder = new PersonalOrder("Елисей", 1000, "SMALL");
        smsVanLogistics.processOrder(userOrder, "8-800-555-35-35");

        System.out.println();

        // 3. Создаем второй заказ с внедрением Email-сервиса
        VanLogistics emailVanLogistics = new VanLogistics(emailService);

        // Оформляем корпоративный заказ на 5 грузовиков
        VanService corpOrder = new CorporateOrder("ООО ТехноПром", 1000, "BIG", 5);
        emailVanLogistics.processOrder(corpOrder, "finance@technoprom.ru");

        // Прроверки исключений:
        // Базовая цена равна 0
        // Неизвестный тип грузовика
        userOrder = new PersonalOrder("Артём", 0, "404");
        // Некорректный адрес почты
        emailVanLogistics.processOrder(userOrder, "Pochta");
        // Некорректный телефон
        smsVanLogistics.processOrder(userOrder, "9-999-99-99");

        // . Вывод глобальной статистики
        VanLogistics.printGlobalStats();
    }
}
