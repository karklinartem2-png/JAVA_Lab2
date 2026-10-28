package model;

public abstract class VanService {

    private final String clientName;
    private final double basePrice;
    private final String vanType; // "SMALL" "AVERAGE" "BIG"

    private Loader hiredLoader = null;

    public VanService(String clientName, double basePrice, String vanType) {
        this.clientName = clientName;
        if(basePrice <= 0){
            basePrice = 100;
            System.out.println("[Система] ВНИМАНИЕ: попытка присвоить недопустимое значение (basePrice <= 0). Присвоено значение 100");
        }
        this.basePrice = basePrice;
        this.vanType = vanType.toUpperCase();
    }

    public abstract double calculateOrderPrice();

    public String getClientName() {
        return clientName;
    }
    public String getVanType() {
        return vanType;
    }
    public double getBasePrice(){
        return basePrice;
    }
}