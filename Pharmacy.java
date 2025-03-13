import java.util.ArrayList;
import java.util.List;

class Pharmacy {
    private Inventory inventory = new Inventory();
    private List<Pharmacist> pharmacists = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();

    public void addMedicine(Medicine medicine) {
        inventory.addMedicine(medicine);
    }

    public void editMedicine(String name, double price, int quantity) {
        inventory.editMedicine(name, price, quantity);
    }

    public void removeMedicine(String name) {
        inventory.removeMedicine(name);
    }

    public void viewInventory() {
        inventory.viewInventory();
    }

    public void viewMedicine(String name) {
        inventory.viewMedicine(name);
    }

    public void sellMedicine(String name, int quantity, int choice) {
        inventory.sellMedicine(name, quantity, pharmacists.get(0).toString(), choice);
    }

    public void buyMedicine(String medicineName, int quantity ){
        inventory.noRxReq(medicineName, quantity);
    }

    //add or remove pharmacists
    public void addPharmacist(Pharmacist pharmacist) {
        pharmacists.add(pharmacist);
    }

    public void removePharmacist(Pharmacist pharmacist) {
        pharmacists.remove(pharmacist);
    }

    //add or remove customers
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    //add or remove companies
    public void addCompany(Company company) {
        companies.add(company);
    }

    public void removeCompany(Company company) {
        companies.remove(company);
    }

    public Medicine getmedicineName(String medicineName) {
        return inventory.getmedicineName(medicineName);
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }

    //Check credentials for pharmacists
    public Pharmacist pharmacistCred(String name, String password) {
        return (Pharmacist) Person.checkCredentials(pharmacists, name, password);
    }

    //Check credentials for customers
    public Customer customerCred(String name, String password) {
        return (Customer) Person.checkCredentials(customers, name, password);
    }

    //Check credentials for companies
    public Company companyCreds(String name, String password) {
        return (Company) Person.checkCredentials(companies, name, password);
    }

    //Check credentials for admin
    public Admin adminCreds(String name, String password) {
        return (Admin) Person.checkCredentials(pharmacists, name, password);
    }

}