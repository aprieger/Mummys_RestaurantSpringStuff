package Model;

public class PkgOrder { 
    private int pkgOrderId;
    private int orderId;
    private int packageIdKey;
    private int customerId;
    private double pricePerPkg;
    private int quantity;
    private int isOpen;

    public PkgOrder() {
        this.pkgOrderId = 0;
        this.orderId = 0;
        this.packageIdKey = 0;
        this.customerId = 0;
        this.pricePerPkg = 0;
        this.quantity = 0;
        this.isOpen = 0;
    }

    public PkgOrder(int pkgOrderId, int orderId, int packageId, int customerId, double pricePerPkg, int Quantity, int isOpen) {
        this.pkgOrderId = pkgOrderId;
        this.orderId = orderId;
        this.packageIdKey = packageId;
        this.customerId = customerId;
        this.pricePerPkg = pricePerPkg;
        this.quantity = Quantity;
        this.isOpen = isOpen;
    }

    public int getPkgOrderId() {
        return pkgOrderId;
    }

    public void setPkgOrderId(int pkgOrderId) {
        this.pkgOrderId = pkgOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPackageIdKey() {
        return packageIdKey;
    }

    public void setPackageIdKey(int packageIdKey) {
        this.packageIdKey = packageIdKey;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getPricePerPkg() {
        return pricePerPkg;
    }

    public void setPricePerPkg(double pricePerPkg) {
        this.pricePerPkg = pricePerPkg;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int Quantity) {
        this.quantity = Quantity;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }
}
