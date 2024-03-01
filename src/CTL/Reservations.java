

	package CTL;

	import java.util.Date;
	import java.util.Enumeration;
	import java.util.Vector;

import javax.swing.JOptionPane;

import GUI.App_init;
	import MDL.Borrow;
import MDL.Reservation;
import MDL.User;

	public class Reservations {
		
		public Vector<Reservation> list = new Vector<Reservation>();	
		App_init strater;
		
		public Reservations(App_init strater)
		{
			this.strater=strater;
			
		}
		
		
		public boolean add_reservation(Reservation r )
		{

			JOptionPane jop1 = new JOptionPane();
			boolean t=false;
			//existance of book
			if(strater.all_books.get_book_by_id(r.isbn_number)==null)
			{
				jop1.showMessageDialog(null, "this book doesn't exist", "Alert", JOptionPane.WARNING_MESSAGE);
				return false;
			}
	
			 /*existance ok reservation*/
			for(int i=0;i<list.size();i++)
	        {

				Reservation x =(Reservation)list.get(i);
		     	if(x.collage_ID.equalsIgnoreCase(r.collage_ID) && x.isbn_number.equalsIgnoreCase(r.isbn_number) )
		     	{	jop1.showMessageDialog(null, "you have already reserved this book", "Alert", JOptionPane.WARNING_MESSAGE);
		     	
		     	t=true;
		     	return false;
		     	
		     	}
		     	}
			
		     if(t==false)
		    	 {
		    	
		    	 
		    	 //number of borrow verification
		    	 if(get_reservation_nb(r.collage_ID)>2)
		    	 {
		    		 jop1.showMessageDialog(null, "you have already reserved 3 book", "Alert", JOptionPane.WARNING_MESSAGE);
		    		 return false;
		    	 }
		    	 else
		    	 {
		    		//the book is borreed yes/no
		    	 		
		    	 		if(strater.all_reservation.is_reserved(r.isbn_number)==true)
		    	 		{
		    	 			jop1.showMessageDialog(null, "this book is reserveded by another user", "Alert", JOptionPane.WARNING_MESSAGE);
		    	 			return false;
		    	 		}
		    		 list.addElement(r);
		    	 return true;
		    	 }
		    	 
		 	
		    	 }return true;
		     }

		public boolean remove_reservation(String id,String isbn )
		{
			boolean t=false;
			int response=0;
			int dialogResult;
			JOptionPane jop1 = new JOptionPane();
			
			//existance of book
			if(strater.all_books.get_book_by_id(isbn)==null)
			{
				jop1.showMessageDialog(null, "this book doesn't exist", "Alert", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			/*existance ok borrow*/
			for(int i=0;i<list.size();i++)
	        {
				Reservation x =(Reservation)list.get(i);
		     	if(x.collage_ID.equalsIgnoreCase(id) && x.isbn_number.equalsIgnoreCase(isbn))
		     	{	System.out.print( "borrow exixt");
		     	t=true;
		     	list.remove(x);
		    	jop1.showMessageDialog(null, "book reservation is deleted", "Information", JOptionPane.INFORMATION_MESSAGE);
		     	return true;
		     	}}
		     if(t==false)
		     {
		     jop1.showMessageDialog(null, "you haven't reserved this book" , "Alert", JOptionPane.ERROR_MESSAGE);
		 	
		     }
		     return false;
		     }
		
		
		
		public int get_reservation_nb(String id )
		{
			int nb=0;
			for(int i=0;i<list.size();i++)
			{
				Reservation x =(Reservation)list.get(i);
	     	if(x.collage_ID.equalsIgnoreCase(id) )
	     	{	
	     	nb++;
     	
	     	}
        	}
     
			return nb;
     
		     
		     }


		
		public boolean is_reserved(String isbn )
		{
			
			boolean t=false;
			
			
			 /*existance ok borrow*/
			for(int i=0;i<list.size();i++)
	        {

				Reservation x =(Reservation)list.get(i);
		     	if(x.isbn_number.equalsIgnoreCase(isbn) )
		     	{		     	
		     	
		     	return true;
		     	
		     	}
		     	}
			return false;
		}

		
	}
