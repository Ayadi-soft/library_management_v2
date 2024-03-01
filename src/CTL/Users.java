

	package CTL;
	import java.util.*;

	import MDL.Book;
	import MDL.User;
	public class Users {
		
		public Vector<User> list = new Vector<User>();	
		
		
		public boolean add_user(User b )
		{
			boolean t=false;
		
			for(int i=0;i<list.size();i++)
	        {
				User x =(User)list.get(i);
			if(x.getID().equalsIgnoreCase(b.getID()))
	     	{	System.out.print( "user exixt");
	     	t=true;
	     	return false; 
			}}
			
		    
		    
		     if(t==false)
		    	 list.addElement(b);
		     System.out.print( "user addeed");
		 	return true;
		     
		     }

		
		public boolean remove_user(String id  )
		{
			boolean t=false;
				
			for(int i=0;i<list.size();i++)
	        {
				User x =(User)list.get(i);
			if(x.getID().equalsIgnoreCase(id))
	     	{	System.out.print( "user exixt and will be deleted");
	     	t=true;
		     	return list.remove(x);
		     	
		     	}
		     	}
		     if(t==false)
		    	 System.out.print( "user inexixt");
		 	return false;
		     
		     }
		
		public User get_user_by_id(String id )
		{
				
			for(int i=0;i<list.size();i++)
	        {
				User x =(User)list.get(i);
			if(x.getID().equalsIgnoreCase(id))
	     	{	
		     	return x;
		     	
		     	}
		     	}
		    
		 	return null;
		     
		     }

	}

