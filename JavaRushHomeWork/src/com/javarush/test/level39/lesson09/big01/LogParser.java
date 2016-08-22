package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;
import com.javarush.test.level39.lesson09.big01.query.UserQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery
{
    private Path logDir;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    private Map<Date, String> uniqueIPsMessage = new TreeMap<>();


    public LogParser(Path logDir)
    {
        this.logDir = logDir;
        readDateFromLogFile(logDir);
    }

    private String getIP(String s)
    {
        return s.split("\t")[0];
    }

    private String getName(String s)
    {
        return s.split("\t")[1];
    }

    private String getDate(String s)
    {
        return s.split("\t")[2];
    }

    private String getEvent(String s)
    {
        return s.split("\t")[3];
    }

    private String getStatus(String s)
    {
        return s.split("\t")[4];
    }

    private void readDateFromLogFile(Path logDir)
    {
        File folderLog = new File(logDir.toString());
        File[] listOfLog = folderLog.listFiles();

        for (File file : listOfLog)
        {
            if (file.getName().endsWith(".log"))
            {
                try (BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String s;
                    while ((s = br.readLine()) != null)
                    {

                        Date date = format.parse(getDate(s));
                        uniqueIPsMessage.put(date, s);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    private Set<String> createSetMessageToCurrentDate(Date after, Date before)
    {
        Set<String> setMessageOfCurrentDate = new TreeSet<>();
        for (Map.Entry<Date, String> entry : uniqueIPsMessage.entrySet())
        {
            long time = entry.getKey().getTime();
            if ((after == null || after.getTime() <= time) && (before == null || before.getTime() >= time))
                setMessageOfCurrentDate.add(entry.getValue());
        }
        return setMessageOfCurrentDate;
    }

    private Set<String> getStringParameters(Date after, Date before, String typeFilter, String value)
    {
        Set<String> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            switch (value)
            {
                case ("ip"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getIP(s));
                    break;
                case ("user"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getName(s));
                    break;
                case ("event"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getEvent(s).split(" ")[0]);
                    break;
            }
        }
        return set;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before)
    {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before)
    {
        return getStringParameters(after, before, null, "ip");
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before)
    {
        return getStringParameters(after, before, user, "ip");
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before)
    {
        return getStringParameters(after, before, event.name(), "ip");
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before)
    {
        return getStringParameters(after, before, status.name(), "ip");
    }

    @Override
    public Set<String> getAllUsers()
    {
        return getStringParameters(null, null, null, "user");
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getStringParameters(after, before, null, "user").size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        return getStringParameters(after, before, user, "event").size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        return getStringParameters(after, before, ip,"ip");
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getStringParameters(after,before, Event.LOGIN.name(),"user");
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getStringParameters(after, before, Event.DOWNLOAD_PLUGIN.name(), "user");
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before)
    {
        return getStringParameters(after, before, Event.WRITE_MESSAGE.name(), "user");
    }


    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getStringParameters(after, before, Event.SOLVE_TASK.name(), "user");
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        return getStringParameters(after, before, Event.SOLVE_TASK.name() + " " + task, "user");
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getStringParameters(after, before, Event.DONE_TASK.name(), "user");
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> doneTaskUsers = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before))
        {
            String event = getEvent(s).split(" ")[0];

            String userName = getName(s);
            if (event.equals(Event.DONE_TASK.name()))
            {
                int numTask = Integer.parseInt(getEvent(s).split(" ")[1]);
                if (numTask == task)
                    doneTaskUsers.add(userName);
            }
        }
        return getStringParameters(after, before, Event.DONE_TASK.name() + " " + task, "user");
    }
}
