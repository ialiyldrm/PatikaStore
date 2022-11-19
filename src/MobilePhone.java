import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone extends ProductGroup {
    private int battery;
    private String color;
    private static ArrayList<MobilePhone> phoneList = new ArrayList<>();
    Scanner scan=new Scanner(System.in);

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
        System.out.println("1-Telefon Listesini Görüntüle\n"+
                           "2-Yeni telefon ekle\n"+
                           "3-Telefon Sil\n"+
                           "4-Telefonları id'ye göre sırala\n"+
                           "5-Telefonları markalarına göre filtrele");
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
            default:
                System.out.println("There is no such an option. Please enter your choice again.");
                break;
        }
        
    }

    private void brandFilter() {
        getProduct();
        ArrayList<MobilePhone> filterMobilePhones=new ArrayList<>();
        System.out.print("Filtrelemek istediğiniz markasını giriniz:");
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
        System.out.println("Telefon id giriniz;");
        int id =scan.nextInt();
        System.out.println("Tefonun adını giriniz:");
        String name=scan.next();
        System.out.println("Telefonun fiyatını giriniz:");
        double price=scan.nextDouble();
        System.out.println("İndirim oranını giriniz:");
        int discountRate=scan.nextInt();
        System.out.println("Stok sayısını giriniz:");
        int stock=scan.nextInt();
        System.out.println("Ekran boyutu giriniz:");
        double screenSize = scan.nextDouble();
        System.out.println("Ram boyutunu giriniz:");
        int ram=scan.nextInt();
        System.out.println("Telefon hafıza boyutu giriniz:");
        int storage=scan.nextInt();
        System.out.println("Telefon batarya boyutu giriniz:");
        int battery=scan.nextInt();
        System.out.println("Telefon rengi giriniz:");
        String color=scan.next();

        Brands.printBrands();
        System.out.println("Marka id seçiniz:");
        Brands brand=Brands.getBrand(scan.nextInt());
        MobilePhone phone=new MobilePhone(id, name, price, discountRate, stock, screenSize, ram, storage, brand, battery, color);
        phoneList.add(phone);
        System.out.println("Eklenen telefon id:" + phone.getId());
    }

    public void print(ArrayList<MobilePhone> phones){
        if(phones==null) phones=phoneList;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           |");
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
        System.out.print("Silinmesini istediğiniz ürünün id'sini giriniz:");
        int id=scan.nextInt();
        phoneList.remove(id-1);
        System.out.println("Güncel liste");
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
