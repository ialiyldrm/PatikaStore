import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends ProductGroup {
    private Scanner scan=new Scanner(System.in);
    private static ArrayList<Notebook> notebookList = new ArrayList<>();

    public Notebook(){
        
    }
    public Notebook(int id, String name, double price, int discountRate, int stock, double screenSize, int ram,
            int storage, Brands brand) {
        super(id, name, price, discountRate, stock, screenSize, ram, storage, brand);      
    }

    @Override
    public void menu() {
        System.out.println("1-View Notebook List\n"+
                           "2-Add new Notebook\n"+
                           "3-Notebook Delete\n"+
                           "4-Sort notebooks by id\n"+
                           "5-Filter notebooks by brands\n"+
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
        ArrayList<Notebook> filterNotebooks=new ArrayList<>();
        System.out.print("Enter the name of the brand you want to filter:");
        String filterBrand=scan.next();
        for(Notebook notebook:notebookList){
            if(filterBrand.equals(notebook.getBrand().getBrandName())){
                filterNotebooks.add(notebook);
            }
        }
        print(filterNotebooks);

    }

    @Override
    public void addItem() {
        System.out.println("Enter the notebook id;");
        int id =scan.nextInt();
        System.out.println("Enter the notebook name:");
        String name=scan.next();
        System.out.println("Enter the price of the notebook:");
        double price=scan.nextDouble();
        System.out.println("Enter the discount rate:");
        int discountRate=scan.nextInt();
        System.out.println("Enter the number of stocks:");
        int stock=scan.nextInt();
        System.out.println("Enter screen size:");
        double screenSize = scan.nextDouble();
        System.out.println("Enter ram size:");
        int ram=scan.nextInt();
        System.out.println("Enter notebook memory size:");
        int storage=scan.nextInt();
        

        Brands.printBrands();
        System.out.println("Please choose brand id:");
        Brands brand=Brands.getBrand(scan.nextInt());
        Notebook notebook=new Notebook(id, name, price, discountRate, stock, screenSize, ram, storage, brand);
        notebookList.add(notebook);
        System.out.println("Added Notebook:" + notebook.getId() + "-" + notebook.getName());       
    }

    public void print(ArrayList<Notebook> notebook){
        if(notebook==null) notebook=notebookList;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Product Name                  | Price          | Brand         | Stock        | Discount Rate      | RAM    | Screen Size      | Memory   |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook n:notebook){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getBrand().getBrandName(),n.getStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getStorage());
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
        notebookList.remove(id-1);
        System.out.println("Current list");
        getProduct();       
        
    }
    
}
