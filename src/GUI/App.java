package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class App {

	public JFrame jFrame = null;
	private JPanel jContentPane = null;
	public JToolBar jToolBar = null;
	private JButton Button_logout = null;
	private JButton Button_user_info = null;
	private JButton Button_book_search = null;
	private JButton Button_user_mgr = null;
	private JButton Button_book_mgr = null;
	private JButton Button_fines = null;
	private JButton Button_exit = null;
	public static App_init strater;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 strater = new App_init();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//App_init strater = new App_init();
				App application = new App();
				application.getJFrame().setVisible(true);
				strater.main_form=application;
				strater.activate();
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setSize(600, 500);
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setLocation((screenSize.width-jFrame.getSize().width)/2,(screenSize.height-jFrame.getSize().height)/2);
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Library Management");
		}
		return jFrame;
	}


	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
		}
		return jContentPane;
	}
	
	/**
	 * This method initializes jToolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.add(getButton_logout());
			jToolBar.add(getButton_user_info());
			jToolBar.add(getButton_book_search());
			jToolBar.add(getButton_user_mgr());
			jToolBar.add(getButton_book_mgr());
			jToolBar.add(getButton_fines());
			jToolBar.add(getButton_exit());
			
		}
		return jToolBar;
	}

	/**
	 * This method initializes Button_logout	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_logout() {
		if (Button_logout == null) {
			Button_logout = new JButton();
			Button_logout.setIcon(new ImageIcon(getClass().getResource("/Img/logout.png")));
			Button_logout.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					 Authentication form = new Authentication(strater,strater.main_form) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
					deactivate_menu();
				}
			});
		}
		return Button_logout;
	}

	/**
	 * This method initializes Button_user_info	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_user_info() {
		if (Button_user_info == null) {
			Button_user_info = new JButton();
			Button_user_info.setIcon(new ImageIcon(getClass().getResource("/Img/user_info.png")));
			Button_user_info.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Info_user form = new Info_user(strater);
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_user_info;
	}

	/**
	 * This method initializes Button_book_search	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_book_search() {
		if (Button_book_search == null) {
			Button_book_search = new JButton();
			Button_book_search.setIcon(new ImageIcon(getClass().getResource("/Img/borrow.png")));
			Button_book_search.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {	
					search_book form = new search_book(strater) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_book_search;
	}

	/**
	 * This method initializes Button_user_mgr	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_user_mgr() {
		if (Button_user_mgr == null) {
			Button_user_mgr = new JButton();
			Button_user_mgr.setIcon(new ImageIcon(getClass().getResource("/Img/user_conf.png")));
			Button_user_mgr.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					User_list form = new User_list(strater) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_user_mgr;
	}

	/**
	 * This method initializes Button_book_mgr	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_book_mgr() {
		if (Button_book_mgr == null) {
			Button_book_mgr = new JButton();
			Button_book_mgr.setIcon(new ImageIcon(getClass().getResource("/Img/book_mgr.png")));
			Button_book_mgr.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Book_list form = new Book_list(strater) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_book_mgr;
	}

	/**
	 * This method initializes Button_fines	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_fines() {
		if (Button_fines == null) {
			Button_fines = new JButton();
			Button_fines.setIcon(new ImageIcon(getClass().getResource("/Img/fines.png")));
			Button_fines.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					
					Controle_fines form = new Controle_fines(strater) ;
					form.add(getJToolBar(), BorderLayout.BEFORE_FIRST_LINE);
					jFrame.setContentPane(form);
				}
			});
		}
		return Button_fines;
	}

	/**
	 * This method initializes Button_exit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_exit() {
		if (Button_exit == null) {
			Button_exit = new JButton();
			Button_exit.setIcon(new ImageIcon(getClass().getResource("/Img/arreter.png")));
			Button_exit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);}
			});
		}
		return Button_exit;
	}


	public void deactivate_menu()
	{
		 Button_logout.setEnabled(false);
		  Button_user_info.setEnabled(false);
		 Button_book_search.setEnabled(false);
		 Button_user_mgr.setEnabled(false);
		 Button_book_mgr.setEnabled(false);
		 Button_fines.setEnabled(false);
		
	}
	
	public void Activate_menu_super_user()
	{
		 Button_logout.setEnabled(true);
		  Button_user_info.setEnabled(true);
		 Button_book_search.setEnabled(true);
		 Button_user_mgr.setEnabled(true);
		 Button_book_mgr.setEnabled(true);
		 Button_fines.setEnabled(true);
	}
	public void Activate_menu_normal_user()
	{
		 Button_logout.setEnabled(true);
		  Button_user_info.setEnabled(true);
		 Button_book_search.setEnabled(true);
	}
}
