package com.bookpublisher.app.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdentifier1 implements IdentifierGenerator {
	private String defaultPrefix = "CTS";
	private int defaultNumber = 1;

	public CustomIdentifier1() {
		System.out.println("printing ]t from identifier");
	}
	@Override
	public Serializable generate(SessionImplementor session, Object arg1) throws HibernateException {
		System.out.println("this is generate");
		String u_id = "";
		String digits = "";
		String mid = "";
		PreparedStatement pst = null;
		ResultSet rs = null;

		Connection con = session.connection();
		try {
			pst = con.prepareStatement("SELECT u_id FROM CustomerDTO order by u_id desc LIMIT 1");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs != null && rs.next()) {
				System.out.println("rs != null && rs.next() If Block ");
				u_id = rs.getString("u_id");
				System.out.println(u_id);

				String prefix = u_id.substring(0, 3);
				String str1[] = u_id.split(prefix);

				String s = str1[1];
				mid = s.substring(0, 4);
				String str2[] = s.split(mid);

				DateFormat dateFormat = new SimpleDateFormat("yyyy");
				Calendar cal = Calendar.getInstance();
				mid = dateFormat.format(cal.getTime());
				prefix = prefix.concat(mid);

				digits = String.format("%05d", Integer.parseInt(str2[1]) + 1);

				u_id = prefix.concat(digits);
				System.out.println("If pat u_id :" + u_id);

			} else {
				DateFormat dateFormat = new SimpleDateFormat("yyyy");
				Calendar cal = Calendar.getInstance();
				mid = dateFormat.format(cal.getTime());
				defaultPrefix = defaultPrefix.concat(mid);

				digits = String.format("%05d", defaultNumber);
				u_id = defaultPrefix.concat(digits);
				System.out.println(u_id + "\t employeed id");
			}
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u_id;
	}
}
