class Pharmacist extends Person{

    public Pharmacist(String name, String password, int IDnumber) {
        super(name, IDnumber, password);
    }

    @Override
    public String toString() {
        return "Pharmacist: " + this.getName();
    }
}