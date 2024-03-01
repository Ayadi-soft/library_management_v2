package MDL;



public class User {
	private String collage_ID;
	private String name;
	private String phone_number;
	private String email;
	private String address;
	private String department;
	public float sum_fines_payed;
	public float sum_fines_credit;
	public String user_type="";

	
	
	public  User(String id)
	{ this.collage_ID = id;} 
	
	public  User(String id,String name)
	{ this.collage_ID = id;
	this.name = name;} 
	
	
	public  User(String id,String name, String phone ,String email ,String adr,String dep,String type )
	{ this.collage_ID = id;
	this.name = name;
	this.phone_number = phone;
	this.email = email;
	this.address = adr;
	this.department = dep;
	this.user_type=type;
	} 
	
	
	
	 public void setCollage_ID(String collage_ID)
     {
       this.collage_ID = collage_ID;
     }
	 public void setName_ID(String name)
     {
       this.name = name;
     }
	 public void setPhone_number(String phonenumber)
     {
       this.phone_number = phonenumber;
     }
	 public void setEmail(String email)
     {
       this.email = email;
     }
	 public void setAddress(String address)
     {
       this.address = address;
     }
	 public void setDepartment(String department)
     {
       this.department = department;
     }
	 
	 public String getDepartment()
     {
       return department;
     }    
	 
	 public String getAddress()
     {
       return address;
     } 
	 public String getEmail()
     {
       return email;
     } 
	 public String getPhone_number()
     {
       return phone_number;
     } 
	 public String getName()
     {
       return name;
     } 
	 public String getID()
     {
       return collage_ID;
     } 
	 
	 
	 
}