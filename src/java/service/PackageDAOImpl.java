package service;

import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import model.Package;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PackageDAOImpl implements PackageDAO{
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addPackage(Package pkg) {
        String updateStr = ("INSERT INTO Packages (Package_Id, Name, Description, Meal_Category, Image_Source, Price, Is_Special, Meal_Type)"
                + " VALUES (?,?,?,?,?,?,?,?)");
        jdbcTemplate.update(updateStr, new Object[]{
                pkg.getPackageId(), pkg.getName(), pkg.getDescription(), pkg.getMealCategory(), 
                pkg.getImageSource(), pkg.getPrice(), pkg.getIsSpecial(), pkg.getMealType()});
    }
    
    @Override
    public void editName(int editPackageId, String newName) {
        String updateStr = ("UPDATE Packages SET Name=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newName, editPackageId});
    }
    
    @Override
    public void editDescription(int editPackageId, String newDescription) {
        String updateStr = ("UPDATE Packages SET Description=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newDescription, editPackageId});
    }
    
    @Override
    public void editMealCategory(int editPackageId, int newMealCategory) {
        String updateStr = ("UPDATE Packages SET MealCategory=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newMealCategory, editPackageId});
    }
    
    @Override
    public void editImageSource(int editPackageId, String newImageSource) {
        String updateStr = ("UPDATE Packages SET ImageSource=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newImageSource, editPackageId});
    }
    
    @Override
    public void editPrice(int editPackageId, double newPrice) {
        String updateStr = ("UPDATE Packages SET Price=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newPrice, editPackageId});
    }
    
    @Override
    public void editIsSpecial(int editPackageId, int newIsSpecial) {
        String updateStr = ("UPDATE Packages SET IsSpecial=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newIsSpecial, editPackageId});
    }
    
    @Override
    public void editMealType(int editPackageId, int newMealType) {
        String updateStr = ("UPDATE Packages SET MealType=? WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newMealType, editPackageId});
    }
    
    @Override
    public void deletePackage(int deletePackageId) {
        String updateStr = ("DELETE FROM Packages WHERE Package_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{deletePackageId});
    }
    
    @Override
    public List getAllPackageData() {
        return jdbcTemplate.query("select * from Packages", new PackageRowMapper());
    }
    
    @Override
    public Package getSinglePackageData(int packageId) {
        Object o[]={packageId};
        int argsTypes[]={Types.INTEGER};
        RowMapper mapper=new PackageRowMapper();
        List l = jdbcTemplate.query("SELECT * FROM Packages WHERE Package_Id=?",o,argsTypes,mapper);
        Iterator it=l.iterator();
        Package p=(Package)it.next();
        return p;
    }
}