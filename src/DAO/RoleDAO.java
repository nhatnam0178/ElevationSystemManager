package DAO;

import Config.ConnectionSQL;

public final class RoleDAO {
	public boolean insertRole(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_ROLE", params);
		return kq;
	}
	public boolean delRole(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Role_by_id", params);

		return kq;
	}
}
