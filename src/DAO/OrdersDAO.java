package DAO;
import java.util.Date;

import Config.ConnectionSQL;
import entities.Account;
import entities.Client;
import entities.Status_Order;

public final class OrdersDAO {
	public boolean insertOrders(Client client_id, Account account_id, double total_price, Date date_of_order,
			Date date_of_system_installed, Date date_of_complete, Status_Order status)
	{
		String[] params = {String.valueOf(client_id),String.valueOf(account_id),String.valueOf(total_price),String.valueOf(date_of_order),
				String.valueOf(date_of_system_installed),String.valueOf(date_of_complete),String.valueOf(status)};
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_Orders", params);
		return kq;
	}

	public boolean delOrders(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Orders_by_id", params);

		return kq;
	}
	public boolean editAccount(int id,Client client_id, Account account_id, double total_price, Date date_of_order,
			Date date_of_system_installed, Date date_of_complete, Status_Order status) {

		String[] params = { 
				String.valueOf(id),String.valueOf(client_id),String.valueOf(account_id),String.valueOf(total_price),String.valueOf(date_of_order),
				String.valueOf(date_of_system_installed),String.valueOf(date_of_complete),String.valueOf(status)
		};
		boolean kq = ConnectionSQL.CallProcExec("sp_update_Orders", params);
		return kq;
	}
	public boolean findbyId(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_find_Orders_by_id", params);

		return kq;
	}
	
}