package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



import java.io.*;
import java.util.List;

/**
 * Created by dima on 26.02.16.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath;

    {
        filePath = getClass().getPackage().toString().replace(".", "/").replaceFirst("package ", "./src/") + "/vacancies.html";
    }
    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }


    @Override
    public void update(List<Vacancy> vacancies)
    {
        try
        {

            updateFile(getUpdatedFileContent(vacancies));

        }catch (IOException e)
        {
            System.out.println("Some exception occurred");
            e.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {
        Document document = getDocument();
        Element tmp = document.getElementsByClass("template").first();
        Element clone =  tmp.clone();
        clone.removeAttr("style");
        clone.removeClass("template");

        document.select("[class*=\"vacancy\"]").not("[class=\"vacancy template\"]").remove();

        for (Vacancy vacancy : vacancies)
        {
            Element newElemTeg = clone.clone();
            newElemTeg.getElementsByClass("city").first().text(vacancy.getCity());
            newElemTeg.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
            newElemTeg.getElementsByClass("salary").first().text(vacancy.getSalary());
            newElemTeg.getElementsByTag("a").first().attr("href", vacancy.getUrl()).text(vacancy.getTitle());

            tmp.before(newElemTeg.outerHtml());
        }

        return document.html();
    }

    private void updateFile(String body)
    {
        try
        {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            bufferedWriter.write(body);
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch (IOException e){ e.printStackTrace();}
    }


    public void userCitySelectEmulationMethod(String cityName)
    {
        controller.onCitySelect(cityName);
    }

    protected Document getDocument() throws IOException
    {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
