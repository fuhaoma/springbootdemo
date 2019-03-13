package com.mfh.user.controller;

import com.mfh.core.BaseController;
import com.mfh.user.entity.UserE;
import com.mfh.user.service.UserService;
import com.mfh.user.vo.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.List;

@RestController
@RequestMapping("/mfh")
public class APIController extends BaseController {
    @Resource
    private UserService service;

    @RequestMapping("/user")
    public ResponseEntity getVO(@RequestParam("id")Integer id) {
        UserE user = service.getUserE(id);
//        UserVO vo = UserVO.convert2VO(user);
        return ok(user);
    }
    @GetMapping("/user/age")
    public ResponseEntity getAge() {
        List<String> ages = service.getAgeAndName();
        return ok(ages);
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserEntity user){
        return ok("成功");
    }

    public static void main(String[] args) {
        File file=new File("shattered-1.pdf");
        File file1=new File("shattered-2.pdf");
        String sha1 = getSHA1(getBytes(file));
        String sha11 = getSHA1(getBytes(file1));
        System.out.println(sha1);
        System.out.println(sha11);
        System.out.println(sha1.equals(sha11));
        System.out.println(sha1.length());
        System.out.println(sha11.length());


//        String sha15 = getSHA1();


    }

    private static String getSHA1(byte[] file) {
        try {
            MessageDigest instance = MessageDigest.getInstance("sha1");
            instance.update(file);
            return getFormattedText(instance.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] getBytes(File file){
        byte[] bytes;
        FileInputStream fileOutputStream;
        try {
            fileOutputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n=fileOutputStream.read(b))!=-1){
                byteArrayOutputStream.write(b,0,n);
            }
            byteArrayOutputStream.flush();
            fileOutputStream.close();
            byteArrayOutputStream.close();
            bytes=byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
      '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
}
