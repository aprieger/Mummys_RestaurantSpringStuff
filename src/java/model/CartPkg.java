package model;

public class CartPkg { 
    private int oPkgOrderId;
    private int oOrderId;
    private int oPackageId;
    private int oCustomerId;
    private double oPricePerPkg;
    private int oQuantity;
    private int oIsOpen;
    
    private int pPackageId;
    private String pName;
    private String pDescription; 
    private int pMealCategory;
    private String pImageSource;
    private double pPrice;
    private int pIsSpecial;
    private int pMealType;

    public CartPkg() {
    }

    public CartPkg(int oPkgOrderId, int oOrderId, int oPackageId, int oCustomerId, double oPricePerPkg, int oQuantity, int oIsOpen, int pPackageId, String pName, String pDescription, int pMealCategory, String pImageSource, double price, int pIsSpecial, int pMealType) {
        this.oPkgOrderId = oPkgOrderId;
        this.oOrderId = oOrderId;
        this.oPackageId = oPackageId;
        this.oCustomerId = oCustomerId;
        this.oPricePerPkg = oPricePerPkg;
        this.oQuantity = oQuantity;
        this.oIsOpen = oIsOpen;
        this.pPackageId = pPackageId;
        this.pName = pName;
        this.pDescription = pDescription;
        this.pMealCategory = pMealCategory;
        this.pImageSource = pImageSource;
        this.pPrice = price;
        this.pIsSpecial = pIsSpecial;
        this.pMealType = pMealType;
    }

    public int getoPkgOrderId() {
        return oPkgOrderId;
    }

    public void setoPkgOrderId(int oPkgOrderId) {
        this.oPkgOrderId = oPkgOrderId;
    }

    public int getoOrderId() {
        return oOrderId;
    }

    public void setoOrderId(int oOrderId) {
        this.oOrderId = oOrderId;
    }

    public int getoPackageId() {
        return oPackageId;
    }

    public void setoPackageId(int oPackageId) {
        this.oPackageId = oPackageId;
    }

    public int getoCustomerId() {
        return oCustomerId;
    }

    public void setoCustomerId(int oCustomerId) {
        this.oCustomerId = oCustomerId;
    }

    public double getoPricePerPkg() {
        return oPricePerPkg;
    }

    public void setoPricePerPkg(double oPricePerPkg) {
        this.oPricePerPkg = oPricePerPkg;
    }

    public int getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(int oQuantity) {
        this.oQuantity = oQuantity;
    }

    public int getoIsOpen() {
        return oIsOpen;
    }

    public void setoIsOpen(int oIsOpen) {
        this.oIsOpen = oIsOpen;
    }

    public int getpPackageId() {
        return pPackageId;
    }

    public void setpPackageId(int pPackageId) {
        this.pPackageId = pPackageId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public int getpMealCategory() {
        return pMealCategory;
    }

    public void setpMealCategory(int pMealCategory) {
        this.pMealCategory = pMealCategory;
    }

    public String getpImageSource() {
        return pImageSource;
    }

    public void setpImageSource(String pImageSource) {
        this.pImageSource = pImageSource;
    }

    public double getpPrice() {
        return pPrice;
    }

    public void setpPrice(double pPrice) {
        this.pPrice = pPrice;
    }

    public int getpIsSpecial() {
        return pIsSpecial;
    }

    public void setpIsSpecial(int pIsSpecial) {
        this.pIsSpecial = pIsSpecial;
    }

    public int getpMealType() {
        return pMealType;
    }

    public void setpMealType(int pMealType) {
        this.pMealType = pMealType;
    }
    
    
}
