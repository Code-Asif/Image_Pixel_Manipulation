/* 
*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*

* Linear Algebra Project ( Image pixels manipulation array matrix).

* Welcome to a minimal software that take an image, encrypt it then as per user
requirement decrypt that same image with the help of cypher key which is entered by user.

      * Developer :- Asif Alam
      * Date :- 19/03/2023

*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*
*/

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ImageManipulation {
    public static void operate(int key)
    {
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Image Encrypting");
        JFrame f=new JFrame();
        f.setTitle("Encrypting and Decrypting System");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.BLUE);

        Font font=new Font("Ink Free",Font.BOLD,30);

        //creating button
        JButton button=new JButton();
        button.setText("Choose an image");
        button.setFont(font);
        
        //creating text field
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        button.addActionListener(e->{
            System.out.println("Choose an image");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }
}