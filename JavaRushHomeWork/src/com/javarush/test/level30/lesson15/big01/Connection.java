package com.javarush.test.level30.lesson15.big01;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by dima on 14.03.16.
 */
public class Connection implements Closeable
{
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException
    {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void send(Message message) throws IOException
    {
        synchronized (out) {
            out.writeObject(message);
        }
    }

   public Message receive() throws IOException, ClassNotFoundException
   {
       synchronized (in)
       {
           return (Message) in.readObject();
       }
   }

    public SocketAddress getRemoteSocketAddress()
    {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException
    {
        socket.close();
        in.close();
        out.close();
    }
}
