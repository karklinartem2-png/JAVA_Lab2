package model;

public class CorporateOrder extends VanService{
    private final int amountOfVans;

    public CorporateOrder(String clientName, double basePrice, String vanType, int ammountOfVans){
        super(clientName, basePrice, vanType);
        this.amountOfVans = Math.max(1, ammountOfVans);
    }

    @Override
    public double calculateOrderPrice() {
        final double priceModifier = switch (getVanType()) {
            case "SMALL" -> 1.0;//Если к-во грузовиков больше одного, то цена по тарифу снижена (кроме случая SMALL)
            case "AVERAGE" -> {
                if(amountOfVans >1) yield 1.30;
                else yield 1.35;
            }
            case "BIG" -> {
                if(amountOfVans >1) yield 1.75;
                else yield 1.80;
            }
            default -> {
                System.out.println("[Система] Неизвестный тип грузовика. Выбран грузовик малого размера.");
                yield 1.0;
            }
        };

        double finalPrice = getBasePrice() * priceModifier * amountOfVans;
        return Math.round(finalPrice * 100.0)/100.0;
    }

    public int getAmountOfVans() {
        return amountOfVans;
    }
}
