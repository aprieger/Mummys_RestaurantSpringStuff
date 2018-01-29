package service;

import java.util.List;
import model.Package;

public interface PackageDAO {
    public void addPackage(Package pkg);
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
