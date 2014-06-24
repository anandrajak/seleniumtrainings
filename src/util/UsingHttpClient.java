package util;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
    public class UsingHttpClient {

        private static final String HTTP_HOST = "http://fotostrana.ru/support/ajax/deleteuser/";
        public final static String ENCODING = "UTF-8";

        //public static reset

        // invoke API method using Http
        public static JSONObject invokeGetHttp(String params) throws Exception {

            // result of xml parsing
            JSONObject jsonobj = null;

            // Create an instance of HttpClient_.
            HttpClient client = new HttpClient();

            GetMethod method;
            // Create a method instance.
            if (params.startsWith("http"))
            {
                method = new GetMethod(params); // если передаются не параметры а готовый урл
            }                                   // это исключение - использование не для тестов
            else
            {
                method = new GetMethod(HTTP_HOST + params);
            }

            // Provide custom retry handler is necessary
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));

            try {
                // Execute the method.
                int statusCode = client.executeMethod(method);

                if (statusCode != HttpStatus.SC_OK) {
                    System.err.println("Method failed: " + method.getStatusLine());
                }

                // Read the response body.
                InputStream responseBody = method.getResponseBodyAsStream();

                // Deal with the response.
                // Use caution: ensure correct character ENCODING and is not binary data
                InputStreamReader response = new InputStreamReader(responseBody, ENCODING);

                // convert InputStramReader to String.  It needs to convert to json object
                String strResponse = convertStreamToString(response);

                XML convertXML2Json = new XML();

                jsonobj = convertXML2Json.toJSONObject(strResponse);


            } catch (HttpException e) {
                System.err.println("Fatal protocol violation: " + e.getMessage());
                e.printStackTrace();
                throw e;
            } catch (IOException e) {
                System.err.println("Fatal transport error: " + e.getMessage());
                e.printStackTrace();
                throw e;
            } finally {
                // Release the connection.
                method.releaseConnection();

            }

            return jsonobj;
        }

        // convert InputStramReader to String.
        static public String convertStreamToString(InputStreamReader reader)
                throws IOException {
            if (reader != null) {
                Writer writer = new StringWriter();

                char[] buffer = new char[1024];
                try {
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                } finally {
                }
                return writer.toString();
            } else {
                return "";
            }
        }


    }





