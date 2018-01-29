package service;

import model.PkgOrder;
import model.CartPkg;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class CartPkgRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        CartPkg c = new CartPkg();
        c.setoPkgOrderId(rs.getInt(1));
        c.setoOrderId(rs.getInt(2));
        c.setoPackageId(rs.getInt(3));
        c.setoCustomerId(rs.getInt(4));
        c.setoPricePerPkg(rs.getInt(5));
        c.setoQuantity(rs.getInt(6));
        c.setoIsOpen(rs.getInt(7));
        
	c.setpPackageId(rs.getInt(8));
	c.setpName(rs.getString(9));
        c.setpDescription(rs.getString(10));
        c.setpMealCategory(rs.getInt(11));
        c.setpImageSource(rs.getString(12));
        c.setpPrice(rs.getDouble(13));
        c.setpIsSpecial(rs.getInt(14));
        c.setpMealType(rs.getInt(15));
	return c;
    }     
}