
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Withdrawl extends JFrame implements ActionListener{
    
    JButton withdraw,back;
    String pinno;
    JTextField amount;
    Withdrawl(String pinno){
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2=i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0, 0, 800, 650);
        add(label);
        
        JLabel text=new JLabel("Enter the amount you want to withdraw");
        text.setBounds(150, 200, 500, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        label.add(text);
        
        amount=new JTextField();
        amount.setBounds(200, 250, 150, 20);
        amount.addActionListener(this);
        label.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(300, 320, 120, 20);
        withdraw.addActionListener(this);
        label.add(withdraw);
        
        back=new JButton("Back");
        back.setBounds(300, 350, 120, 20);
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
        }else if(e.getSource()==withdraw){
            String num=amount.getText();
            Date date=new Date();
            if(num.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount");
            }else{
                try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pinno+"','"+date+"','Withdraw','"+num+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+num+" withdrawl successfully ");
                    setVisible(false);
                    new Transactions(pinno).setVisible(true);
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
            
        }
    }
    
    public static void main(String[] args){
        new Withdrawl("");
    }
}
