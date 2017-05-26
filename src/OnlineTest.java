/*Online Java  Test*/  
  
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
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
            bk.setBounds(480,20+30*x,100,30);  
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
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Question-1: Which is a reserved word in the Java programming language?");  
            jb[0].setText("method");jb[1].setText("native");jb[2].setText("subclasses");jb[3].setText("array");   
        }  
        if(current==1)  
        {  
            l.setText("Question-2: Which is a valid keyword in java?");  
            jb[0].setText("Interface");jb[1].setText("String");jb[2].setText("Float");jb[3].setText("Unsinged");  
        }  
        if(current==2)  
        {  
            l.setText("Question-3: Which of these is not a bitwise operator?");  
            jb[0].setText("&");jb[1].setText("&=");jb[2].setText("|=");jb[3].setText("<=");  
        }  
        if(current==3)  
        {  
            l.setText("Question-4:  On applying Left shift operator, <<, on an integer bits are lost one they are shifted past which position bit?");  
            jb[0].setText("1");jb[1].setText("32");jb[2].setText("33");jb[3].setText("31");  
        }  
        if(current==4)  
        {  
            l.setText("Question-5: Which operator is used to invert all the digits in binary representation of a number?");  
            jb[0].setText("~");jb[1].setText("<<<");jb[2].setText(">>>");jb[3].setText("^");  
        }  
        if(current==5)  
        {  
            l.setText("Question-6: Which right shift operator preserves the sign of the value?");  
            jb[0].setText("<<");jb[1].setText(">>");jb[2].setText("<<=");jb[3].setText(">>=");  
        }  
        if(current==6)  
        {  
            l.setText("Question-7: Which of these functions is called to display the output of an applet? ");  
            jb[0].setText("Display()");jb[1].setText("Print()");jb[2].setText("DisplayApplet()");  
                        jb[3].setText("PrintApplet");  
        }  
        if(current==7)  
        {  
            l.setText("Question-8: What does AWT stands for?");  
            jb[0].setText("All Window Tools");jb[1].setText("All Writing Tools");jb[2].setText("Abstract Window Toolkit");  
                        jb[3].setText("Abstract Writing Toolkit");         
        }  
        if(current==8)  
        {  
            l.setText("Quetion-9: Which of these methods can be used to output a sting in an applet?");  
            jb[0].setText("display()");jb[1].setText("print()");jb[2].setText("DrawString()");jb[3].setText("Transient");  
        }  
        if(current==9)  
        {  
            l.setText("Question-10: Which of these data tupe can be used for a method having a return statement in it?");  
            jb[0].setText("void");jb[1].setText("int");jb[2].setText("float");  
                        jb[3].setText("All of the mentioned");  
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
            return(jb[0].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[3].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[1].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[2].isSelected());  
        if(current==9)  
            return(jb[3].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  