package DAO;

import Config.ConnectionSQL;

public final class OrdersDAO {
	public int insertOrders(int client_id, int account_id, double total_price, String date_of_order,
			String date_of_system_installed, String date_of_complete, int status) {
		String[] params = { String.valueOf(client_id), String.valueOf(account_id), String.valueOf(total_price),
				date_of_order, date_of_system_installed, date_of_complete, String.valueOf(status) };

		int kq = (int)ConnectionSQL.CallProcScala("sp_insert_ORDERS", params);
		return kq;
	}

	public boolean delOrders(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Orders_by_id", params);

		return kq;
	}

	public boolean findbyId(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_find_Orders_by_id", params);

		return kq;
	}

	
}