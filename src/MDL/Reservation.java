package MDL;

import java.util.Date;

public class Reservation {
	
	public String collage_ID;
	public String name;
	public String isbn_number;
	public Date reserv_date;
	
	
	public  Reservation(String ID,String isbn)
	{
		this.collage_ID=ID;
		this.isbn_number=isbn;
		this.reserv_date= new Date();
		
	}
	
}
