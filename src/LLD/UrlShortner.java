package LLD;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HexFormat;

public class UrlShortner {

    static HashMap<String,String> urlMappingTable = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        StringBuilder completeUrl = new StringBuilder("https://www.99acres.com/2-bhk-bedroom-independent-house-villa-for-sale-in-prasanth-layout-bangalore-east-1500-sqft-spid-N85003498");
        String endUrl = completeUrl.substring(24,completeUrl.length());
        String shortUrl = createShortUrl(endUrl);
        urlMappingTable.put(shortUrl,endUrl);

        urlMappingTable.forEach((k,v)->{
            System.out.println(k+"->"+v);
        });


    }

    //Functional Requirements
    //1.create tiny url from source yrl
    //2.get real url from tiny url

    public static String createShortUrl(String sourceUrl) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(sourceUrl.getBytes());
        return HexFormat.of().formatHex(hash).substring(0,6);
    }

    public static String getRealUrl(String tinyUrl){
        return urlMappingTable.getOrDefault(tinyUrl, null);
    }



}

