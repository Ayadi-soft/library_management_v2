package MDL;

import java.util.Date;

public class Borrow {
	
	public String collage_ID;
	public String name;
	public String isbn_number;
	public Date borrow_date;
	public Date retour_date;
	
	
	public Borrow(String id,String isbn)
	{
		this.collage_ID=id;
		this.isbn_number=isbn;
		this.borrow_date= new Date();
		this.retour_date= null;
	}
	
	public Borrow(String id,String isbn,Date d)
	{
		this.collage_ID=id;
		this.isbn_number=isbn;
		this.borrow_date= d;
		this.retour_date= null;
	}
	 

}
