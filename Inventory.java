import java.util.HashMap;

class Inventory {
    private HashMap<String, Medicine> inventory = new HashMap<>();

    public void addMedicine(Medicine medicine) {
        inventory.put(medicine.getName(), medicine);
    }

    public void editMedicine(String name, double price, int quantity) {
        Medicine medicine = inventory.get(name);
        if (medicine != null) {
            medicine.setPrice(price);
            medicine.setQuantity(quantity);
        } else {
            System.out.println(name + " Cant be Found\n");
        }
    }

    public void removeMedicine(String name) {
        if (inventory.containsKey(name)) {
            inventory.remove(name);
        } else {
            System.out.println(name + " Cant be Found\n");
        }
    }

    public void viewInventory() {
        //System.out.println("Inventory: " + "\n" + inventory.values() + "\n");
        System.out.println("Inventory:");
        for (Medicine medicine : inventory.values()) {
            System.out.println("--[ Drug: " + medicine.getName() + 
                               " Manufacturer: " + medicine.getCompany() + 
                               " Price: " + medicine.getPrice() + 
                               " Quantity: " + medicine.getQuantity() + " ]--");
        }
    }

    public void viewMedicine(String name) {
        Medicine medicine = inventory.get(name);
        if (medicine != null) {
            System.out.println(medicine);
        } else {
            System.out.println(name + " Cant be Found\n");
        }
    }

    public void sellMedicine(String name, int quantity, String pharmacist) {
        Medicine medicine = inventory.get(name);
        if (medicine != null) {
            if (medicine.getQuantity() >= quantity) {
                medicine.setQuantity(medicine.getQuantity() - quantity);
                double Amount = medicine.getPrice() * quantity;
                System.out.println("Sold " + name + "\tQty: " + quantity + "\tAmount: " + Amount + pharmacist);
            } else {
                System.out.println("Insufficient " + name);
            }
        } else {
            System.out.println(name + " Cant be Found\n");
        }
    }
}