package com.javainuse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javainuse.model.ZipTar;
import com.javainuse.util.DBConnection;

public class ZipDao {
	
	DBConnection dbConnection = null;
	public String addFileInfo(ZipTar zipTar) {
		
		dbConnection = new DBConnection();
		
		Connection con = null;
		
		con = dbConnection.dbConnection();
		
		String insertTableSQL = "INSERT INTO public.\"ZIPTARDATA\""
				+ "(USER_ID, FILE_NAME, FILE_DATA, file_checksum) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, zipTar.getUserId());
			preparedStatement.setString(2, zipTar.getFileName());
			preparedStatement.setBytes(3, zipTar.getFileData());
			preparedStatement.setString(4, zipTar.getCheckSum());
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "SUCCESS";
	}

public ZipTar downloadZipTar(String userId) {
		
		dbConnection = new DBConnection();
		
		Connection con = null;
		ResultSet rs =null;
		con = dbConnection.dbConnection();
		ZipTar zt = null;
		String insertTableSQL = "SELECT USER_ID, FILE_NAME, FILE_DATA, file_checksum  FROM public.\"ZIPTARDATA\" WHERE USER_ID = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, userId);
			// execute insert SQL stetement
			rs = preparedStatement.executeQuery();
			while(rs.next()) {
				zt = new ZipTar();
				zt.setUserId(rs.getString("USER_ID"));
				zt.setFileName(rs.getString("FILE_NAME"));
				zt.setFileData(rs.getBytes("FILE_DATA"));
				zt.setCheckSum(rs.getString("file_checksum"));
				return zt;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return zt;
	}
}
