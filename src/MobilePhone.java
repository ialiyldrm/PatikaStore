import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends ProductGroup {
    private int battery;
    private String color;
    private static ArrayList<MobilePhone> phoneList = new ArrayList<>();
    private Scanner scan=new Scanner(System.in);

    public MobilePhone(){

    }
    public MobilePhone(int id, String name, double price, int discountRate, int stock, double screenSize, int ram,
            int storage, Brands brand,int battery,String color) {
        super(id, name, price, discountRate, stock, screenSize, ram, storage, brand);
        this.battery=battery;
        this.color=color;
               
    }

    @Override
    public void menu() {
        System.out.println("1-View Phone List\n"+
                           "2-Add new phone\n"+
                           "3-Delete Phone\n"+
                           "4-Sort phones by id\n"+
                           "5-Filter phones by brands\n"+
                           "0-Back to the panel!");
        System.out.println();
        System.out.print("Your select:");
        int select= scan.nextInt();
        switch(select){
            case 1:
                getProduct();
                break;
            case 2:
                addItem();
                break;
            case 3:
                deleteItem();
                break;
            case 4:
                getProduct();
                break;
            case 5:
                brandFilter();
                break;
            case 0:
                break;
            default:
                System.out.println("There is no such an option. Please enter your choice again.");
                break;
        }
        
    }

    private void brandFilter() {
        getProduct();
        ArrayList<MobilePhone> filterMobilePhones=new ArrayList<>();
        System.out.print("Enter the brand you want to filter:");
        String filterBrand=scan.next();
        for(MobilePhone phone:phoneList){
            if(filterBrand.equals(phone.getBrand().getBrandName())){
                filterMobilePhones.add(phone);
            }
        }
        print(filterMobilePhones);

    }

    @Override
    public void addItem() {
        System.out.println("Enter the phone id;");
        int id =scan.nextInt();
        System.out.println("Enter the name of the phone:");
        String name=scan.next();
        System.out.println("Enter the price of the phone:");
        double price=scan.nextDouble();
        System.out.println("Enter the discount rate:");
        int discountRate=scan.nextInt();
        System.out.println("Enter the number of stocks:");
        int stock=scan.nextInt();
        System.out.println("Enter screen size:");
        double screenSize = scan.nextDouble();
        System.out.println("Enter ram size:");
        int ram=scan.nextInt();
        System.out.println("Enter phone memory size:");
        int storage=scan.nextInt();
        System.out.println("Enter phone battery size:");
        int battery=scan.nextInt();
        System.out.println("Enter phone color:");
        String color=scan.next();

        Brands.printBrands();
        System.out.println("Please choose brand id:");
        Brands brand=Brands.getBrand(scan.nextInt());
        MobilePhone phone=new MobilePhone(id, name, price, discountRate, stock, screenSize, ram, storage, brand, battery, color);
        phoneList.add(phone);
        System.out.println("Added Phone" + phone.getId() + "-"+ phone.getName());
    }

    public void print(ArrayList<MobilePhone> phones){
        if(phones==null) phones=phoneList;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                  | Price          | Brand         | Stock        | Discount Rate      | RAM    | Screen Size      | Memory   | Battery Capacity  | Color           |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (MobilePhone n:phones){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getBrandName(),n.getStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getStorage(),n.getBattery(),n.getColor());
        }
    }

    @Override
    public void getProduct() {
        print(null);
        
    }

    @Override
    public void deleteItem() {
        getProduct();
        System.out.print("Enter the id of the product you want to be deleted:");
        int id=scan.nextInt();
        phoneList.remove(id-1);
        System.out.println("Current list");
        getProduct();
        
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
