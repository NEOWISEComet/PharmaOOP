class Admin extends Person{

    private Pharmacy pharmacy;
    
    /*private String name = "admin";
    private String password = "admin";*/

    public Admin(String name, String password, int IDnumebr, Pharmacy pharmacy) {
        super(name, IDnumebr, password);
        this.pharmacy = pharmacy;       
    }

    /*public void addMedicine(String medicineName, String company, double price, int quantity, boolean Rx) {
        pharmacy.addMedicine(new Medicine(medicineName, company, price, quantity, Rx));
    }*/

    /*public void editMedicine(String medicineName, double price, int quantity) {
        pharmacy.editMedicine(medicineName, price, quantity);
    }*/

    /*public void removeMedicine(String medicineName) {
        pharmacy.removeMedicine(medicineName);
    }*/

    /*public void viewInventory() {
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
    }*/

    public void receiveRequest(Request request) {
        pharmacy.getRequests().put(request.getMedicineName(), request);
    }

    /*public void proccessRequest(String medicineName) {
        HashMap<String, Request> requests = pharmacy.getRequests();
        Request request = requests.get(medicineName);
        if (request != null) {
            switch (request.getAction()) {
                case "add":
                    pharmacy.addMedicine(new Medicine(request.getMedicineName(), request.getCompany(), request.getPrice(), request.getQuantity(), request.isRx()));
                    break;
                case "edit":
                    pharmacy.editMedicine(request.getMedicineName(), request.getPrice(), request.getQuantity());
                    break;
                case "remove":
                    pharmacy.removeMedicine(request.getMedicineName());
                    break;
            }
            requests.remove(medicineName);
        } else {
            System.out.println("No request found for the medicine: " + medicineName);
        }
    }*/

    /*public void viewRequests() {
        HashMap<String, Request> requests = pharmacy.getRequests();
        for (Request request : requests.values()) {
            System.out.println("Request: " + request.getAction() + " " + request.getMedicineName() + " by " + request.getCompany());
        }
    }*/
}