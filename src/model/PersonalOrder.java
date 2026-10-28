package model;

public class PersonalOrder extends VanService {

    public PersonalOrder(String clientName, double basePrice) {
        super(clientName, basePrice, "SMALL");
    }

    public PersonalOrder(String clientName, double basePrice, String vanType){
        super(clientName, basePrice, vanType);
    }

    @Override
    public double calculateOrderPrice() {
        final double priceModifier = switch (getVanType()) {
            case "SMALL" -> 1.0;
            case "AVERAGE" -> 1.35;
            case "BIG" -> 1.80;
            default -> {
                System.out.println("[Система] Неизвестный тип грузовика. Выбран грузовик малого размера.");
                yield 1.0;
            }
        };

        double finalPrice = getBasePrice() * priceModifier;
        return Math.round(finalPrice * 100.0)/100.0;
    }
}
