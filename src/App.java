import java.util.Scanner;
public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isExist = true;
        while(isExist){
            System.out.println("PatikaStore Product Management Panel !");

            System.out.println("1-Notebook Transactions");
            System.out.println("2-Mobile Phone Transactions");
            System.out.println("3-List Brand");
            System.out.println("0- Sign Out!");
            System.out.print("Your preference :");

            int select = input.nextInt();
    
            switch(select){
                case 1:
                    System.out.println("Notebook Transactions");
                    break;
                case 2:
                    System.out.println("Mobile Phone Transactions");
                    break;
                case 3:
                    Brands.createBrands();
                    Brands.printBrands();
                    break;
                case 0:
                    System.out.println("Exiting");
                    isExist=false;
                    break;
                default:
                    System.out.println();
                    System.out.println("There is no such an option. Please enter your choice again.");
                    System.out.println();
            }
        }       
    }
}
