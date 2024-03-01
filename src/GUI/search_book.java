package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.Date;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import MDL.Borrow;
import MDL.Reservation;

public class search_book extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_type = null;
	private JRadioButton Radio_title = null;
	private JLabel Label_author = null;
	private JRadioButton Radio_author = null;
	private JTextField TextField_key = null;
	private JLabel Label_key = null;
	private JScrollPane jScrollPane = null;
	private JTable Table_book = null;
	Object[][] data = new Object[100][3]; 
	App_init strater;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public search_book(App_init strater) {
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
		
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(47, 431, 442, 27));
		jLabel.setText("**use contextual menu to borrow book or to reserve book");
		Label_key = new JLabel();
		Label_key.setBounds(new Rectangle(233, 139, 63, 25));
		Label_key.setText("keyword : ");
		Label_author = new JLabel();
		Label_author.setBounds(new Rectangle(53, 170, 111, 23));
		Label_author.setText("Search by author : ");
		Label_type = new JLabel();
		Label_type.setBounds(new Rectangle(54, 146, 92, 24));
		Label_type.setText("Search by title : ");
		Label_title = new JLabel();
		Label_title.setText("Search book");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		Label_title.setBounds(new Rectangle(193, 87, 203, 44));
		this.setSize(600, 500);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(Label_type, null);
		this.add(getRadio_title(), null);
		this.add(Label_author, null);
		this.add(getRadio_author(), null);
		this.add(getTextField_key(), null);
		this.add(Label_key, null);
		this.add(getJScrollPane(), null);
		this.add(jLabel, null);
		
	}

	/**
	 * This method initializes Radio_title	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadio_title() {
		if (Radio_title == null) {
			Radio_title = new JRadioButton();
			Radio_title.setBounds(new Rectangle(152, 149, 21, 15));
			Radio_title.setSelected(true);
			Radio_title.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"+Radio_title.isSelected()); 
					if(Radio_title.isSelected()==true)
						Radio_author.setSelected(false);
					Object[][] data = strater.all_books.get_book_by_name(TextField_key.getText());
					//A string array containing the column names for the JTable. 
					String[] columnNames = {"ISBN","Title","Autor"}; 
			
					//Create the JTable using the data array and column name array. 
					Table_book.setModel( new DefaultTableModel(data,columnNames));
				}
			});
			
		}
		return Radio_title;
	}

	/**
	 * This method initializes Radio_author	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadio_author() {
		if (Radio_author == null) {
			Radio_author = new JRadioButton();
			Radio_author.setBounds(new Rectangle(166, 171, 20, 17));
			Radio_author.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					System.out.println("itemStateChanged()"+Radio_author.isSelected()); 
					if(Radio_author.isSelected()==true)
						Radio_title.setSelected(false);
					
					Object[][] data = strater.all_books.get_book_by_author(TextField_key.getText());
					//A string array containing the column names for the JTable. 
					String[] columnNames = {"ISBN","Title","Autor"}; 
			
					//Create the JTable using the data array and column name array. 
					Table_book.setModel( new DefaultTableModel(data,columnNames));
				}
			});
		}
		return Radio_author;
	}

	/**
	 * This method initializes TextField_key	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextField_key() {
		if (TextField_key == null) {
			TextField_key = new JTextField();
			TextField_key.setBounds(new Rectangle(233, 167, 298, 25));
			TextField_key.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyReleased(java.awt.event.KeyEvent e) {
					System.out.print("keeeeeyyyy "+TextField_key.getText());
					
					if(Radio_title.isSelected())
					{Object[][] data = strater.all_books.get_book_by_name(TextField_key.getText());
					//A string array containing the column names for the JTable. 
					String[] columnNames = {"ISBN","Title","Autor"}; 
			
					//Create the JTable using the data array and column name array. 
					Table_book.setModel( new DefaultTableModel(data,columnNames));
					}
					else
					{Object[][] data = strater.all_books.get_book_by_author(TextField_key.getText());
					//A string array containing the column names for the JTable. 
					String[] columnNames = {"ISBN","Title","Autor"}; 
			
					//Create the JTable using the data array and column name array. 
					Table_book.setModel( new DefaultTableModel(data,columnNames));
					}
				}
			});
		}
		return TextField_key;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(45, 200, 500, 220));
			jScrollPane.setViewportView(getTable_book());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes Table_book	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable_book() {
		if (Table_book == null) {
			
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ISBN","Title","Autor"}; 
			int j=0;
			for(int i=0;i<strater.all_books.list.size();i++)
	        {
				data[j][0]=new String(strater.all_books.list.get(i).getISBN());
				data[j][1]=new String(strater.all_books.list.get(i).gettitle());
				data[j][2]=new String(strater.all_books.list.get(i).getauthor());
				j++;
	}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_book =  new JTable(defTableModel);
			Table_book.addMouseListener(new java.awt.event.MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent event) {
	        		if(event.getButton() == event.BUTTON3){
	        			if(Table_book.getSelectedRow()>=0){
							JMenuItem ajouter = new JMenuItem("borrow");
							ajouter.addActionListener(new java.awt.event.ActionListener() {
								public void actionPerformed(java.awt.event.ActionEvent e) {
									int ligne = Table_book.getSelectedRow();
									String cellule =(String) Table_book.getValueAt(ligne,0);
									
									JOptionPane jop1 = new JOptionPane();
									
									if(strater.all_borrow.add_borrow(new Borrow(strater.current_user.getID(),cellule.toString(),new Date())))
										jop1.showMessageDialog(null, "successful operation", "information", JOptionPane.INFORMATION_MESSAGE);
									
										}
							});	
								
							JMenuItem erase = new JMenuItem("reserve");
							erase.addActionListener(new java.awt.event.ActionListener() {
								public void actionPerformed(java.awt.event.ActionEvent e) {
									int ligne = Table_book.getSelectedRow();
									String cellule =(String) Table_book.getValueAt(ligne,0);
									JOptionPane jop1 = new JOptionPane();
									if(strater.all_reservation.add_reservation(new Reservation(strater.current_user.getID(),cellule)))
										jop1.showMessageDialog(null, "successful operation", "information", JOptionPane.INFORMATION_MESSAGE);
								
									
								}
							});
							
							
							
							
							JPopupMenu menu = new JPopupMenu();
							menu.add(ajouter);
							menu.add(erase);
							
							menu.show(Table_book, event.getX(), event.getY());
	        			}}
					
	        	}
	        });
		}
		return Table_book;
	}
	

	

}  //  @jve:decl-index=0:visual-constraint="10,10"
