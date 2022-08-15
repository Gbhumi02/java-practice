import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Pro implements ActionListener, ItemListener
{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    JFrame f1,f2,f3,f4,f5,f6,f7,f8;
    JPanel p1,p2,p3,p4,p5;
    JLabel lb1,lb2,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JTextField t0,t1,ps,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12;
    JTextArea tr1;
    ImageIcon bimg1,bimg2;
    Choice ch1,ch2,ch3;
    Color c1;
    String branch,semester,section;
    JTable tb;
    JScrollPane sp;
    DefaultTableModel dtm;

    public Pro()
    {
//*******First Interface************
         f1=new JFrame("Library Management System");
       //  p3 = new JPanel();
        bimg1=new ImageIcon("i1.jpg");
        // p3.setBackground(Color.MAGENTA);
         //p3.setSize(500,500);
         c1=new Color(31,190,214);
         lb1=new JLabel(bimg1);

         t0=new JTextField(8);
         ps=new JPasswordField(8);
    //     lb1.setSize(400,400);
         f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f1.setVisible(true);
        f1.setLayout(new BorderLayout());
        f1.setLayout(new FlowLayout());
        b1=new JButton("LogIn");
        b1.setBackground(c1);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
      //  p3.add(b1);

f1.add(b1);
        f1.add(lb1);
    //   lb1.add(b1);
        f1.setSize(2000,2000);
        
//*******Second Interface************
        f2=new JFrame("Options");
       bimg2=new ImageIcon("bgimg.png");
        f2.setBackground(Color.MAGENTA);
        f2.setBackground(Color.DARK_GRAY);
        lb2=new JLabel(bimg2);
        b2=new JButton("Issue book");
        b2.setBounds(600,50,150,80);
        b2.setBackground(c1);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b3=new JButton("Return book");
        b3.setBackground(c1);
        b3.setForeground(Color.white);
        b3.setBounds(600,200,150,80);
        b3.addActionListener(this);
        b4=new JButton("All books");
        b4.setBackground(c1);
        b4.setForeground(Color.white);
        b4.setBounds(600,350,150,80);
        b4.addActionListener(this);
        b5=new JButton("Insert Books");
        b5.setBackground(c1);
        b5.setForeground(Color.white);
        b5.setBounds(600,500,150,80);
        b5.addActionListener(this);
//        b6=new JButton("Create new Admin");
//        b6.setBackground(c1);
//        b6.setForeground(Color.white);
//        b6.setBounds(600,400,150,80);
//        b6.addActionListener(this);
        lb2.add(b2);
        lb2.add(b3);
        lb2.add(b4);
        lb2.add(b5);
        f2.add(lb2);
        f2.setSize(2000,2000);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//*********Issuing Frame*************        
        
          f3=new JFrame("Issuing frame");
         // f3.setLayout(new GridLayout(7,2));
p1=new JPanel();
p1.setBackground(Color.LIGHT_GRAY);
p2=new JPanel();
p2.setBackground(Color.LIGHT_GRAY);
l1=new JLabel("Student Name");
l2=new JLabel("Enrollment Number");
l3=new JLabel("Branch");
l4=new JLabel("Section");
l5=new JLabel("Semester");
l6=new JLabel("Book number");
l7=new JLabel("Book Name");
t1=new JTextField(8);
t2=new JTextField(8);
t3=new JTextField(8);
t4=new JTextField(8);

ch1=new Choice();
ch2=new Choice();
ch3=new Choice();
ch1.add("CSE");
ch1.add("ME");
ch1.add("CE");
ch1.add("EE");
ch1.add("EX");
ch1.add("AI&DS");
ch1.add("Pharma");
ch1.add("MBA");
ch2.add("1");
ch2.add("2");
ch2.add("3");
ch2.add("4");
ch2.add("5");
ch3.add("1");
ch3.add("2");
ch3.add("3");
ch3.add("4");
ch3.add("5");
ch3.add("6");
ch3.add("7");
ch3.add("8");
ch1.addItemListener(this);
ch2.addItemListener(this);
ch3.addItemListener(this);
p1.setLayout(new GridLayout(7,2));
p1.add(l1);
p1.add(t1);
p1.add(l2);
p1.add(t2);
p1.add(l3);
p1.add(ch1);
p1.add(l4);
p1.add(ch2);
p1.add(l5);
p1.add(ch3);
p1.add(l6);
p1.add(t3);
p1.add(l7);
p1.add(t4);

b7=new JButton("Insert");
b7.addActionListener(this);
b7.setBounds(500,100,30,30);

p2.add(b7);


f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f3.setLayout(new GridLayout(2,1));
f3.add(p1);
f3.add(p2);
f3.setSize(2000,2000);

        
//**********************************RETURNING FRAME**************************************
f5 = new JFrame("Returning Books");
f5.setLayout(new GridLayout(2,2));

l9 = new JLabel("Enter book number");
t6 = new JTextField(8);
b8 = new JButton("Return");
b8.addActionListener(this);
f5.add(l9);
f5.add(t6);

f5.add(b8);
f5.setSize(300,300);
f5.setVisible(false);


//*******************ALL BOOKS FRAME************************
f6 = new JFrame("ALL AVAILABLE BOOKS");
dtm = new DefaultTableModel();
tb = new JTable(dtm);
sp = new JScrollPane(tb); 
dtm.addColumn("Book Name");
dtm.addColumn("Book No.");
dtm.addColumn("Semester");
dtm.addColumn("Branch");

f6.add(sp);

f6.setSize(2000,2000);
f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//*************************INSERTING BOOK FRAME**************************
f7 = new JFrame("Inserting Books");
l10 = new JLabel("Book name");
t9 = new JTextField(20);
l11 = new JLabel("Book number");
t10 = new JTextField(10);
l12 = new JLabel("For Branch");
t11 = new JTextField(8);
l13 = new JLabel("For semester");
t12 = new JTextField(10);

b9 = new JButton("Insert");
b9.addActionListener(this);

f7.setLayout(new GridLayout(2,1));

p4 = new JPanel();
p4.setLayout(new GridLayout(4,2));
p5 = new JPanel();

p4.add(l10);
p4.add(t9);
p4.add(l11);
p4.add(t10);
p4.add(l12);
p4.add(t11);
p4.add(l13);
p4.add(t12);

p5.add(b9);

f7.add(p4);
f7.add(p5);

f7.setSize(2000,2000);
f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//constructor close
    
    
    
    
    
//***********BUTTON Functions********
public void actionPerformed(ActionEvent act){
	
	
 //************************************LogIn Button****************************
        if(act.getSource()==b1){
             Object[] message = {
                  "Username:", t0,
                  "Password:", ps
              };
          int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                   if (t0.getText().equals("h") && ps.getText().equals("h")) {
                         JOptionPane.showMessageDialog(lb1,"Login successful");
                         f2.setVisible(true);
                         
                      } 
                   else {
                         JOptionPane.showMessageDialog(lb1,"login failed");
                        }
             } 
            else {
                 JOptionPane.showMessageDialog(lb1,"Login cancelled");
             }
         }


//**********Issue button*************
         if(act.getSource()==b2){
        	 
        	 //issue visible
            f3.setVisible(true);  
            
         }
         
         //***********************************************************
         
         if(act.getSource()==b3){
        	 
        	 //return visible
             f5.setVisible(true);  
             
          }
         
         /////////////////////////ALL BOOKS FRAME DETAILS BUTTONS/////////////////////////
         
         if (act.getSource() == b4){
        	 f6.setVisible(true);
        	 String bn,bno,b,sem;
      		try {
      		         Class.forName("com.mysql.jdbc.Driver");
      		      } 
      		catch(ClassNotFoundException e) {
      		         System.out.println("Class not found "+ e);
      		      }
      		try {
      		Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bhumigupta","root","rootwdp");
      		         
      		PreparedStatement pst6 = con.prepareStatement("select * from allbook");

      		ResultSet rs = pst6.executeQuery();

      		

      		while (rs.next()){
      		bn = rs.getString(1);
      		bno = rs.getString(2);
      		b = rs.getString(3);
      		sem = rs.getString(4);
      		
      		dtm.addRow(new Object[]{bn,bno,b,sem});
      		}
      		}
      		catch(Exception e){
      		JOptionPane.showMessageDialog(f6,e.getMessage());
      		}
      		        	 }
         
         
         //*****??????***********INSERTING NEW BOOKS*******????????*************
         
         if(act.getSource()==b5){
        	 //NEW BOOK FRAME VISIBLE
        	 
             f7.setVisible(true);  
             
          }
         
         //(((((((((((((((((((((((ISSUE BOOK BUTTON)))))))))))))))))))))))
         
         if(act.getSource()==b7) {
        	 String s1="", s2 = "", s3 = "",s4 ="",s5="",s6="",s7="";
        	
        	      s1=t1.getText();
        	      s2=t2.getText();
        	      s3=ch1.getSelectedItem();
        	      s4 = ch2.getSelectedItem();
        	      s5 = ch3.getSelectedItem();
        	      s6 = t3.getText();
        	      s7 = t4.getText();

       

        	 try {
        	 Class.forName("com.mysql.jdbc.Driver");
        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhumigupta","root","rootwdp");


        	 PreparedStatement pst = con.prepareStatement("INSERT INTO book values(?,?,?,?,?,?,?)");
        	 pst.setString(1,s1);
        	 pst.setString(2,s2);
        	 pst.setString(3,s3);
        	pst.setString(4,s4);
        	 pst.setString(5,s5);
        	 pst.setString(6,s6);
        	 pst.setString(7,s7);

        	 int sm = pst.executeUpdate();

        	 if(sm!=0)
        	 JOptionPane.showMessageDialog(f3,"Issued");

        	 else {
        	 t1.setText("");
        	 t2.setText("");
        	 t3.setText("");
        	 t4.setText("");
        	 JOptionPane.showMessageDialog(f3,"Error");
        	 con.close();
        	 }
        	 }
        	 catch(Exception e){
        	 JOptionPane.showMessageDialog(f3,e.getMessage());
        	 //System.out.println();
        	 }
         }
         
         
         
         //{{{{{{{{{{{{{{{{{{ RETURN BOOK BUTTON }}}}}}}}}}}}}}}}}}
         if(act.getSource()==b8) {
        	 String s1 = t6.getText();
        	// String s2 = t7.getText();
         try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhumigupta","root","rootwdp");


         PreparedStatement pst2 = con.prepareStatement("delete from book where bookNum = ?");

         pst2.setString(1,s1);
        // pst2.setString(2,s2);


         int en = pst2.executeUpdate();
         if(en!=0)
         JOptionPane.showMessageDialog(f5,"Returned");

         else 
         {
         JOptionPane.showMessageDialog(f5,"No such record");
         con.close();
         }
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(f5,"Alert:"+e.getMessage());
         }
         }
         
         
         //???????????????????? INSERTING NEW BOOKS ?????????????????????/
         
         if(act.getSource()==b9) {
     
        	 String s1="", s2 = "", s3 = "",s4 ="";
        	

        	      s1=t9.getText();
        	      s2=t10.getText();
        	      s3=t11.getText();
        	      s4 = t12.getText();
        	    


        	 try {
        	 Class.forName("com.mysql.jdbc.Driver");
        	 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhumigupta","root","rootwdp");

        	

        	 PreparedStatement pst = con.prepareStatement("INSERT INTO allbook values(?,?,?,?)");
        	 pst.setString(1,s1);
        	 pst.setString(2,s2);
        	 pst.setString(3,s3);
        	pst.setString(4,s4);
        	 

        	 int sm = pst.executeUpdate();

        	 if(sm!=0)
        	 JOptionPane.showMessageDialog(f7,"BOOK INSERTED");

        	 else {
        	 t1.setText("");
        	 t2.setText("");
        	 t3.setText("");
        	 t4.setText("");
        	 JOptionPane.showMessageDialog(f7,"Error");
        	 con.close();
        	 }
        	 }
        	 catch(Exception e){
        	 JOptionPane.showMessageDialog(f7,e.getMessage());
        	 
        	 }
         }
         


}
//************Button function ends**********
 
//************Item Listener******** 
 
 
 public void itemStateChanged(ItemEvent itm){
       if(itm.getSource()==ch1){
          branch=ch1.getSelectedItem();
       }
       if(itm.getSource()==ch2){
         section=ch2.getSelectedItem();
       }
       if(itm.getSource()==ch3){
         semester=ch3.getSelectedItem();
       }

 }
 
 //************Item Listener ends***********
 
    public static void main(String args[])
    {
        new Pro();
    }
}