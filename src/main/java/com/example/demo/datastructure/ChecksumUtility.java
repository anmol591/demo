package com.example.demo.datastructure;
import com.paytm.pg.merchant.*;

public class ChecksumUtility {

    public static void createChecksum() throws Exception {
        /* initialize JSON String */
        String body = "{\"mid\":\"PTMAIP50605021738524\",\"orderId\":\"12492163864\"}";

       /**
            * Generate checksum by parameters we have in body
             * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
       */

        String paytmChecksum = PaytmChecksum.generateSignature(body, "dfdfjjkj987DESF");
        System.out.println("generateSignature Returns: " + paytmChecksum);
    }

    public static void validateChecksum() throws Exception {
        /* string we need to verify against checksum */
        String body = "{\"mid\":\"PTMAIP50605021738524\",\"orderId\":\"12492163864\"}";

        /* checksum that we need to verify */
        String paytmChecksum = "CHECKSUM_VALUE";

           /**
                * Verify checksum
                * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
            * */
        boolean isVerifySignature = PaytmChecksum.verifySignature(body, "YOUR_MERCHANT_KEY", paytmChecksum);
        if (isVerifySignature) {
            System.out.append("Checksum Matched");
        } else {
            System.out.append("Checksum Mismatched");
        }
    }

    public static void main(String args[]){
        try {
            createChecksum();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
