import java.util.Scanner;

public class Main {
    static Pharmacy pharmacy = new Pharmacy();
    
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //test datas
        pharmacy.addMedicine(new Medicine("Paracetamol", "GSK", 5.00, 100, false));
        pharmacy.addPharmacist(new Pharmacist("Jojo", "test", 9029));
        pharmacy.addCompany(new Company("GSK", 1234, "test", 1234567890));
        pharmacy.addCustomer(new Customer("Name", "passw", 1, 9609));        

        boolean Running = true;
        while (Running) {
            System.out.println(
            "--[ Pharmacy Management System ]--\n" +
            "1. Admin\n" +
            "2. Pharmacist\n" +
            "3. Company\n" +
            "4. Customer\n" +
            "0. Exit"
            );

            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String adminName = sc.nextLine();
                    System.out.print("Password: ");
                    String adminPass = sc.nextLine();            
                    if (pharmacy.login(adminName, adminPass)) {
                        AdminMenu();
                    } else {
                        System.out.println("Invalid credentials");
                        sc.nextLine();
                    }
                    break;
    
                case 2:
                    System.out.print("Name: ");
                    String pharmacistName = sc.nextLine();
                    System.out.print("Password: ");
                    String pharmacistPass = sc.nextLine();
                    Pharmacist pharmacist = pharmacy.pharmacistCred(pharmacistName, pharmacistPass);
                    if (pharmacist != null) {
                        PharmacistMenu(pharmacistName);
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;
    
                case 3:
                    System.out.print("Name: ");
                    String companyName = sc.nextLine();
                    System.out.print("Password: ");
                    String companyPass = sc.nextLine();
                    Company company = pharmacy.companyCreds(companyName, companyPass);
                    if (company != null) {
                        ComapnyMenu(companyName);
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;
    
                case 4:
                    CustomerMenu();
                    break;

                case 0:
                    Running = false;
                    break;
            
                default:
                    System.out.println("Invalid");
                    break;
            }                
        }            
    }
    
