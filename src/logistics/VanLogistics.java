package logistics;

import model.VanService;
import service.NotificationService;

public class VanLogistics {
    // Статические поля для глобального мониторинга системы
    private static int totalOrders = 0;
    private static double totalRevenue = 0;

    private final NotificationService notificationService;

    public VanLogistics(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public void processOrder(VanService serv, String contact) {
        double finalPrice = serv.calculateOrderPrice();

        totalRevenue += finalPrice;
        totalOrders++;

        String message = String.format("Успешная оплата! Арендатор: %s | Размер грузовика: %s | К оплате: %.2f руб.%n",
                serv.getClientName(), serv.getVanType(), finalPrice);

        notificationService.sendNotification(message, contact);
    }

    public static void printGlobalStats() {
        System.out.println("\n------------------------------------------------");
        System.out.println("   ГЛОБАЛЬНАЯ СТАТИСТИКА АРЕНДЫ ГРУЗОВИКОВ   ");
        System.out.println("--------------------------------------------------");
        System.out.println("Всего заказов: " + totalOrders);
        System.out.println("Общая выручка: " + Math.round(totalRevenue * 100.0) / 100.0 + " руб.");
        System.out.println("--------------------------------------------------");
    }
}