package com.shvants.UrlShorter.util;

import java.util.ArrayList;
import java.util.List;

public class ShortUrlGenerator {

    private static final String prefix = "https://shv.by/";
    private static String[] encryptKey = {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "0","1","2","3","4","5","6","7","8","9"
    };
    private static int base = encryptKey.length;
    
    private static List<Integer> base62Id(int id){
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        do {
            if (id >= base){
                list.add(id / base);
                id %= base;
            } else {
                list.add(id);
                flag = -1;
            }
        } while (flag == 0);
        return list;
    }
    
    public static String generateShortUrl(Number id){
        StringBuilder shortUrl = new StringBuilder(prefix);
        base62Id(id.intValue()).forEach(digit -> shortUrl.append(encryptKey[digit]));
        return shortUrl.toString();
    }
}