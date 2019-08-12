
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author 1bestcsharp.blogspot.com
 */
import javax.swing.table.*;

import java.awt.Image;
import java.sql.*;
import java.util.*;

import javax.swing.*;

  class User1 {
	  private String flight_id;
	  private String flight_name;
		private String source;
		private String departure;
		private String flight_class;
		private String flight_charges;
		private String seats;
		private String destination;
		private String arrived_time;
	 
	 public User1(String Flight_ID,String Flight_Name,String Source,String Departure,String Destination,String Arrived_Time,String Flight_Class,String Flight_Charges,String Seats)
	    {
	        this.flight_id =Flight_ID;
	        this.flight_name = Flight_Name;
	        this.source =Source;
	        this.departure = Departure;
	        this.destination=Destination;
	        this.arrived_time=Arrived_Time;
	        this.flight_class=Flight_Class;
	        this.flight_charges=Flight_Charges;
	        this.seats = Seats;

	        
	    }
	
   
	public User1(String string, String string2) {
		// TODO Auto-generated constructor stub
	}


	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getFlight_class() {
		return flight_class;
	}

	public void setFlight_class(String flight_class) {
		this.flight_class = flight_class;
	}

	public String getFlight_charges() {
		return flight_charges;
	}

	public void setFlight_charges(String flight_charges) {
		this.flight_charges = flight_charges;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}


	public String getDestination() {
		// TODO Auto-generated method stub
		return destination;
	}
	public void setDestination(String Destination) {
		this.destination = Destination;
	}



	public String getArrived_Time() {
		// TODO Auto-generated method stub
		return arrived_time;
	}
	public void setArrived_Time(String Arrived_Time) {
		this.arrived_time = Arrived_Time;
	}


	
    


 }