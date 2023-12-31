public class TimberTransport extends GoodsTransport {
    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating, String transportType,
            float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating, transportType);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public float getTimberLength() {
        return timberLength;
    }

    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    @Override
    public String vehicleSelection() {
        // setting default return type
        double area = 2 * 3.147 * getTimberLength() * getTimberRadius();
        String vehicleType = "Truck";
        if (area < 250) {
            vehicleType = "Truck";
        } else if (area >= 250 && area <= 400) {
            vehicleType = "Lorry";
        } else {
            vehicleType = "MonsterLorry";
        }

        return vehicleType;
    }

    @Override
    public float calculateTotalCharge() {
        float volume = (float) (3.147 * getTimberRadius() * getTimberRadius() * getTimberLength());
        String vehicleType = vehicleSelection();
        float vehiclePrice = 1000;

        if (vehicleType.equalsIgnoreCase("Truck")) {
            vehiclePrice = 1700;
        } else if (vehicleType.equalsIgnoreCase("Lorry")) {
            vehiclePrice = 1000;
        } else {
            vehiclePrice = 3000;
        }

        float price = (float) (volume * getTimberPrice() * (getTimberType().equalsIgnoreCase("premium") ? 0.25 : 0.15));
        float tax = (float) (price * 0.30);

        float discount = 0;
        switch (transportRating) {
            case 5:
                discount = (float) (0.20 * price);
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
        float charge = (price + vehiclePrice + tax) - discount;

        return charge;
    }

}
