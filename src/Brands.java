import java.util.Comparator;
import java.util.TreeSet;

public class Brands {
    private int brandID;
    private String brandName;
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
        System.out.println("Brand List");
        for (Brands brand : brandList) {
            System.out.println("- " + brand.getBrandName());
        }
        System.out.println("----------------------------");
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

    