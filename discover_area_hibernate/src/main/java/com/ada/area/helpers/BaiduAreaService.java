package com.ada.area.helpers;

import com.ada.area.data.entity.Area;
import com.google.gson.*;
import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

public class BaiduAreaService {

    public static void main(String[] args) {


        String id = "8258";
        List<Area> areas = shangquan(id);

        for (Area area : areas) {
            System.out.println(area);
        }
    }

    public static List<Area> area(String id) {
        List<Area> areas = new ArrayList<Area>();
        HttpBrowser browser = new HttpBrowser();
        browser.setDefaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
        HttpRequest request = HttpRequest
                .get("http://api.map.baidu.com/shangquan/forward/?qt=sub_area_list&ext=1&level=1&areacode=" + id + "&business_flag=0");

        HttpResponse response = browser.sendRequest(request);
        if (response.statusCode() == 200) {
            String body = browser.getPage();
            x(areas, body);

        }
        return areas;
    }

    private static void x(List<Area> areas, String body) {
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(body);
        JsonElement content = element.getAsJsonObject().get("content");
        if (content == null) {
            return;
        }

        JsonElement sub = content.getAsJsonObject().get("sub");
        if (sub != null) {
            JsonArray array = sub.getAsJsonArray();
            for (JsonElement jsonElement : array) {
                JsonObject object = jsonElement.getAsJsonObject();
                String name = object.get("area_name").getAsString();
                Integer type = object.get("area_type").getAsInt();
                Integer code = object.get("area_code").getAsInt();
                String geo = object.get("geo").getAsString();
                Area area = new Area();
                area.setName(name);
                area.setCode(code + "");
                area.setGeo(geo);
                area.setType(type);
                areas.add(area);
            }
        }
    }

    public static List<Area> shangquan(String id) {
        List<Area> areas = new ArrayList<Area>();
        HttpBrowser browser = new HttpBrowser();
        browser.setDefaultHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:54.0) Gecko/20100101 Firefox/54.0");
        HttpRequest request = HttpRequest
                .get("http://api.map.baidu.com/shangquan/forward/?qt=sub_area_list&ext=1&level=1&areacode=" + id + "&business_flag=1");

        HttpResponse response = browser.sendRequest(request);
        if (response.statusCode() == 200) {
            x(areas, browser.getPage());

        }
        return areas;
    }
}
