package co.k.prj.comm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256 {
	
    public String encrypt(String text) throws NoSuchAlgorithmException { // encrypt로 text를 주면
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());

        return bytesToHex(md.digest()); // 암호화 된 내용을 리턴
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
