import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pharmacy {
    private Inventory inventory = new Inventory();
    private Admin admin;
    private HashMap<String, Request> requests;
    
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

    public void searchMedicine(String medicineName) {
        inventory.searchMedicine(medicineName);
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

    public List<Company> getCompany(){
        return companies;
    }

    public void proccessRequest(String medicineName) {
        Request request = requests.get(medicineName);
        if (request != null) {
            switch (request.getAction()) {
                case "add":
                    addMedicine(new Medicine(request.getMedicineName(), request.getCompany(), request.getPrice(), request.getQuantity(), request.isRx()));
                    break;
                case "edit":
                    editMedicine(request.getMedicineName(), request.getPrice(), request.getQuantity());
                    break;
                case "remove":
                    removeMedicine(request.getMedicineName());
                    break;
            }
            requests.remove(medicineName);
        }else {
            System.out.println("No request found");
        }
    }

    public void receiveRequest(Request request) {
        requests.put(request.getMedicineName(), request);
    }

    public void requestAddMedicine(String medicineName, String company, double price, int quantity, boolean Rx) {
       Request request = new Request(medicineName, company, price, quantity, Rx, "add");
        receiveRequest(request);
    }

    public void requestEditMedicine(String medicineName, String company, double price, int quantity) {
        Request request = new Request(medicineName, company, price, quantity, "edit");
        receiveRequest(request);
    }

    public void requestRemoveMedicine(String medicineName, String company) {
        Request request = new Request(medicineName, company, 0, 0, "remove");
        receiveRequest(request);
    }

    public HashMap<String, Request> getRequests() {
        return requests;
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
    /*public Admin adminCreds(String name, String password) {
        return (Admin) Person.checkCredentials(List.of(admin), name, password);
    }*/

    public boolean login(String name, String password) {
        return admin.getName().equals(name) && admin.getPassword().equals(password);
    }

}