package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.BookVO;

public class BookDAO {

	// DB��������
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "myuser";
	private final String passwd = "1234";

	// DB���� �� Ŀ�ؼ� ��ü �������� �޼ҵ�
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		// 1�ܰ�. JDBC ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2�ܰ�. DB����
		con = DriverManager.getConnection(url, user, passwd);

		return con;
	} // getConnection

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// JDBC �ڿ� �ݱ� (����� �������� ����)
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close

	// å����ϱ�
	public void insertBook(BookVO bookVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO Book (num,name,writer,publisher, kategorie, count, reg_date) ";
			sql += "VALUES (seq_book.nextval, ?, ?, ?, ?, ?,?) ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookVO.getName());
			pstmt.setString(2, bookVO.getWriter());
			pstmt.setString(3, bookVO.getPublisher());
			pstmt.setString(4, bookVO.getKategorie());
			pstmt.setString(5, bookVO.getCount());
			pstmt.setTimestamp(6, bookVO.getRegdate());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}// insertBook()

	// �޺��ڽ� �˻��ϱ�

	public List<BookVO> search(String field, String word) {// <-���� �κ� �� ������ ����?
		List<BookVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = " 	SELECT * " + "	FROM book " + "	WHERE " + field + " LIKE ? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + word + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setNum(rs.getInt("num"));
				bookVO.setName(rs.getString("name"));
				bookVO.setWriter(rs.getString("writer"));
				bookVO.setPublisher(rs.getString("publisher"));
				bookVO.setKategorie(rs.getString("kategorie"));
				bookVO.setCount(rs.getString("count"));
				bookVO.setRegdate(rs.getTimestamp("reg_date"));

				list.add(bookVO);

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}// search

//��ƺ���
	public List<BookVO> getBooks() {
		List<BookVO> list = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();

			String sql = "SELECT * FROM book ORDER BY kategorie,Name ASC";

			System.out.println(sql);

			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVO bookVO = new BookVO();
				bookVO.setNum(rs.getInt("num"));
				bookVO.setName(rs.getString("name"));
				bookVO.setWriter(rs.getString("writer"));
				bookVO.setPublisher(rs.getString("publisher"));
				bookVO.setKategorie(rs.getString("kategorie"));
				bookVO.setCount(rs.getString("count"));
				bookVO.setRegdate(rs.getTimestamp("reg_date"));

				list.add(bookVO);

			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}

	// �����ϱ�
	public void updateBooks(BookVO bookVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "	UPDATE book";
			sql += "	SET name=?,writer=?,publisher=?,";
			sql += "	kategorie=?,count=?,reg_date=?";
			sql += "	WHERE num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bookVO.getName());
			pstmt.setString(2, bookVO.getWriter());
			pstmt.setString(3, bookVO.getPublisher());
			pstmt.setString(4, bookVO.getKategorie());
			pstmt.setString(5, bookVO.getCount());
			pstmt.setTimestamp(6, bookVO.getRegdate());
			pstmt.setInt(7, bookVO.getNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}// updateBooks

	// �����ϱ�

	public void removeByNum(int num) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "DELETE FROM book ";
			sql += "WHERE num=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}

	}// removeBynum

	// main�� �̹��� �ֱ�

}// public class BookDAO