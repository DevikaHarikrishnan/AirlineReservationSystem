package com.skps.airlinereservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.skps.ars.utilities.ConnectionMySql;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;

public class Admin_AddFlight extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JTextField textField_7;
	private JLabel label_1;
	private JTextField textField_8;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel lblAircraftType;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel label_7;
	private JTextField textField_14;
	private JPanel panel_2;
	private JButton btnSubmit;
	private JButton button;
	private JButton btnSubmit_1;
	private JPanel panel_4;
	private JPanel panel_21;
	private JPanel panel_5, panel_6, panel_13, panel_14;
	private JTabbedPane tabbedPane;
	private JPanel panel_9;
	private JLabel lblScheduleId_1;
	private JLabel label_11;
	private JLabel lblFlightDate;
	private JLabel lblBusinessSeats_1;
	private JLabel lblEconomySeats_1;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JButton btnAddScheduledFlight;
	private JLabel lblScheduleId;
	private JTextField textField_32;
	private JButton btnDeleteScheduledFlight;
	private JPanel panel_12;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTable table_1;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTable table_2;
	private JTable table;
	private JTable table_3;
	private JTextField textField_82;
	private JTextField textField_83;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JPanel panel_25;
	private JLabel label_44;
	private JTextField textField_87;
	private JLabel label_45;
	private JTextField textField_88;
	private JLabel label_46;
	private JLabel label_47;
	private JLabel label_48;
	private JTextField textField_89;
	private JTextField textField_90;
	private JTextField textField_91;
	private JButton button_2;
	private JPanel panel_26;
	private JLabel lblFlightNumber_2;
	private JTextField textField_92;
	private JButton button_3;
	private JTable table_4;
	private JTable table_5;
	private JTable table_6;
	private JTable table_7;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JLabel lblNewLabel_1;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_AddFlight frame = new Admin_AddFlight();
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
	public Admin_AddFlight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1298, 717);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		tabbedPane.setBounds(17, 5, 1269, 645);
		contentPane.add(tabbedPane);

		panel_21 = new JPanel();
		tabbedPane.addTab("Flight Transaction", null, panel_21, null);
		panel_21.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_21.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 313, 348, 272);
		panel_21.add(panel_3);

		JLabel lblFlightNumber_1 = new JLabel("Flight Number");
		lblFlightNumber_1.setBounds(6, 19, 83, 14);
		panel_3.add(lblFlightNumber_1);

		textField_82 = new JTextField();
		textField_82.setColumns(10);
		textField_82.setBounds(125, 16, 217, 20);
		panel_3.add(textField_82);

		JLabel lblDepartureTime = new JLabel("Departure Time");
		lblDepartureTime.setBounds(6, 49, 110, 14);
		panel_3.add(lblDepartureTime);

		textField_83 = new JTextField();
		textField_83.setColumns(10);
		textField_83.setBounds(125, 47, 217, 20);
		panel_3.add(textField_83);

		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(6, 84, 110, 14);
		panel_3.add(lblArrivalTime);

		JLabel lblAircraftTypeid = new JLabel("Aircraft TypeId");
		lblAircraftTypeid.setBounds(6, 117, 110, 14);
		panel_3.add(lblAircraftTypeid);

		JLabel lblSectorid = new JLabel("SectorId");
		lblSectorid.setBounds(6, 150, 110, 14);
		panel_3.add(lblSectorid);

		textField_84 = new JTextField();
		textField_84.setColumns(10);
		textField_84.setBounds(125, 81, 217, 20);
		panel_3.add(textField_84);

		textField_85 = new JTextField();
		textField_85.setColumns(10);
		textField_85.setBounds(125, 114, 217, 20);
		panel_3.add(textField_85);

		textField_86 = new JTextField();
		textField_86.setColumns(10);
		textField_86.setBounds(125, 147, 217, 20);
		panel_3.add(textField_86);

		JButton button_1 = new JButton("Submit");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String flightno = textField_82.getText();
				String depTime = textField_83.getText();
				String arrTime = textField_84.getText();
				String aircraftId = textField_85.getText();
				String sectorId = textField_86.getText();

				if (flightno != null) {
					String sqlFlight = "Insert into flights (flightno,deptime, arrtime,aircrafttypeID,sectorID)values(\""
							+ flightno + "\",\"" + depTime + "\",\"" + arrTime + "\",\""
							+ aircraftId + "\",\"" + sectorId + "\");";
					try {
						System.out.println(sqlFlight);
						ConnectionMySql connClass = new ConnectionMySql();
						Connection conn = connClass.getConnection();
						Statement statement = conn.createStatement();
						statement.executeUpdate(sqlFlight);
						statement.close();
						connClass.destroyConnection(conn);
						JOptionPane.showMessageDialog(null, "Successfully inserted");
						//
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					//
					catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String message = "Enter a valid not null flight number";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		button_1.setBounds(112, 199, 89, 23);
		panel_3.add(button_1);

		panel_25 = new JPanel();
		panel_25.setLayout(null);
		panel_25.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modify Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_25.setBounds(826, 332, 348, 272);
		panel_21.add(panel_25);

		label_44 = new JLabel("Flight Number");
		label_44.setBounds(6, 19, 83, 14);
		panel_25.add(label_44);

		textField_87 = new JTextField();
		textField_87.setColumns(10);
		textField_87.setBounds(125, 16, 217, 20);
		panel_25.add(textField_87);

		label_45 = new JLabel("Departure Time");
		label_45.setBounds(6, 49, 110, 14);
		panel_25.add(label_45);

		textField_88 = new JTextField();
		textField_88.setColumns(10);
		textField_88.setBounds(125, 47, 217, 20);
		panel_25.add(textField_88);

		label_46 = new JLabel("Arrival Time");
		label_46.setBounds(6, 84, 110, 14);
		panel_25.add(label_46);

		label_47 = new JLabel("Aircraft TypeId");
		label_47.setBounds(6, 117, 110, 14);
		panel_25.add(label_47);

		label_48 = new JLabel("SectorId");
		label_48.setBounds(6, 150, 110, 14);
		panel_25.add(label_48);

		textField_89 = new JTextField();
		textField_89.setColumns(10);
		textField_89.setBounds(125, 81, 217, 20);
		panel_25.add(textField_89);

		textField_90 = new JTextField();
		textField_90.setColumns(10);
		textField_90.setBounds(125, 114, 217, 20);
		panel_25.add(textField_90);

		textField_91 = new JTextField();
		textField_91.setColumns(10);
		textField_91.setBounds(125, 147, 217, 20);
		panel_25.add(textField_91);

		button_2 = new JButton("Submit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String flightno = textField_87.getText();
				String depTime = textField_88.getText();
				String arrTime = textField_89.getText();
				String aircraftId = textField_90.getText();
				String sectorId = textField_91.getText();

				System.out.println("flightno=" + flightno);
				String sqlModifyFlight = "Update flights set depTime= \"" + depTime + "\", arrTime= \"" + arrTime
						+ "\", aircrafttypeID=\"" + aircraftId + "\",sectorID= \"" + sectorId + "\" where flightno= \""
						+ flightno + "\";";
				if (flightno != null) {
					if (!(flightno.trim().equalsIgnoreCase(""))) {
						try {
							System.out.println(sqlModifyFlight);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlModifyFlight);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully modified");
							//
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
						//
						catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						String message = "Enter a valid flight number";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid flight number";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		button_2.setBounds(112, 199, 89, 23);
		panel_25.add(button_2);

		panel_26 = new JPanel();
		panel_26.setLayout(null);
		panel_26.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Delete Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_26.setBounds(404, 504, 348, 85);
		panel_21.add(panel_26);

		lblFlightNumber_2 = new JLabel("Flight Number");
		lblFlightNumber_2.setBounds(6, 19, 83, 14);
		panel_26.add(lblFlightNumber_2);

		textField_92 = new JTextField();
		textField_92.setColumns(10);
		textField_92.setBounds(125, 16, 217, 20);
		panel_26.add(textField_92);

		button_3 = new JButton("Submit");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String flightNo = textField_92.getText();
				if (flightNo != null) {
					if (!flightNo.trim().equalsIgnoreCase("")) {
						String sqlDelFlights = "Delete from flights where flightNo= \"" + flightNo + "\"";
						try {
							System.out.println(sqlDelFlights);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlDelFlights);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully deleted");
							//
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
						//
						catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						String message = "Enter a valid flight number";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid flight number";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		button_3.setBounds(104, 51, 89, 23);
		panel_26.add(button_3);

		Connection conn2 = null;
		ArrayList columnNames2 = new ArrayList();
		ArrayList data2 = new ArrayList();
		ResultSet rs2;
		ResultSetMetaData md2;
		DefaultTableModel model2 = new DefaultTableModel();
		try {
			String sql2 = "select flightno,deptime,arrtime,aircrafttypeID,sectorID from flights";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn2 = connClass.getConnection();
			Statement statement2 = conn2.createStatement();

			rs2 = statement2.executeQuery(sql2);
			md2 = rs2.getMetaData();
			int columns2 = md2.getColumnCount();
			System.out.print("column count: " + columns2);

			// Get column names
			for (int i = 1; i <= columns2; i++) {
				System.out.print("column name: " + md2.getColumnName(i));
				columnNames2.add(md2.getColumnName(i).toUpperCase());

			}

			model2.setColumnIdentifiers(columnNames2.toArray());
			// Get row data
			while (rs2.next()) {
				ArrayList row2 = new ArrayList(columns2);

				for (int i = 1; i <= columns2; i++) {
					row2.add(rs2.getObject(i));

				}

				data2.add(row2);
			}
			for (int i = 0; i < data2.size(); i++) {
				ArrayList subArray2 = (ArrayList) data2.get(i);

				model2.addRow(subArray2.toArray());
			}

			statement2.close();
			// conn.close();
			connClass.destroyConnection(conn2);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		table_6 = new JTable();
		table_6.setBounds(29, 24, 1201, 289);
		table_6.setBackground(Color.gray);

		table_6.setModel(model2);
		table_6.setColumnSelectionAllowed(true);
		table_6.setCellSelectionEnabled(true);
		table_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_6.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_6.setFillsViewportHeight(true);
		table_6.setVisible(true);
		panel_21.add(table_6);
		panel_5 = new JPanel();
		tabbedPane.addTab("Booking Details", null, panel_5, null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(null);

		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_23.setBounds(40, 2, 1189, 294);
		panel_5.add(panel_23);
		panel_23.setLayout(null);

		Connection conn = null;
		ArrayList columnNames = new ArrayList();
		ArrayList data = new ArrayList();
		ResultSet rs;
		ResultSetMetaData md;
		DefaultTableModel model = new DefaultTableModel();
		try {
			String sql = "select * from passengers";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn = connClass.getConnection();
			Statement statement = conn.createStatement();

			rs = statement.executeQuery(sql);
			md = rs.getMetaData();
			int columns = md.getColumnCount();
			System.out.print("column count: " + columns);

			// Get column names
			for (int i = 1; i <= columns; i++) {
				System.out.print("column name: " + md.getColumnName(i));
				columnNames.add(md.getColumnName(i).toUpperCase());

			}

			model.setColumnIdentifiers(columnNames.toArray());
			// Get row data
			while (rs.next()) {
				ArrayList row = new ArrayList(columns);

				for (int i = 1; i <= columns; i++) {
					row.add(rs.getObject(i));

				}

				data.add(row);
			}
			for (int i = 0; i < data.size(); i++) {
				ArrayList subArray = (ArrayList) data.get(i);

				model.addRow(subArray.toArray());
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
		table = new JTable();
		table.setBounds(6, 46, 1177, 241);
		table.setBackground(Color.CYAN);

		table.setModel(model);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setVisible(true);
		panel_23.add(table);
		/*
		 * setResizable(false);
		 * setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE); setBounds(100, 100,
		 * 816, 303); contentPane = new JPanel(); contentPane.setBorder(new
		 * LineBorder(new Color(0, 0, 0))); setContentPane(contentPane);
		 * contentPane.setLayout(null); Connection conn = null; ArrayList
		 * columnNames = new ArrayList(); ArrayList data = new ArrayList();
		 * ResultSet rs; ResultSetMetaData md;
		 * 
		 * DefaultTableModel model = new DefaultTableModel(); try { String sql =
		 * "select a.flightno, a.flightdate ,b.deptime, b.arrtime, c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare from scheduledflights a, flights b, aircraft c ,sector d where a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and b.sectorId=d.sectorId and c.aircraftType=\"Domestic\""
		 * ; //String sql =
		 * "select a.flightno, a.flightdate ,b.deptime, b.arrtime, c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare from scheduledflights a, flights b, aircraft c ,sector d where a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and b.sectorId=d.sectorId and c.aircraftType=\"International\""
		 * ;"; ConnectionMySql connClass = new ConnectionMySql(); conn =
		 * connClass.getConnection(); Statement statement =
		 * conn.createStatement();
		 * 
		 * rs = statement.executeQuery(sql); md = rs.getMetaData(); int columns
		 * = md.getColumnCount(); System.out.print("column count: " + columns);
		 * 
		 * // Get column names for (int i = 1; i <= columns; i++) {
		 * System.out.print("column name: " + md.getColumnName(i));
		 * columnNames.add(md.getColumnName(i).toUpperCase());
		 * 
		 * }
		 * 
		 * model.setColumnIdentifiers(columnNames.toArray()); // Get row data
		 * while (rs.next()) { ArrayList row = new ArrayList(columns);
		 * 
		 * for (int i = 1; i <= columns; i++) { row.add(rs.getObject(i));
		 * 
		 * }
		 * 
		 * data.add(row); } for (int i = 0; i < data.size(); i++) { ArrayList
		 * subArray = (ArrayList) data.get(i);
		 * 
		 * model.addRow(subArray.toArray()); }
		 * 
		 * statement.close(); // conn.close();
		 * connClass.destroyConnection(conn);
		 * 
		 * } catch (SQLException e) { System.out.println(e.getMessage()); }
		 * 
		 * catch (Exception e) { e.printStackTrace(); }
		 * 
		 * table_1 = new JTable(); table_1.setBackground(Color.CYAN);
		 * 
		 * table_1.setModel(model); table_1.setColumnSelectionAllowed(true);
		 * table_1.setCellSelectionEnabled(true); table_1.setBorder(new
		 * LineBorder(new Color(0, 0, 0)));
		 * table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 * table_1.setFillsViewportHeight(true); table_1.setVisible(true);
		 * JScrollPane scrollPane = new JScrollPane(); scrollPane.setSize(760,
		 * 200); scrollPane.setLocation(50, 50);
		 * scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0))); //
		 * scrollPane.setBounds(40, 62, 676, 0);
		 * scrollPane.setViewportView(table_1);
		 * scrollPane.setHorizontalScrollBarPolicy(JScrollPane.
		 * HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 * scrollPane.setVerticalScrollBarPolicy(JScrollPane.
		 * VERTICAL_SCROLLBAR_AS_NEEDED); scrollPane.setVisible(true);
		 * contentPane.add(scrollPane);
		 */

		JLabel lblNewLabel_7 = new JLabel("Show Booking Details");
		lblNewLabel_7.setBounds(307, 16, 170, 14);
		panel_23.add(lblNewLabel_7);

		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_24.setBounds(34, 291, 1189, 295);
		panel_5.add(panel_24);
		panel_24.setLayout(null);
		Connection conn1 = null;
		ArrayList columnNames1 = new ArrayList();
		ArrayList data1 = new ArrayList();
		ResultSet rs1;
		ResultSetMetaData md1;

		DefaultTableModel model1 = new DefaultTableModel();

		try {
			String sql1 = "select * from dailycollections";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn1 = connClass.getConnection();
			Statement statement1 = conn1.createStatement();

			rs1 = statement1.executeQuery(sql1);
			md1 = rs1.getMetaData();
			int columns1 = md1.getColumnCount();
			System.out.print("column count: " + columns1);

			// Get column names
			for (int i = 1; i <= columns1; i++) {
				System.out.print("column name: " + md1.getColumnName(i));
				columnNames1.add(md1.getColumnName(i).toUpperCase());

			}

			model1.setColumnIdentifiers(columnNames1.toArray());
			// Get row data
			while (rs1.next()) {
				ArrayList row1 = new ArrayList(columns1);

				for (int i = 1; i <= columns1; i++) {
					row1.add(rs1.getObject(i));

				}

				data1.add(row1);
			}
			for (int i = 0; i < data.size(); i++) {
				ArrayList subArray1 = (ArrayList) data1.get(i);

				model1.addRow(subArray1.toArray());
			}

			statement1.close();
			// conn.close();
			connClass.destroyConnection(conn1);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		table_3 = new JTable();
		table_3.setBounds(6, 47, 1177, 241);
		table_3.setBackground(Color.CYAN);

		table_3.setModel(model1);
		table_3.setColumnSelectionAllowed(true);
		table_3.setCellSelectionEnabled(true);
		table_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_3.setFillsViewportHeight(true);
		table_3.setVisible(true);
		panel_24.add(table_3);

		JLabel lblNewLabel_6 = new JLabel("Show Collections ");
		lblNewLabel_6.setBounds(307, 16, 212, 20);
		panel_24.add(lblNewLabel_6);

		panel_13 = new JPanel();
		tabbedPane.addTab("Sector Details", null, panel_13, null);
		panel_13.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_13.setLayout(null);

		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Sector",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_19.setBounds(6, 11, 214, 477);
		panel_13.add(panel_19);
		panel_19.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Sector Id");
		lblNewLabel_4.setBounds(6, 19, 67, 14);
		panel_19.add(lblNewLabel_4);

		textField_61 = new JTextField();
		textField_61.setBounds(102, 16, 106, 20);
		panel_19.add(textField_61);
		textField_61.setColumns(10);

		JLabel lblSource = new JLabel("Source");
		lblSource.setBounds(6, 61, 67, 14);
		panel_19.add(lblSource);

		textField_62 = new JTextField();
		textField_62.setBounds(102, 58, 106, 20);
		panel_19.add(textField_62);
		textField_62.setColumns(10);

		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setBounds(6, 106, 67, 14);
		panel_19.add(lblDestination);

		textField_63 = new JTextField();
		textField_63.setBounds(102, 103, 106, 20);
		panel_19.add(textField_63);
		textField_63.setColumns(10);

		JLabel lblWeekDay = new JLabel("Week Day1");
		lblWeekDay.setBounds(6, 152, 67, 14);
		panel_19.add(lblWeekDay);

		textField_64 = new JTextField();
		textField_64.setBounds(102, 149, 106, 20);
		panel_19.add(textField_64);
		textField_64.setColumns(10);

		JLabel lblWeekDay_1 = new JLabel("Week Day2");
		lblWeekDay_1.setBounds(6, 200, 67, 14);
		panel_19.add(lblWeekDay_1);

		textField_65 = new JTextField();
		textField_65.setBounds(102, 197, 106, 20);
		panel_19.add(textField_65);
		textField_65.setColumns(10);

		JLabel lblWeekDay_2 = new JLabel("Week Day3");
		lblWeekDay_2.setBounds(6, 251, 67, 14);
		panel_19.add(lblWeekDay_2);

		textField_66 = new JTextField();
		textField_66.setBounds(102, 248, 106, 20);
		panel_19.add(textField_66);
		textField_66.setColumns(10);

		JLabel lblBusinessFare = new JLabel("Business Fare");
		lblBusinessFare.setBounds(6, 301, 86, 14);
		panel_19.add(lblBusinessFare);

		textField_67 = new JTextField();
		textField_67.setBounds(102, 298, 106, 20);
		panel_19.add(textField_67);
		textField_67.setColumns(10);

		JLabel lblEconomyFare = new JLabel("Economy Fare");
		lblEconomyFare.setBounds(6, 347, 86, 14);
		panel_19.add(lblEconomyFare);

		textField_68 = new JTextField();
		textField_68.setBounds(102, 344, 106, 20);
		panel_19.add(textField_68);
		textField_68.setColumns(10);

		JLabel lblFlightType = new JLabel("Flight Type");
		lblFlightType.setBounds(6, 389, 67, 14);
		panel_19.add(lblFlightType);

		textField_69 = new JTextField();
		textField_69.setBounds(102, 386, 106, 20);
		panel_19.add(textField_69);
		textField_69.setColumns(10);

		JButton btnNewButton_2 = new JButton("Add Sector");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sectorId = textField_61.getText();
				String source = textField_62.getText();
				String destination = textField_63.getText();
				String weekday1 = textField_64.getText();
				String weekday2 = textField_65.getText();
				String weekday3 = textField_66.getText();
				double bfare = Double.parseDouble(textField_67.getText());
				double efare = Double.parseDouble(textField_68.getText());
				String flightType = textField_69.getText();

				String sqlSector = "Insert into sector (sectorID,source, destination,weekday1,weekday2,weekday3,bfare,efare,flightType)values(\""
						+ sectorId + "\",\"" + source + "\",\"" + destination + "\",\"" + weekday1 + "\",\"" + weekday2
						+ "\",\"" + weekday3 + "\"," + bfare + "," + efare + ",\"" + flightType + "\");";
				if (sectorId != null) {
					try {
						System.out.println(sqlSector);
						ConnectionMySql connClass = new ConnectionMySql();
						Connection conn = connClass.getConnection();
						Statement statement = conn.createStatement();
						statement.executeUpdate(sqlSector);
						statement.close();
						connClass.destroyConnection(conn);
						JOptionPane.showMessageDialog(null, "Successfully inserted");
						//
					} catch (SQLException ex) {
						System.out.println(ex.getMessage());
					}
					//
					catch (Exception exc) {
						exc.printStackTrace();
					}
				}

			}

		});
		btnNewButton_2.setBounds(61, 447, 89, 23);
		panel_19.add(btnNewButton_2);

		JPanel panel_20 = new JPanel();
		panel_20.setLayout(null);
		panel_20.setBorder(new TitledBorder(null, "Modify Sector", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_20.setBounds(274, 11, 214, 477);
		panel_13.add(panel_20);

		JLabel label_34 = new JLabel("Sector Id");
		label_34.setBounds(6, 19, 67, 14);
		panel_20.add(label_34);

		textField_70 = new JTextField();
		textField_70.setColumns(10);
		textField_70.setBounds(102, 16, 106, 20);
		panel_20.add(textField_70);

		JLabel label_35 = new JLabel("Source");
		label_35.setBounds(6, 61, 67, 14);
		panel_20.add(label_35);

		textField_71 = new JTextField();
		textField_71.setColumns(10);
		textField_71.setBounds(102, 58, 106, 20);
		panel_20.add(textField_71);

		JLabel label_36 = new JLabel("Destination");
		label_36.setBounds(6, 106, 67, 14);
		panel_20.add(label_36);

		textField_72 = new JTextField();
		textField_72.setColumns(10);
		textField_72.setBounds(102, 103, 106, 20);
		panel_20.add(textField_72);

		JLabel label_37 = new JLabel("Week Day1");
		label_37.setBounds(6, 152, 67, 14);
		panel_20.add(label_37);

		textField_73 = new JTextField();
		textField_73.setColumns(10);
		textField_73.setBounds(102, 149, 106, 20);
		panel_20.add(textField_73);

		JLabel label_38 = new JLabel("Week Day2");
		label_38.setBounds(6, 200, 67, 14);
		panel_20.add(label_38);

		textField_74 = new JTextField();
		textField_74.setColumns(10);
		textField_74.setBounds(102, 197, 106, 20);
		panel_20.add(textField_74);

		JLabel label_39 = new JLabel("Week Day3");
		label_39.setBounds(6, 251, 67, 14);
		panel_20.add(label_39);

		textField_75 = new JTextField();
		textField_75.setColumns(10);
		textField_75.setBounds(102, 248, 106, 20);
		panel_20.add(textField_75);

		JLabel label_40 = new JLabel("Business Fare");
		label_40.setBounds(6, 301, 86, 14);
		panel_20.add(label_40);

		textField_76 = new JTextField();
		textField_76.setColumns(10);
		textField_76.setBounds(102, 298, 106, 20);
		panel_20.add(textField_76);

		JLabel label_41 = new JLabel("Economy Fare");
		label_41.setBounds(6, 347, 86, 14);
		panel_20.add(label_41);

		textField_77 = new JTextField();
		textField_77.setColumns(10);
		textField_77.setBounds(102, 344, 106, 20);
		panel_20.add(textField_77);

		JLabel label_42 = new JLabel("Flight Type");
		label_42.setBounds(6, 389, 67, 14);
		panel_20.add(label_42);

		textField_78 = new JTextField();
		textField_78.setColumns(10);
		textField_78.setBounds(102, 386, 106, 20);
		panel_20.add(textField_78);

		JButton btnModifySector = new JButton("Modify Sector");
		btnModifySector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sectorId = textField_70.getText();
				String source = textField_71.getText();
				String destination = textField_72.getText();
				String weekday1 = textField_73.getText();
				String weekday2 = textField_74.getText();
				String weekday3 = textField_75.getText();
				double bfare = Double.parseDouble(textField_76.getText());
				double efare = Double.parseDouble(textField_77.getText());
				String flightType = textField_78.getText();

				String sqlModifySector = "Update sector set source= \"" + source + "\", destination= \"" + destination
						+ "\" ,weekday1=\"" + weekday1 + "\",weekday2= \"" + weekday2 + "\", weekday3=\"" + weekday3
						+ "\",bfare=" + bfare + ",efare =" + efare + ",flightType= \"" + flightType
						+ "\" where sectorId= \"" + sectorId + "\";";
				if (sectorId != null) {
					if (!(sectorId.trim().equalsIgnoreCase(""))) {
						try {
							System.out.println(sqlModifySector);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlModifySector);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully updated");
							//
						} catch (SQLException e4) {
							System.out.println(e4.getMessage());
						}
						//
						catch (Exception ex4) {
							ex4.printStackTrace();
						}
					} else {
						String message = "Enter a valid sector Id";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid sector Id";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnModifySector.setBounds(35, 447, 123, 23);
		panel_20.add(btnModifySector);

		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Delete Sector",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_21.setBounds(132, 506, 214, 86);
		panel_13.add(panel_21);
		panel_21.setLayout(null);

		JLabel label_43 = new JLabel("Sector Id");
		label_43.setBounds(6, 19, 67, 14);
		panel_21.add(label_43);

		textField_79 = new JTextField();
		textField_79.setBounds(102, 16, 106, 20);
		panel_21.add(textField_79);
		textField_79.setColumns(10);

		JButton btnDeleteSector = new JButton("Delete Sector");
		btnDeleteSector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SectorId = textField_79.getText();
				if (SectorId != null) {
					if (!SectorId.trim().equalsIgnoreCase("")) {
						String sqlDelSector = "Delete from Sector where SectorId= \"" + SectorId + "\"";
						try {
							System.out.println(sqlDelSector);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlDelSector);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully deleted");
							//
						} catch (SQLException e6) {
							System.out.println(e6.getMessage());
						}
						//
						catch (Exception ex6) {
							ex6.printStackTrace();
						}

					} else {
						String message = "Enter a valid Sector Id";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid SectorId";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteSector.setBounds(38, 56, 127, 23);
		panel_21.add(btnDeleteSector);

		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Show Sector",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_22.setBounds(492, 11, 766, 334);
		panel_13.add(panel_22);
		panel_22.setLayout(null);
		Connection conn3 = null;
		ArrayList columnNames3 = new ArrayList();
		ArrayList data3 = new ArrayList();
		ResultSet rs3;
		ResultSetMetaData md3;
		DefaultTableModel model3 = new DefaultTableModel();
		try {
			String sql2 = "select * from sector";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn3 = connClass.getConnection();
			Statement statement3 = conn3.createStatement();

			rs3 = statement3.executeQuery(sql2);
			md3 = rs3.getMetaData();
			int columns3 = md3.getColumnCount();
			System.out.print("column count: " + columns3);

			// Get column names
			for (int i = 1; i <= columns3; i++) {
				System.out.print("column name: " + md3.getColumnName(i));
				columnNames3.add(md3.getColumnName(i).toUpperCase());

			}

			model3.setColumnIdentifiers(columnNames3.toArray());
			// Get row data
			while (rs3.next()) {
				ArrayList row3 = new ArrayList(columns3);

				for (int i = 1; i <= columns3; i++) {
					row3.add(rs3.getObject(i));

				}

				data3.add(row3);
			}
			for (int i = 0; i < data3.size(); i++) {
				ArrayList subArray3 = (ArrayList) data3.get(i);

				model3.addRow(subArray3.toArray());
			}

			statement3.close();
			// conn.close();
			connClass.destroyConnection(conn3);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		table_2 = new JTable();
		table_2.setBounds(6, 45, 754, 237);

		table_2.setColumnSelectionAllowed(true);
		table_2.setCellSelectionEnabled(true);
		table_2.setBackground(Color.gray);

		table_2.setModel(model3);

		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_2.setFillsViewportHeight(true);
		table_2.setVisible(true);
		panel_22.add(table_2);

		panel_4 = new JPanel();
		tabbedPane.addTab("Aircraft Transaction", null, panel_4, null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);

		panel = new JPanel();
		panel.setBounds(32, 315, 384, 272);
		panel_4.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Aircraft",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Aircraft Id");
		lblNewLabel.setBounds(6, 19, 83, 14);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(141, 19, 217, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblAircraftDescription = new JLabel("Aircraft Description");
		lblAircraftDescription.setBounds(6, 49, 125, 14);
		panel.add(lblAircraftDescription);

		textField_1 = new JTextField();
		textField_1.setBounds(141, 50, 217, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblBusinessSeats = new JLabel("# Business Seats");
		lblBusinessSeats.setBounds(6, 84, 125, 14);
		panel.add(lblBusinessSeats);

		JLabel lblEconomySeats = new JLabel("# Economy Seats");
		lblEconomySeats.setBounds(6, 117, 125, 14);
		panel.add(lblEconomySeats);

		JLabel lblCityFrom = new JLabel("Aircraft Type");
		lblCityFrom.setBounds(6, 150, 110, 14);
		panel.add(lblCityFrom);

		textField_2 = new JTextField();
		textField_2.setBounds(141, 84, 217, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(141, 117, 217, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(141, 150, 217, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aircraftId = textField.getText();
				String airDesc = textField_1.getText();
				int bseats = Integer.parseInt(textField_2.getText());
				int eseats = Integer.parseInt(textField_3.getText());
				String airType = textField_4.getText();
				String sqlAircraft = "Insert into aircraft (aircraftTypeID,description, bseats,eseats,aircraftType)values(\""
						+ aircraftId + "\",\"" + airDesc + "\"," + bseats + "," + eseats + ",\"" + airType + "\");";
				if (aircraftId != null) {
					try {
						System.out.println(sqlAircraft);
						ConnectionMySql connClass = new ConnectionMySql();
						Connection conn = connClass.getConnection();
						Statement statement = conn.createStatement();
						statement.executeUpdate(sqlAircraft);
						statement.close();
						connClass.destroyConnection(conn);
						JOptionPane.showMessageDialog(null, "Successfully inserted");
						//
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					//
					catch (Exception e) {
						e.printStackTrace();
					}
				}

			}

		});
		btnSubmit.setBounds(112, 199, 89, 23);
		panel.add(btnSubmit);

		panel_1 = new JPanel();
		panel_1.setBounds(844, 315, 348, 270);
		panel_4.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modify Aircraft",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		label = new JLabel("Aircraft Id");
		label.setBounds(6, 19, 83, 14);
		panel_1.add(label);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(125, 16, 217, 20);
		panel_1.add(textField_7);

		label_1 = new JLabel("Aircraft Description");
		label_1.setBounds(6, 49, 110, 14);
		panel_1.add(label_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(125, 47, 217, 20);
		panel_1.add(textField_8);

		label_2 = new JLabel("# Business Seats");
		label_2.setBounds(6, 84, 110, 14);
		panel_1.add(label_2);

		label_3 = new JLabel("# Economy Seats");
		label_3.setBounds(6, 117, 110, 14);
		panel_1.add(label_3);

		lblAircraftType = new JLabel("Aircraft Type");
		lblAircraftType.setBounds(6, 150, 110, 14);
		panel_1.add(lblAircraftType);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(125, 81, 217, 20);
		panel_1.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(125, 114, 217, 20);
		panel_1.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(125, 147, 217, 20);
		panel_1.add(textField_11);

		button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aircraftId = textField_7.getText();
				String airDesc = textField_8.getText();
				int bseats = Integer.parseInt(textField_9.getText());
				int eseats = Integer.parseInt(textField_10.getText());
				String airType = textField_11.getText();
				System.out.println("aircraftId=" + aircraftId);
				String sqlModifyAircraft = "Update aircraft set description= \"" + airDesc + "\", bseats= " + bseats
						+ " ,eseats=" + eseats + ",aircraftType= \"" + airType + "\" where aircraftTypeId= \""
						+ aircraftId + "\";";
				if (aircraftId != null) {
					if (!(aircraftId.trim().equalsIgnoreCase(""))) {
						try {
							System.out.println(sqlModifyAircraft);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlModifyAircraft);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully updated");
							//
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
						//
						catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						String message = "Enter a valid aircraft Id";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid aircraft Id";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		button.setBounds(135, 193, 89, 23);
		panel_1.add(button);

		panel_2 = new JPanel();
		panel_2.setBounds(452, 502, 348, 85);
		panel_4.add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Delete Aircraft",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setLayout(null);

		label_7 = new JLabel("Aircraft Id");
		label_7.setBounds(6, 19, 83, 14);
		panel_2.add(label_7);

		textField_14 = new JTextField();
		textField_14.setBounds(125, 16, 217, 20);
		panel_2.add(textField_14);
		textField_14.setColumns(10);

		btnSubmit_1 = new JButton("Submit");
		btnSubmit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aircraftId = textField_14.getText();
				if (aircraftId != null) {
					if (!aircraftId.trim().equalsIgnoreCase("")) {
						String sqlDelAircraft = "Delete from aircraft where aircraftTypeID= \"" + aircraftId + "\"";
						try {
							System.out.println(sqlDelAircraft);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlDelAircraft);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully deleted");
							//
						} catch (SQLException e) {
							System.out.println(e.getMessage());
						}
						//
						catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						String message = "Enter a valid aircraft Id";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid aircraft Id";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSubmit_1.setBounds(104, 51, 89, 23);
		panel_2.add(btnSubmit_1);
		Connection conn4 = null;
		ArrayList columnNames4 = new ArrayList();
		ArrayList data4 = new ArrayList();
		ResultSet rs4;
		ResultSetMetaData md4;
		DefaultTableModel model4 = new DefaultTableModel();
		try {
			String sql2 = "select aircraftTypeID,description,bseats,eseats,aircraftType from aircraft";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn4 = connClass.getConnection();
			Statement statement4 = conn4.createStatement();

			rs4 = statement4.executeQuery(sql2);
			md4 = rs4.getMetaData();
			int columns4 = md4.getColumnCount();
			System.out.print("column count: " + columns4);

			// Get column names
			for (int i = 1; i <= columns4; i++) {
				System.out.print("column name: " + md4.getColumnName(i));
				columnNames4.add(md4.getColumnName(i).toUpperCase());

			}

			model4.setColumnIdentifiers(columnNames4.toArray());
			// Get row data
			while (rs4.next()) {
				ArrayList row4 = new ArrayList(columns4);

				for (int i = 1; i <= columns4; i++) {
					row4.add(rs4.getObject(i));

				}

				data4.add(row4);
			}
			for (int i = 0; i < data4.size(); i++) {
				ArrayList subArray4 = (ArrayList) data4.get(i);

				model4.addRow(subArray4.toArray());
			}

			statement4.close();
			// conn.close();
			connClass.destroyConnection(conn4);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		table_7 = new JTable();
		table_7.setBounds(32, 26, 1190, 264);
		table_7.setBackground(Color.gray);

		table_7.setModel(model4);
		table_7.setColumnSelectionAllowed(true);
		table_7.setCellSelectionEnabled(true);
		table_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_7.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_7.setFillsViewportHeight(true);
		table_7.setVisible(true);
		panel_4.add(table_7);

		panel_14 = new JPanel();
		tabbedPane.addTab("User Profile", null, panel_14, null);
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_14.setLayout(null);

		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add User Profile",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_15.setBounds(4, 5, 457, 323);
		panel_14.add(panel_15);
		panel_15.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("User Id");
		lblNewLabel_2.setBounds(6, 19, 71, 14);
		panel_15.add(lblNewLabel_2);

		textField_33 = new JTextField();
		textField_33.setBounds(111, 16, 86, 20);
		panel_15.add(textField_33);
		textField_33.setColumns(10);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(6, 60, 71, 14);
		panel_15.add(lblFirstName);

		textField_34 = new JTextField();
		textField_34.setBounds(111, 57, 86, 20);
		panel_15.add(textField_34);
		textField_34.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(6, 105, 71, 14);
		panel_15.add(lblLastName);

		textField_35 = new JTextField();
		textField_35.setBounds(111, 102, 86, 20);
		panel_15.add(textField_35);
		textField_35.setColumns(10);

		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(6, 149, 95, 14);
		panel_15.add(lblContactNumber);

		textField_36 = new JTextField();
		textField_36.setBounds(111, 146, 86, 20);
		panel_15.add(textField_36);
		textField_36.setColumns(10);

		JLabel lblDob = new JLabel("DoB");
		lblDob.setBounds(6, 198, 71, 14);
		panel_15.add(lblDob);

		textField_37 = new JTextField();
		textField_37.setBounds(111, 195, 86, 20);
		panel_15.add(textField_37);
		textField_37.setColumns(10);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(6, 247, 71, 14);
		panel_15.add(lblAddress);

		textField_38 = new JTextField();
		textField_38.setBounds(111, 244, 86, 20);
		panel_15.add(textField_38);
		textField_38.setColumns(10);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(245, 22, 71, 14);
		panel_15.add(lblState);

		textField_39 = new JTextField();
		textField_39.setBounds(350, 19, 86, 20);
		panel_15.add(textField_39);
		textField_39.setColumns(10);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(245, 63, 71, 14);
		panel_15.add(lblCountry);

		textField_40 = new JTextField();
		textField_40.setBounds(350, 60, 86, 20);
		panel_15.add(textField_40);
		textField_40.setColumns(10);

		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setBounds(245, 102, 71, 14);
		panel_15.add(lblEmailId);

		textField_41 = new JTextField();
		textField_41.setBounds(350, 99, 86, 20);
		panel_15.add(textField_41);
		textField_41.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(245, 146, 71, 14);
		panel_15.add(lblPassword);

		textField_42 = new JTextField();
		textField_42.setBounds(350, 143, 86, 20);
		panel_15.add(textField_42);
		textField_42.setColumns(10);

		JLabel lblUserType = new JLabel("User Type");
		lblUserType.setBounds(245, 198, 71, 14);
		panel_15.add(lblUserType);

		textField_43 = new JTextField();
		textField_43.setBounds(350, 195, 86, 20);
		panel_15.add(textField_43);
		textField_43.setColumns(10);

		JLabel lblUserNam = new JLabel("User Name");
		lblUserNam.setBounds(245, 244, 71, 14);
		panel_15.add(lblUserNam);

		textField_44 = new JTextField();
		textField_44.setBounds(350, 241, 86, 20);
		panel_15.add(textField_44);
		textField_44.setColumns(10);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(6, 297, 71, 14);
		panel_15.add(lblCity);

		textField_45 = new JTextField();
		textField_45.setBounds(111, 294, 86, 20);
		panel_15.add(textField_45);
		textField_45.setColumns(10);

		JButton btnAddUser = new JButton("Add Profile");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = 0;
				if (textField_33.getText() != null || !textField_33.getText().isEmpty()) {
					userId = Integer.parseInt(textField_33.getText());
				}
				String firstname = textField_34.getText();
				String lastname = textField_35.getText();
				long contactnumber = 0;
				if (textField_36.getText() != null || !textField_36.getText().isEmpty()) {
					contactnumber = Long.parseLong(textField_36.getText());
				}
				String dob = textField_37.getText();
				String address = textField_38.getText();
				String city = textField_45.getText();
				String state = textField_39.getText();
				String country = textField_40.getText();
				String emailId = textField_41.getText();
				String password = textField_42.getText();
				String userType = textField_43.getText();
				String userName = textField_44.getText();

				String sqlUser = "Insert into user_profile (userid, firstname, lastname, contactno, dob, address, city, state, country,emailid, password, usertype, username) VALUES("
						+ userId + ",\"" + firstname + "\"," + "\"" + lastname + "\"," + contactnumber + ",\"" + dob
						+ "\",\"" + address + "\",\"" + city + "\",\"" + state + "\",\"" + country + "\",\"" + emailId
						+ "\",\"" + password + "\",\"" + userType + "\",\"" + userName + "\");";

				try {
					System.out.println(sqlUser);
					ConnectionMySql connClass = new ConnectionMySql();
					Connection conn = connClass.getConnection();
					Statement statement = conn.createStatement();
					statement.executeUpdate(sqlUser);
					statement.close();
					connClass.destroyConnection(conn);
					JOptionPane.showMessageDialog(null, "Successfully inserted");
					//
				} catch (SQLException exception) {
					String message = "All fields are mandatory. Enter valid values and try again";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					System.out.println(exception.getMessage());
				}
				//
				catch (Exception exception1) {
					exception1.printStackTrace();
				}
			}

		});
		btnAddUser.setBounds(292, 293, 128, 23);
		panel_15.add(btnAddUser);

		lblNewLabel_1 = new JLabel("yyyy/mm/dd");
		lblNewLabel_1.setBounds(111, 219, 86, 14);
		panel_15.add(lblNewLabel_1);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Delete User",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_16.setBounds(10, 350, 203, 98);
		panel_14.add(panel_16);
		panel_16.setLayout(null);

		JLabel label_20 = new JLabel("User Id");
		label_20.setBounds(6, 19, 71, 14);
		panel_16.add(label_20);

		textField_46 = new JTextField();
		textField_46.setBounds(111, 16, 86, 20);
		panel_16.add(textField_46);
		textField_46.setColumns(10);

		JButton btnDeleteUser = new JButton("Delete User");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = 0;
				if (textField_46.getText() != null || !textField_46.getText().isEmpty()) {
					userId = Integer.parseInt(textField_46.getText());
				}
				String sqlDelFlights = "Delete from user_profile where userid= " + userId + ";";
				try {
					System.out.println(sqlDelFlights);
					ConnectionMySql connClass = new ConnectionMySql();
					Connection conn = connClass.getConnection();
					Statement statement = conn.createStatement();
					statement.executeUpdate(sqlDelFlights);
					statement.close();
					connClass.destroyConnection(conn);
					JOptionPane.showMessageDialog(null, "Successfully deleted");
					//
				} catch (SQLException exc) {
					System.out.println(exc.getMessage());
				}
				//
				catch (Exception exce) {
					exce.printStackTrace();
				}
			}
		});
		btnDeleteUser.setBounds(55, 68, 114, 23);
		panel_16.add(btnDeleteUser);

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modify User Profile",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_17.setBounds(471, 5, 457, 323);
		panel_14.add(panel_17);

		JLabel label_21 = new JLabel("User Id");
		label_21.setBounds(6, 19, 71, 14);
		panel_17.add(label_21);

		textField_47 = new JTextField();
		textField_47.setColumns(10);
		textField_47.setBounds(111, 16, 86, 20);
		panel_17.add(textField_47);

		JLabel label_22 = new JLabel("First Name");
		label_22.setBounds(6, 60, 71, 14);
		panel_17.add(label_22);

		textField_48 = new JTextField();
		textField_48.setColumns(10);
		textField_48.setBounds(111, 57, 86, 20);
		panel_17.add(textField_48);

		JLabel label_23 = new JLabel("Last Name");
		label_23.setBounds(6, 105, 71, 14);
		panel_17.add(label_23);

		textField_49 = new JTextField();
		textField_49.setColumns(10);
		textField_49.setBounds(111, 102, 86, 20);
		panel_17.add(textField_49);

		JLabel label_24 = new JLabel("Contact Number");
		label_24.setBounds(6, 149, 95, 14);
		panel_17.add(label_24);

		textField_50 = new JTextField();
		textField_50.setColumns(10);
		textField_50.setBounds(111, 146, 86, 20);
		panel_17.add(textField_50);

		JLabel label_25 = new JLabel("DoB");
		label_25.setBounds(6, 198, 71, 14);
		panel_17.add(label_25);

		textField_51 = new JTextField();
		textField_51.setColumns(10);
		textField_51.setBounds(111, 195, 86, 20);
		panel_17.add(textField_51);

		JLabel label_26 = new JLabel("Address");
		label_26.setBounds(6, 247, 71, 14);
		panel_17.add(label_26);

		textField_52 = new JTextField();
		textField_52.setColumns(10);
		textField_52.setBounds(111, 244, 86, 20);
		panel_17.add(textField_52);

		JLabel label_27 = new JLabel("State");
		label_27.setBounds(245, 22, 71, 14);
		panel_17.add(label_27);

		textField_53 = new JTextField();
		textField_53.setColumns(10);
		textField_53.setBounds(350, 19, 86, 20);
		panel_17.add(textField_53);

		JLabel label_28 = new JLabel("Country");
		label_28.setBounds(245, 63, 71, 14);
		panel_17.add(label_28);

		textField_54 = new JTextField();
		textField_54.setColumns(10);
		textField_54.setBounds(350, 60, 86, 20);
		panel_17.add(textField_54);

		JLabel label_29 = new JLabel("Email Id");
		label_29.setBounds(245, 102, 71, 14);
		panel_17.add(label_29);

		textField_55 = new JTextField();
		textField_55.setColumns(10);
		textField_55.setBounds(350, 99, 86, 20);
		panel_17.add(textField_55);

		JLabel label_30 = new JLabel("Password");
		label_30.setBounds(245, 146, 71, 14);
		panel_17.add(label_30);

		textField_56 = new JTextField();
		textField_56.setColumns(10);
		textField_56.setBounds(350, 143, 86, 20);
		panel_17.add(textField_56);

		JLabel label_31 = new JLabel("User Type");
		label_31.setBounds(245, 198, 71, 14);
		panel_17.add(label_31);

		textField_57 = new JTextField();
		textField_57.setColumns(10);
		textField_57.setBounds(350, 195, 86, 20);
		panel_17.add(textField_57);

		JLabel label_32 = new JLabel("User Name");
		label_32.setBounds(245, 244, 71, 14);
		panel_17.add(label_32);

		textField_58 = new JTextField();
		textField_58.setColumns(10);
		textField_58.setBounds(350, 241, 86, 20);
		panel_17.add(textField_58);

		JLabel label_33 = new JLabel("City");
		label_33.setBounds(6, 297, 71, 14);
		panel_17.add(label_33);

		textField_59 = new JTextField();
		textField_59.setColumns(10);
		textField_59.setBounds(111, 294, 86, 20);
		panel_17.add(textField_59);

		JButton btnModifyProfile = new JButton("Modify Profile");
		btnModifyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int userId = 0;
				if (textField_47.getText() != null || !textField_47.getText().isEmpty()) {
					userId = Integer.parseInt(textField_47.getText());
				}
				String firstname = textField_48.getText();
				String lastname = textField_49.getText();
				long contactnumber = 0;
				if (textField_50.getText() != null || !textField_50.getText().isEmpty()) {
					contactnumber = Long.parseLong(textField_50.getText());
				}
				String dob = textField_51.getText();
				String address = textField_52.getText();
				String city = textField_59.getText();
				String state = textField_53.getText();
				String country = textField_54.getText();
				String emailId = textField_55.getText();
				String password = textField_56.getText();
				String userType = textField_57.getText();
				String userName = textField_58.getText();
				String sqlModifyUser = "Update user_profile set firstname=\"" + firstname + "\", lastname= \"" + lastname
						+ "\", contactno=" + contactnumber + ",dob= \"" + dob + "\",address=\"" + address + "\",city=\""
						+ city + "\",state=\"" + state + "\",country=\"" + country + "\",emailid=\"" + emailId
						+ "\",password=\"" + password + "\",usertype=\"" + userType + "\" where userid= " + userId
						+ ";";
				try {
					System.out.println(sqlModifyUser);
					ConnectionMySql connClass = new ConnectionMySql();
					Connection conn = connClass.getConnection();
					Statement statement = conn.createStatement();
					statement.executeUpdate(sqlModifyUser);
					statement.close();
					connClass.destroyConnection(conn);
					JOptionPane.showMessageDialog(null, "Successfully modified");
					//
				} catch (SQLException exception3) {
					String message = "Enter valid values. All fields mandatory";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					System.out.println(exception3.getMessage());
				}
				//
				catch (Exception exception4) {
					exception4.printStackTrace();
				}

			}
		});
		btnModifyProfile.setBounds(288, 293, 148, 23);
		panel_17.add(btnModifyProfile);

		label_12 = new JLabel("yyyy/mm/dd");
		label_12.setBounds(111, 219, 86, 14);
		panel_17.add(label_12);

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Show User Profile",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_18.setBounds(236, 341, 687, 263);
		panel_14.add(panel_18);
		panel_18.setLayout(null);
		Connection conn7 = null;
		ArrayList columnNames7 = new ArrayList();
		ArrayList data7 = new ArrayList();
		ResultSet rs7;
		ResultSetMetaData md7;
		DefaultTableModel model7 = new DefaultTableModel();
		try {
			String sql7 = "select * from user_profile";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass = new ConnectionMySql();
			conn7 = connClass.getConnection();
			Statement statement7 = conn7.createStatement();

			rs7 = statement7.executeQuery(sql7);
			md7 = rs7.getMetaData();
			int columns7 = md7.getColumnCount();
			System.out.print("column count: " + columns7);

			// Get column names
			for (int i = 1; i <= columns7; i++) {
				System.out.print("column name: " + md7.getColumnName(i));
				columnNames7.add(md7.getColumnName(i).toUpperCase());

			}

			model7.setColumnIdentifiers(columnNames7.toArray());
			// Get row data
			while (rs7.next()) {
				ArrayList row7 = new ArrayList(columns7);

				for (int i = 1; i <= columns7; i++) {
					row7.add(rs7.getObject(i));

				}

				data7.add(row7);
			}
			for (int i = 0; i < data7.size(); i++) {
				ArrayList subArray7 = (ArrayList) data7.get(i);

				model7.addRow(subArray7.toArray());
			}

			statement7.close();
			// conn.close();
			connClass.destroyConnection(conn7);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		table_1 = new JTable();
		table_1.setBounds(6, 44, 675, 196);
		table_1.setBackground(Color.gray);
		table_1.setModel(model7);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.setFillsViewportHeight(true);
		table_1.setVisible(true);
		panel_18.add(table_1);

		Connection conn6 = null;
		ArrayList columnNames6 = new ArrayList();
		ArrayList data6 = new ArrayList();
		ResultSet rs6;
		ResultSetMetaData md6;
		DefaultTableModel model6 = new DefaultTableModel();
		try {
			String sql6 = "select scheduleID,flightno,flightdate,bcsavailable,ecsavailable,flightType from scheduledflights";
			// String sql = "select a.flightno, a.flightdate ,b.deptime,
			// b.arrtime,
			// c.description,d.source,d.destination,d.weekday1,d.weekday2,d.weekday3,d.bfare,d.efare
			// from scheduledflights a, flights b, aircraft c ,sector d where
			// a.flightno=b.flightno and b.aircraftTypeID=c.aircraftTypeID and
			// b.sectorId=d.sectorId and c.aircraftType=\"International\"";";
			ConnectionMySql connClass6 = new ConnectionMySql();
			conn6 = connClass6.getConnection();
			Statement statement6 = conn6.createStatement();

			rs6 = statement6.executeQuery(sql6);
			md6 = rs6.getMetaData();
			int columns6 = md6.getColumnCount();
			System.out.print("column count: " + columns6);

			// Get column names
			for (int i = 1; i <= columns6; i++) {
				System.out.print("column name: " + md6.getColumnName(i));
				columnNames6.add(md6.getColumnName(i).toUpperCase());

			}

			model6.setColumnIdentifiers(columnNames6.toArray());
			// Get row data
			while (rs6.next()) {
				ArrayList row6 = new ArrayList(columns6);

				for (int i = 1; i <= columns6; i++) {
					row6.add(rs6.getObject(i));

				}

				data6.add(row6);
			}
			for (int i = 0; i < data6.size(); i++) {
				ArrayList subArray6 = (ArrayList) data6.get(i);

				model6.addRow(subArray6.toArray());
			}

			statement6.close();
			// conn.close();
			connClass6.destroyConnection(conn6);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		panel_6 = new JPanel();
		tabbedPane.addTab("Schedule Change", null, panel_6, null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setLayout(null);

		panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Add Scheduled Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_9.setBounds(32, 371, 275, 233);
		panel_6.add(panel_9);

		lblScheduleId_1 = new JLabel("Schedule Id");
		lblScheduleId_1.setBounds(6, 19, 88, 14);
		panel_9.add(lblScheduleId_1);

		label_11 = new JLabel("Flight #");
		label_11.setBounds(6, 46, 88, 14);
		panel_9.add(label_11);

		lblFlightDate = new JLabel("Flight Date");
		lblFlightDate.setBounds(6, 74, 88, 14);
		panel_9.add(lblFlightDate);

		lblBusinessSeats_1 = new JLabel("business seats");
		lblBusinessSeats_1.setBounds(6, 107, 88, 14);
		panel_9.add(lblBusinessSeats_1);

		lblEconomySeats_1 = new JLabel("economy seats");
		lblEconomySeats_1.setBounds(6, 142, 88, 14);
		panel_9.add(lblEconomySeats_1);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(129, 16, 120, 20);
		panel_9.add(textField_21);

		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(129, 43, 120, 20);
		panel_9.add(textField_22);

		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(129, 74, 120, 20);
		panel_9.add(textField_23);

		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(129, 104, 120, 20);
		panel_9.add(textField_24);

		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(129, 139, 120, 20);
		panel_9.add(textField_25);

		btnAddScheduledFlight = new JButton("Add Scheduled Flight");
		btnAddScheduledFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ScheduleId = textField_21.getText();
				String flightno = textField_22.getText();
				String flightdate = textField_23.getText();
				int bcsavailable = Integer.parseInt(textField_24.getText());
				int ecsavailable = Integer.parseInt(textField_25.getText());
				String flighttype = textField_5.getText();
				if (ScheduleId != null) {
					String sqlSchedFlight = "Insert into scheduledflights (scheduleID,flightno, flightdate,bcsavailable,ecsavailable,flighttype)values(\""
							+ ScheduleId + "\",\"" + flightno + "\",\"" + flightdate + "\"," + bcsavailable + ","
							+ ecsavailable + ",\"" + flighttype + "\");";
					try {
						System.out.println(sqlSchedFlight);
						ConnectionMySql connClass = new ConnectionMySql();
						Connection conn = connClass.getConnection();
						Statement statement = conn.createStatement();
						statement.executeUpdate(sqlSchedFlight);
						statement.close();
						connClass.destroyConnection(conn);
						JOptionPane.showMessageDialog(null, "Successfully inserted");
						//
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					//
					catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String message = "Enter a valid not null schedule id";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}

				// INSERT INTO `scheduledflights` (`scheduleID`, `flightno`,
				// `flightdate`, `bcsavailable`, `ecsavailable`,`flighttype`)

				// VALUES
			}
		});
		btnAddScheduledFlight.setBounds(57, 199, 192, 23);
		panel_9.add(btnAddScheduledFlight);

		JLabel lblFlightType_1 = new JLabel("flight type");
		lblFlightType_1.setBounds(6, 171, 88, 14);
		panel_9.add(lblFlightType_1);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(129, 168, 120, 20);
		panel_9.add(textField_5);

		panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Delete Scheduled Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_12.setBounds(464, 516, 302, 77);
		panel_6.add(panel_12);
		panel_12.setLayout(null);

		lblScheduleId = new JLabel("Schedule Id");
		lblScheduleId.setBounds(6, 19, 88, 14);
		panel_12.add(lblScheduleId);

		textField_32 = new JTextField();
		textField_32.setBounds(129, 16, 120, 20);
		panel_12.add(textField_32);
		textField_32.setColumns(10);

		btnDeleteScheduledFlight = new JButton("Delete Scheduled Flight");
		btnDeleteScheduledFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String scheduleId = textField_32.getText();
				if (scheduleId != null) {
					if (!scheduleId.trim().equalsIgnoreCase("")) {
						String sqlDelSchedule = "Delete from scheduledflights where scheduleID= \"" + scheduleId + "\"";
						try {
							System.out.println(sqlDelSchedule);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlDelSchedule);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully deleted");
							//
						} catch (SQLException e7) {
							System.out.println(e7.getMessage());
						}
						//
						catch (Exception e8) {
							e8.printStackTrace();
						}

					} else {
						String message = "Enter a valid schedule ID";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid schedule ID";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnDeleteScheduledFlight.setBounds(62, 47, 187, 23);
		panel_12.add(btnDeleteScheduledFlight);

		table_4 = new JTable();
		table_4.setBounds(786, 37, -736, 273);
		panel_6.add(table_4);
		table_5 = new JTable();
		table_5.setBounds(60, 37, 1166, 303);
		table_5.setBackground(Color.gray);

		table_5.setModel(model6);
		table_5.setColumnSelectionAllowed(true);
		table_5.setCellSelectionEnabled(true);
		table_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_5.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_5.setFillsViewportHeight(true);
		table_5.setVisible(true);
		panel_6.add(table_5);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modify Scheduled Flight",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_7.setBounds(924, 371, 302, 233);
		panel_6.add(panel_7);

		JLabel label_4 = new JLabel("Schedule Id");
		label_4.setBounds(6, 19, 88, 14);
		panel_7.add(label_4);

		JLabel label_5 = new JLabel("Flight #");
		label_5.setBounds(6, 46, 88, 14);
		panel_7.add(label_5);

		JLabel label_6 = new JLabel("Flight Date");
		label_6.setBounds(6, 74, 88, 14);
		panel_7.add(label_6);

		JLabel label_8 = new JLabel("business seats");
		label_8.setBounds(6, 107, 88, 14);
		panel_7.add(label_8);

		JLabel label_9 = new JLabel("economy seats");
		label_9.setBounds(6, 142, 88, 14);
		panel_7.add(label_9);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(129, 16, 120, 20);
		panel_7.add(textField_6);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(129, 43, 120, 20);
		panel_7.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(129, 74, 120, 20);
		panel_7.add(textField_13);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(129, 104, 120, 20);
		panel_7.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(129, 139, 120, 20);
		panel_7.add(textField_16);

		JButton btnModifyScheduledFlight = new JButton("Modify Scheduled Flight");
		btnModifyScheduledFlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ScheduleId = textField_6.getText();
				String flightno = textField_12.getText();
				String flightdate = textField_13.getText();
				int bcsavailable = Integer.parseInt(textField_15.getText());
				int ecsavailable = Integer.parseInt(textField_16.getText());
				String flighttype = textField_17.getText();

				System.out.println("ScheduleId=" + ScheduleId);
				String sqlModifyScheduledFlight = "Update scheduledflights set flightno= \"" + flightno
						+ "\", flightdate= \"" + flightdate + "\", bcsavailable=" + bcsavailable + ",ecsavailable= "
						+ ecsavailable + ",flighttype=\"" + flighttype + "\" where scheduleID= \"" + ScheduleId + "\";";
				if (ScheduleId != null) {
					if (!(ScheduleId.trim().equalsIgnoreCase(""))) {
						try {
							System.out.println(sqlModifyScheduledFlight);
							ConnectionMySql connClass = new ConnectionMySql();
							Connection conn = connClass.getConnection();
							Statement statement = conn.createStatement();
							statement.executeUpdate(sqlModifyScheduledFlight);
							statement.close();
							connClass.destroyConnection(conn);
							JOptionPane.showMessageDialog(null, "Successfully modified");
							//
						} catch (SQLException e9) {
							System.out.println(e9.getMessage());
						}
						//
						catch (Exception e10) {
							e10.printStackTrace();
						}
					} else {
						String message = "Enter a valid schedule Idr";
						JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					String message = "Enter a valid schedule Idr";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModifyScheduledFlight.setBounds(57, 199, 192, 23);
		panel_7.add(btnModifyScheduledFlight);

		JLabel label_10 = new JLabel("flight type");
		label_10.setBounds(6, 171, 88, 14);
		panel_7.add(label_10);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(129, 168, 120, 20);
		panel_7.add(textField_17);

		label_13 = new JLabel("yyyy/mm/dd");
		label_13.setBounds(339, 447, 86, 14);
		panel_6.add(label_13);

		label_14 = new JLabel("yyyy/mm/dd");
		label_14.setBounds(817, 447, 86, 14);
		panel_6.add(label_14);
	}
}
