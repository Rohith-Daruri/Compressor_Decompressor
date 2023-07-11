package compressor_decompressor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AppFrame implements ActionListener {
    JFrame frame;
    JButton compress;
    JButton decompress;
    AppFrame(){
        frame = new JFrame("Compress & Decompress");
        frame.setLayout(null);
        frame.setSize(1000,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compress = new JButton("Select to compress");
        compress.setBounds(20,100,200,30);
        compress.addActionListener(this);
        decompress = new JButton("select to decompress");
        decompress.setBounds(250,100,200,30);
        decompress.addActionListener(this);
        frame.add(compress);
        frame.add(decompress);
        frame.getContentPane().setBackground(Color.blue);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==compress){
              JFileChooser filechooser = new JFileChooser();
              int response = filechooser.showSaveDialog(null);
              if(response==JFileChooser.APPROVE_OPTION){
                  File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                  try{
                      compressor.method(file);
                  } catch (IOException ex) {
                      JOptionPane.showMessageDialog(null,e.toString());
                  }
              }
          }
          if(e.getSource()==decompress){
              JFileChooser filechooser = new JFileChooser();
              int response = filechooser.showSaveDialog(null);
              if(response==JFileChooser.APPROVE_OPTION){
                  File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                  try{
                      Decompressor.method(file);
                  } catch (IOException ex) {
                      JOptionPane.showMessageDialog(null,e.toString());
                  }
              }
          }
    }
    public static void main(String[] args){
        AppFrame af = new AppFrame();
    }
}

