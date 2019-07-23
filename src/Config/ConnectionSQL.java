package Config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class ConnectionSQL {
	private static String url = helper.FileHelper.getConnectionString("bin\\App.xml");
	public Connection conn;
	private static Parameters pars;
	public static Connection Connect() {
		try {
			Connection conn;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static ResultSet Query(String strQuery) {
		Statement stmt;
		try {

			stmt = Connect().createStatement();
			ResultSet rs = stmt.executeQuery(strQuery);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public ResultSet Query(String str, String[] params) {
		PreparedStatement stmt;
		try {

			stmt = Connect().prepareStatement(str);
			for (int i = 0; i < params.length; i++) {
				stmt.setString(i + 1, params[i]);

			}
			ResultSet rs = stmt.executeQuery();
			return rs;
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public static ResultSet CallProc(String storeName) {
		try {
			// khong truyen tham so
			CallableStatement state = Connect().prepareCall("{ call " + storeName + "}");
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ResultSet CallProc(String storeName, String[] parameters) {
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			return state.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * goi thu tuc de thuc thi truyen tham so de delete
	 * 
	 * @param storeName
	 * @param parameters
	 * @return
	 */
	public static boolean CallProcExec(String storeName, String[] parameters) {
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			return state.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 *
	 * 
	 * @param storeName
	 * @param parameters
	 * @return
	 */
	public static Object[] CallProcScala(String storeName, String[] parameters, int paraout) {
		String[] obj = new String[paraout];

		int len = parameters.length + paraout;
		pars = new Parameters();
		try {
			String str = "{ call " + storeName + "(" + pars.getpara(parameters, paraout) + ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);
			}
			for (int i = parameters.length; i < len; i++) {
				state.registerOutParameter(i + 1, java.sql.Types.JAVA_OBJECT);
			}

			state.execute();
			int j = 0;
			for (int i = parameters.length; i < len; i++) {
				obj[j] = state.getString(i + 1);
				j++;
			}

			return obj;

		} catch (SQLException e) {
			// TODO Auto-generated catch blok
			e.printStackTrace();
		}

		return null;

	}
	/**
	 *
	 * 
	 * @param storeName
	 * @param parameters
	 * @return
	 */
	public static Object CallProcScala(String storeName, String[] parameters) {
		Object obj = null;
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			state.registerOutParameter(1, java.sql.Types.JAVA_OBJECT);
			state.execute();
			obj = state.getObject(parameters.length + 1);
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch blok
			e.printStackTrace();
		}

		return obj;

	}

	/**
	 *
	 * 
	 * @param storeName
	 * @param parameters
	 * @return value
	 */
	public static Object CallProcScalaV(String storeName, String[] parameters) {
		int valueOut = 0;
		try {
			String str = "{ call " + storeName + "(";
			for (int i = 0; i < parameters.length; i++) {
				if (i + 1 == parameters.length) {
					str += "?";
				} else {
					str += "?,";
				}
			}
			str += ")}";
			CallableStatement state = Connect().prepareCall(str);
			// code truyen tham so su dung loop
			for (int i = 0; i < parameters.length; i++) {
				state.setString(i + 1, parameters[i]);

			}
			state.registerOutParameter(1, java.sql.Types.INTEGER);
			state.execute();
			valueOut = state.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch blok
			e.printStackTrace();
		}

		return valueOut;

	}
}
