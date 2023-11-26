
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinno){
        
        setTitle("Mini Statement");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel txt=new JLabel();
        txt.setBounds(20,80,300,300);
        add(txt);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(140, 20, 100, 30);
        bank.setFont(new Font("System",Font.BOLD,16));
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(30, 70, 300, 30);
        add(card);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where PIN_Number='"+pinno+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where PIN_number='"+pinno+"'");
            while(rs.next()){
                txt.setText(txt.getText()+"<html>"+rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"<br>");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        setSize(400,500);
        setLocation(100,100);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
