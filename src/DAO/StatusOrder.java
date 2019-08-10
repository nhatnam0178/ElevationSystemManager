package DAO;

import Config.ConnectionSQL;

public final class StatusOrder {
	public boolean insertStatusOrder(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_Status_Order", params);
		return kq;
	}
	public boolean editStatusOrder(int id, String name) {
		String[] params = { String.valueOf(id), name };

		boolean kq = ConnectionSQL.CallProcExec("sp_update_StatusOrder", params);
		return kq;
	}
	public boolean delStatusOrder(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_StatusOrder_by_id", params);

		return kq;
	}
}