import java.util.List;

class Person{
    
    protected String name;
    protected String password;
    private int IDnumber;

    public Person(String name, int IDnumber, String password) {
        this.name = name;
        this.IDnumber = IDnumber;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIDnumebr(int IDnumber) {
        this.IDnumber = IDnumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getIDnumber() {
        return IDnumber;
    }

    public String getPassword() {
        return password;
    }

    //Checks if the name and password matches
    public boolean login(String name, String password) {
        return this.name.equals(name) && this.password.equals(password);
    }

    //checks Credentials '?' is for the class or lists later, the persons are the classes
    public static Person checkCredentials(List<? extends Person> persons, String name, String password) {
        for (Person person : persons) {
            if (person.login(name, password)) {
                return person;
            }
        }
        return null;
    }
    
}