import java.util.ArrayList;
import java.util.List;

class Pharmacy {
    private Inventory inventory = new Inventory();
    private List<Pharmacist> pharmacists = new ArrayList<>();

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

    public void sellMedicine(String name, int quantity) {
        inventory.sellMedicine(name, quantity, pharmacists.get(0).toString());
    }

    public void addPharmacist(Pharmacist pharmacist) {
        pharmacists.add(pharmacist);
    }

    public void removePharmacist(Pharmacist pharmacist) {
        pharmacists.remove(pharmacist);
    }

    public List<Pharmacist> getPharmacists() {
        return pharmacists;
    }
}