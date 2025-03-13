class Medicine {
    
    private String medicineName;
    private String company;
    private double price;
    private int quantity;
    private boolean Rx;

    public Medicine(String medicineName, String company, double price, int quantity, boolean Rx) {
        this.medicineName = medicineName;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
        this.Rx = Rx;
    }

    public String getmedicineName() {
        return medicineName;
    }

    public String getCompany() {
        return company;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getRx() {
        return Rx;
    }

    @Override
    public String toString() {
        return "--[ Drug: " + medicineName + "\tManufacturer: " + company + "\tPrice: " + price + "\tQuantity: " + quantity + "\tRx: " + Rx + "]--";
    }

}

