package DAO;

import java.util.List;
import Model.Package;

public interface PackageDAO {
    public void addPackage(Package pkg);
    public void editPackage(int editPackageId, String name, String description, int mealCategory, String imageSource, double price, int isSpecial, int mealType);
    public void editName(int editPackageId, String newName);
    public void editDescription(int editPackageId, String newDescription);
    public void editMealCategory(int editPackageId, int newMealCategory);
    public void editImageSource(int editPackageId, String newImageSource);
    public void editPrice(int editPackageId, double newPrice);
    public void editIsSpecial(int editPackageId, int newIsSpecial);
    public void editMealType(int editPackageId, int newMealType);
    public void deletePackage(int deletePackageId);
    public List getAllPackageData();
    public Package getSinglePackageData(int packageId);
}
