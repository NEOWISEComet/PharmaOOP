class Pharmacist extends Person{

    private Pharmacy pharmacy;

    public Pharmacist(String name, String password, int IDnumber, Pharmacy pharmacy) {
        super(name, IDnumber, password);
        this.pharmacy = pharmacy;
    }

    public void searchMedicine(String medicineName) {
        pharmacy.searchMedicine(medicineName);
    }

    public void sellMedicine(String name, int quantity, int choice) {
        pharmacy.sellMedicine(name, quantity, choice);
    }

    public void viewInventory() {
        pharmacy.viewInventory();
    }

    @Override
    public String toString() {
        return "Pharmacist: " + this.getName();
    }
}