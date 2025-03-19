import java.util.Scanner;

public class Main {
    static Pharmacy pharmacy = new Pharmacy();
    
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        Admin admin = new Admin("admin", "admin", 1, pharmacy);
        Scanner sc = new Scanner(System.in);

        pharmacy.addMedicine(new Medicine("Paracetamol", "GSK", 5.00, 100, false));
        pharmacy.addPharmacist(new Pharmacist("Jojo", "test", 9029, pharmacy));

    }
    
    //Not Tested
    public void AdminMenu(){

        boolean Running = true;
        while (Running) {
            System.out.println(
            "\n--[ Pharmacy Management System ]--\n" +
            "1. Company\n" +
            "2. Medicine/Request\n" +
            "3. Pharmacists\n" +
            "0. Exit"
            );
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
                        "0. Exit"
                        );
                        System.out.println();
                        int companyCase = sc.nextInt();
                        sc.nextLine();
                        switch (companyCase) {
                            case 1:
                                System.out.println("Company: ");
                                String CompanyName = sc.nextLine();
                                System.out.println("ID: ");
                                int ComapnyID = sc.nextInt();
                                System.out.println("Password: ");
                                String CompanyPass = sc.nextLine();
                                System.out.println("Contact: ");
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
                        int pharmacistCase = sc.nextInt();
                        sc.nextLine();
                        switch (pharmacistCase) {
                            case 1:
                                System.out.print("Add Pharmacist: ");
                                String pharmacistName = sc.nextLine();
                                String pharmacistPass = sc.nextLine();
                                int pharmacistIDnumber = sc.nextInt();
                                pharmacy.addPharmacist(new Pharmacist(pharmacistName, pharmacistPass, pharmacistIDnumber, pharmacy));
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
    public void PharmacistMenu(String pharmacistName){
        boolean Running = true;
        while (Running){
            System.out.println(
                "--[ Pharmacy Management System ]--\n" +
                "Pharmacist: " + pharmacistName + "\n" +
                "1. View Incentory\n" +
                "2. Search medicine\n" +
                "3. Sell medicine\n" +
                "0. Exit"
            );

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
                    System.out.print("Sell Drug: ");
                    String sellDrug = sc.nextLine();
                    System.out.print("Quantity: ");
                    int sellQuantity = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Rx Valid? \t 1 - Yes \t 2 - No");
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
    public void ComapnyMenu(String companyName){
        
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

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:               
                Object[] AddmedData = medInfo();
                String AddMedname = (String) AddmedData[0];
                double AddMedprice = (double) AddmedData[1];
                int AddMedquantity = (int) AddmedData[2];
                //refactor
                System.out.print("Rx (true/false): ");
                String RxString = sc.nextLine().toLowerCase();
                boolean Rx = RxString.toLowerCase().equals("true");

                pharmacy.requestAddMedicine(AddMedname, companyName, AddMedprice, AddMedquantity, Rx);
                sc.nextLine();
                break;

            case 2:
                Object[] EditmedData = medInfo();
                String EditMedname = (String) EditmedData[0];
                double EditMedprice = (double) EditmedData[1];
                int EditMedquantity = (int) EditmedData[2];

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

    public Object[] medInfo(){
        System.out.print("Drug Name: ");
        String name = sc.nextLine();
        
        System.out.print("Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        return new Object[]{name, price, quantity};
    }
}