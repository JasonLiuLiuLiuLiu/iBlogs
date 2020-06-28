package site.iblogs.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GravatarTools {

    public static String computeGravatarUrl(String mail, int size, String defaultType) {
        String url = "https://www.gravatar.com/avatar/%s?d=%s&size=%d";
        String defaultIconType = "identicon";
        int defaultSize = 60;
        return String.format(
                url,
                hash(mail),
                defaultType == null ? defaultIconType : defaultType,
                size > 0 ? size : defaultSize);
    }

    private static String hash(String mail) {
        try {
            final MessageDigest md = MessageDigest.getInstance("MD5");
            final byte[] array = md.digest(mail.getBytes("CP1252"));
            final StringBuilder sb = new StringBuilder();
            for (final byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (final NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
