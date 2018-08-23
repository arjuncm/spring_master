package com.howtodospring.demo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

		public static void main(String[] args) {
	        Database db = new Database();
	        try {
	            db.connect();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        db.close();
	    }
}
