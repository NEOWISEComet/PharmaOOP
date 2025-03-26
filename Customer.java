class Customer extends Person{

    private Pharmacy pharmacy;
    private int contactNumber;

    public Customer(String name, String password, int IDnumber, int contactNumber){
        super(name, IDnumber, password);
        this.contactNumber = contactNumber;
    }

    /*
    public void buyMedicine(String medicineName, int quantity){
        pharmacy.buyMedicine(medicineName, quantity);
    }

    public void searchMedicine(String medicineName) {
        pharmacy.searchMedicine(medicineName);
    }
    
    public void viewInventory() {
        pharmacy.viewInventory();
    } */

    public int getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(int contactNumber){
        this.contactNumber = contactNumber;
    }
}