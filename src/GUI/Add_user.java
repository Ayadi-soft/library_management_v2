package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.JSlider;
import javax.swing.JComboBox;

import MDL.Book;
import MDL.User;
import javax.swing.ImageIcon;

public class Add_user extends JPanel {

	private static final long serialVersionUID = 1L;
	private Panel panel = null;
	private JLabel title = null;
	private JLabel Label_isbn = null;
	private JTextField isbn = null;
	private JLabel Label_title = null;
	private JTextField book_title = null;
	private JLabel Label_author = null;
	private JTextField author = null;
	private JButton Button_validate = null;
	private JButton Button_reset = null;
	private JButton Button_close = null;
	private JLabel Label_tel = null;
	private JLabel Label_adr = null;
	private JLabel Label_dep = null;
	private JLabel Label_type = null;
	private JTextField TextField_phone = null;
	private JTextField TextField_adr = null;
	private JTextField TextField_dep = null;
	private JComboBox ComboBox_type = null;
	App_init strater;
	/**
	 * This is the default constructor
	 */
	public Add_user(App_init strater) {
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
		
		
		
		
		
		Label_type = new JLabel();
		Label_type.setBounds(new Rectangle(107, 231, 64, 22));
		Label_type.setText("Type : ");
		Label_dep = new JLabel();
		Label_dep.setBounds(new Rectangle(107, 358, 85, 24));
		Label_dep.setText("Departement :");
		Label_adr = new JLabel();
		Label_adr.setBounds(new Rectangle(107, 323, 58, 25));
		Label_adr.setText("Adress : ");
		Label_tel = new JLabel();
		Label_tel.setBounds(new Rectangle(107, 294, 102, 27));
		Label_tel.setText("Phone Number : ");
		Label_author = new JLabel();
		Label_author.setBounds(new Rectangle(107, 263, 52, 25));
		Label_author.setText("Email : ");
		Label_title = new JLabel();
		Label_title.setBounds(new Rectangle(107, 192, 44, 26));
		Label_title.setText("Name : ");
		Label_isbn = new JLabel();
		Label_isbn.setBounds(new Rectangle(107, 160, 67, 24));
		Label_isbn.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Label_isbn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Label_isbn.setText("Collage ID :");
		title = new JLabel();
		title.setBounds(new Rectangle(230, 99, 128, 38));
		title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		title.setText("Add User");
		this.setSize(600, 500);
		this.setLayout(null);
		this.add(title, null);
		this.add(Label_isbn, null);
		this.add(getIsbn(), null);
		this.add(Label_title, null);
		this.add(getBook_title(), null);
		this.add(Label_author, null);
		this.add(getAuthor(), null);
		this.add(getButton_validate(), null);
		this.add(getButton_reset(), null);
		this.add(Label_tel, null);
		this.add(Label_adr, null);
		this.add(Label_dep, null);
		this.add(Label_type, null);
		this.add(getTextField_phone(), null);
		this.add(getTextField_adr(), null);
		this.add(getTextField_dep(), null);
		this.add(getComboBox_type(), null);
		
	}

	/**
	 * This method initializes panel	
	 * 	
	 * @return java.awt.Panel	
	 */
	private Panel getPanel() {
		if (panel == null) {
			panel = new Panel();
			panel.setLayout(null);
		}
		return panel;
	}

	/**
	 * This method initializes isbn	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getIsbn() {
		if (isbn == null) {
			isbn = new JTextField();
			isbn.setBounds(new Rectangle(177, 161, 93, 23));
		}
		return isbn;
	}

	/**
	 * This method initializes book_title	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getBook_title() {
		if (book_title == null) {
			book_title = new JTextField();
			book_title.setBounds(new Rectangle(177, 194, 111, 26));
		}
		return book_title;
	}

	/**
	 * This method initializes author	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getAuthor() {
		if (author == null) {
			author = new JTextField();
			author.setBounds(new Rectangle(178, 266, 127, 25));
		}
		return author;
	}

	/**
	 * This method initializes Button_validate	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_validate() {
		if (Button_validate == null) {
			Button_validate = new JButton();
			Button_validate.setBounds(new Rectangle(378, 391, 68, 56));
			Button_validate.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
			Button_validate.setText("");
			Button_validate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.print(ComboBox_type.getSelectedItem().toString());
					JOptionPane jop1 = new JOptionPane();	
					if(	strater.all_users.add_user(new User(isbn.getText(),book_title.getText(),TextField_phone.getText(),author.getText(),TextField_adr.getText(),TextField_dep.getText(),ComboBox_type.getSelectedItem().toString())))
					{
					jop1.showMessageDialog(null,"user inserted ","Information", JOptionPane.INFORMATION_MESSAGE);
					isbn.setText("");
					book_title.setText("");
					author.setText("");
					TextField_adr.setText("");
					TextField_dep.setText("");
					TextField_phone.setText("");
					}
					else
					{jop1.showMessageDialog(null,"user exist ","Alert", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return Button_validate;
	}

	/**
	 * This method initializes Button_reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_reset() {
		if (Button_reset == null) {
			Button_reset = new JButton();
			Button_reset.setBounds(new Rectangle(458, 392, 71, 54));
			Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
			Button_reset.setText("");
			Button_reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					isbn.setText("");
					book_title.setText("");
					author.setText("");
					TextField_adr.setText("");
					TextField_dep.setText("");
					TextField_phone.setText("");
				}
			});
		}
		return Button_reset;
	}

	/**
	 * This method initializes TextField_phone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextField_phone() {
		if (TextField_phone == null) {
			TextField_phone = new JTextField();
			TextField_phone.setBounds(new Rectangle(213, 295, 103, 23));
		}
		return TextField_phone;
	}

	/**
	 * This method initializes TextField_adr	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextField_adr() {
		if (TextField_adr == null) {
			TextField_adr = new JTextField();
			TextField_adr.setBounds(new Rectangle(175, 327, 221, 24));
		}
		return TextField_adr;
	}

	/**
	 * This method initializes TextField_dep	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTextField_dep() {
		if (TextField_dep == null) {
			TextField_dep = new JTextField();
			TextField_dep.setBounds(new Rectangle(195, 358, 149, 26));
		}
		return TextField_dep;
	}

	/**
	 * This method initializes ComboBox_type	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboBox_type() {
		if (ComboBox_type == null) {
			ComboBox_type = new JComboBox();
			ComboBox_type.setBounds(new Rectangle(178, 232, 119, 23));
			ComboBox_type.addItem("student");
			ComboBox_type.addItem("university staff");
			ComboBox_type.addItem("administrator");
		}
		return ComboBox_type;
	}

	

}  //  @jve:decl-index=0:visual-constraint="44,-21"
