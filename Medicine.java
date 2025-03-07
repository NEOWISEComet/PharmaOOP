class Medicine {
    
    private String name;
    private String company;
    private double price;
    private int quantity;

    public Medicine(String name, String company, double price, int quantity) {
        this.name = name;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "--[ Drug: " + name + "\tManufacturer: " + company + "\tPrice: " + price + "\tQuantity: " + quantity + " ]--";
    }

}
