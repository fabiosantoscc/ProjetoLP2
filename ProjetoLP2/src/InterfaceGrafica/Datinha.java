package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class Datinha extends JFrame {

	private JPanel contentPane;
	private Calendar data;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datinha frame = new Datinha();
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
	public Datinha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 235, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(177, 235, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(390, 235, -78, 20);
		add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(306, 235, 74, 20);
		add(formattedTextField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(112, 129, 200, 20);
		add(dateChooser);
		
		JButton btnPegar = new JButton("pegar");
		btnPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					data = dateChooser.getCalendar();
					textField.setText(data.get(Calendar.DAY_OF_MONTH) + "");
					textField_1.setText(data.get(Calendar.MONTH) + "");
					formattedTextField_1.setText(data.get(Calendar.YEAR) + "");
				} catch ( Exception e ) {
					JOptionPane.showMessageDialog(null, "Data vazia");
				}
			}
		});
		btnPegar.setBounds(177, 182, 89, 23);
		add(btnPegar);

	}
}
