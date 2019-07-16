package DAO;

import java.sql.ResultSet;

import Config.ConnectionSQL;

public final class DepartmentDAO {
	public boolean insertDepartment(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_Department", params);
		return kq;
	}

	public boolean delDepartment(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Department_by_id", params);

		return kq;
	}

	public boolean editDepartment(int id, String name) {
		String[] params = { String.valueOf(id), name };

		boolean kq = ConnectionSQL.CallProcExec("sp_update_Department", params);
		return kq;
	}

	public ResultSet findbyId(int id) {
		String[] params = { String.valueOf(id) };
		ResultSet rs = ConnectionSQL.CallProc("sp_find_Department_by_id", params);
		return rs;
	}
}
