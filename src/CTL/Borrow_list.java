package CTL;

import java.util.*;

import javax.swing.JOptionPane;



import GUI.App_init;
import MDL.Borrow;
import MDL.User;

public class Borrow_list {
	
public Vector<Borrow> list = new Vector<Borrow>();	
App_init strater;


	public  Borrow_list(App_init strater)
	{
		this.strater=strater;
	}
	
	
	public boolean add_borrow(Borrow b )
	{
		JOptionPane jop1 = new JOptionPane();
		boolean t=false;
		//existance of book
		if(strater.all_books.get_book_by_id(b.isbn_number)==null)
		{
			jop1.showMessageDialog(null, "this book doesn't exist", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
		
		 /*existance ok borrow*/
		for(int i=0;i<list.size();i++)
        {

	         Borrow x =(Borrow)list.get(i);
	     	if(x.collage_ID.equalsIgnoreCase(b.collage_ID) && x.isbn_number.equalsIgnoreCase(b.isbn_number)&& x.retour_date==null )
	     	{	jop1.showMessageDialog(null, "you have already borrow this book", "Alert", JOptionPane.WARNING_MESSAGE);
	     	
	     	t=true;
	     	return false;
	     	
	     	}
	     	}
		
	     if(t==false)
	    	 {
	    	
	    	 
	    	 //number of borrow verification
	    	 if(get_borrow_nb(b.collage_ID)>2)
	    	 {
	    		 jop1.showMessageDialog(null, "you have depassed 3 book", "Alert", JOptionPane.WARNING_MESSAGE);
	    		 return false;
	    	 }
	    	 else
	    	 {
	    		//the book is borreed yes/no
	    	 		
	    	 		if(strater.all_borrow.is_borrowed_now(b.isbn_number)==true)
	    	 		{
	    	 			jop1.showMessageDialog(null, "this book is borrowed by another user", "Alert", JOptionPane.WARNING_MESSAGE);
	    	 			return false;
	    	 		}
	    		 list.addElement(b);
	    	 return true;
	    	 }
	    	 
	 	
	    	 }return true;
	     }

	public boolean return_borrow(String id,String isbn )
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
	         Borrow x =(Borrow)list.get(i);
	     	if(x.collage_ID.equalsIgnoreCase(id) && x.isbn_number.equalsIgnoreCase(isbn)&& x.retour_date==null)
	     	{	System.out.print( "borrow exixt");
	     	t=true;
	     	//calcul of fines
	     	int sum=get_fines_sum(id,isbn);
	     	User u=strater.all_users.get_user_by_id(id);
			if(sum!=0)
			{	
	     		//message de validation de pay
				  response = JOptionPane.showConfirmDialog(null, "You have to pay \n"+sum*0.001 + "    RIAL.\n"+"Do you want to pay them now ?", "Confirm",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.NO_OPTION) {
					    	jop1.showMessageDialog(null, "you should pay fines before returning this book", "Alert", JOptionPane.WARNING_MESSAGE);
							return false;
					    } else if (response == JOptionPane.YES_OPTION) {
					    	double z=sum*0.001;
					    	u.sum_fines_payed=u.sum_fines_payed+(float)z;
					    	x.retour_date=new Date();
					    	jop1.showMessageDialog(null, "book is returned", "Information", JOptionPane.INFORMATION_MESSAGE);
					     	return true;
					     	
					     } else if (response == JOptionPane.CLOSED_OPTION) {
					    	return false;
					    }
	     	
	     	}
			x.retour_date=new Date();
	    	jop1.showMessageDialog(null, "book is returned", "Information", JOptionPane.INFORMATION_MESSAGE);
	     	return true;
	     	}}
	     if(t==false)
	     {
	     jop1.showMessageDialog(null, "you haven't borrow this book" , "Alert", JOptionPane.ERROR_MESSAGE);
	 	
	     }
	     return false;
	     }
	

	// calculate number of borrows
	public int get_borrow_nb(String id )
	{
			int nb=0;
			for(int i=0;i<list.size();i++)
	        {
		         Borrow x =(Borrow)list.get(i);
		     	if(x.collage_ID.equalsIgnoreCase(id)&& x.retour_date==null  )
		     	{	
		     	nb++;
	     	
		     	}
	     	}
	     
	 	return nb;
	     
	     }
	
	// la differance betwin 2 date
	  public static long differenceDate(Date date1, Date date2)
	  {
		long UNE_HEURE = 60 * 60 * 1000L;
	    return ((date2.getTime() - date1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
	  }
	
	// calculate fins sum
	public int get_fines_sum(String id,String isbn )
	{
		int sum=0; int nb=0;
			for(int i=0;i<list.size();i++)
	        {
		         Borrow x =(Borrow)list.get(i);
		     	if(x.collage_ID.equalsIgnoreCase(id)&&x.isbn_number.equalsIgnoreCase(isbn) && x.retour_date==null )
		     	{	
		     		System.out.print( "borrow exixt");
		     		nb=(int)differenceDate( x.borrow_date,new Date());
		     		if(nb>5)sum=(nb-5)*200;
		     		return sum;
	     	
		     	}
	     	}
	     
	 	return sum;
	     
	     }
	
	
	public boolean is_borrowed_now(String isbn )
	{
		
		boolean t=false;
		
		
		 /*existance ok borrow*/
		for(int i=0;i<list.size();i++)
        {

	         Borrow x =(Borrow)list.get(i);
	     	if(x.retour_date==null && x.isbn_number.equalsIgnoreCase(isbn) )
	     	{		     	
	     	
	     	return true;
	     	
	     	}
	     	}
		return false;
	}

	
	public boolean is_borrowed(String isbn )
	{
		
		boolean t=false;
		
		
		 /*existance ok borrow*/
		for(int i=0;i<list.size();i++)
        {

	         Borrow x =(Borrow)list.get(i);
	     	if(x.isbn_number.equalsIgnoreCase(isbn) )
	     	{		     	
	     	
	     	return true;
	     	
	     	}
	     	}
		return false;
	}

}
