package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;


import java.io.IOException;
import java.net.Socket;


/**
 * Created by dima on 16.03.16.
 */
public class Client
{
    protected Connection connection;

    private volatile boolean clientConnected = false;

    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }

    public class SocketThread  extends Thread
    {
        // должен выводить текст message в консоль

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }


        // должен выводить в консоль информацию о том, что участник с именем userName присоединился к чату

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("участник " + userName + " присоединился к чату");
        }


        //  должен выводить в консоль, что участник с именем userName покинул чат

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("участник " + userName + " покинул чат");
        }


        /** Устанавливать значение поля clientConnected класса Client в соответствии с
         переданным параметром. Оповещать (пробуждать ожидающий) основной поток класса Client **/

        protected void notifyConnectionStatusChanged(boolean clientConnected) {

            Client.this.clientConnected = clientConnected;

            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        protected void  clientHandshake() throws IOException, ClassNotFoundException
        {
            while (true) {

                Message message = connection.receive();

                switch (message.getType())
                {
                    case NAME_REQUEST :
                    {
                        String userName;
                        userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }
                    case NAME_ACCEPTED:
                    {
                        notifyConnectionStatusChanged(true);
                        return;
                    }
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {

            while (true)
            {
                Message message = connection.receive();

                switch (message.getType())
                {
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;

                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run()
        {
            try {
                Socket socket = new Socket(getServerAddress(),getServerPort());

                Client.this.connection = new Connection(socket);

                clientHandshake();
                clientMainLoop();

            } catch (IOException e)
            {
                notifyConnectionStatusChanged(false);
            }
            catch (ClassNotFoundException e)
            {
                notifyConnectionStatusChanged(false);
            }

        }
    }

    protected String getServerAddress()
    {
        ConsoleHelper.writeMessage("Введите адресс сервера: ");
        return ConsoleHelper.readString();
    }

    protected int getServerPort()
    {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        return ConsoleHelper.readInt();
    }

    protected String getUserName()
    {
        ConsoleHelper.writeMessage("Введите имя пользователя: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return true;
    }

    protected SocketThread getSocketThread()
    {
        return new SocketThread();
    }

    protected void sendTextMessage(String text)
    {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки");
            clientConnected = false;
        }
    }

    public void run() {

        // Создавать новый сокетный поток с помощью метода getSocketThread

        SocketThread socketThread = getSocketThread();

        // Помечать созданный поток как daemon, это нужно для того, чтобы при выходе
        // из программы вспомогательный поток прервался автоматически.

        socketThread.setDaemon(true);

        // Запустить вспомогательный поток

        socketThread.start();

        // Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка");
            return;
        }

        //После того, как поток дождался нотификации, проверь значение clientConnected

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            //Считывай сообщения с консоли пока клиент подключен. Если будет введена команда 'exit', то выйди из цикла

            while (clientConnected) {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit")) {
                    if (shouldSentTextFromConsole()) {
                        sendTextMessage(message);
                    }
                } else {
                    return;
                }
            }
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }

}
