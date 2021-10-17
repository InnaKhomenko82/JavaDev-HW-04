package util;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Digitalization {
    public static Long getLong(String string){
        return Long.valueOf(string);
    }

    public static Integer getInteger(String string){
        return Integer.valueOf(string);
    }

    @SneakyThrows
    public static Date getDate(String string){
        SimpleDateFormat formatForDate = new SimpleDateFormat("dd.MM.yyyy");
        return formatForDate.parse(string);
    }
}