    //Not Tested, admin not availabvale
    public static void AdminMenu(){
        boolean Running = true;
        while (Running) {
            System.out.println(
            "\n--[ Pharmacy Management System ]--\n" +
            "1. Company\n" +
            "2. Medicine/Request\n" +
            "3. Pharmacists\n" +
            "0. Exit"
            );

            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1: /* Main Case 1 START */
                    
                    boolean companyRun = true;
                    while (companyRun){
                        System.out.println(
                        "\n--[ Pharmacy Management System ]--\n" +
                        "1. Add Company\n" +
                        "2. Remove Company\n" +
                        "3. Edit Company\n" + /* Not Implemented */
                        "4. View Companies\n" +
                        "0. Exit"
                        );

                        System.out.print("Select: ");
                        int companyCase = sc.nextInt();
                        sc.nextLine();

                        switch (companyCase) {
                            case 1:
                                System.out.print("Company: ");
                                String CompanyName = sc.nextLine();
                                System.out.print("ID: ");
                                int ComapnyID = sc.nextInt();
                                System.out.print("Password: ");
                                String CompanyPass = sc.nextLine();
                                System.out.print("Contact: ");
                                int CompanyContact = sc.nextInt();
        
                                pharmacy.addCompany(new Company(CompanyName, ComapnyID, CompanyPass, CompanyContact));
                                break;
            
                            case 2:
                                System.out.print("Remove Company: ");
                                String removeCompany = sc.nextLine();
                                Company companyDelete = null;
                                for (Company company : pharmacy.getCompany()) {
                                    if (company.toString().equals("Company: " + removeCompany)) {
                                        companyDelete = company;
                                        break;
                                    }
                                }
                                if (companyDelete != null) {
                                pharmacy.removeCompany(companyDelete);
                                } else {
                                    System.out.println("Not found");
                                }
                                break;
                            
                            case 3:
                                System.out.print("Edit Company: ");
                                String editCompany = sc.nextLine();
                                Company companyEdit = null;
                                for (Company company : pharmacy.getCompany()) {
                                    if (company.toString().equals("Company: " + editCompany)) {
                                        companyEdit = company;
                                        break;
                                    }
                                }
                                if (companyEdit != null) {
                                    System.out.print("Edit Contact: ");
                                    int editContact = sc.nextInt();
                                    companyEdit.setCompanyContact(editContact);
                                } else {
                                    System.out.println("Not found");
                                }
                                break;
                            

                            case 4:
                                pharmacy.ListCompanies();
                                break;
        
                            case 0:
                                companyRun = false;
                                break;
                        
                            default:
                                break;

                        }
                    
                    
                    }
                    break;
                    //Main case 1 END

                case 2:
                    
                    boolean medicineRun = true;
                    while (medicineRun){
                        System.out.println(
                        "\n--[ Pharmacy Management System ]--\n" +
                        "1. View Rewuest\n" +
                        "2. Process Request\n" +
                        "3. Remove Medicine\n" + 
                        "4. View Inventory\n" +
                        "0. Exit"
                        );

                        System.out.print("Select: ");
                        int medicineCase = sc.nextInt();
                        sc.nextLine();
                        switch (medicineCase) {
                            case 1:
                                pharmacy.getRequests();
                                break;
                            case 2:
                                System.out.print("Process Request: ");
                                String requestName = sc.nextLine();
                                pharmacy.proccessRequest(requestName);
                                pharmacy.getRequests();
                                break;
                            case 3:
                                System.out.print("Remove Drug: ");
                                String removeDrug = sc.nextLine();
                                pharmacy.removeMedicine(removeDrug);
                                break;
                            case 4:
                                pharmacy.viewInventory();
                                break;
                            case 0:
                                medicineRun = false;
                                break;
                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }

                    break;
                    //Main case 2 END

                case 3:

                    boolean pharmacistRun = true;
                    while (pharmacistRun){
                        System.out.println(
                        "\n--[ Pharmacy Management System ]--\n" +
                        "1. Add Pharmacist\n" +
                        "2. Remove Pharmacist\n" +
                        "3. View Pharmacists\n" +
                        "0. Exit"
                        );

                        System.out.print("Select: ");
                        int pharmacistCase = sc.nextInt();
                        sc.nextLine();
                        switch (pharmacistCase) {
                            case 1:
                                System.out.print("Add Pharmacist: ");
                                String pharmacistName = sc.nextLine();
                                String pharmacistPass = sc.nextLine();
                                int pharmacistIDnumber = sc.nextInt();
                                pharmacy.addPharmacist(new Pharmacist(pharmacistName, pharmacistPass, pharmacistIDnumber));
                                break;
                            case 2:
                                System.out.print("Remove Pharmacist: ");
                                String removePharmacistName = sc.nextLine();
                                Pharmacist pharmacistToRemove = null;
                                for (Pharmacist pharmacist : pharmacy.getPharmacists()) {
                                    if (pharmacist.toString().equals("Pharmacist: " + removePharmacistName)) {
                                        pharmacistToRemove = pharmacist;
                                        break;
                                    }
                                }
                                if (pharmacistToRemove != null) {
                                    pharmacy.removePharmacist(pharmacistToRemove);
                                } else {
                                    System.out.println("Not found");
                                }
                                break;
                            case 3:
                                pharmacy.getPharmacists();
                                break;
                            case 0:
                                pharmacistRun = false;
                                break;
                            default:
                                System.out.println("Invalid");
                                break;
                        }
                    }
                    break;
                    //Main case 3 END

                case 0:
                    Running = false;
                    break;
                    //Main case 0 END

                default:
                    System.err.println("Invalid");
                    break;
            }
        }
    }

