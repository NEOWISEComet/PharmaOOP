class Admin extends Person{

    private Pharmacy pharmacy;
    /*private String name = "admin";
    private String password = "admin";*/

    public Admin(String name, String password, int IDnumebr, Pharmacy pharmacy) {
        super(name, IDnumebr, password);
        this.pharmacy = pharmacy;
    }

    public void addMedicine(String medicineName, String company, double price, int quantity, boolean Rx) {
        pharmacy.addMedicine(new Medicine(medicineName, company, price, quantity, Rx));
    }

    public void editMedicine(String medicineName, double price, int quantity) {
        pharmacy.editMedicine(medicineName, price, quantity);
    }

    public void removeMedicine(String medicineName) {
        pharmacy.removeMedicine(medicineName);
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
}