package com.skps.airlinereservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.skps.ars.utilities.ConnectionMySql;

import javax.swing.UIManager;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class DomesticBookingDetails extends JFrame {

	private JTextField textField;
	static DomesticBookingDetails frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static int adultNumber = 0;
	private static int childNumber = 0;
	private static int infantNumber = 0;
	private static String mealPref = "Vegetarian";
	private static JPanel contentPane;
	private static String fName = "";
	private static String lName = "";
	private static String gender = "";
	private static boolean canBook = true;
	private static int age = 0;
	private static double total_fare;
	static String creditCardNum = "";
	int creditLeng = 0;
	String message = "";
	static String flightClass = "Economy";
	static String pnrNum = "";
	static String source = "", destination = "", flightNum = "", sectorId = "";
	// private JTextPane textPane_1, textPane_2,textPane_3,textPane_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	static java.sql.Date travelDate = null;
	static java.sql.Date bookDate = null;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DomesticBookingDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DomesticBookingDetails() {
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(10, 28, 46, 14);
		contentPane.add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(10, 63, 46, 14);
		contentPane.add(lblTo);

		JLabel lblDateOfJourney = new JLabel("Date of Journey");
		lblDateOfJourney.setBounds(10, 101, 103, 20);
		contentPane.add(lblDateOfJourney);

		JLabel lblNumberOfPassengers = new JLabel("Number of adults (age >12)");
		lblNumberOfPassengers.setBounds(10, 142, 160, 20);
		contentPane.add(lblNumberOfPassengers);

		JButton btnNewButton = new JButton("Search Flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchFlights_Domestic domSearch = new SearchFlights_Domestic();
				domSearch.setVisible(true);
			}
		});
		btnNewButton.setBounds(447, 297, 132, 23);
		contentPane.add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(124, 25, 103, 20);
		contentPane.add(comboBox);
		ItemListener itemListenerFrom = new ItemListener() {

			// To get user selected value
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				source = (itemEvent.getItem()).toString();

			}
		};
		comboBox.addItemListener(itemListenerFrom);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(124, 60, 103, 20);
		contentPane.add(comboBox_1);
		ItemListener itemListenerTo = new ItemListener() {

			// To get user selected value
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				destination = (itemEvent.getItem()).toString();

			}
		};
		comboBox_1.addItemListener(itemListenerTo);
		// fetching values from db to populate the combo box
		Connection conn = null;
		ResultSet rs;

		try {
			String sql = "SELECT source,destination FROM sector where flighttype = 'Domestic'";
			ConnectionMySql connClass = new ConnectionMySql();
			conn = connClass.getConnection();
			Statement statement = conn.createStatement();

			rs = statement.executeQuery(sql);

			// Get row data
			while (rs.next()) {
				comboBox.addItem(rs.getString(1));
				comboBox_1.addItem(rs.getString(2));
			}

			statement.close();
			// conn.close();
			connClass.destroyConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		textField = new JTextField();
		textField.setBounds(124, 101, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(413, 16, 137, 118);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMeal = new JLabel("Meal Preference");
		lblMeal.setBounds(28, 16, 103, 14);
		panel.add(lblMeal);

		JRadioButtonMenuItem rdbtnmntmVegetarian = new JRadioButtonMenuItem("Vegetarian");
		buttonGroup_1.add(rdbtnmntmVegetarian);
		rdbtnmntmVegetarian.setBounds(6, 51, 125, 22);
		panel.add(rdbtnmntmVegetarian);
		rdbtnmntmVegetarian.setSelected(true);

		JRadioButtonMenuItem rdbtnmntmNonVegetarian = new JRadioButtonMenuItem("Non Vegetarian");
		buttonGroup_1.add(rdbtnmntmNonVegetarian);
		rdbtnmntmNonVegetarian.setBounds(6, 89, 125, 22);
		panel.add(rdbtnmntmNonVegetarian);
		ChangeListener changeListener = new ChangeListener() {
			public void stateChanged(ChangeEvent changEvent) {
				AbstractButton aButton = (AbstractButton) changEvent.getSource();
				ButtonModel aModel = aButton.getModel();
				boolean armed = aModel.isArmed();
				boolean pressed = aModel.isPressed();
				boolean selected = aModel.isSelected();
				// System.out.println("Changed: " + armed + "/" + pressed + "/"
				// +
				// selected);
				System.out.println("Selected: " + selected);
				if (selected) {
					System.out.println("Meal preference is " + getSelectedButtonText(buttonGroup_1));
					mealPref = getSelectedButtonText(buttonGroup_1);
				}
			}
		};

		rdbtnmntmVegetarian.addChangeListener(changeListener);
		rdbtnmntmNonVegetarian.addChangeListener(changeListener);
		JButton btnMakePayment = new JButton("Make Payment");
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creditCardNum = textField_4.getText();
				creditLeng = creditCardNum.length();
				if (source.equalsIgnoreCase("Kolkata") && (destination.equalsIgnoreCase("Bangalore"))) {
					flightNum = "FJA22";
					sectorId = "ko-blr";
				} else if (source.equalsIgnoreCase("Bangalore") && (destination.equalsIgnoreCase("Delhi"))) {
					flightNum = "FJA23";
					sectorId = "blr-dl";
				} else if (source.equalsIgnoreCase("Bangalore") && (destination.equalsIgnoreCase("Ahmedabad"))) {
					flightNum = "FJA24";
					sectorId = "blr-ahm";
				} else if (source.equalsIgnoreCase("Bangalore") && (destination.equalsIgnoreCase("Mumbai"))) {
					flightNum = "FJA26";
					sectorId = "blr-mum";
				} else {
					message = "No Flights scheduled between chosen cities";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					canBook = false;
				}
				checkScheduledFlight();

				if (creditLeng != 16) {
					message = "Please enter  16 digit card number";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					canBook = false;
					contentPane.repaint();
				} else if (creditLeng == 16) {
					try {
						long credit = Long.parseLong(creditCardNum);
					} catch (Exception ex) {
						message = "Please enter numerical values";
						canBook = false;
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
						contentPane.repaint();
					}
				}
				// String pnrNum=
				if (canBook) {
					checkSeatAvailability();
					calculateFare();
					insertRecords();
					updateSeat();
					String message1 = "Successfully booked Tickets !! Have a happy and safe journey !Here is your ticket?";
					JOptionPane.showMessageDialog(null, message1);
					try {
						int totPassenger = adultNumber + childNumber + infantNumber;
						String content = "Passenger Name :" + fName + " " + lName + "\n Total Passengers :"
								+ totPassenger + "\n Total Fare :" + total_fare + "\n Travel Date : " + travelDate
								+ "\n PNR Number :" + pnrNum;

						File file = new File("E:/ticket/dom_ticket.txt");

						// if file doesnt exists, then create it
						if (!file.exists()) {
							file.createNewFile();
						}

						FileWriter fw = new FileWriter(file.getAbsoluteFile());
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(content);
						bw.close();

						System.out.println("Done");

					} catch (IOException e) {
						e.printStackTrace();
					}

					/*
					 * JDialog YES = new JDialog(); String
					 * labl="Passenger Name :"+fName+" "+lName; JLabel label =
					 * new JLabel(labl); label.setVisible(true); YES.add(label);
					 * JLabel label1 = new
					 * JLabel("Number of Adults :"+adultNumber);
					 * label1.setVisible(true); YES.add(label1); JLabel label2 =
					 * new JLabel("Number of Children :"+childNumber);
					 * YES.add(label2); JLabel label3 = new
					 * JLabel("Number of Infants :"+infantNumber);
					 * YES.add(label3); JLabel label4 = new
					 * JLabel("Seat Type :"+flightClass); YES.add(label4);
					 * JLabel label5 = new
					 * JLabel("Date of Journey :"+travelDate); YES.add(label5);
					 * JLabel label6 = new JLabel("Total fare :"+total_fare);
					 * YES.add(label6); JLabel label7 = new
					 * JLabel("Wish you a safe journey. Meals and Beverages will be served "
					 * ); YES.add(label7); YES.setSize(500, 500);
					 * YES.setVisible(true);
					 */

				} else if (!canBook) {
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					canBook = true;
				}
			}
		});
		btnMakePayment.setBounds(447, 364, 132, 23);
		btnMakePayment.setVisible(false);
		contentPane.add(btnMakePayment);
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number");
		lblCreditCardNumber.setBounds(10, 368, 111, 20);
		lblCreditCardNumber.setVisible(false);
		contentPane.add(lblCreditCardNumber);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(124, 364, 275, 20);
		textField_4.setVisible(false);
		contentPane.add(textField_4);

		JLabel lblEnterDigit = new JLabel("Enter 16 digit number");
		lblEnterDigit.setBounds(59, 329, 221, 20);
		lblEnterDigit.setVisible(false);
		contentPane.add(lblEnterDigit);
		JButton btnNewButton_1 = new JButton("Book Flight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				java.sql.Date sqlDate = null;
				java.util.Date utilDate = null;
				java.util.Date today = new Date();
				String time = "";

				int dialogButton = 0;
				int dialogResult = 0;
				try {

					fName = textField_1.getText();
					lName = textField_2.getText();
					age = Integer.parseInt(textField_5.getText());
					gender = textField_3.getText();
					utilDate = format.parse(textField.getText());
					travelDate = new java.sql.Date(utilDate.getTime());
					// travelDate=utilDate;
					System.out.println("travelDate =" + travelDate.toString());
					time = format.format(today);
					bookDate = new java.sql.Date(today.getTime());
					// bookDate=format.parse(time);
					System.out.println("bookDate =" + bookDate.toString());
					// checkScheduledFlight();
					// System.out.println(sqlDate);
				} catch (ParseException e) {

					message = "Please enter  details with valid values";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					System.out.println(e.getMessage());
				} catch (Exception e) {

					message = "Please enter all details with valid values";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					System.out.println(e.getMessage());
				}
				// SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
				// java.sql.Date travelDate= new java.sql.Date();

				Connection conn = null;
				ResultSet rs = null;
				try {
					if (utilDate.compareTo(today) < 0 || utilDate.compareTo(today) == 0) {
						message = "Please enter a valid date";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					} else if ((adultNumber == 0) && (childNumber == 0) && (infantNumber == 0)) {
						message = "Please enter number of adults/children/infants";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					} else if ((fName.equals("")) || (lName.equals("")) || (age == 0) || (gender.equals(""))) {

						message = "Please enter all details with valid values";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					} else {

						dialogButton = JOptionPane.YES_NO_OPTION;
						dialogResult = JOptionPane.showConfirmDialog(null, "Proceed with Booking?", "Warning",
								dialogButton);
						if (dialogResult == JOptionPane.YES_OPTION) {
							// Saving code here
							btnMakePayment.setVisible(true);
							lblCreditCardNumber.setVisible(true);
							textField_4.setVisible(true);
							lblEnterDigit.setVisible(true);
						}
					}

				} catch (Exception ex) {
					message = "Check the values you entered";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					System.out.println(ex.getMessage());
				}

			}
		});
		btnNewButton_1.setBounds(288, 297, 125, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("DOMESTIC FLIGHT BOOKING");
		lblNewLabel.setBounds(140, 0, 230, 14);
		contentPane.add(lblNewLabel);

		Integer[] adultNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		JComboBox comboBox_2 = new JComboBox(adultNum);
		ItemListener itemListener = new ItemListener() {

			// To get user selected value
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				adultNumber = ((Integer) itemEvent.getItem()).intValue();

			}
		};
		comboBox_2.addItemListener(itemListener);
		comboBox_2.setBounds(10, 173, 111, 20);
		contentPane.add(comboBox_2);

		JLabel lblNumberOfChildren = new JLabel("Number of children (2-12)");
		lblNumberOfChildren.setBounds(192, 142, 160, 20);
		contentPane.add(lblNumberOfChildren);

		Integer[] childNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		JComboBox comboBox_3 = new JComboBox(childNum);
		ItemListener itemListener1 = new ItemListener() {

			// To get user selected value
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				childNumber = ((Integer) itemEvent.getItem()).intValue();

			}
		};
		comboBox_3.addItemListener(itemListener1);
		comboBox_3.setBounds(202, 173, 111, 20);
		contentPane.add(comboBox_3);

		JLabel lblNumberOfInfants = new JLabel("Number of Infants (0-12)");
		lblNumberOfInfants.setBounds(369, 142, 160, 20);
		contentPane.add(lblNumberOfInfants);

		Integer[] infantNum = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		JComboBox comboBox_4 = new JComboBox(infantNum);
		comboBox_4.setBounds(369, 173, 111, 20);
		contentPane.add(comboBox_4);
		ItemListener itemListener2 = new ItemListener() {

			// To get user selected value
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				infantNumber = ((Integer) itemEvent.getItem()).intValue();

			}
		};
		comboBox_4.addItemListener(itemListener2);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(237, 16, 137, 118);
		contentPane.add(panel_1);

		JLabel lblMealPseatType = new JLabel("Travel Class");
		lblMealPseatType.setBounds(28, 16, 103, 14);
		panel_1.add(lblMealPseatType);

		JRadioButtonMenuItem rdbtnmntmBusiness = new JRadioButtonMenuItem("Business");
		buttonGroup.add(rdbtnmntmBusiness);
		rdbtnmntmBusiness.setSelected(true);
		rdbtnmntmBusiness.setBounds(6, 51, 125, 22);
		panel_1.add(rdbtnmntmBusiness);

		JRadioButtonMenuItem rdbtnmntmEconomy = new JRadioButtonMenuItem("Economy");
		buttonGroup.add(rdbtnmntmEconomy);
		rdbtnmntmEconomy.setBounds(6, 89, 125, 22);
		panel_1.add(rdbtnmntmEconomy);
		ChangeListener changeListener1 = new ChangeListener() {
			public void stateChanged(ChangeEvent changEvent) {
				AbstractButton aButton = (AbstractButton) changEvent.getSource();
				ButtonModel aModel = aButton.getModel();
				boolean armed = aModel.isArmed();
				boolean pressed = aModel.isPressed();
				boolean selected = aModel.isSelected();
				// System.out.println("Changed: " + armed + "/" + pressed + "/"
				// +
				// selected);
				System.out.println("Selected flight class: " + selected);
				if (selected || armed || pressed) {
					System.out.println("Flight Class is " + getSelectedButtonTextClass(buttonGroup));
					flightClass = getSelectedButtonTextClass(buttonGroup);
				}
			}
		};

		rdbtnmntmEconomy.addChangeListener(changeListener1);
		rdbtnmntmBusiness.addChangeListener(changeListener1);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 223, 103, 20);
		contentPane.add(lblFirstName);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(88, 223, 103, 20);
		contentPane.add(textField_1);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(266, 223, 103, 20);
		contentPane.add(lblLastName);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(390, 223, 103, 20);
		contentPane.add(textField_2);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 254, 103, 20);
		contentPane.add(lblGender);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(88, 254, 103, 20);
		contentPane.add(textField_3);

		JLabel lblEnterMf = new JLabel("Enter M/F");
		lblEnterMf.setBounds(111, 283, 103, 20);
		contentPane.add(lblEnterMf);

		JLabel lblDdmmyyyy = new JLabel("dd/mm/yyyy");
		lblDdmmyyyy.setBounds(134, 120, 103, 20);
		contentPane.add(lblDdmmyyyy);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(263, 254, 103, 20);
		contentPane.add(lblAge);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(390, 254, 103, 20);
		contentPane.add(textField_5);
	}

	public String getSelectedButtonTextClass(ButtonGroup buttonGroup) {

		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				flightClass = button.getText();
			}
		}

		return flightClass;
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		// String mealPref = "";
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				mealPref = button.getText();
			}
		}

		return mealPref;
	}

	private void checkScheduledFlight() {
		try {

			ConnectionMySql connClass = new ConnectionMySql();
			Connection conn = connClass.getConnection();
			Statement statement = conn.createStatement();
			String sqlSchedule = "select flightdate from scheduledflights where flightno = \"" + flightNum + "\";";
			java.sql.Date schedDate = null;
			String scheduleDate = "";
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			java.util.Date utilDate = format.parse(textField.getText());

			travelDate = new java.sql.Date(utilDate.getTime());
			// travelDate=utilDate;
			System.out.println("travelDate =" + travelDate.toString());
			ResultSet rs = statement.executeQuery(sqlSchedule);
			// Get row data
			while (rs.next()) {
				schedDate = rs.getDate(1);
				System.out.println("schedDate =" + schedDate);
				System.out.println("travelDate =" + travelDate);
				if (!(schedDate.toString().equalsIgnoreCase(travelDate.toString()))) {
					String message = "Sorry No flights on the chosen date. Check Schedule and Book flight";
					int dialogResult = JOptionPane.showConfirmDialog(null, message);
					contentPane.repaint();
					canBook = false;
				}
				// schedId=rs.getString(2);
			}

			statement.close();
			// conn.close();
			connClass.destroyConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void checkSeatAvailability() {
		int totalPassenger = adultNumber + childNumber;
		String sqlSeatEco = "", sqlSeatBus = "", sqlEco = "", sqlBus = "", schedId = "";
		int seatAvlBus = 0, seatAvlEco = 0;
		boolean isBus = false, isEco = false;
		ResultSet rs = null;
		if (flightClass.equalsIgnoreCase("Economy")) {
			sqlSeatEco = "Select ecsavailable from scheduledflights where flightno =\"" + flightNum + "\";";

			isEco = true;
		} else if (flightClass.equalsIgnoreCase("Business")) {
			sqlSeatBus = "Select bcsavailable from scheduledflights where flightno =\"" + flightNum + "\";";
			isBus = true;
		}
		try {

			ConnectionMySql connClass = new ConnectionMySql();
			Connection conn = connClass.getConnection();
			Statement statement = conn.createStatement();
			if (isEco) {
				rs = statement.executeQuery(sqlSeatEco);
				// Get row data
				while (rs.next()) {
					seatAvlEco = rs.getInt(1);
					// schedId=rs.getString(2);
				}
				// if (seatAvlEco > totalPassenger) {
				// Statement statement1 = conn.createStatement();
				// sqlEco = "Update scheduledflights set ecsavailable = " +
				// (seatAvlEco - totalPassenger) +" where scheduleId = \""+
				// schedId+"\";";
				// statement1.executeUpdate(sqlEco);
				// } else
				if (seatAvlEco < totalPassenger) {
					String message = "Sorry Economy Seats Not Available. You may try business. Do you want to continue";
					int dialogResult = JOptionPane.showConfirmDialog(null, message);
					contentPane.repaint();

				}
			} else if (isBus) {
				rs = statement.executeQuery(sqlSeatBus);
				// Get row data
				while (rs.next()) {
					seatAvlBus = rs.getInt(1);
					// schedId=rs.getString(2);
				}
				// if (seatAvlBus > totalPassenger) {
				// Statement statement1 = conn.createStatement();
				// sqlBus = "Update scheduledflights set bcsavailable = " +
				// (seatAvlBus - totalPassenger)+" where scheduleId = \""+
				// schedId+"\";";
				// statement1.executeUpdate(sqlBus);
				// } else
				if (seatAvlBus < totalPassenger) {
					String message = "Sorry Business Seats Not Available.You may try economy. Do you want to continue";
					int dialogResult = JOptionPane.showConfirmDialog(null, message);
					contentPane.repaint();

				}
			}

			statement.close();
			// conn.close();
			connClass.destroyConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void updateSeat() {
		int totalPassenger = adultNumber + childNumber;
		String sqlSeatEco = "", sqlSeatBus = "", sqlEco = "", sqlBus = "", schedId = "";
		int seatAvlBus = 0, seatAvlEco = 0;
		boolean isBus = false, isEco = false;
		ResultSet rs = null;
		if (flightClass.equalsIgnoreCase("Economy")) {
			sqlSeatEco = "Select ecsavailable,scheduleId from scheduledflights where flightno =\"" + flightNum + "\";";

			isEco = true;
		} else if (flightClass.equalsIgnoreCase("Business")) {
			sqlSeatBus = "Select bcsavailable,scheduleId from scheduledflights where flightno =\"" + flightNum + "\";";
			isBus = true;
		}
		try {

			ConnectionMySql connClass = new ConnectionMySql();
			Connection conn = connClass.getConnection();
			Statement statement = conn.createStatement();
			if (isEco) {
				rs = statement.executeQuery(sqlSeatEco);
				// Get row data
				while (rs.next()) {
					seatAvlEco = rs.getInt(1);
					schedId = rs.getString(2);
				}
				if (seatAvlEco > totalPassenger) {
					Statement statement1 = conn.createStatement();
					sqlEco = "Update scheduledflights set ecsavailable = " + (seatAvlEco - totalPassenger)
							+ " where scheduleId = \"" + schedId + "\";";
					statement1.executeUpdate(sqlEco);
				}
			} else if (isBus) {
				rs = statement.executeQuery(sqlSeatBus);
				// Get row data
				while (rs.next()) {
					seatAvlBus = rs.getInt(1);
					schedId = rs.getString(2);
				}
				if (seatAvlBus > totalPassenger) {
					Statement statement1 = conn.createStatement();
					sqlBus = "Update scheduledflights set bcsavailable = " + (seatAvlBus - totalPassenger)
							+ " where scheduleId = \"" + schedId + "\";";
					statement1.executeUpdate(sqlBus);
				}
			}

			statement.close();
			// conn.close();
			connClass.destroyConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void insertRecords() {
		try {
			System.out.println("Name is " + fName);
			System.out.println("class is" + flightClass);
			// System.out.println("pnrNum is"+pnrNum);
			pnrNum = fName.substring(0, 1) + flightClass.substring(0, 1) + age + travelDate.toString().substring(0, 4)
					+ bookDate.toString().substring(0, 2);
			char gen = gender.charAt(0);
			System.out.println("flightnumber =" + flightNum);
			String sqlPassengers = "Insert into passengers (pnrno,flightno, traveldate,fname,lname,age,gender,class,mealpref,status,No_Adults,No_Child, No_Infant,bookdate)values(\""
					+ pnrNum + "\",\"" + flightNum + "\",\"" + travelDate.toString() + "\",\"" + fName + "\",\"" + lName
					+ "\"," + age + ",\"" + gender + "\",\"" + flightClass + "\",\"" + mealPref + "\",\"booked\","
					+ adultNumber + "," + childNumber + "," + infantNumber + ",\"" + bookDate.toString() + "\");";
			System.out.println(sqlPassengers);
			String sqlDailyCollections = "Insert into dailycollections(pnrno,trandate,trantype,amount) values (\""
					+ pnrNum + "\",\"" + travelDate.toString() + "\",\" online \"," + total_fare + ");";
			// flighttype = 'International'";
			System.out.println(sqlDailyCollections);
			ConnectionMySql connClass = new ConnectionMySql();
			Connection conn = connClass.getConnection();
			Statement statement = conn.createStatement();
			statement.executeUpdate(sqlPassengers);
			statement.executeUpdate(sqlDailyCollections);
			//
			// rs = statement.executeQuery(sql);
			//
			// // Get row data
			// while (rs.next()) {
			// comboBox.addItem(rs.getString(1));
			// comboBox_1.addItem(rs.getString(2));
			// }
			//
			statement.close();
			// // conn.close();
			connClass.destroyConnection(conn);
			//
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		//
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void calculateFare() {
		int totalPassenger = adultNumber + childNumber;
		System.out.println("adultNumber=" + adultNumber);
		System.out.println("childNumber=" + childNumber);
		System.out.println("infantNumber=" + infantNumber);
		String sqlFare = "";
		double fare = 0.0, fare_child = 0.0;
		if (flightClass.equalsIgnoreCase("Economy")) {

			sqlFare = "Select efare from Sector where SectorId =\"" + sectorId + "\";";
		} else if (flightClass.equalsIgnoreCase("Business")) {
			sqlFare = "Select bfare from Sector where SectorId =\"" + sectorId + "\";";
		}
		try {

			ConnectionMySql connClass = new ConnectionMySql();
			Connection conn = connClass.getConnection();
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery(sqlFare);

			// Get row data
			while (rs.next()) {
				fare = rs.getDouble(1);

			}

			statement.close();
			// conn.close();
			connClass.destroyConnection(conn);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		if (childNumber > 0) {
			fare_child = ((fare * 85) / 100) * childNumber;
		}
		long diff = travelDate.getTime() - bookDate.getTime();
		System.out.println("diff long=" + diff);
		int diffInDays = ((int) diff) / (1000 * 60 * 60 * 24);
		System.out.println("diff days=" + diffInDays);
		if (diffInDays < 3) {
			fare = (fare * 130) / 100;
			String message = "Your travel date is within three days. You will be charged 30 % extra";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
		}
		total_fare = fare * adultNumber + fare_child * childNumber;

	}
}
