import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task4 {
    public static String getCrypted(String text, String algo) throws NoSuchAlgorithmException {
        MessageDigest provider = MessageDigest.getInstance(algo);
        String encoding = "UTF-8";
        try {
            return new String(provider.digest(text.getBytes(encoding)), encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println(e.getMessage());
        }
        return "";
    }
}
