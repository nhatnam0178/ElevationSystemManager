package DAO;

public final class RoleDAO {
	public boolean insertRole(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_ROLE", params);
		return kq;
	}
}
