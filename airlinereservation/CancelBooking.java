package com.skps.airlinereservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.skps.ars.utilities.ConnectionMySql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class CancelBooking extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelBooking frame = new CancelBooking();
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
	public CancelBooking() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BOOKING CANCELLATION");
		lblNewLabel.setBounds(150, 11, 197, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PNR Number");
		lblNewLabel_1.setBounds(27, 102, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(191, 99, 138, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pnrNum=textField.getText();
				String sqlGetTravelDate="select traveldate from passengers where pnrno= \""+pnrNum+"\"";
				String sqlDeletePassenger="Delete from passengers where pnrno= \""+pnrNum+"\"";
				String sqlDeleteDailyCol="Delete from dailycollections where pnrno =\""+pnrNum+"\"";
				if (pnrNum ==null || pnrNum.isEmpty()){
					String message = "Enter valid pnr number and try again";
					JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
				}else{
					try {
						System.out.println(sqlDeletePassenger);
						System.out.println(sqlDeleteDailyCol);
						ConnectionMySql connClass = new ConnectionMySql();
						Connection conn = connClass.getConnection();
						Statement statement = conn.createStatement();
						ResultSet rs =statement.executeQuery(sqlGetTravelDate);
						java.sql.Date rsDate=null;
						while (rs.next()){
							rsDate=rs.getDate(1);
						}
						java.sql.Date travelDt=new java.sql.Date(rsDate.getTime());
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
						java.util.Date today= new java.util.Date();
						java.sql.Date cancelDate= new java.sql.Date(today.getTime());
						System.out.println("travelDt="+travelDt.toString());
						long diff=travelDt.getTime()-cancelDate.getTime();
						System.out.println("diff long="+diff);
						int diffInDays =((int)diff)/(1000 * 60 * 60 * 24);
						System.out.println("diff days="+diffInDays);
						if (diffInDays<=2){
							
							String message="Your travel date is within two days. You will not receive any refund ";
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
						}else if (diffInDays>2){
							
							String message=" You will not receive 50% refund";
							JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.INFORMATION_MESSAGE);
						}
						statement.executeUpdate(sqlDeletePassenger);
						statement.executeUpdate(sqlDeleteDailyCol);
						statement.close();
						connClass.destroyConnection(conn);
						JOptionPane.showMessageDialog(null, "Successfully Cancelled");
						//
					} catch (SQLException exc) {
						System.out.println(exc.getMessage());
					}
					//
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnSubmit.setBounds(151, 153, 89, 23);
		contentPane.add(btnSubmit);
	}
}
