
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Signup3 extends JFrame implements ActionListener{
    String formno;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    
    Signup3(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel label=new JLabel("Page 3: Account Details");
        label.setFont(new Font("Raleway",Font.BOLD,22));
        label.setBounds(250, 50, 600, 40);
        add(label);
        
        JLabel type=new JLabel("Account Type :");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(100, 100, 200, 40);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(150, 140, 200, 20);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(350, 140, 250, 20);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(150, 160, 200, 20);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(350, 160, 250, 20);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup typegrp=new ButtonGroup();
        typegrp.add(r1);
        typegrp.add(r2);
        typegrp.add(r3);
        typegrp.add(r4);
        
        JLabel card=new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(100, 200, 200, 40);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-6397");
        number.setFont(new Font("Raleway",Font.BOLD,20));
        number.setBounds(300, 200, 300, 40);
        add(number);
        
        JLabel detail=new JLabel("  (Your 16-digit card number)");
        detail.setFont(new Font("Raleway",Font.BOLD,12));
        detail.setBounds(300, 230, 300, 15);
        add(detail);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(100, 250, 200, 40);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(300, 250, 100, 40);
        add(pnumber);
        
        JLabel pindetail=new JLabel("  (Your 4-digit pin number)");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(300, 280, 300, 15);
        add(pindetail);
        
        JLabel service=new JLabel("Service Required :");
        service.setFont(new Font("Raleway",Font.BOLD,20));
        service.setBounds(100, 300, 300, 40);
        add(service);
        
        c1=new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(150, 340, 200, 20);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 340, 200, 20);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(150, 360, 200, 20);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4=new JCheckBox("Emails & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 360, 200, 20);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(150, 380, 200, 20);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 380, 200, 20);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 440, 600, 20);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250, 500, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
         cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(380, 500, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
         getContentPane().setBackground(Color.WHITE);
        setSize(750,650);
        setLocation(300,10);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==submit){
            
            String acc_type="";
            if(r1.isSelected()){
                acc_type="Saving Account";
            }else if(r2.isSelected()){
                acc_type="Fixed Deposit Account";
            }else if(r3.isSelected()){
                acc_type="Current Account";
            }else if(r4.isSelected()){
                acc_type="Recurring Deposit Account";
            }
            
            Random ran=new Random();
            String cardno=""+Math.abs((ran.nextLong()%90000000L)+8675463000000000L);
            String pinno=""+Math.abs((ran.nextLong()%9000L)+1000L);
            
            String facility="";
            if(c1.isSelected()){
                facility=facility + "ATM Card";
            }else if(c2.isSelected()){
                facility=facility + "Internet Bankinig";
            }else if(c3.isSelected()){
                facility=facility + "Mobile Bankinig";
            }else if(c4.isSelected()){
                facility=facility + "Email & SMS Alerts";
            }else if(c5.isSelected()){
                facility=facility + "Cheque Book";
            }else if(c6.isSelected()){
                facility=facility + "E-Statements ";
            }
            
            try{
                if(acc_type.equals("")){
                JOptionPane.showMessageDialog(null, "Account Type is required");
            }else{
                     Conn c=new Conn();
                String query1="insert into signup3 values('"+formno+"','"+acc_type+"','"+cardno+"','"+pinno+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number: "+cardno+"\nPIN: "+pinno);
                 setVisible(false);
                 new Deposit(pinno).setVisible(true);
                
                }
                
            }catch(Exception ex){
                System.out.println(ex);
            }
            
        }else if(e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Signup3("");
    }
}
