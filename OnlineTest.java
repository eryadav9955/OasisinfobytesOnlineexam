/*Online Java Paper Test*/  
  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  

{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg ;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x, 100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Number of primitive datatype in java are?");  
            jb[0].setText("6");jb[1].setText("8");jb[2].setText("7");jb[3].setText("9");   
        }  
        
        if(current==1)  
        {  
            l.setText("Que2: what is the size of float and double in java?");  
            jb[0].setText("32 and 32");jb[1].setText("64 and 64");jb[2].setText("32 and 64");jb[3].setText("64 and 32");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Automatic type conversion is possible in which of the possible cases?");  
            jb[0].setText("Bytes to int");jb[1].setText("Long to int");jb[2].setText("Short to int");jb[3].setText("int to long");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Select the valid statement.");  
            jb[0].setText("char[] ch = new char [5]");jb[1].setText("char[] ch = new char (5)");jb[2].setText("char[] ch = new char []");jb[3].setText("char[] ch = new char ()");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: In which of the following is toString() method defined?");  
            jb[0].setText("java.lang.util");jb[1].setText("java.lang.String");jb[2].setText("java.lang.Object");jb[3].setText("None");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: To which of the following does the class string belong to.");  
            jb[0].setText("java.string");jb[1].setText("java.applet");jb[2].setText("java.lang");jb[3].setText("java.awt");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Identify the modifier which cannot be used for constructor. ");  
            jb[0].setText("Public");jb[1].setText("Static");jb[2].setText("Protected");  
                        jb[3].setText("Private");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Exception created by try block is caught in which block.");  
            jb[0].setText("None");jb[1].setText("final");jb[2].setText("throw");  
                        jb[3].setText("catch");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: what does the operator >>>> do?");  
            jb[0].setText("Right shift operator");jb[1].setText("Zero fill right shift");jb[2].setText("Zero fill left shift");jb[3].setText("Left fill left shift");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which of the following is used to find and fix bugs in the program?");  
            jb[0].setText("JDK");jb[1].setText("JRE");jb[2].setText("JDB");  
                        jb[3].setText("JVM");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  