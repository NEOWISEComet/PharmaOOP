import java.util.HashMap;

class Inventory {
    private HashMap<String, Medicine> inventory = new HashMap<>();

    public void addMedicine(Medicine medicine) {
        inventory.put(medicine.getmedicineName(), medicine);
    }

    public void editMedicine(String medicineName, double price, int quantity) {
        Medicine medicine = inventory.get(medicineName);
        if (medicine != null) {
            medicine.setPrice(price);
            medicine.setQuantity(quantity);
        } else {
            System.out.println(medicineName + " Can't be Found\n");
        }
    }

    public void removeMedicine(String medicineName) {
        if (inventory.containsKey(medicineName)) {
            inventory.remove(medicineName);
        } else {
            System.out.println(medicineName + " Can't be Found\n");
        }
    }

    public void viewInventory() {
        System.out.println("Inventory:");
        for (Medicine medicine : inventory.values()) {
            System.out.println("--[ Drug: " + medicine.getmedicineName() + 
                               " Manufacturer: " + medicine.getCompany() + 
                               " Price: " + medicine.getPrice() + 
                               " Quantity: " + medicine.getQuantity() + 
                               " Rx: " + medicine.getRx() + " ]--");
        }
    }

    public void viewMedicine(String medicineName) {
        Medicine medicine = inventory.get(medicineName);
        if (medicine != null) {
            System.out.println(medicine);
        } else {
            System.out.println(medicineName + " Can't be Found\n");
        }
    }

    //Pharmacist class
    public void sellMedicine(String medicineName, int quantity, String pharmacist, int choice) {
        Medicine medicine = inventory.get(medicineName);
        if (medicine != null) {
            if (medicine.getRx()) {
                System.out.println("Prescription Required: " + medicineName + 
                "\n1 Rx Valid" +
                "\n2 Rx Invalid");
                //int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        RxReq(medicineName, quantity, pharmacist);
                        break;               
                    case 2:
                        System.out.println("No prescription provided cant be sold");
                        break;                  
                    default:
                        System.out.println("Invalid");
                        break;
                }
                
            } else {
                noRxReq(medicineName, quantity);
            }
        } else {
            System.out.println(medicineName + " Cant be Found\n");
        }       
    }

    //Just for the sellMedicine method
    private void sellDrug( String medicineName, int quantity, String pharmacist){
        Medicine medicine = inventory.get(medicineName);
        if (medicine.getQuantity() >= quantity) {
            medicine.setQuantity(medicine.getQuantity() - quantity);
            double Amount = medicine.getPrice() * quantity;
            System.out.println("Sold " + medicineName + "\tQty: " + quantity + "\tAmount: " + Amount + pharmacist);
        } else {
            System.out.println("Insufficient stock: " + medicineName);
        }       
    }

    private void buyMedicine(String medicineName, int quantity){
        Medicine medicine = inventory.get(medicineName);
        if (medicine.getQuantity() >= quantity) {
            medicine.setQuantity(medicine.getQuantity() - quantity);
            double Amount = medicine.getPrice() * quantity;
            System.out.println("Sold " + medicineName + "\tQty: " + quantity + "\tAmount: " + Amount);
        } else {
            System.out.println("Insufficient stock: " + medicineName);
        }
    }

    //Check the Medicine class for the prescription
    public boolean Prescription(String medicineName){
        Medicine medicine = inventory.get(medicineName);
        if (medicine.getRx()) {
            return true;
        }else{
            return false;
        }
    }

    //For the Customer class
    public void noRxReq(String medicineName, int quantity){
        if (!Prescription(medicineName)) {
            buyMedicine(medicineName, quantity);
        }
    }

    //Will not be used
    private void RxReq(String medicineName, int quantity, String pharmacist){
        if (Prescription(medicineName)) {
            sellDrug(medicineName, quantity, pharmacist);
        }
    }

    //To get the Comapny name of the medicine for the Company class for the edit and remove methods
    public Medicine getmedicineName(String medicineName) {
        return inventory.get(medicineName);
    }

}