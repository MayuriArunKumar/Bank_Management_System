
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton yes,no,eyes,eno;
    JComboBox religionbox,categorybox,occubox,edubox,incomebox;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
       
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION - PAGE 2");
        
       
        JLabel additionDetails=new JLabel("Page 2: Additonal Details");
        additionDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionDetails.setBounds(290,80,400,30);
        add(additionDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valreligion[]={"Hindu","Muslim","Christian","Sikh","Jains","Buddist"};
        religionbox =new JComboBox(valreligion);
        religionbox.setBounds(300,140,400,30);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);
       
        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]={"General","OBC","SC","ST"};
        categorybox =new JComboBox(valcategory);
        categorybox.setBounds(300,190,400,30);
        categorybox.setBackground(Color.WHITE);
        add(categorybox);
       
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valincome[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomebox =new JComboBox(valincome);
        incomebox.setBounds(300,240,400,30);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);
        
        JLabel gender=new JLabel("Educational:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String valedu[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Other"};
        edubox =new JComboBox(valedu);
        edubox.setBounds(300,315,400,30);
        edubox.setBackground(Color.WHITE);
        add(edubox);
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        String valoccu[]={"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occubox =new JComboBox(valoccu);
        occubox.setBounds(300,390,400,30);
        occubox.setBackground(Color.WHITE);
        add(occubox);
        
        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,540,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("NO");
        no.setBounds(450,540,100,30);
        no.setBackground(Color.WHITE);
        add(no);
     
        ButtonGroup maritialgroup=new ButtonGroup();
        maritialgroup.add(yes);
        maritialgroup.add(no);
      
        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("NO");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
     
        ButtonGroup emaritialgroup=new ButtonGroup();
        emaritialgroup.add(eyes);
        emaritialgroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String religion= (String) religionbox.getSelectedItem();
        String category =(String)categorybox.getSelectedItem();
        String income = (String)incomebox.getSelectedItem();
        String education=(String)edubox.getSelectedItem();
        String occupation=(String)occubox.getSelectedItem();
        String senior = null;
        if(yes.isSelected()){
            senior="Yes";
        }else if(no.isSelected()){
            senior="No";
        }
        
        String existing=null;
        if(eyes.isSelected()){
            existing="Yes";
        }else if(eno.isSelected()){
            existing="No";
        }
        
        String pannum= pan.getText();
        String aadharnum=aadhar.getText();
        
        try{
            Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"', '"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pannum+"','"+aadharnum+"','"+existing+"','"+senior+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
   
    }
}
