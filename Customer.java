class Customer extends Person{

    private int contactNumber;

    public Customer(String name, String password, int IDnumber, int contactNumber){
        super(name, IDnumber, password);
        this.contactNumber = contactNumber;
    }

    public int getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(int contactNumber){
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString(){
        return "Customer: " + this.getName() + "\tContact: " + contactNumber;
    }
}