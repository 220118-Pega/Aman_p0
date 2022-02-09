package com.revature.p0.storage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Contains logic to create connection to the db so we dont need to create interface to make your java code logic
 * @author vergi
 *
 */
public class ConnectionFactory {
	
	// What needs to be in my class? Always remember attribute and methods, maybe also constructors
	// instance for my connection factory
	private static final ConnectionFactory connectionfactory = new ConnectionFactory();
	//Instance of properties
	private Properties props = new Properties();
	
	// use static to forceably load into the memory
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private ConnectionFactory() {
		// load properties file
		// we use loader to put the properties file into the connection factory if not stacktrace we can know issue or what happened.
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("db.properties"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	// we use singleton here to specify that there will only one instance of this class
	public static ConnectionFactory getInstance() {
		return connectionfactory;
	}
	
	// getConnection -- is used to establish connection with database provided by the URL in my db.properties
	// actual method that creates the connection to the method
	public Connection getConnection() {
		Connection conn = null;
		// try face i am establishing connection provide with information
		try {
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
		}
		// in catch if connection is not established list them
		catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
