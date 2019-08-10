package DAO;

import java.sql.ResultSet;
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

	public ResultSet findbyId(int id) {
		String[] params = { String.valueOf(id) };
		ResultSet rs = ConnectionSQL.CallProc("sp_find_Complain_by_id", params);

		return rs;
	}

	public boolean ChangeStatus(int id, int status,int isChar) {
		String[] params = { String.valueOf(id),String.valueOf(status),String.valueOf(isChar) };
		boolean kq = Config.ConnectionSQL.CallProcExec("sp_updateStatus_COMPLAIN", params);
		return kq;
	}

}