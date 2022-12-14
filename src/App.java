import java.util.Scanner;
public class App {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isExist = true;
        while(isExist){
            System.out.println("PatikaStore Product Management Panel !");
            System.out.println();
            System.out.println("1-Notebook Transactions");
            System.out.println("2-Mobile Phone Transactions");
            System.out.println("3-List Brand");
            System.out.println("4-Brand add");
            System.out.println("5-Brand delete");
            System.out.println("0-Sign Out!");
            System.out.println();
            System.out.print("Your preference :");

            int select = input.nextInt();
    
            switch(select){
                case 1:
                    System.out.println();
                    System.out.println("Notebook Transactions");
                    Notebook notebook=new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Mobile Phone Transactions");
                    MobilePhone phone=new MobilePhone();
                    phone.menu();
                    break;
                case 3:
                    Brands.printBrands();
                    break;
                case 4:
                    Brands.addBrand();
                    System.out.println("Brand added.");
                    break;
                case 5:
                    Brands.deleteBrand();
                    System.out.println("Brand deleted.");
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
