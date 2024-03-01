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

import MDL.Book;

import java.awt.ComponentOrientation;
import javax.swing.ImageIcon;

public class Add_book extends JPanel {

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
	public App_init strater;
	/**
	 * This is the default constructor
	 */
	public Add_book(App_init strater) {
		super();
		this.strater=strater;
		if (strater==null)System.out.print( "const nulll starter");
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		
		
		
		
		Label_author = new JLabel();
		Label_author.setBounds(new Rectangle(183, 294, 52, 25));
		Label_author.setText("Author : ");
		Label_title = new JLabel();
		Label_title.setBounds(new Rectangle(182, 253, 44, 26));
		Label_title.setText("Title : ");
		Label_isbn = new JLabel();
		Label_isbn.setBounds(new Rectangle(180, 206, 43, 24));
		Label_isbn.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		Label_isbn.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Label_isbn.setText("ISBN :");
		title = new JLabel();
		title.setBounds(new Rectangle(215, 112, 151, 41));
		title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		title.setText("Add book");
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
			isbn.setBounds(new Rectangle(226, 206, 93, 26));
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
			book_title.setBounds(new Rectangle(229, 251, 111, 26));
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
			author.setBounds(new Rectangle(241, 294, 127, 25));
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
			Button_validate.setBounds(new Rectangle(342, 394, 100, 50));
			Button_validate.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
			Button_validate.setText("");
			Button_validate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane jop1 = new JOptionPane();	
				if(	strater.all_books.add_book(new Book(isbn.getText(),book_title.getText(),author.getText())))
				{
				jop1.showMessageDialog(null,"book inserted ","Information", JOptionPane.INFORMATION_MESSAGE);
				isbn.setText("");
				book_title.setText("");
				author.setText("");
				}
				else
				{jop1.showMessageDialog(null,"book exist ","Alert", JOptionPane.ERROR_MESSAGE);
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
			Button_reset.setBounds(new Rectangle(450, 394, 100, 50));
			Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
			
			Button_reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					isbn.setText("");
					book_title.setText("");
					author.setText("");
				}
			});
		}
		return Button_reset;
	}

	

}  //  @jve:decl-index=0:visual-constraint="64,88"
