
package bank.management.system;
import java.awt.*;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JButton b1,b2,b3,b4,b5,b6,back;
    String pinno;
    FastCash(String pinno){
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2=i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0, 0, 800, 650);
        add(label);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(165, 200, 500, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        label.add(text);
        
        b1=new JButton("Rs.100");
        b1.setBounds(150, 250, 120, 20);
        b1.addActionListener(this);
        label.add(b1);
        
        b2=new JButton("Rs.500");
        b2.setBounds(300, 250,150, 20);
        b2.addActionListener(this);
        label.add(b2);
        
        b3=new JButton("Rs.1000");
        b3.setBounds(150, 280, 120, 20);
        b3.addActionListener(this);
        label.add(b3);
        
        b4=new JButton("Rs.2000");
        b4.setBounds(300, 280, 150, 20);
        b4.addActionListener(this);
        label.add(b4);
        
        b5=new JButton("Rs.5000");
        b5.setBounds(150, 310, 120, 20);
        b5.addActionListener(this);
        label.add(b5);
        
        b6=new JButton("Rs.10000");
        b6.setBounds(300, 310, 150, 20);
        b6.addActionListener(this);
        label.add(b6);
        
        back=new JButton("Back");
        back.setBounds(240, 350, 100, 20);
        back.addActionListener(this);
        label.add(back);
        
         setSize(800,650);
        setLocation(300,10);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==back){
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }else {
            String amount=((JButton)e.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where PIN_number='"+pinno+"'");
                int bal=0;
                while(rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        bal+= Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal-= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=back && bal<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   
                }
                else{
                Date date=new Date();
                String query="insert into bank values('"+pinno+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs."+amount+" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinno).setVisible(true);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
    }
    
    public static void main(String[] args){
        new FastCash("");
    }
}
