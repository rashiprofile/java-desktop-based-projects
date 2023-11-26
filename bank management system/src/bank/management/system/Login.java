
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardText;
    JPasswordField pinText;
    
    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); 
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel text=new JLabel("' Welcome to ATM '");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250, 40, 400, 40);
        add(text);
        
        JLabel cardno=new JLabel("Card No : ");
        cardno.setFont(new Font("Raleway",Font.BOLD,24));
        cardno.setBounds(200, 120, 400, 40);
        add(cardno);
        
         cardText=new JTextField();
        cardText.setBounds(350, 130, 250, 30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,24));
        pin.setBounds(200, 180, 400, 40);
        add(pin);
        
         pinText=new JPasswordField();
        pinText.setBounds(350, 185, 250, 30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);
        
         login=new JButton("SIGN IN");
        login.setBounds(300, 250, 100, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
         clear=new JButton("CLEAR");
        clear.setBounds(450, 250, 100, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         signup=new JButton("SIGN UP");
        signup.setBounds(350, 300, 150, 35);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        setSize(800,480);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            cardText.setText("");
            pinText.setText("");
        }
        else if(e.getSource()==login){
            Conn c=new Conn();
            String cardno=cardText.getText();
            String pinno=pinText.getText();
            String query="select * from login where Card_Number='"+cardno+"' and PIN_Number='"+pinno+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorect Card Number or PIN !");
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
            
        }
        else if (e.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
