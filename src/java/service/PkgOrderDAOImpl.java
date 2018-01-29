package service;

import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.PkgOrder;
import javax.sql.DataSource;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class PkgOrderDAOImpl implements PkgOrderDAO{
    private static JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        jdbcTemplate=new JdbcTemplate(dataSource);
    }
    
    @Override
    public void addOpenPkgOrder(PkgOrder pkgOrder) {
        try {
        String updateStr = ("INSERT INTO PkgOrders (Pkg_Order_Id, Order_Id, Package_Id, Customer_Id, Price_Per_Pkg, Quantity, Is_Open) "
                + " VALUES (?,?,?,?,?,?,?)");
        
        jdbcTemplate.update(updateStr, new Object[]{
                pkgOrder.getPkgOrderId(), pkgOrder.getOrderId(), pkgOrder.getPackageId(), pkgOrder.getCustomerId(), 
                pkgOrder.getPricePerPkg(), pkgOrder.getQuantity(), pkgOrder.getIsOpen()});
       
        } catch (Exception e){System.out.println(e);}
    }
    @Override
    public void editOrderId(int pkgOrderId, int newOrderId) {
        String updateStr = ("UPDATE PkgOrders SET Order_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newOrderId, pkgOrderId});
    }
    @Override
    public void editPackageId(int pkgOrderId, int newPackageId){
        String updateStr = ("UPDATE PkgOrders SET Package_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newPackageId, pkgOrderId});        
    }
    @Override
    public void editCustomerId(int pkgOrderId, int newCustomerId){
        String updateStr = ("UPDATE PkgOrders SET Customer_Id=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newCustomerId, pkgOrderId});           
    }
    @Override
    public void editQuantity(int pkgOrderId, int newQuantity){
        String updateStr = ("UPDATE PkgOrders SET Quantity=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newQuantity, pkgOrderId});           
    }
    @Override
    public void editIsOpen(int pkgOrderId, int newIsOpen){
        String updateStr = ("UPDATE PkgOrders SET Is_Open=? WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{newIsOpen, pkgOrderId});           
    }
    @Override
    public void closePkgOrder (int pkgOrderId, int newOrderId){
        //Object o[]={newOrderId};
        //int argsTypes[]={Types.INTEGER};
        //RowMapper mapper=new OrderRowMapper();
        //List results = jdbcTemplate.query("SELECT * from Orders WHERE Order_Id=?",o,argsTypes,mapper);
        //if (!results.isEmpty()) {
            String updateStr = ("UPDATE PkgOrders SET Order_Id=? WHERE Pkg_Order_Id=?");
            jdbcTemplate.update(updateStr, new Object[]{newOrderId, pkgOrderId}); 
            updateStr = ("UPDATE PkgOrders SET Is_Open=0 WHERE Pkg_Order_Id=?");
            jdbcTemplate.update(updateStr, new Object[]{pkgOrderId});
        //}
        //else
        //    System.out.println(">>>>Error: Order doesn't exist");
    }
    @Override
    public void deletePkgOrder(int deletePkgOrderId){
        String updateStr = ("DELETE FROM PkgOrders WHERE Pkg_Order_Id=?");
        jdbcTemplate.update(updateStr, new Object[]{deletePkgOrderId});
    }
    @Override
    public int getNextPkgOrderId(){
        return jdbcTemplate.queryForObject("SELECT MAX(Pkg_Order_Id)FROM PkgOrders",Integer.class)+1;
    }
    @Override
    public PkgOrder getSinglePkgOrder(int pkgOrderId){
        Object o[]={pkgOrderId};
        int argsTypes[]={Types.INTEGER};
        RowMapper mapper=new PackageRowMapper();
        List l = jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Pkg_Order_Id=?",o,argsTypes,mapper);
        Iterator it=l.iterator();
        model.PkgOrder p=(model.PkgOrder)it.next();
        return p;
    }
    @Override
    public List<PkgOrder> getOpenPkgOrdersByCustomer(int Customer_Id){
        Object o[]={Customer_Id};
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Customer_Id=? AND Is_Open=1",o, new PackageRowMapper());
    }
    @Override
    public List<PkgOrder> getAllPkgOrdersByOrder(int OrderId){
        Object o[]={OrderId};
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Order_Id=?",o, new PackageRowMapper());
    }
    @Override
    public List<PkgOrder> getAllClosedPkgOrders(){
        return jdbcTemplate.query("SELECT * FROM PkgOrders WHERE Is_Open=0", new PackageRowMapper());
    }
    @Override
    public double getFinalPrice(int customer_id){
        Object[] o={customer_id};
        return jdbcTemplate.queryForObject("SELECT SUM(Price_Per_Pkg*Quantity) FROM PkgOrders WHERE Is_Open=0 AND Customer_Id=?",o,Double.class);
    }
}