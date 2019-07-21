package DAO;

import java.util.Date;

import Config.ConnectionSQL;
import entities.Account;
import entities.Orders;
import entities.Status_Complain;

public final class ComplainDAO {
	public boolean insertComplain(int order_id, int account_id, int is_chargeable, String problem, String date_complain,
			int status_id, String technician_person) {
		String[] params = { String.valueOf(order_id), String.valueOf(account_id), String.valueOf(is_chargeable),
				problem, date_complain, String.valueOf(status_id), technician_person };
		boolean kq = ConnectionSQL.CallProcExec("sp_insert_Complain", params);
		return kq;
	}

	public boolean delComplain(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_delete_Complain_by_id", params);

		return kq;
	}

	public boolean editComplain(int id, Orders order_id, Account account_id, boolean is_chargeable, String problem,
			Date date_complain, Status_Complain status_id, String technician_person) {

		String[] params = { String.valueOf(id), String.valueOf(status_id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_update_Complain", params);
		return kq;
	}

	public boolean findbyId(int id) {
		String[] params = { String.valueOf(id) };
		boolean kq = ConnectionSQL.CallProcExec("sp_find_Complain_by_id", params);

		return kq;
	}

}