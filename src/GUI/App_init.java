package GUI;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	import MDL.*;
import CTL.*;
		public class App_init {
			private JPanel jPane_vide = null;
			public Users all_users;
			public Books all_books ;
			public Borrow_list all_borrow;
			public Reservations all_reservation;
			public User current_user;
			public App main_form;
			
			public  App_init(){
				all_users =new Users();
				all_books =new Books();
				all_borrow=new Borrow_list(this);
				all_reservation= new Reservations(this);
				
				all_users.add_user(new User("1","Mohamed","2287644","aa@gamai.com","usa","","administrator"));
				all_users.add_user(new User("2","Ali","34211231","ff@gamai.com","france","","student"));
				all_users.add_user(new User("3","Salah","98711231","pp@gamai.com","germany","","student"));
				
				all_books.add_book(new Book("1","Introduction to Algorithms ","Thomas H. Cormen "));
				all_books.add_book(new Book("2","Structure  of Computer Programs","Harold Abelson "));
				all_books.add_book(new Book("3","The C Programming Language ","Brian W. Kernighan "));
				all_books.add_book(new Book("4","Design Patterns","Erich Gamma "));
				all_books.add_book(new Book("5","The Pragmatic Programmer ","Andrew Hunt "));
				all_books.add_book(new Book("6","Introduction to the Theory of Computation ","Michael Sipser "));
				all_books.add_book(new Book("7","Artificial Intelligence ","Stuart Russell "));
				
				// Date date1 = new GregorianCalendar(2016,5,11,11,59).getTime( );
				all_borrow.add_borrow(new Borrow("1","1",new GregorianCalendar(2016,4,21).getTime( )));
				all_borrow.add_borrow(new Borrow("1","2",new GregorianCalendar(2016,4,11).getTime( )));
				all_borrow.add_borrow(new Borrow("1","3",new GregorianCalendar(2016,4,12).getTime( )));
				all_borrow.add_borrow(new Borrow("2","4",new GregorianCalendar(2016,4,23).getTime( )));
				all_borrow.add_borrow(new Borrow("2","5",new GregorianCalendar(2016,4,24).getTime( )));
				
				all_reservation.add_reservation(new Reservation("1","6"));
				all_reservation.add_reservation(new Reservation("2","7"));
				
			}	
			
			public void verif_user(String id )
			{
				
				current_user=this.all_users.get_user_by_id(id);
				if(current_user ==null)
				{
					JOptionPane jop1 = new JOptionPane();
					jop1.showMessageDialog(null, "this user does not exist", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					
					if(current_user.user_type==null) System.out.print(current_user.user_type);
					if(current_user.user_type.equalsIgnoreCase("administrator")==true)
					{
						this.main_form.Activate_menu_super_user();
						this.main_form.jFrame.setContentPane(getjpan());
					}
					else
					{
						this.main_form.Activate_menu_normal_user();
						this.main_form.jFrame.setContentPane(getjpan());	
					}
				}
			}
			
			private JPanel getjpan() {
				
					jPane_vide = new JPanel();
					jPane_vide.setSize(600, 500);
					jPane_vide.setLayout(null);
					jPane_vide.add(main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
				
				return jPane_vide;
			}
			
			public void activate() {
				 Authentication form = new Authentication(this,main_form) ;
				 main_form.deactivate_menu();
				 form.add(main_form.jToolBar, BorderLayout.BEFORE_FIRST_LINE);
					main_form.jFrame.setContentPane(form);
					main_form.deactivate_menu();
				
			}

		}
