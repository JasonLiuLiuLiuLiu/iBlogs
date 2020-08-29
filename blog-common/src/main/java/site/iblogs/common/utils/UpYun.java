package site.iblogs.common.utils;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpYun {

    /**
     * 默认的编码格式
     */
    private static final String UTF8 = "UTF-8";

    public static String PURGE_API = "http://purge.upyun.com/purge/";


    /**
     * 刷新缓存
     */
    public static String purgeUrl(String bucketName, String userName, String password, String url) {

        String result = null;
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(PURGE_API);
        password = md5(password);

        String sign = md5(url + "&" + bucketName + "&" + getGMTDate() + "&" + password);
        String EXPECT = "Expect";
        post.setHeader(EXPECT, "");
        String AUTHORIZATION = "Authorization";
        post.setHeader(AUTHORIZATION, "UpYun " + bucketName + ":" + userName + ":" + sign);
        String DATE = "Date";
        post.setHeader(DATE, getGMTDate());

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("purge", url));
        post.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert response != null;
            result = EntityUtils.toString(response.getEntity());
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 对字符串进行 MD5 加密
     */
    private static String md5(String strSrc) {
        String result = "";
        byte[] temp = null;
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            temp = md5.digest(strSrc.getBytes(UTF8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < temp.length; i++) {
            result += Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
        }

        return result;
    }

    /**
     * 获取 GMT 格式时间戳
     */
    private static String getGMTDate() {
        SimpleDateFormat df = new SimpleDateFormat(
                "E, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(new Date());
    }
}
