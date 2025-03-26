class Pharmacist extends Person{

    private Pharmacy pharmacy;

    public Pharmacist(String name, String password, int IDnumber, Pharmacy pharmacy) {
        super(name, IDnumber, password);
        this.pharmacy = pharmacy;
    }

    @Override
    public String toString() {
        return "Pharmacist: " + this.getName();
    }
}