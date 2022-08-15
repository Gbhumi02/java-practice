import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class pro2 implements ActionListener//, ItemListener
{
    JButton b1,b2,b3,b4,b5,b6,b7;
    JFrame f1,f2,f3,f4,f5;
    JPanel p1,p2,p3;
    JLabel lb1,lb2,l1,l2,l3,l4,l5;
    JTextField t0,t1,ps,t2,t3,t4,t5;
    JTextArea tr1;
    ImageIcon bimg1,bimg2;
    Choice ch1,ch2,ch3;
    Color c1;
    String branch,semester,section;
    JTable tb;
    JScrollPane sp;
    DefaultTableModel dtm;

public pro2(){
//*********************LOGIN*******************************
f1=new JFrame("Inventory Management System");
bimg1=new ImageIcon("img.png");
c1=new Color(31,190,214);
lb1=new JLabel(bimg1);
t0=new JTextField(8);
ps=new JPasswordField(8);
//lb1.setSize(400,400);
f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f1.setVisible(true);
f1.setLayout(new BorderLayout());
f1.setLayout(new FlowLayout());
b1=new JButton("LogIn");
b1.setVisible(true);
b1.setBackground(c1);
b1.setForeground(Color.yellow);
b1.addActionListener(this);
f1.add(b1);
f1.add(lb1);
f1.setSize(2000,2000);



//*******************Second Interface**********************************
f2 = new JFrame("Options of Inventory Management");
f2=new JFrame("Options"); 
 bimg2=new ImageIcon("img1.png");
f2.setBackground(Color.DARK_GRAY);
lb2=new JLabel(bimg2);
b3=new JButton("Update Admin Details");
b3.setBackground(c1);
b3.setForeground(Color.white);
b3.setBounds(600,100,250,80);
b3.addActionListener(this);
b4=new JButton("All items");
b4.setBackground(c1);
b4.setForeground(Color.white);
b4.setBounds(600,200,250,80);
b4.addActionListener(this);
b5=new JButton("Sold items");
b5.setBackground(c1);
b5.setForeground(Color.white);
b5.setBounds(600,300,250,80);
b5.addActionListener(this);
b6=new JButton("Create new Admin");
b6.setBackground(c1);
b6.setForeground(Color.white);
b6.setBounds(600,400,250,80);
b6.addActionListener(this);

lb2.add(b3);
lb2.add(b4);
lb2.add(b5);
f2.add(lb2);
f2.setSize(2000,2000);
//f2.setVisible(true);
f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//********************************REGISTER PAGE*************************
f3=new JFrame("Registeration Page");
p1=new JPanel();
p2=new JPanel();
l1=new JLabel("Full Name");
l2=new JLabel("Email Id");
l3=new JLabel("Password");
l4 =new JLabel("Contact");
t1=new JTextField(8);
t2=new JTextField(8);
t3=new JTextField(8);
t4 =new JTextField(10);
p1.setLayout(new GridLayout(4,2));
p1.add(l1);
p1.add(t1);
p1.add(l2);
p1.add(t2);
p1.add(l3);
p1.add(t3);
p1.add(l4);
p1.add(t4);
b7=new JButton("Update");
b7.addActionListener(this);
b7.setBounds(500,100,30,30);

p2.add(b7);
f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f3.setLayout(new GridLayout(2,1));
f3.add(p1);
f3.add(p2);
f3.setSize(2000,2000);

}


public void actionPerformed(ActionEvent a) {
	if(a.getSource()==b1){
		                  
        Object[] message = {
             "Username:", t0,
             "Password:", ps
         };
     int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
       if (option == JOptionPane.OK_OPTION) {
              if (t0.getText().equals("k") && ps.getText().equals("k")) {
                    JOptionPane.showMessageDialog(f2,"Login successful");
                    f2.setVisible(true);
                    
                 } 
              else {
                    JOptionPane.showMessageDialog(f2,"login failed");
                   }
              
       }
       else {
           JOptionPane.showMessageDialog(f1,"Login cancelled");
       }
	}    //b1 close 
	
	if(a.getSource()==b3) {
		f3.setVisible(true);
		
	}//b3 close
	
	if(a.getSource()==b4) {
		f4 = new JFrame("ALL AVAILABLE ITEMS");
		f4.setSize(2000,2000);
		f4.setVisible(true);
	}//b4 close
	
	if(a.getSource()==b5) {
		f5 = new JFrame("SOLD ITEMS");
		f5.setSize(2000,2000);
		f5.setVisible(true);
	}
	
	
	
}//action event close

public static void main(String[] args) {
	new pro2();
}//main function
}//main class close
