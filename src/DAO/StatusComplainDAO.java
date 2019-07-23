package DAO;

public final class StatusComplainDAO {
	public boolean insertStatusComplain(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_Status_Complain", params);
		return kq;
	}



}