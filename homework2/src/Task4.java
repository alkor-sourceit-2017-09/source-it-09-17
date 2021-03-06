import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task4 {
    public static String getCrypted(String text, String algo) throws NoSuchAlgorithmException {
        MessageDigest provider = MessageDigest.getInstance(algo);
        try {
            String encoding = "UTF-8";
            return new String(provider.digest(text.getBytes(algo)), encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }
}
