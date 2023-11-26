package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinno;
    
    BalanceEnquiry(String pinno){
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2=i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0, 0, 800, 650);
        add(label);
        
        
        
         Conn c=new Conn();
         int bal=0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where PIN_number='"+pinno+"'");
                while(rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        bal+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal-= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception ex){
                System.out.println(ex);
            }
        
        JLabel text=new JLabel("Your Current Account Balance is : ");
        text.setBounds(150, 200, 500, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);
        
        JLabel txt=new JLabel("Rs. "+bal);
        txt.setBounds(250, 240, 200, 40);
        txt.setForeground(Color.WHITE);
        txt.setFont(new Font("System",Font.BOLD,16));
        label.add(txt);
        
        back=new JButton("Back");
        back.setBounds(350, 370, 100, 20);
        back.addActionListener(this);
        label.add(back);
        
         setSize(800,650);
        setLocation(300,10);
        setVisible(true);
        
 }
    public void actionPerformed(ActionEvent e){
       setVisible(false);
       new Transactions(pinno).setVisible(true);
    }
    public static void main(String[] args){
        new BalanceEnquiry("");
    }
}
