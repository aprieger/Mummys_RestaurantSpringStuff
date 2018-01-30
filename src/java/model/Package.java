package Model;

public class Package { 
    private int packageId;
    private String name;
    private String description; 
    private int mealCategory;
    private String imageSource;
    private double price;
    private int isSpecial;
    private int mealType;

    public Package() {
    }

    public Package(int packageId, String name, String description, int mealCategory, String imageSource, double price, int isSpecial, int mealType) {
        this.packageId = packageId;
        this.name = name;
        this.description = description;
        this.mealCategory = mealCategory;
        this.imageSource = imageSource;
        this.price = price;
        this.isSpecial = isSpecial;
        this.mealType = mealType;
    }
    
    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(int mealCategory) {
        this.mealCategory = mealCategory;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(int isSpecial) {
        this.isSpecial = isSpecial;
    }

    public int getMealType() {
        return mealType;
    }

    public void setMealType(int mealType) {
        this.mealType = mealType;
    }
}
