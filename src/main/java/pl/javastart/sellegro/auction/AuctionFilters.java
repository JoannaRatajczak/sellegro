package pl.javastart.sellegro.auction;

public class AuctionFilters { //enum? switch

    private String carMake;
    private String carModel;
    private String color;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMaker) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
