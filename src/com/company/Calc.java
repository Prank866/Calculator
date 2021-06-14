package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Calc extends JFrame implements ActionListener {
    JButton button1,button2,button3,button4,button5,button6,button7,button8;
    static JTextField pole1;
    static JTextField pole2;
    static JTextField pole3;
    JLabel label1,label2,label3;
    JMenuItem menuItemAdd, menuItemSub, menuItemMul, menuItemDiv, menuItemZamknij,menuItemUP,menuItemSQRT,menuItemFact;
    public Calc()
    {
        setBounds(300,300,300,200);
        setTitle("Kalkulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelK = new JPanel(null);
        JToolBar pasek = new JToolBar();

        JMenuBar jmenubar = new JMenuBar();
        jmenubar.setBounds(0,0,300,25);
        panelK.add(jmenubar);

        JMenu jMenuPlik = new JMenu("Plik");
        JMenu jMenuEdycja = new JMenu("Edycja");
        jmenubar.add(jMenuPlik);
        jmenubar.add(jMenuEdycja);

        Image imageIconFrame = new ImageIcon(getClass().getClassLoader().getResource("calculator-.png")).getImage();
        setIconImage(imageIconFrame);

        ImageIcon imageIconAdd = new ImageIcon(getClass().getClassLoader().getResource("add.png"));
        ImageIcon imageIconSub = new ImageIcon(getClass().getClassLoader().getResource("sub.png"));
        ImageIcon imageIconMul = new ImageIcon(getClass().getClassLoader().getResource("mul.png"));
        ImageIcon imageIconDiv = new ImageIcon(getClass().getClassLoader().getResource("div.png"));
        ImageIcon imageIconCE = new ImageIcon(getClass().getClassLoader().getResource("CE.png"));
        ImageIcon imageIconUP = new ImageIcon(getClass().getClassLoader().getResource("up.png"));
        ImageIcon imageIconSQRT = new ImageIcon(getClass().getClassLoader().getResource("sqrt.png"));
        ImageIcon imageIconFact = new ImageIcon(getClass().getClassLoader().getResource("fact.png"));

        menuItemZamknij = new JMenuItem("Zamknij");
        menuItemAdd = new JMenuItem("Add",imageIconAdd);
        menuItemSub = new JMenuItem("Sub",imageIconSub);
        menuItemMul = new JMenuItem("Mul",imageIconMul);
        menuItemDiv = new JMenuItem("Div",imageIconDiv);
        menuItemUP = new JMenuItem("UP",imageIconUP);
        menuItemSQRT = new JMenuItem("SQRT",imageIconSQRT);
        menuItemFact = new JMenuItem("FACT",imageIconFact);

        menuItemZamknij.addActionListener(this);
        menuItemAdd.addActionListener(this);
        menuItemSub.addActionListener(this);
        menuItemMul.addActionListener(this);
        menuItemDiv.addActionListener(this);
        menuItemUP.addActionListener(this);
        menuItemSQRT.addActionListener(this);
        menuItemFact.addActionListener(this);

        jMenuPlik.add(menuItemZamknij);
        jMenuEdycja.add(menuItemAdd);
        jMenuEdycja.add(menuItemSub);
        jMenuEdycja.add(menuItemMul);
        jMenuEdycja.add(menuItemDiv);
        jMenuEdycja.add(menuItemUP);
        jMenuEdycja.add(menuItemSQRT);
        jMenuEdycja.add(menuItemFact);

        label1 = new JLabel("=");
        label1.setBounds(165,80,20,20);
        panelK.add(label1);

        label2 = new JLabel("KALKULATOR");
        label2.setForeground(Color.RED);
        label2.setBounds(100,45,100,25);
        panelK.add(label2);

        pole1 = new JTextField("0");
        pole1.setBounds(50,80,35,25);
        panelK.add(pole1);
        pole2 = new JTextField("0");
        pole2.setBounds(100,80,35,25);
        panelK.add(pole2);
        pole3 = new JTextField("0");
        pole3.setBounds(200,80,65,25);
        panelK.add(pole3);



        button1 = new JButton(imageIconAdd);
        button1.addActionListener(this);
        pasek.add(button1);

        button2 = new JButton(imageIconSub);
        button2.addActionListener(this);
        pasek.add(button2);

        button3 = new JButton(imageIconMul);
        button3.addActionListener(this);
        pasek.add(button3);

        button4 = new JButton(imageIconDiv);
        button4.addActionListener(this);
        pasek.add(button4);

        button6 = new JButton(imageIconUP);
        button6.addActionListener(this);
        pasek.add(button6);

        button7 = new JButton(imageIconSQRT);
        button7.addActionListener(this);
        pasek.add(button7);

        button8 = new JButton(imageIconFact);
        button8.addActionListener(this);
        pasek.add(button8);

        button5 = new JButton(imageIconCE);
        button5.addActionListener(this);
        pasek.add(button5);

        panelK.setBackground(Color.BLACK);
        panelK.add(pasek);
        pasek.setBounds(0,25,300,25);
        setContentPane(panelK);
        setVisible(true);
    }


    public static void main(String[] args) { new Calc(); }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object object = e.getSource();
        String a;
        String b;

        a=pole1.getText();
        b=pole2.getText();

        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);


        if (object == button1|| object==menuItemAdd){

            try {


                    Socket s = new Socket("localhost", 4888);


                    DataInputStream input = new DataInputStream(s.getInputStream());
                    DataOutputStream output = new DataOutputStream(s.getOutputStream());
                    int z=1;

                    output.writeInt(z);
                    output.writeInt(num1);
                    output.writeInt(num2);
                    output.flush();


                int w=input.readInt();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }


        }else if (object==button2 || object==menuItemSub){

            try {


                    Socket s = new Socket("localhost", 4888);


                    DataInputStream input = new DataInputStream(s.getInputStream());
                    DataOutputStream output = new DataOutputStream(s.getOutputStream());
                    int z=2;

                    output.writeInt(z);
                    output.writeInt(num1);
                    output.writeInt(num2);
                    output.flush();


                    int w=input.readInt();
                    String wynik = ""+w;
                    pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }
        }else if (object==button3 || object==menuItemMul){

            try {


                Socket s = new Socket("localhost", 4888);


                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                int z=3;

                output.writeInt(z);
                output.writeInt(num1);
                output.writeInt(num2);
                output.flush();


                int w=input.readInt();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }
        }else if (object==button4 || object==menuItemDiv){

            try {


                Socket s = new Socket("localhost", 4888);


                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                int z=4;

                output.writeInt(z);
                output.writeInt(num1);
                output.writeInt(num2);
                output.flush();


                float w=input.readFloat();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }



        }else if (object==button5){
            pole1.setText("0");
            pole2.setText("0");
            pole3.setText("0");
        }else if (object==menuItemZamknij){

            System.exit(0);

        }else if (object==button6 || object==menuItemUP) {

            try {


                Socket s = new Socket("localhost", 4888);


                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                int z=6;

                output.writeInt(z);
                output.writeInt(num1);
                output.writeInt(num2);
                output.flush();


                int w=input.readInt();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }

        }else if (object==button7 || object==menuItemSQRT){

            try {


                Socket s = new Socket("localhost", 4888);


                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                int z=7;

                output.writeInt(z);
                output.writeInt(num1);
                output.writeInt(num2);
                output.flush();


                double w=input.readDouble();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }

        }else if (object==button8 || object==menuItemFact){

            try {


                Socket s = new Socket("localhost", 4888);


                DataInputStream input = new DataInputStream(s.getInputStream());
                DataOutputStream output = new DataOutputStream(s.getOutputStream());
                int z=8;

                output.writeInt(z);
                output.writeInt(num1);
                output.writeInt(num2);
                output.flush();


                long w=input.readLong();
                String wynik = ""+w;
                pole3.setText(wynik);



            }catch(Exception IOE){
                IOE.printStackTrace();
            }

        }
    }
}
