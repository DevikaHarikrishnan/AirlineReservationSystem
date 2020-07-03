package com.skps.airlinereservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.skps.ars.utilities.ConnectionMySql;

import javax.swing.UIManager;

/*
 * Main class for admin login and for customer flight ticket booking, search and cancellation
 */
public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private static String userPref = "", userSel = "", userChoice = "";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {// invoking the constructor
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. The constructor
	 */
	public LoginPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 529, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Admin Login",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(221, 140, 203, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label = new JLabel("User Name");
		label.setBounds(7, 52, 92, 14);
		panel_1.add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(6, 80, 86, 14);
		panel_1.add(label_1);

		textField_1 = new JTextField();
		textField_1.setBounds(109, 46, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(111, 77, 86, 20);
		panel_1.add(passwordField_1);

		JButton btnLogin_1 = new JButton("Login");
		btnLogin_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// action performed
															// when user clicks
															// login
				try {
					String dbPwd = "";
					String username = textField_1.getText();
					System.out.println("username=" + username);
					char[] password = passwordField_1.getPassword();
					char[] dbPwd1 = new char[20];
					System.out.println("password=" + password);
					// invoking the utility class for creating connection
					ConnectionMySql connClass = new ConnectionMySql();
					Connection conn = connClass.getConnection();
					Statement statement = conn.createStatement();
					// query to get password for the logged in user from db
					String sqlUserProfile = "select password from user_profile where username = \"" + username + "\";";
					ResultSet rs = statement.executeQuery(sqlUserProfile);

					while (rs.next()) {
						dbPwd = rs.getString(1);
						dbPwd1 = dbPwd.toCharArray();
						System.out.println("DB pwd= " + dbPwd1);

						// schedId=rs.getString(2);
					}

					statement.close();
					// conn.close();
					connClass.destroyConnection(conn);
					// if password matches, allow user to login
					if (Arrays.equals(password, dbPwd1)) {
						System.out.println("passwords match");
						Admin_AddFlight adminFlight = new Admin_AddFlight();
						adminFlight.setVisible(true);
					} else {// else show error message and prompt user to
							// re-enter correct details
						String message = "Unsuccessful login. Re-enter correct details";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		btnLogin_1.setBounds(71, 105, 89, 23);
		panel_1.add(btnLogin_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Passenger Action",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 140, 154, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Domestic");
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(30, 286, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setVisible(false);
		JLabel lblNewLabel = new JLabel("Choose Domestic or International ");
		lblNewLabel.setBounds(304, 290, 195, 14);
		lblNewLabel.setVisible(false);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = "";
				if (userPref.equalsIgnoreCase("Book Flight")) {

					if (userChoice.equalsIgnoreCase("International")) {
						InternationalFlightBooking international = new InternationalFlightBooking();
						international.setVisible(true);
					} else if (userChoice.equalsIgnoreCase("domestic")) {
						DomesticBookingDetails domestic = new DomesticBookingDetails();
						domestic.setVisible(true);
					}

				} else if (userPref.equalsIgnoreCase("Cancel Booking")) {
					CancelBooking cancelBooking = new CancelBooking();
					cancelBooking.setVisible(true);
				} else if (userPref.equalsIgnoreCase("Search Flight")) {

					if (userChoice.equalsIgnoreCase("International")) {
						SearchFlights_International searchInternational = new SearchFlights_International();
						searchInternational.setVisible(true);
					} else if (userChoice.equalsIgnoreCase("domestic")) {
						SearchFlights_Domestic searchDomestic = new SearchFlights_Domestic();
						searchDomestic.setVisible(true);
					}
				}
			}
		});
		btnNewButton.setBounds(10, 105, 89, 23);
		btnNewButton.setVisible(false);
		panel.add(btnNewButton);

		JRadioButton rdbtnInternational = new JRadioButton("International");
		buttonGroup_1.add(rdbtnInternational);
		rdbtnInternational.setBounds(141, 286, 119, 23);
		contentPane.add(rdbtnInternational);
		rdbtnInternational.setVisible(false);
		ChangeListener changeListener1 = new ChangeListener() {
			public void stateChanged(ChangeEvent changEvent) {
				AbstractButton aButton = (AbstractButton) changEvent.getSource();
				ButtonModel aModel = aButton.getModel();
				boolean armed = aModel.isArmed();
				boolean pressed = aModel.isPressed();
				boolean selected = aModel.isSelected();
				System.out.println("Selected: " + selected);
				if (selected) {
					btnNewButton.setVisible(true);
					System.out.println("User Choice is " + getSelectedButtonText(buttonGroup_1));
					userChoice = getSelectedButtonText(buttonGroup_1);
				}
			}
		};

		JRadioButton rdbtnBookFlight = new JRadioButton("Book Flight");
		rdbtnBookFlight.setBounds(6, 24, 109, 23);
		panel.add(rdbtnBookFlight);
		buttonGroup.add(rdbtnBookFlight);

		JRadioButton rdbtnCancelFlight = new JRadioButton("Cancel Booking");
		rdbtnCancelFlight.setBounds(6, 48, 109, 23);
		panel.add(rdbtnCancelFlight);
		buttonGroup.add(rdbtnCancelFlight);

		JRadioButton rdbtnSearchFlight = new JRadioButton("Search Flight");
		rdbtnSearchFlight.setBounds(6, 71, 109, 23);
		panel.add(rdbtnSearchFlight);
		buttonGroup.add(rdbtnSearchFlight);
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
					rdbtnNewRadioButton.setVisible(true);
					rdbtnInternational.setVisible(true);
					lblNewLabel.setVisible(true);
					System.out.println("User preference is " + getSelectedButtonText(buttonGroup));
					userPref = getSelectedButtonText(buttonGroup);
				}
			}
		};
		rdbtnBookFlight.addChangeListener(changeListener);
		rdbtnCancelFlight.addChangeListener(changeListener);
		rdbtnSearchFlight.addChangeListener(changeListener);

		rdbtnNewRadioButton.addChangeListener(changeListener1);
		rdbtnInternational.addChangeListener(changeListener1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(
				"E:\\devi\\class 10 icse\\computer\\project\\18 Oct\\New Project ARS\\New folder\\AirlineDevika\\Airline-Reservation-System.jpg"));
		lblNewLabel_2.setBackground(Color.CYAN);
		lblNewLabel_2.setBounds(39, -15, 445, 144);
		contentPane.add(lblNewLabel_2);

	}

	// Method to get user selected value from radiobutton group. returns
	// selected value
	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		// String mealPref = "";
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				userSel = button.getText();
			}
		}

		return userSel;
	}
}
