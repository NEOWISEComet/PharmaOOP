class Company extends Person{

    private Pharmacy pharmacy;
    private int companyContact;
    
    public Company(String name, int IDnumber, String password, int companyContact) {
        super(name, IDnumber, password);
        this.companyContact = companyContact;
    }

    public void setCompanyContact(int companyContact) {
        this.companyContact = companyContact;
    }

    public int getCompanyContact() {
        return companyContact;
    }

    /*public void addMedicine(String medicineName, String company, double price, int quantity, boolean Rx) {
        pharmacy.addMedicine(new Medicine(medicineName, this.getName() , price, quantity, Rx));
    }
    public void editMedicine(String medicineName, double price, int quantity) {
        if (this.getName().equals(pharmacy.getmedicineName(medicineName).getCompany())){
            pharmacy.editMedicine(medicineName, price, quantity);
        } else {
            System.out.println("You are not allowed to edit this medicine");
        }
    }
    public void removeMedicine(String medicineName) {
        if (this.getName().equals(pharmacy.getmedicineName(medicineName).getCompany())){
            pharmacy.removeMedicine(medicineName);
        } else {
            System.out.println("You are not allowed to remove this medicine");
        }
    }*/

    // Sends a request to add medicine via Pharmacy
    public void requestAddMedicine(String medicineName, double price, int quantity, boolean Rx) {
        pharmacy.requestAddMedicine(medicineName, this.getName(), price, quantity, Rx);
    }

    // Sends a request to edit medicine via Pharmacy
    public void requestEditMedicine(String medicineName, double price, int quantity) {
        pharmacy.requestEditMedicine(medicineName, this.getName(), price, quantity);
    }

    // Sends a request to remove medicine via Pharmacy
    public void requestRemoveMedicine(String medicineName) {
        pharmacy.requestRemoveMedicine(medicineName, this.getName());
    }

}