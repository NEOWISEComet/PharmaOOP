public class Request {
    private String medicineName;
    private String company;
    private double price;
    private int quantity;
    private boolean Rx;
    
    // add, edit, remove
    private String action;

    public Request(String medicineName, String company, double price, int quantity, boolean Rx, String action) {
        this.medicineName = medicineName;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
        this.Rx = Rx;
        this.action = action;
    }

    public String getMedicineName() {
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

    public boolean isRx() {
        return Rx;
    }

    public String getAction() {
        return action;
    }

    public void setRx(boolean Rx) {
        this.Rx = Rx;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAction(String action) {
        this.action = action;
    }

    /*public void updateRequest(String medicineName, String company, String field, Object newValue) {
        if (this.medicineName.equals(medicineName) && this.company.equals(company)) {
            switch (field) {
                case "price":
                    if (newValue instanceof Double) {
                        setPrice((Double) newValue);
                    }
                    break;
                case "quantity":
                    if (newValue instanceof Integer) {
                        setQuantity((Integer) newValue);
                    }
                    break;
                case "Rx":
                    if (newValue instanceof Boolean) {
                        setRx((Boolean) newValue);
                    }
                    break;
                case "action":
                    if (newValue instanceof String) {
                        setAction((String) newValue);
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + field);
            }
        }
    }*/
    
    public Request(String medicineName, String company, double price, int quantity, String action) {
        //this(medicineName, company, price, quantity, false, action);
        this.medicineName = medicineName;
        this.company = company;
        this.price = price;
        this.quantity = quantity;
        this.action = action;
    }
}