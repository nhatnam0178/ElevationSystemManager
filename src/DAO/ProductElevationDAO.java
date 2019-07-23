package DAO;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Config.ConnectionSQL;

public final class ProductElevationDAO {
	public boolean insertProductElevation(String name, String type, int price, String date_of_order, int warranty,
			String warranty_expire_date) {
		String[] params = { name, type, String.valueOf(price), date_of_order, String.valueOf(warranty),
				warranty_expire_date };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_Product_Elevation", params);
		return kq;
	}

	public boolean delProduct(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Product_Elevation_by_id", params);

		return kq;
	}

	public boolean editProductElevation(String name, String type, int price, String date_of_order, int warranty,
			String warranty_expire_date, int id) {
		String[] params = { name, type, String.valueOf(price), String.valueOf(date_of_order), String.valueOf(warranty),
				String.valueOf(warranty_expire_date), String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_update_Product_Elevation", params);
		return kq;
	}

	public ResultSet findbyId(int id) {
		String[] params = { String.valueOf(id) };
		ResultSet rs = ConnectionSQL.CallProc("sp_find_Product_by_id", params);

		return rs;
	}

	public String findbyIdReturnName(int id, String strSto) {
		String[] params = { String.valueOf(id) };
		String str = "";
		ResultSet rs = ConnectionSQL.CallProc(strSto, params);
		try {
			while (rs.next()) {
				str = rs.getString("NAME");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

}