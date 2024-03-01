package MDL;

import java.util.Vector;

public class Book {
	private String isbn_number;
	private String title;
	private String author;
	
	//public Vector<borrow_book> _unnamed_borrow_book_ = new Vector<borrow_book>();
	//public Vector<return_book> _unnamed_return_book_ = new Vector<return_book>();
	//public Vector<reserve_book> _unnamed_reserve_book_ = new Vector<reserve_book>();
	//public student _unnamed_student_;
	
	public  Book(String isbn){
		 this.isbn_number = isbn;
	}
	public  Book(String isbn,String title,String author){
		this.isbn_number = isbn;
		this.title = title;
		this.author = author;
	}
	
	  public String getISBN()
      {
        return isbn_number;
      }    
	  public String gettitle()
      {
        return title;
      }  
	  public String getauthor()
      {
        return author;
      }
	  
	  public void setISBN(String isbn)
      {
        this.isbn_number = isbn;
      }
	  public void setTitle(String title)
      {
        this.title = title;
      } 
	  public void setAuthor(String author)
      {
          this.author = author;
        }
	  
	  
}
