class Pharmacist {

    private String name;
    private Pharmacy pharmacy;

    public Pharmacist(String name, Pharmacy pharmacy) {
        this.name = name;
        this.pharmacy = pharmacy;
    }

    public void searchMedicine(String name) {
        pharmacy.viewMedicine(name);
    }

    public void sellMedicine(String name, int quantity) {
        pharmacy.sellMedicine(name, quantity);
    }

    @Override
    public String toString() {
        return "Pharmacist: " + name;
    }
}