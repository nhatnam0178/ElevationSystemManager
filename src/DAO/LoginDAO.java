package DAO;

import Config.ConnectionSQL;

public final class LoginDAO {
	public Object[] CheckLogin(String sp_name, String[] login, int paraout) {
		
		return ConnectionSQL.CallProcScala(sp_name, login, paraout);
	}
}
