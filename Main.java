import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;
        
        do {
            System.out.println("===========");
            System.out.println("ATM MACHINE");
            System.out.println("===========");
            System.out.println("1. Add A New Customer");
            System.out.println("2. Open A New Account For A Customer");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Savings");
            System.out.println("6. Customer Lists");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    do {
                        System.out.println("\nAdd A New Customer");
                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine().trim();
                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine().trim();

                        if (firstName.isEmpty() || lastName.isEmpty()) {
                            System.out.println("Name Must Not Be Empty");
                            break;
                        }

                        System.out.println("Are you sure the name is: " + firstName + " " + lastName + "?");
                        System.out.print("Enter Y/N: ");
                        String confirm = scanner.nextLine().trim();

                        if (confirm.equalsIgnoreCase("Y")) {
                            bank.addCustomer(firstName, lastName);
                            System.out.println("Customer Added.");
                            break;  
                        } else if (confirm.equalsIgnoreCase("N")) {
                            System.out.println("Please enter the name again.");
                        } else {
                            System.out.println("Invalid Choice.");
                            break;
                        }
                    } while (true);
                    break;

                case 2:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("\nNo customers found.");
                        break;
                    }
                    System.out.println("\nOpen A New Account");

                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer customerC2 = bank.getCustomer(i);

                        System.out.println((i + 1) + ". " + customerC2.getFirstName() + " " + customerC2.getLastName());
                    }

                    System.out.print("Select Customer: ");
                    int customerIndexC2 = scanner.nextInt();
                    scanner.nextLine();

                    customerIndexC2--;

                    if (customerIndexC2 < 0 || customerIndexC2 >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid Customer.");
                        break;
                    }

                    Customer customer = bank.getCustomer(customerIndexC2);

                    if (customer.getNumOfAccounts() >= 5) {
                        System.out.println("This customer already has 5 accounts.");
                        break;
                    }

                    Account account = new Account();
                    customer.setAccount(account);

                    System.out.println("Account opened for " + customer.getFirstName() + " " + customer.getLastName());
                    break;
                    
                case 3:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("\nNo customers found.");
                        break;
                    }

                    System.out.println("\nDeposit into: ");
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer customerC3 = bank.getCustomer(i);

                        System.out.println((i + 1) + ". " + customerC3.getFirstName() + " " + customerC3.getLastName());
                    }
                    System.out.print("Select Customer: ");
                    int customerIndexC3 = scanner.nextInt();
                    scanner.nextLine();

                    customerIndexC3--;

                    if (customerIndexC3 < 0 || customerIndexC3 >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid Customer.");
                        break;
                    }

                    Customer customerC3 = bank.getCustomer(customerIndexC3);
                    if (customerC3.getNumOfAccounts() == 0) {
                        System.out.println("This customer has no accounts.");
                        break;
                    }

                    System.out.println("\nSelect Account:");

                    for (int i = 0; i < customerC3.getNumOfAccounts(); i++) {
                        System.out.println("Account " + (i + 1));
                    }

                    System.out.print("Select Account: ");
                    int accountIndexC3 = scanner.nextInt();
                    scanner.nextLine();

                    accountIndexC3--;

                    if (accountIndexC3 < 0 || accountIndexC3 >= customerC3.getNumOfAccounts()) {
                        System.out.println("Invalid Account.");
                        break;
                    }

                    Account accountC3 = customerC3.getAccount(accountIndexC3);

                    System.out.print("Enter Amount to Deposit: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    accountC3.deposit(amount);
                    break;

                case 4:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("\nNo customers found.");
                        break;
                    }

                    System.out.println("\nWithdraw From: ");
                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer customerC4 = bank.getCustomer(i);

                        System.out.println((i + 1) + ". " + customerC4.getFirstName() + " " + customerC4.getLastName());
                    }
                    System.out.print("Select Customer: ");
                    int customerIndexC4 = scanner.nextInt();
                    scanner.nextLine();

                    customerIndexC4--;

                    if (customerIndexC4 < 0 || customerIndexC4 >= bank.getNumOfCustomers()) {
                        System.out.println("Invalid Customer.");
                        break;
                    }

                    Customer customerC4 = bank.getCustomer(customerIndexC4);
                    if (customerC4.getNumOfAccounts() == 0) {
                        System.out.println("This customer has no accounts.");
                        break;
                    }

                    System.out.println("\nSelect Account:");

                    for (int i = 0; i < customerC4.getNumOfAccounts(); i++) {
                        System.out.println("Account " + (i + 1));
                    }

                    System.out.print("Select Account: ");
                    int accountIndexC4 = scanner.nextInt();
                    scanner.nextLine();

                    accountIndexC4--;

                    if (accountIndexC4 < 0 || accountIndexC4 >= customerC4.getNumOfAccounts()) {
                        System.out.println("Invalid Account.");
                        break;
                    }

                    Account accountC4 = customerC4.getAccount(accountIndexC4);

                    System.out.print("Enter Amount to Withdraw: ");
                    double amountC4 = scanner.nextDouble();
                    scanner.nextLine();

                    accountC4.withdraw(amountC4);
                    break;

                case 5:
                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("\nNo customers found.");
                        break;
                    }
                    
                    System.out.println("\nCheck Savings: ");

                        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                            Customer customerC5 = bank.getCustomer(i);

                            System.out.println(
                                (i + 1) + ". " + customerC5.getFirstName() + " " + customerC5.getLastName());
                        }

                        System.out.print("Select Customer: ");
                        int customerIndexC5 = scanner.nextInt();
                        scanner.nextLine();

                        customerIndexC5--;

                        if (customerIndexC5 < 0 || customerIndexC5 >= bank.getNumOfCustomers()) {
                            System.out.println("Invalid Customer.");
                            break;
                        }

                        Customer customerC5 = bank.getCustomer(customerIndexC5);

                        if (customerC5.getNumOfAccounts() == 0) {
                            System.out.println("This customer has no accounts.");
                            break;
                        }

                        System.out.println("\nSelect Account:");

                        for (int i = 0; i < customerC5.getNumOfAccounts(); i++) {
                            System.out.println("Account " + (i + 1));
                        }

                        System.out.print("Select Account: ");
                        int accountIndexC5 = scanner.nextInt();
                        scanner.nextLine();

                        accountIndexC5--;

                        if (accountIndexC5 < 0 || accountIndexC5 >= customerC5.getNumOfAccounts()) {
                            System.out.println("Invalid Account.");
                            break;
                        }

                        Account accountC5 = customerC5.getAccount(accountIndexC5);

                        System.out.println("Current Balance: " + accountC5.getBalance());
                        break;

                case 6:
                    System.out.println("\nCustomer Lists");

                    if (bank.getNumOfCustomers() == 0) {
                        System.out.println("No customers found.");
                        break;
                    }

                    for (int i = 0; i < bank.getNumOfCustomers(); i++) {
                        Customer customerC6 = bank.getCustomer(i);

                        System.out.println((i + 1) + ". " + customerC6.getFirstName() + " " + customerC6.getLastName());
                    }
                    break;

                case 0:
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Invalid Value.");
                }
        } while (choice != 0);
    }
}