package DAO;

public final class StatusOrder {
	public boolean insertStatusOrder(String name) {
		String[] params = { name };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_insert_Status_Order", params);
		return kq;
	}
	

}