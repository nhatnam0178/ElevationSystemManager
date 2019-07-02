package DAO;

import Config.ConnectionSQL;

public final class AccountDAO {
	public boolean insertAccount(String username, String password, String name, boolean gender, String email,
			String phone, String address, int role_id, int department_id) {
		String[] params = { username, password, name, String.valueOf(gender), email, phone, address,
				String.valueOf(role_id), String.valueOf(department_id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_ACCOUNT", params);
		return kq;
	}
	
}
