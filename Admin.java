class Admin {

    private Pharmacy pharmacy;
    private String name = "admin";
    private String password = "admin";

    public Admin(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void addMedicine(String name, String company, double price, int quantity) {
        pharmacy.addMedicine(new Medicine(name, company, price, quantity));
    }

    public void editMedicine(String name, double price, int quantity) {
        pharmacy.editMedicine(name, price, quantity);
    }

    public void removeMedicine(String name) {
        pharmacy.removeMedicine(name);
    }

    public void viewInventory() {
        pharmacy.viewInventory();
    }

    public void addPharmacist(Pharmacist pharmacist) {
        pharmacy.addPharmacist(pharmacist);
    }

    public void removePharmacist(Pharmacist pharmacist) {
        pharmacy.removePharmacist(pharmacist);
    }

    public void viewPharmacists() {
        for (Pharmacist pharmacist : pharmacy.getPharmacists()) {
            System.out.println(pharmacist);
        }
    }

    public boolean login(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }
}