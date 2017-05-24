package com.wdsznb.books.services.imp;

import com.wdsznb.books.clients.SHA1;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Tyranitarx on 2017/5/9.
 */
//@Service("CheckWXService")
//public class CheckWXService {
//    private static String token="wxpdsznb";
//    public static boolean checkSignature(String signature, String timestamp,
//                                         String nonce) {
//        String[] arr = new String[] { token, timestamp, nonce };
//        // sort
//        Arrays.sort(arr);
//
//        // generate String
//        String content = arr[0]+arr[1]+arr[2];
//
//
//        // shal code
//        String temp = SHA1.encode(content);
//        System.out.print(temp.equalsIgnoreCase(signature));
//        return temp.equalsIgnoreCase(signature);
//    }
//}
