package model;

public class PkgOrder { 
    private int pkgOrderId;
    private int orderId;
    private int packageId;
    private int customerId;
    private double pricePerPkg;
    private int Quantity;
    private int isOpen;

    public PkgOrder() {
    }

    public PkgOrder(int pkgOrderId, int orderId, int packageId, int customerId, double pricePerPkg, int Quantity, int isOpen) {
        this.pkgOrderId = pkgOrderId;
        this.orderId = orderId;
        this.packageId = packageId;
        this.customerId = customerId;
        this.pricePerPkg = pricePerPkg;
        this.Quantity = Quantity;
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

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
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
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(int isOpen) {
        this.isOpen = isOpen;
    }
}