    //Not FInal
    public static void PharmacistMenu(String pharmacistName){
        boolean Running = true;
        while (Running){
            System.out.println(
                "\n--[ Pharmacy Management System ]--\n" +
                "Pharmacist: " + pharmacistName + "\n" +
                "1. View Incentory\n" +
                "2. Search medicine\n" +
                "3. Sell medicine\n" +
                "0. Exit"
            );

            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    pharmacy.viewInventory();
                    break;
                case 2:
                    System.out.print("Search Drug: ");
                    String searchDrug = sc.nextLine();
                    pharmacy.searchMedicine(searchDrug);
                    break;
                case 3:
                    pharmacy.viewInventory();
                    System.out.print("Sell Drug: ");
                    String sellDrug = sc.nextLine();
                    System.out.print("Quantity: ");
                    int sellQuantity = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("\t 1 - Yes \t 2 - No \nRx Valid? ");
                    int RxReqChoice = sc.nextInt();
                    pharmacy.sellMedicine(sellDrug, sellQuantity, RxReqChoice);
                    break;
                case 0:
                    Running = false;
                    break;                   
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }

    //Not Tested Pray that it works
    public static void ComapnyMenu(String companyName){
        
        boolean Running = true;
        while (Running)
        System.out.println(
            "\n--[ Pharmacy Management System ]--\n" +
            "1. Add Medicine\n" +
            "2. Edit Medicine\n" +
            "3. Remove medicine\n" +
            "4. View inventory\n" +
            "0. Exit"
        );

        System.out.print("Select: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:               
                System.out.print("Add Medicine");
                String AddMedname = sc.nextLine();

                System.out.print("Price: ");
                int AddMedprice = sc.nextInt();

                System.out.print("Quantity: ");
                int AddMedquantity = sc.nextInt();
                
                System.out.print("Rx (true/false): ");
                String RxString = sc.nextLine().toLowerCase();
                boolean Rx = RxString.toLowerCase().equals("true");

                pharmacy.requestAddMedicine(AddMedname, companyName, AddMedprice, AddMedquantity, Rx);
                sc.nextLine();
                break;

            case 2:
                System.out.print("Add Medicine");
                String EditMedname = sc.nextLine();

                System.out.print("Price: ");
                int EditMedprice = sc.nextInt();

                System.out.print("Quantity: ");
                int EditMedquantity = sc.nextInt();

                pharmacy.requestEditMedicine(EditMedname, companyName, EditMedprice, EditMedquantity);
                break;

            case 3:
                System.out.print("Remove Drug: ");
                String removeDrug = sc.nextLine();

                pharmacy.requestRemoveMedicine(removeDrug, companyName);
                break;

            case 4:
                pharmacy.viewInventory();
                break;

            case 0:
                Running = false;
                break;
            default:
                System.out.println("Invalid");
                break;
        }
    }

    //Spray and Pray || LogInSign
    public static void CustomerMenu(){

        System.out.println(
            "\n--[ LogIn || SignUp ]--\n" +
            "1. Log In\n" +
            "2. Sign Up\n" +
            "0. Exit\n"
        );

        System.out.print("Select: ");
        int LoginSignup = sc.nextInt();
        sc.nextLine();
        boolean Running = true;
        while(Running){
            switch (LoginSignup) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    Customer customer = pharmacy.customerCred(name, password);
                    if (customer != null) {
                        CustomerPage(name, password);
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;
                case 2:
                    System.out.print("Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Password: ");
                    String newPassword = sc.nextLine();
                    System.out.print("ID: ");
                    int newID = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Contact: ");
                    int newContact = sc.nextInt();
                    sc.nextLine();
                    pharmacy.addCustomer(new Customer(newName, newPassword, newID, newContact));
                    break;
                case 0:
                    Running = false;
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }      
    }

    //After Customer Log In
    public static void CustomerPage(String customerName, String customerPassword){
        boolean Running = true;
        while (Running){
            System.out.println(
                "--[ Customer Page ]--\n" +
                "1. View Incentory\n" +
                "2. Search medicine\n" +
                "3. Buy medicine\n" +
                "0. Exit"
            );

            System.out.print("Select: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    pharmacy.viewInventory();
                    break;
                case 2:
                    System.out.print("Search Drug: ");
                    String searchDrug = sc.nextLine();
                    pharmacy.searchMedicine(searchDrug);
                    break;
                case 3:
                    System.out.print("Buy Drug: ");
                    String buyDrug = sc.nextLine();
                    System.out.print("Quantity: ");
                    int buyQuantity = sc.nextInt();
                    sc.nextLine();

                    pharmacy.buyMedicine(buyDrug, buyQuantity);
                    break;
                case 4:
                    pharmacy.removeCustomer(pharmacy.customerCred(customerName, customerPassword));
                    Running = false;
                    break;
                case 0:
                    Running = false;
                    break;                   
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
}