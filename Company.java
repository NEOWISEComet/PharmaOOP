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

    //Only adds medicine to the pharmacy of the company
    public void addMedicine(String medicineName, String company, double price, int quantity, boolean Rx) {
        pharmacy.addMedicine(new Medicine(medicineName, this.getName() , price, quantity, Rx));
    }

    //Checks company name then edit
    public void editMedicine(String medicineName, double price, int quantity) {
        if (this.getName().equals(pharmacy.getmedicineName(medicineName).getCompany())){
            pharmacy.editMedicine(medicineName, price, quantity);
        } else {
            System.out.println("You are not allowed to edit this medicine");
        }
    }

    //Checks company name then remove
    public void removeMedicine(String medicineName) {
        if (this.getName().equals(pharmacy.getmedicineName(medicineName).getCompany())){
            pharmacy.removeMedicine(medicineName);
        } else {
            System.out.println("You are not allowed to remove this medicine");
        }
    }

}