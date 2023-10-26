public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating, String transportType,
            float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating, transportType);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getBrickSize() {
        return brickSize;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    @Override
    public String vehicleSelection() {
        int brickQty = getBrickQuantity();
        String vehicleType = "Truck";
        if (brickQty >= 300 && brickQty <= 500) {
            vehicleType = "Lorry";
        } else {
            vehicleType = "MonsterLorry";
        }
        return vehicleType;
    }

    @Override
    public float calculateTotalCharge() {
        float price = getBrickPrice() * getBrickQuantity();
        String vehicleType = vehicleSelection();
        float vehiclePrice = 1000;

        if (vehicleType.equalsIgnoreCase("Lorry")) {
            vehiclePrice = 1700;
        } else {
            vehiclePrice = 3000;
        }

        float tax = (float) (price * 0.3);
        float discount = 0;
        switch (transportRating) {
            case 5:
                discount = (float) (0.020 * price);
                break;
            case 3:
            case 4:
                discount = (float) (0.10 * price);
                break;
            case 1:
            case 2:
                // No discount for transportRating 1 and 2
                break;
            default:
                discount = 0;
        }
        return (price + vehiclePrice + tax) - discount;
    }

}
