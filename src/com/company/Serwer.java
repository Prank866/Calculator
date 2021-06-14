package com.company;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Serwer extends Calc {

    public static int Add(int a, int b) {
        return a + b;
    }

    public static int Sub(int a, int b) {
        return a - b;
    }

    public static int Mul(int a, int b) {
        return a * b;
    }

    public static float Div(float a, float b) {
        return a / b;
    }

    public static int UP(int a, int b) {
        return (int) Math.pow(a, b);
    }

    public static double SQRT(double a) {
        return Math.sqrt(a);
    }

    public static long Fact(long a) {
        long wynik = 1;

        for (long i = a; i > 0; i--) {
            wynik *= i;
        }

        return wynik;
    }

    public static void main(String[] args) {

        try {

            ServerSocket ss = new ServerSocket(4888);
            Socket s = ss.accept();

            DataInputStream input = new DataInputStream(s.getInputStream());
            DataOutputStream output = new DataOutputStream(s.getOutputStream());

            int z = input.readInt();
            int a = input.readInt();
            int b = input.readInt();

            if (z == 1) {

                int wynikAdd = Add(a, b);
                output.writeInt(wynikAdd);

            } else if (z == 2) {

                int wynikSub = Sub(a, b);
                output.writeInt(wynikSub);

            } else if (z == 3) {

                int wynikMul = Mul(a, b);
                output.writeInt(wynikMul);

            } else if (z == 4) {

                JFrame f = new JFrame();
                if (a == 0 || b == 0) JOptionPane.showMessageDialog(f, "Nie dziel przez 0 !!!");

                float wynikDiv = Div(a, b);
                Math.round(wynikDiv);
                output.writeFloat(wynikDiv);

            } else if (z == 6) {

                int wynikUP = UP(a, b);
                output.writeInt(wynikUP);

            } else if (z == 7) {

                double wynikSQRT = SQRT(a);
                output.writeDouble(wynikSQRT);

            } else if (z == 8) {

                long wynikFact = Fact(a);
                output.writeLong(wynikFact);

            }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Koniec Pracy Serwera");
    }
}
