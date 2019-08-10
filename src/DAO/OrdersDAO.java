package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Config.ConnectionSQL;

public final class OrdersDAO {
	public boolean insertOrders(int client_id, int account_id, int total_price, String date_of_order,
			String date_of_system_installed, String date_of_complete, int status) {
		String[] params = { String.valueOf(client_id), String.valueOf(account_id), String.valueOf(total_price),
				date_of_order, date_of_system_installed, date_of_complete, String.valueOf(status) };

		boolean kq = ConnectionSQL.CallProcExec("sp_insert_ORDERS", params);
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

	public boolean changeStatus(int idGet, int Status_id) {
		String[] params = { String.valueOf(idGet), String.valueOf(Status_id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_updateStatus_ORDERS", params);
		return kq;
	}
	public int GetInsertId(String query, String[] params) {
		PreparedStatement stmt;
		try {
			int key = -1;
			stmt = ConnectionSQL.Connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);
			}
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				key = rs.getInt(1);
			}
			return key;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return -1;
	}

}