package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by dima on 19.03.16.
 */
public class BotClient extends Client
{
    private static int botsCounter = 0;

    public static void main(String[] args) {

       new BotClient().run();

    }
    public class BotSocketThread  extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);

            String senderName = "";
            String senderMessageText;

            if (message.contains(": "))
            {
                senderName = message.split(": ")[0];
                senderMessageText = message.split(": ")[1];
            }
            else
            {
                senderMessageText = message;
            }

            SimpleDateFormat format = null;

            // Отправить ответ в зависимости от текста принятого сообщения. Если текст сообщения:

            if ("дата".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d.MM.YYYY");
            }
            else if ("день".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d");
            }
            else if ("месяц".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("MMMM");
            }
            else if ("год".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("YYYY");
            }
            else if ("время".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H:mm:ss");
            }
            else if ("час".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H");
            }
            else if ("минуты".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("m");
            }
            else if ("секунды".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("s");
            }

            if (format != null)
            {
                sendTextMessage("Информация для " + senderName + ": " + format.format(Calendar.getInstance().getTime()));
            }

        }
    }

    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    protected String getUserName()
    {
        if (botsCounter == 99)
        {
            botsCounter = 0;
        }
        return "date_bot_" + botsCounter++;
    }

}
