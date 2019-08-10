package DAO;

import Config.ConnectionSQL;

public final class StatusComplainDAO {
	public boolean insertStatusComplain(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_Status_Complain", params);
		return kq;
	}

	public boolean editStatusComplain(int id, String name) {
		String[] params = { String.valueOf(id), name };

		boolean kq = ConnectionSQL.CallProcExec("sp_update_StatusComplain", params);
		return kq;
	}
	public boolean delStatusComplain(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_StatusComplain_by_id", params);

		return kq;
	}
}