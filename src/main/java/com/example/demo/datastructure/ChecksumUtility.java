package com.example.demo.datastructure;
import com.paytm.pg.merchant.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;
import java.util.TreeMap;

public class ChecksumUtility {

    public static void createChecksum() throws Exception {
        /* initialize JSON String */
        String body = "{\"planName\":\"API Test 23\",\"planDescription\":\"API Test\",\"subscriptionFrequencyUnit\":\"ONDEMAND\",\"subscriptionAmountType\":\"VARIABLE\",\"graceDays\":\"0\",\"autoRetry\":\"false\",\"retryCount\":\"1\",\"trialPeriod\":\"0\",\"isAmountPlanLevel\":\"false\",\"autoRenewal\":\"false\",\"txnAmount\":\"\",\"subscriptionMaxAmount\":\"\",\"mid\":\"INTEGR77698636129383\"}";

       /**
            * Generate checksum by parameters we have in body
             * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
       */

        String paytmChecksum = PaytmChecksum.generateSignature(body, "0@z#pqDCwqYHqWHT");
        System.out.println("generateSignature Returns: " + paytmChecksum);
    }

    public static void validateChecksum() throws Exception {
        /* string we need to verify against checksum */
        String body = "";

        /* checksum that we need to verify */
        String paytmChecksum = "cc2xjpfKiIpQSErIqGjwBE0zynFL1Osdpp7+z/sYLHdzx/GoDqNlZ/3EjwY6vCLn8+vdo8JEqAfhXbbw3UJhsozGYxLG8TCKD39rVwECC/I=";

           /**
                * Verify checksum
                * Find your Merchant Key in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys
            * */
        boolean isVerifySignature = PaytmChecksum.verifySignature(body, "tYAB7CZpBnpeXeby", paytmChecksum);
        if (isVerifySignature) {
            System.out.append("Checksum Matched");
        } else {
            System.out.append("Checksum Mismatched");
        }
    }

    //create checksum with form parameters
    public static void createChecksumFormBased() throws Exception {
        TreeMap<String, String> paytmParams = new TreeMap<String, String>();
        //put all form parameters here
        paytmParams.put("MID", "RUPAYB58539831709103");
        paytmParams.put("ORDER_ID", "renw2988294");
        paytmParams.put("REQUEST_TYPE","RENEW_SUBSCRIPTION");
        paytmParams.put("TXN_AMOUNT","5.5");
        paytmParams.put("SUBS_ID","113809682");


        String paytmChecksum = PaytmChecksum.generateSignature(paytmParams, "tYAB7CZpBnpeXeby");
        System.out.println("form based generatedSignature Returns: " + paytmChecksum);
    }

    public static void validateFormBasedChecksum(HttpServletRequest request) throws Exception {
        String paytmChecksum = null;

        /* Create a TreeMap from the parameters received in POST */
        TreeMap<String, String> paytmParams = new TreeMap<String, String>();
        for (Map.Entry<String, String[]> requestParamsEntry : request.getParameterMap().entrySet()) {
            if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
                paytmChecksum = requestParamsEntry.getValue()[0];
            } else {
                paytmParams.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
            }
        }


        boolean isVerifySignature = PaytmChecksum.verifySignature(paytmParams, "YOUR_MERCHANT_KEY", paytmChecksum);
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
