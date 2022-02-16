import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("0. Quit");
            System.out.println("1. Create Employee");
            System.out.print(": ");
            
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                createEmployee();
            }
        }
    }

    public static void createEmployee() {
        System.out.println("0. Return to main menu");
        System.out.println("1. Set salary (monthly format)");
        System.out.println("2. Set salary (yearly format)");
        System.out.println("3. Set age");
        System.out.println("4. Preview Payday Statement");
        System.out.println("5. Retirement Help");
        System.out.print(": ");

        int choice = scanner.nextInt();
        
        if(choice == 0) {
            break;
        }

        switch (choice) {
            case 1:
                System.out.print("New monthly salary: ");
                
                break;
        
            default:
                break;
        }
    }
}
