package GUI;
import javax.swing.table.AbstractTableModel;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class User_list extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	App_init strater;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JTable Table_book = null;
	private JButton Button_add_user = null;
	private JButton Button_del_user = null;

	/**
	 * This is the default constructor
	 */
	public User_list(App_init strater) {
		super();
		this.strater=strater;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		Label_title = new JLabel();
		Label_title.setText("Users List");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		Label_title.setBounds(new Rectangle(217, 113, 143, 28));
		this.setSize(600, 500);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(getJScrollPane1(), null);
		this.add(getButton_add_user(), null);
		this.add(getButton_del_user(), null);
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(55, 164, 480, 200));
			jScrollPane1.setViewportView(getTable_book());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes Table_book	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable_book() {
		if (Table_book == null) {
			Object[][] data = new Object[100][7]; 
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ID","name","Type","Phone Number","Email","Address"}; 
			
			for(int i=0;i<strater.all_users.list.size();i++)
	        {
				data[i][0]=new String(strater.all_users.list.get(i).getID());
				data[i][1]=new String(strater.all_users.list.get(i).getName());
				data[i][2]=new String(strater.all_users.list.get(i).user_type);
				data[i][3]=new String(strater.all_users.list.get(i).getPhone_number());
				data[i][4]=new String(strater.all_users.list.get(i).getEmail());
				data[i][5]=new String(strater.all_users.list.get(i).getAddress());
	}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_book =  new JTable(defTableModel);
			
			
		}
		return Table_book;
	}

	/**
	 * This method initializes Button_add_user	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_add_user() {
		if (Button_add_user == null) {
			Button_add_user = new JButton();
			Button_add_user.setBounds(new Rectangle(225, 369, 50, 50));
			Button_add_user.setIcon(new ImageIcon(getClass().getResource("/Img/add.png")));
			Button_add_user.setText("");
			Button_add_user.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Add_user form = new Add_user(strater) ;
					form.add(strater.main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
					strater.main_form.jFrame.setContentPane(form);
					
				}
			});
		}
		return Button_add_user;
	}

	/**
	 * This method initializes Button_del_user	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_del_user() {
		if (Button_del_user == null) {
			Button_del_user = new JButton();
			Button_del_user.setBounds(new Rectangle(288, 369, 50, 50));
			Button_del_user.setIcon(new ImageIcon(getClass().getResource("/Img/del.png")));
			Button_del_user.setText("");
			Button_del_user.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(Table_book.getSelectedRow()>=0)
					{

								int ligne = Table_book.getSelectedRow();
								String cellule = (String) Table_book
										.getValueAt(ligne, 0);

								if (cellule != null) {
					JOptionPane jop1 = new JOptionPane();
					if(strater.all_users.remove_user(cellule))
					{
					jop1.showMessageDialog(null, "user deleted" , "Informatioin", JOptionPane.INFORMATION_MESSAGE); }
					else
					{jop1.showMessageDialog(null, "user does not exist" , "Informatioin", JOptionPane.ERROR_MESSAGE);}
					
				}}
					Table_book=null;
					jScrollPane1.setViewportView(getTable_book() );	
				
				}
			});
		}
		return Button_del_user;
	}

	
	

}  
