package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dima on 14.03.16.
 */
public class Server
{
    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }
    }

    public static void main(String[] args)
    {
        int portServer = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(portServer))
        {
            ConsoleHelper.writeMessage("Cервер запущен");

            while (true)
            {
                Socket socket =serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка сокета");;
        }
    }
}
