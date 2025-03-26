class Company extends Person{

    private int companyContact;
    
    public Company(String name, int IDnumber, String password, int companyContact) {
        super(name, IDnumber, password);
        this.companyContact = companyContact;
    }

    public void setCompanyContact(int companyContact) {
        this.companyContact = companyContact;
    }

    public int getCompanyContact() {
        return companyContact;
    }

    @Override
    public String toString() {
        return "Companies: " + this.getName() + "\tContact: " + companyContact;
    }

}