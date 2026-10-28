package model;

public class Loader {
    private final String loadersName;
    private double rentalHours;
    private double pricePerHour;

    public String getLoadersName() {
        return loadersName;
    }

    public double getRentalHours() {
        return rentalHours;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
    public void setRentalHours(double rentalHours) {
        if (rentalHours >= 1) {
            this.rentalHours = rentalHours;
        } else {
            this.rentalHours = 1;
        }
    }
    public void setPricePerHour(double pricePerHour) {
        if (pricePerHour >= 100) {
            this.pricePerHour = pricePerHour;
        } else {
            this.pricePerHour = 100;
        }
    }
    public Loader(String loadersName, double rentalHours, double pricePerHour) {
        this.loadersName = loadersName.toUpperCase();
        setRentalHours(rentalHours);
        setPricePerHour(pricePerHour);
    }
}