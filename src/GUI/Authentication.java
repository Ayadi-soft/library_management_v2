package GUI;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Authentication extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_id = null;
	private JTextField id = null;
	private JButton ok = null;
	private JButton Button_reset = null;
	App a;
	App_init strater;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	/**
	 * This is the default constructor
	 */
	public Authentication(App_init strater,App a) {
		super();
		this.a=a;
		this.strater=strater;
		initialize();
		a.deactivate_menu();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(75, 404, 241, 23));
		jLabel1.setText("the ID of a sutudent is : 2");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(77, 373, 240, 22));
		jLabel.setText("the ID of the Administrator is : 1");
		Label_id = new JLabel();
		Label_id.setBounds(new Rectangle(179, 215, 90, 27));
		Label_id.setText("College ID : ");
		Label_title = new JLabel();
		Label_title.setText("Authentication");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(212, 144, 171, 34));
		this.setSize(600, 500);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(Label_id, null);
		this.add(getId(), null);
		this.add(getOk(), null);
		this.add(getButton_reset(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
	}

	/**
	 * This method initializes id	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getId() {
		if (id == null) {
			id = new JTextField();
			id.setBounds(new Rectangle(300, 213, 124, 30));
		}
		return id;
	}

	/**
	 * This method initializes ok	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getOk() {
		if (ok == null) {
			ok = new JButton();
			ok.setBounds(new Rectangle(250, 300,  50, 50));
			ok.setIcon(new ImageIcon(getClass().getResource("/Img/val.png")));
			ok.setText("");
			ok.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					strater.verif_user(id.getText() );
					id.setText("");
				}
			});
		}
		return ok;
	}

	/**
	 * This method initializes Button_reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_reset() {
		if (Button_reset == null) {
			Button_reset = new JButton();
			Button_reset.setBounds(new Rectangle(350, 300,  50, 50));
			Button_reset.setIcon(new ImageIcon(getClass().getResource("/Img/reset.png")));
			Button_reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					id.setText("");
				}
			});
		}
		return Button_reset;
	}

	
}  //  @jve:decl-index=0:visual-constraint="10,10"
