import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Pharmacy pharmacy = new Pharmacy();
        Admin admin = new Admin("admin", "admin", 1, pharmacy);
        Scanner sc = new Scanner(System.in);

        admin.addMedicine("Paracetamol", "GSK", 5.00, 100, false);
        admin.addPharmacist(new Pharmacist("Jojo", "test", 9029, pharmacy));
        
        while (true) {
        System.out.println("\n--[ Pharmacy Management System ]--\n" +
        "Role \t1 \n\t2 \n\t3");
        System.out.print("Action: ");
        int role = sc.nextInt();
        sc.nextLine();

        switch (role) {
            case 1:
            System.out.print("Enter username: ");
            String user = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
    
            if (admin.login(user, password)) {
                boolean programRun = true;
                while (programRun) {
                    System.out.println(
                        "\n--[ Pharmacy Management System ]--\n" +
                        "1. Add medicine\n" +
                        "2. Edit medicine\n" +
                        "3. Remove medicine\n" +
                        "4. View inventory\n" +
                        "5. Add pharmacist\n" +
                        "6. Remove pharmacist\n" +
                        "7. View pharmacists\n" +
                        "8. Exit"
                    );
                    System.out.print("Action: ");
                    int choice = sc.nextInt();
                    sc.nextLine();
    
                    switch (choice) {
                        case 1:
                            System.out.print("Drug Name: ");
                            String name = sc.nextLine();
                            System.out.print("Manufacturer: ");
                            String company = sc.nextLine();
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
                            System.out.print("Quantity: ");
                            int quantity = sc.nextInt();

                            //refactor
                            System.out.print("Rx (true/false): ");
                            String RxString = sc.nextLine().toLowerCase();
                            boolean Rx = RxString.toLowerCase().equals("true");

                            sc.nextLine();
                            admin.addMedicine(name, company, price, quantity, Rx);
                            sc.nextLine();
                            admin.viewInventory();
                            break;
                        case 2:
                            System.out.print("Drug to Edit: ");
                            String editDrug = sc.nextLine();
                            System.out.print("Price: ");
                            double editPrice = sc.nextDouble();
                            System.out.print("Quantity: ");
                            int editQuantity = sc.nextInt();
                            sc.nextLine();
                            admin.editMedicine(editDrug, editPrice, editQuantity);
                            break;
                        case 3:
                            System.out.print("Remove Drug: ");
                            String removeDrug = sc.nextLine();
                            admin.removeMedicine(removeDrug);
                            break;
                        case 4:
                            admin.viewInventory();
                            break;
                        case 5:
                            System.out.print("Add Pharmacist: ");
                            String pharmacistName = sc.nextLine();
                            String pharmacistPass = sc.nextLine();
                            int pharmacistIDnumber = sc.nextInt();
                            admin.addPharmacist(new Pharmacist(pharmacistName, pharmacistPass, pharmacistIDnumber, pharmacy));
                            break;
                        case 6:
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
                                admin.removePharmacist(pharmacistToRemove);
                            } else {
                                System.out.println("Not found");
                            }
                            break;
                        case 7:
                            admin.viewPharmacists();
                            break;
                        case 8:
                            programRun = false;
                            break;
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                }
            } else {
                System.out.println("--!--[ Invalid ]--!--\n" + "Restarting Program");
            }
                break;
            case 2:
            System.out.print("Enter your name: ");
            String pharmacistName = sc.nextLine();
            String pharmacistPass = sc.nextLine();
            int pharmacistIDnumber = sc.nextInt();

            Pharmacist pharmacist = new Pharmacist(pharmacistName, pharmacistPass, pharmacistIDnumber, pharmacy);
            boolean pharmacistRunning = true;
            while (pharmacistRunning) {
                System.out.println(
                    "--[ Pharmacy Management System ]--\n" +
                    "Pharmacist: " + pharmacistName + "\n" +
                    "0. View Incentory\n" +
                    "1. Search medicine\n" +
                    "2. Sell medicine\n" +
                    "3. Exit"
                );
                System.out.print("Action: ");
                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 0:
                        pharmacist.viewInventory();
                        break;
                    case 1:
                        System.out.print("Search Drug: ");
                        String searchDrug = sc.nextLine();
                        pharmacist.searchMedicine(searchDrug);
                        break;
                    case 2:
                        System.out.print("Sell Drug: ");
                        String sellDrug = sc.nextLine();
                        System.out.print("Quantity: ");
                        int sellQuantity = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.print("Rx Valid? \t 1 - Yes \t 2 - No");
                        int RxReqChoice = sc.nextInt();
                        pharmacist.sellMedicine(sellDrug, sellQuantity, RxReqChoice);
                        break;
                    case 3:
                        pharmacistRunning = false;
                        System.out.println("\n-------------------------");
                        break;
                    default:
                        System.out.println("Invalid");
                        break;
                }
            }
            break;

            case 3:
            System.out.println("Closing Program");
            sc.close();
            System.exit(0);
            break;
        default:
            System.out.println("Invalid");
            break;
        }
        }
    }
}