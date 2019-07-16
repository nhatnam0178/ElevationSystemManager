package DAO;

import Config.ConnectionSQL;

public final class ClientDAO {
	public boolean insertClient(String name, String phone, String address, String company_name) {
		String[] params = { name, phone, address, company_name };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_Client", params);
		return kq;
	}

	public boolean delClient(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Client_by_id", params);

		return kq;
	}

	public boolean editClient(int id, String name, String phone, String address, String company_name) {

		String[] params = { String.valueOf(id), name, phone, address, company_name };
		boolean kq = ConnectionSQL.CallProcExec("sp_update_Client", params);
		return kq;
	}

	public boolean findbyId(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_find_Client_by_id", params);

		return kq;
	}
}