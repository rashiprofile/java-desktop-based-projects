
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener{
    
    
    JTextField adhartext,pantext;
    JRadioButton yes1,yes2,no1,no2;
    JButton next;
    JComboBox edu,inc,occ,rel,categ;
    String formno;
    
    Signup2(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        JLabel add_details=new JLabel("Page 2: Additional Details ");
        add_details.setFont(new Font("Raleway",Font.BOLD,20));
        add_details.setBounds(250, 50, 600, 40);
        add(add_details);
        
        JLabel religion=new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,18));
        religion.setBounds(100, 100, 200, 30);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         rel=new JComboBox(valReligion);
        rel.setBounds(300, 100, 350, 30);
        rel.setBackground(Color.WHITE);
        add(rel);
        
         JLabel category=new JLabel("Category :");
        category.setFont(new Font("Raleway",Font.BOLD,18));
        category.setBounds(100, 140, 200, 30);
        add(category);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
         categ=new JComboBox(valCategory);
        categ.setBounds(300, 140, 350, 30);
        categ.setBackground(Color.WHITE);
        add(categ);
        
         JLabel income=new JLabel("Income :");
        income.setFont(new Font("Raleway",Font.BOLD,18));
        income.setBounds(100, 180, 200, 30);
        add(income);
        
        String valIncome[]={"Null","< 1,00,000","< 2,50,000","< 5,00,000","Other"};
         inc=new JComboBox(valIncome);
        inc.setBounds(300, 180, 350, 30);
        inc.setBackground(Color.WHITE);
        add(inc);
        
         JLabel education=new JLabel("Educational");
        education.setFont(new Font("Raleway",Font.BOLD,18));
        education.setBounds(100, 230, 200, 30);
        add(education);
        
         JLabel qual=new JLabel("Qualifications :");
        qual.setFont(new Font("Raleway",Font.BOLD,18));
        qual.setBounds(100, 250, 200, 30);
        add(qual);
        
        String valQual[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
         edu=new JComboBox(valQual);
        edu.setBounds(300, 240, 350, 30);
        edu.setBackground(Color.WHITE);
        add(edu);
        
         JLabel occupation=new JLabel("Occupation :");
        occupation.setFont(new Font("Raleway",Font.BOLD,18));
        occupation.setBounds(100, 290, 200, 30);
        add(occupation);
        
        String valOcc[]={"Salaried","Self-employed","Bussiness","Student","Retired","Other"};
         occ=new JComboBox(valOcc);
        occ.setBounds(300, 290, 350, 30);
        occ.setBackground(Color.WHITE);
        add(occ);
       
        JLabel pan=new JLabel("PAN Number :");
        pan.setFont(new Font("Raleway",Font.BOLD,18));
        pan.setBounds(100, 330, 200, 30);
        add(pan);
        
        pantext=new JTextField();
        pantext.setFont(new Font("Raleway",Font.BOLD,14));
        pantext.setBounds(300, 330, 350, 30);
        add(pantext);
        
         JLabel adhar=new JLabel("Adhar Number :");
        adhar.setFont(new Font("Raleway",Font.BOLD,18));
        adhar.setBounds(100, 370, 200, 30);
        add(adhar);
        
        adhartext=new JTextField();
        adhartext.setFont(new Font("Raleway",Font.BOLD,14));
        adhartext.setBounds(300, 370, 350, 30);
        add(adhartext);
        
         JLabel sen_citizen=new JLabel("Senior Citizen :");
        sen_citizen.setFont(new Font("Raleway",Font.BOLD,18));
        sen_citizen.setBounds(100, 410, 200, 30);
        add(sen_citizen);
        
         yes1=new JRadioButton("Yes");
        yes1.setBounds(300, 410, 100, 30);
        yes1.setBackground(Color.WHITE);
        add(yes1);
        
         no1=new JRadioButton("No");
        no1.setBounds(400, 410, 100, 30);
        no1.setBackground(Color.WHITE);
        add(no1);
        
        ButtonGroup citizengrp=new ButtonGroup();
        citizengrp.add(yes1);
        citizengrp.add(no1);
        
        
         JLabel exist_account=new JLabel("Existing Account :");
        exist_account.setFont(new Font("Raleway",Font.BOLD,18));
        exist_account.setBounds(100, 440, 200, 30);
        add(exist_account);
        
         yes2=new JRadioButton("Yes");
        yes2.setBounds(300, 440, 100, 30);
        yes2.setBackground(Color.WHITE);
        add(yes2);
        
         no2=new JRadioButton("No");
        no2.setBounds(400, 440, 100, 30);
        no2.setBackground(Color.WHITE);
        add(no2);
        
        ButtonGroup existgrp=new ButtonGroup();
        existgrp.add(yes2);
        existgrp.add(no2);
        
        
         
          next =new JButton ("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550, 520, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,650);
        setLocation(300,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        
        String srel=(String)rel.getSelectedItem();
        String scateg=(String)categ.getSelectedItem();
        String sinc=(String)inc.getSelectedItem();
        String sedu=(String)edu.getSelectedItem();
        String socc=(String)occ.getSelectedItem();
        
         String sen_citizen=null;
        if(yes1.isSelected()){
            sen_citizen="Yes";
        }else if(no1.isSelected())
            sen_citizen="No";
       
         String exist_account=null;
        if(yes2.isSelected()){
            exist_account="Yes";
        }else if(no2.isSelected()){
            exist_account="No";
        }
        
        String sadhar=adhartext.getText();
        String span=pantext.getText();
        
        try{
               Conn c=new Conn();
                String query="insert into signup2 values('"+formno+"','"+srel+"','"+scateg+"','"+sinc+"','"+sedu+"','"+socc+"','"+span+"','"+sadhar+"','"+sen_citizen+"','"+exist_account+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup3(formno).setVisible(true);
            
        }catch (Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public static void main(String[] args){
        new Signup2("");
    }
}
