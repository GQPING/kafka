package com.dpim.kafka.utils;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    public static final String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANtUGcKojPuIuhejzJBDnY2q4PyTgFxYuDq71YTn9jPtyCDiypi0P8vBayCZhXjqOwFnSRZ/sA5cZk8McdMODBkCAwEAAQ==";
    public static final String privateKey = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEA21QZwqiM+4i6F6PMkEOdjarg/JOAXFi4OrvVhOf2M+3IIOLKmLQ/y8FrIJmFeOo7AWdJFn+wDlxmTwxx0w4MGQIDAQABAkEAjVynPc9lDroRNytbrZ/m7Gg2mpR3Jw4Hr9Ngy0i2ZsCpckLL1HGerKJ+gfGQVW0mbcN+8Bv8b5sxR12QYAx0AQIhAPhjdddid1KVuYQPH4CjqK+irL8MYtw/rGyaB6ffcx7zAiEA4gysL5SCDA7ZGH70elFkeoczrKLGD3hvY2N5ZYFk48MCIQDXjTCRdlDIaUhx8tHKx7u2l3xD2xLbwaH3KQAlzYLQwwIgUgu9d2uUpCHDhFOYEsl2Cc8G33MZJkZVT6KsTj5fyxcCIQDSvAk2qTH6G7K64gAHgET+wbRzZ6GGJBa4LLHK6fqJuQ==";


    /**
     * @description: 私钥加密
     * @return String
     */
    public static String getEncrypMsg(String msg){
        byte[] encryptedData = new byte[10240];
        try {
            BASE64Decoder base64Decoder=new BASE64Decoder();
            byte[] bytesOfPrivateKey = base64Decoder.decodeBuffer(privateKey);
            // 2.私钥加密、公钥解密 ---- 加密
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytesOfPrivateKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            //result = cipher.doFinal(msg.getBytes());
            //
            byte[] bytes = msg.getBytes();
            int inputLen = bytes.length;
            int offLen = 0;//偏移量
            int i = 0;
            ByteArrayOutputStream bops = new ByteArrayOutputStream();
            while(inputLen - offLen > 0){
                byte [] cache;
                if(inputLen - offLen > 53){
                    cache = cipher.doFinal(bytes, offLen,53);
                }else{
                    cache = cipher.doFinal(bytes, offLen,inputLen - offLen);
                }
                bops.write(cache);
                i++;
                offLen = 53 * i;
            }
            bops.close();
            encryptedData = bops.toByteArray();

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(encryptedData);
    }
    /**
     * @description: 公钥解密
     * @return String
     */
    public static String getDeEncrypMsg(String msg){

        byte[] result = new byte[10240];
        try {
            BASE64Decoder base64Decoder=new BASE64Decoder();
            byte[] bytesOfPublicKey = base64Decoder.decodeBuffer(publicKey);
            // 3.私钥加密、公钥解密 ---- 解密
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytesOfPublicKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            //result = cipher.doFinal(msg.getBytes());

            byte[] bytes = base64Decoder.decodeBuffer(msg);
            int inputLen = bytes.length;
            int offLen = 0;
            int i = 0;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while(inputLen - offLen > 0){
                byte[] cache;
                if(inputLen - offLen > 64){
                    cache = cipher.doFinal(bytes,offLen,64);
                }else{
                    cache = cipher.doFinal(bytes,offLen,inputLen - offLen);
                }
                byteArrayOutputStream.write(cache);
                i++;
                offLen = 64 * i;

            }
            byteArrayOutputStream.close();
            result = byteArrayOutputStream.toByteArray();

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return new String(result);
    }

}
