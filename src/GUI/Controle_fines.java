package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import MDL.Borrow;

public class Controle_fines extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JScrollPane jScrollPane = null;
	private JTable Table_fines = null;
	App_init strater;
	private JLabel Lab_lab = null;
	private JLabel lab_total = null;
	/**
	 * This is the default constructor
	 */
	public Controle_fines(App_init strater) {
		super();
		this.strater=strater;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		lab_total = new JLabel();
		lab_total.setBounds(new Rectangle(459, 403, 67, 29));
		lab_total.setText("");
		Lab_lab = new JLabel();
		Lab_lab.setBounds(new Rectangle(408, 402, 37, 28));
		Lab_lab.setText("total : ");
		Label_title = new JLabel();
		Label_title.setText("Control of fines");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		Label_title.setBounds(new Rectangle(196, 107, 217, 42));
		this.setSize(600, 500);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(getJScrollPane(), null);
		this.add(Lab_lab, null);
		this.add(lab_total, null);
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(45, 170, 501, 220));
			jScrollPane.setViewportView(getTable_fines());
		}
		return jScrollPane;
	}

	// la differance betwin 2 date
	  public static long differenceDate(Date date1, Date date2)
	  {
		long UNE_HEURE = 60 * 60 * 1000L;
	    return ((date2.getTime() - date1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
	  }
	
	/**
	 * This method initializes Table_fines	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable_fines() {
		if (Table_fines == null) {
			Object[][] data = new Object[100][6]; int nb=0; double sum=0; double total=0;
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ISBN","User ID","borrow date","number of days","Fines"}; 
			int j=0; 
			for(int i=0;i<strater.all_borrow.list.size();i++)
	        {
				sum=0;
				 Borrow x =(Borrow)strater.all_borrow.list.get(i);
			     if(   x.retour_date==null ){ 
				data[j][0]=new String(x.isbn_number);
				
				data[j][1]=new String(x.collage_ID);
				
				data[j][2]=new String("");
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				data[j][2] = sdf.format(x.borrow_date);
				
				nb=(int)differenceDate( x.borrow_date,new Date());
				data[j][3]=new String("a");
				data[j][3]=nb;
				if(nb>5)sum=(nb-5)*200;
				data[j][4]=new String("a");
				data[j][4]=sum*0.001;
				j++; total+=sum*0.001;
	        }}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_fines =  new JTable(defTableModel);
			 
			lab_total.setText(Double.toString(total)+"  RIAL");
		}
		return Table_fines;
	}

}  
