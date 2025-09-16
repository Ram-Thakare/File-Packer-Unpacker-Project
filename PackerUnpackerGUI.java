import MarvellousPackerUnpacker.MarvellousPackerGUI;
import MarvellousPackerUnpacker.MarvellousUnpackerGUI;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener
{
    public Font customFont;
    public JFrame frame;
    public JButton button1, button2;
    public JLabel welcome, option;

    public void GUIFrame()
    {
        frame = new JFrame("Packer Unpacker Application");

            welcome = new JLabel("|| Welcome to our Application ||");
            welcome.setBounds(100,20,350,100);
            customFont = new Font("Verdana", Font.BOLD, 14); 
            welcome.setFont(customFont);

            option = new JLabel("Choice the option : ");
            option.setBounds(120,80,350,100);
            customFont = new Font("Verdana", Font.BOLD, 12); 
            option.setFont(customFont);

            button1 = new JButton("Packing");
            button1.setBounds(140,160,200,30);
            button1.addActionListener(this);

            button2 = new JButton("Unpacking");
            button2.setBounds(140,210,200,30);
            button2.addActionListener(this);
            
            frame.add(option);
            frame.add(welcome);
            frame.add(button1);
            frame.add(button2);
            frame.setSize(500,400);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent aobj)
    {
        if(aobj.getSource() == button1)
        {
           PackikngActivity pobj = new PackikngActivity();
           pobj.Pack();
        }
        else if(aobj.getSource() == button2)
        {
            UnpackingActivity upobj = new UnpackingActivity();
            upobj.Unpack();
        }

    }
}
class PackikngActivity extends JFrame implements ActionListener
{
    public JFrame fobj;
    public JButton bobj;
    public JLabel folder,file,Result;
    public JTextField folderText,fileText;

    public void Pack()
    {
        fobj = new JFrame("Packer Unpacker Application");
        
        bobj = new JButton("Packed");
        bobj.setBounds(120,200,250,30);

        folder = new JLabel("Folder Name : ");
        folder.setBounds(80,60,120,36);
        folderText = new JTextField();
        folderText.setBounds(180,60,180,36);
        
        file = new JLabel("File Name : ");
        file.setBounds(80,120,120,36);
        fileText = new JTextField();
        fileText.setBounds(180,120,180,36);
    
        Result = new JLabel("");
        Result.setBounds(50,270,300,30);

        fobj.add(bobj);
        fobj.add(folderText);
        fobj.add(folder);
        fobj.add(fileText);
        fobj.add(file);
        fobj.add(Result);
        bobj.addActionListener(this);
        fobj.setSize(500,400);
        fobj.setLayout(null);
        fobj.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent aobj)
    {
        boolean bRet = false;
        String FolderName = folderText.getText();
        String FileName = fileText.getText(); 

        MarvellousPackerGUI mobj1 = new MarvellousPackerGUI(FileName, FolderName);
        bRet = mobj1.PackingActivity();
        if(bRet == true)
        {
            Result.setText("Files packed succesfully");
        }
        else 
        {
            Result.setText("Unable pack files");
        }
        
    }
}

class UnpackingActivity extends JFrame implements ActionListener
{
    public JFrame fobj;
    public JButton bobj;
    public JLabel file,Result;
    public JTextField fileText;

    public void Unpack()
    {
        fobj = new JFrame("Packer Unpacker Application");
        
        bobj = new JButton("Unpacked");
        bobj.setBounds(120,200,250,30);
        
        file = new JLabel("File Name : ");
        file.setBounds(80,120,120,36);
        fileText = new JTextField();
        fileText.setBounds(180,120,180,36);
    
        Result = new JLabel("");
        Result.setBounds(50,270,300,30);

        fobj.add(bobj);
        fobj.add(fileText);
        fobj.add(file);
        fobj.add(Result);
        bobj.addActionListener(this);
        fobj.setSize(500,400);
        fobj.setLayout(null);
        fobj.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent aobj)
    {
        boolean bRet = false;
        String FileName = fileText.getText(); 

        MarvellousUnpackerGUI mobj1 = new MarvellousUnpackerGUI(FileName);
        bRet = mobj1.UnpackingActivity();
        if(bRet == true)
        {
            Result.setText("Files Unpacked succesfully");
        }
        else 
        {
            Result.setText("Unable unpack files");
        }
        
    }
    
}

class PackerUnpackerGUI
{
    public static void main(String A[])
    {
        GUI gobj = new GUI();

        gobj.GUIFrame();
    }
} 