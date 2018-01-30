package DAO;

import Model.PkgOrder;
import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class PkgOrderRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int index) throws SQLException {
        PkgOrder p = new PkgOrder();
	p.setPkgOrderId(rs.getInt(1));
	p.setOrderId(rs.getInt(2));
        p.setPackageIdKey(rs.getInt(3));
        p.setCustomerId(rs.getInt(4));
        p.setPricePerPkg(rs.getDouble(5));
        p.setQuantity(rs.getInt(6));
        p.setIsOpen(rs.getInt(7));
	return p;
    }     
}