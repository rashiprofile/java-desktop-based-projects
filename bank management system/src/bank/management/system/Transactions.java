
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fast,mini,pinch,bal,exit;
    String pinno;
    Transactions(String pinno){
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
        
        deposit=new JButton("Deposit");
        deposit.setBounds(150, 250, 120, 20);
        deposit.addActionListener(this);
        label.add(deposit);
        
        withdraw=new JButton("Cash Withdrawl");
        withdraw.setBounds(300, 250,150, 20);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        fast=new JButton("Fast Cash");
        fast.setBounds(150, 280, 120, 20);
        fast.addActionListener(this);
        label.add(fast);
        
        mini=new JButton("Mini Statement");
        mini.setBounds(300, 280, 150, 20);
        mini.addActionListener(this);
        label.add(mini);
        
        pinch=new JButton("Pin Change");
        pinch.setBounds(150, 310, 120, 20);
        pinch.addActionListener(this);
        label.add(pinch);
        
        bal=new JButton("Balancce Enquiry");
        bal.setBounds(300, 310, 150, 20);
        bal.addActionListener(this);
        label.add(bal);
        
        exit=new JButton("Exit");
        exit.setBounds(240, 350, 100, 20);
        exit.addActionListener(this);
        label.add(exit);
        
         setSize(800,650);
        setLocation(300,10);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            setVisible(false);
        }else if (e.getSource()==deposit){
            setVisible(false);
            new Deposit(pinno).setVisible(true);
        }else if (e.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinno).setVisible(true);
        }else if (e.getSource()==fast){
            setVisible(false);
            new FastCash(pinno).setVisible(true);
        }else if (e.getSource()==mini){
            new MiniStatement(pinno).setVisible(true);
        }else if (e.getSource()==pinch){
            setVisible(false);
            new PinChange(pinno).setVisible(true);
        }else if (e.getSource()==bal){
            setVisible(false);
            new BalanceEnquiry(pinno).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("");
    }
}
