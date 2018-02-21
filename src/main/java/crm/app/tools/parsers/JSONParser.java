package crm.app.tools.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JSONParser<T> {

    private final Class<T> tClass;

    public JSONParser(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T parseFromUrl(String url) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(new URL(url), tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public T parseJSON(String json) {
        ObjectMapper mapper = new ObjectMapper();
        T obj = null;
        try {
            obj = mapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
