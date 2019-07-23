package DAO;

import java.sql.ResultSet;
import java.util.Date;

import Config.ConnectionSQL;
import entities.Orders;
import entities.Product_Elevation;

public final class OrderDetailDAO {
	public boolean insertOrderDetail(int order_id, int product_id, int num_of_system_installed, int price,
			int warranty_period, String warranty_expire_date) {
		String[] params = { String.valueOf(order_id), String.valueOf(product_id),
				String.valueOf(num_of_system_installed), String.valueOf(price), String.valueOf(warranty_period),
				warranty_expire_date };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_Order_Detail", params);
		return kq;

	}

	public boolean editOrder_Detail(int order_id, int product_id, int num_of_system_installed, int price,
			int warranty_period, String warranty_expire_date) {

		String[] params = { String.valueOf(num_of_system_installed), String.valueOf(price),
				String.valueOf(warranty_period), warranty_expire_date, String.valueOf(order_id),
				String.valueOf(product_id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_update_Order_Detail", params);
		return kq;
	}

	public ResultSet findbyId(int id) {
		String[] params = { String.valueOf(id) };
		ResultSet rs = ConnectionSQL.CallProc("sp_find_Order_Detail_by_id", params);
		return rs;
	}
}