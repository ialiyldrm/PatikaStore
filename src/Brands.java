import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Brands {
    private int brandID;
    private String brandName;
    private static Scanner input=new Scanner(System.in);
    private static TreeSet<Brands> brandList=new TreeSet<>(new Comparator<Brands>() {
        @Override
        public int compare(Brands o1, Brands o2) {
            return o1.getBrandName().compareTo(o2.getBrandName());
        }
    });

    public Brands(int brandID, String brandName) {
        this.brandID = brandID;
        this.brandName = brandName;
    }

    public static void addBrand(){
        System.out.print("Enter brand id:");
        int id=input.nextInt();
        System.out.print("Enter brand name:");
        String name=input.next();
        brandList.add(new Brands(id, name));    
    }

    public static void deleteBrand(){
        printBrands();
        System.out.print("Enter the id of the brand you want to delete:");
        int id=input.nextInt();
        for (Brands brand : brandList) {
            if(id==brand.getBrandID()){
                brandList.remove(brand);
                break;
            }           
        }
    }
    public static void createBrands(){
        brandList.add(new Brands(1,"Samsung"));
        brandList.add(new Brands(2,"Lenovo"));
        brandList.add(new Brands(3,"Apple"));
        brandList.add(new Brands(4,"Huawei"));
        brandList.add(new Brands(5,"Casper"));
        brandList.add(new Brands(6,"Asus"));
        brandList.add(new Brands(7,"HP"));
        brandList.add(new Brands(8,"Xiaomi"));
        brandList.add(new Brands(9,"Monster"));
    }
    public static void printBrands() {
        createBrands();
        System.out.println();
        System.out.println("Brand List");
        for (Brands brand : brandList) {
            System.out.println(brand.getBrandID()+"- " + brand.getBrandName());
        }
        System.out.println("----------------------------");
    }
    public static Brands getBrand(int id){
        Brands temp=null;
        for (Brands brand : brandList) {
            if(id==brand.getBrandID()){
                temp=brand;
            }
        }
        return temp;
    }

    public int getBrandID() {
        return brandID;
    }
    public void setBrandID(int brandID) {
        this.brandID = brandID;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}

    
