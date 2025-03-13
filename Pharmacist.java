class Pharmacist extends Person{

    private String holdName;
    private Pharmacy pharmacy;

    public Pharmacist(String name, String password, int IDnumber, Pharmacy pharmacy) {
        super(name, IDnumber, password);
        this.pharmacy = pharmacy;
        this.holdName = name;
    }

    public void searchMedicine(String name) {
        pharmacy.viewMedicine(name);
    }

    public void sellMedicine(String name, int quantity, int choice) {
        pharmacy.sellMedicine(name, quantity, choice);
    }

    public void viewInventory() {
        pharmacy.viewInventory();
    }

    @Override
    public String toString() {
        return "Pharmacist: " + holdName;
    }
}