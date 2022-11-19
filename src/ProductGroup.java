public abstract class ProductGroup {
    private int id;
    private String name;
    private double price;
    private int discountRate;
    private int stock;
    private double screenSize;
    private int ram;
    private int storage;
    private Brands brand;

    public ProductGroup(int id, String name, double price, int discountRate, int stock, double screenSize, int ram,
            int storage, Brands brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discountRate = discountRate;
        this.stock = stock;
        this.screenSize = screenSize;
        this.ram = ram;
        this.storage = storage;
        this.brand = brand;
    }
    
    public abstract void menu();
    public abstract void addItem();
    public abstract void getProduct();
    public abstract void deleteItem();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public Brands getBrand() {
        return brand;
    }

    public void setBrand(Brands brand) {
        this.brand = brand;
    }  
}
