package CTL;
import java.util.*;

import javax.swing.JOptionPane;

import MDL.Book;
import MDL.User;
public class Books {
	
	public Vector<Book> list = new Vector<Book>();	
	
	
	public boolean add_book(Book b )
	{
		boolean t=false;
		for(int i=0;i<list.size();i++)
        {
			Book x =(Book) list.get(i);
			
		if(x.getISBN().equalsIgnoreCase(b.getISBN()))
    	{	System.out.print( "Book exixt");
    	t=true;
    	return false; 
		}} 
	         if(t==false)
	    	 list.addElement(b);
	 	return true;
	     
	     }
	
	public boolean remove_book(String isbn )
	{
		boolean t=false;
		for(int i=0;i<list.size();i++)
        {
			Book x =(Book) list.get(i);
	     	if(x.getISBN().equalsIgnoreCase(isbn))
	     	{	System.out.print( "book exixt");
	     	t=true;
	     	return list.remove(x);
	     	
	     	}
	     	}
	     if(t==false)
	    	 System.out.print( "book inexixt");
	 	return false;
	     
	     }

	public Book get_book_by_id(String isbn )
	{
		
		JOptionPane jop1 = new JOptionPane();	
		for(int i=0;i<list.size();i++)
        {
			Book x =(Book) list.get(i);
			if(x.getISBN().equalsIgnoreCase(isbn))
	     	{	System.out.print( "book exixt");
	     	
	     	return x;
	     	
	     	}
	     	}
	     
	     return null; 
	     }
	
	

	public Object[][] get_book_by_author(String author )
	{
		
		Object[][] data = new Object[100][3]; 
		int j=0;
		for(int i=0;i<list.size();i++)
        {
			Book x =(Book) list.get(i);
			if(x.getauthor().indexOf(author)!=-1)
	     	{	
	     	data[j][0]=new String(list.get(i).getISBN());
			data[j][1]=new String(list.get(i).gettitle());
			data[j][2]=new String(list.get(i).getauthor());
	     	j++;
	     	     	
	     	}
	   	}
	    
	 	return data;
	     
	     }
	
	

	public Object[][] get_book_by_name(String name )
	{
		int j=0;
		Object[][] data = new Object[100][3]; 
		for(int i=0;i<list.size();i++)
        {
			Book x =(Book) list.get(i);
			System.out.print( x.gettitle()+"  vs  "+name); System.out.println(x.gettitle().indexOf(name));
			if(x.gettitle().indexOf(name)!=-1)
	     	{	
	     	data[j][0]=new String(list.get(i).getISBN());
			data[j][1]=new String(list.get(i).gettitle());
			data[j][2]=new String(list.get(i).getauthor());
			j++;
	     	     	
	     	}
	   	}
	    
	 	return data;
	     }
	
	


}



