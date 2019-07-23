package DAO;

import java.sql.ResultSet;

import Config.ConnectionSQL;

public final class AccountDAO {
	public boolean insertAccount(String username, String password, String name, boolean gender, String email,
			String phone, String address, int role_id, int department_id) {
		String[] params = { username, password, name, String.valueOf(gender), email, phone, address,
				String.valueOf(role_id), String.valueOf(department_id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_ACCOUNT", params);
		return kq;
	}

	public boolean delAccount(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_ACCOUNT_by_id", params);

		return kq;
	}

	public boolean editAccount(String password, String name, boolean gender, String email, String phone, String address,
			int role_id, int department_id, String id, String username) {

		String[] params = { password, name, String.valueOf(gender), email, phone, address, String.valueOf(role_id),
				String.valueOf(department_id), id, username };
		boolean kq = ConnectionSQL.CallProcExec("sp_update_ACCOUNT", params);
		return kq;
	}

	public ResultSet findbyId(int id) {
		String[] params = { String.valueOf(id) };

		ResultSet rs = ConnectionSQL.CallProc("sp_find_ACCOUNT_by_id", params);

		return rs;
	}

	public ResultSet findAccountByUsername(String username) {
		String[] params = { username };
		ResultSet rs = ConnectionSQL.CallProc("sp_find_ACCOUNT_by_Username", params);
		return rs;
	}

}
