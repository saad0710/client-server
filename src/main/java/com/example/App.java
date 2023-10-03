package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class App 
{
    public static void main( String[] args )
    {
        try {

            System.out.println("server avviato...");
            ServerSocket server = new ServerSocket(3000);

            Socket s = server.accept();
            System.out.println("un client si è connesso :)");

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String messaggio_ricevuto = in.readLine();
            System.out.println("il client ha scritto: " + messaggio_ricevuto);

            String messaggio_modificato = messaggio_ricevuto.toUpperCase();
            out.writeBytes(messaggio_modificato + "\n");

            server.close();
            s.close();
  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore edurante l'istanza del server");
            System.exit(1);
        }
    }
}

