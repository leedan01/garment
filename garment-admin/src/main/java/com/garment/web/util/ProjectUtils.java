package com.garment.web.util;

import com.alibaba.fastjson2.JSON;
import com.garment.web.controller.ai.TbGarmentHistoryController;
import com.garment.web.dto.ImaginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.spring.web.json.Json;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/10/26  15:10
 * @Version 1.0
 */
public class ProjectUtils {

    private static final Logger log = LoggerFactory.getLogger(ProjectUtils.class);

    public static final String compressed = "compressed_";

    private static final String token = "Bearer 92e8f7f8-8f15-450a-a533-c45ae855995e";

    private static final String postUrl = "https://api.thenextleg.io/getImage";

    private static final String imagineUrl = "https://api.thenextleg.io/v2/imagine";

    private static final String getProcessUrl = "https://api.thenextleg.io/v2/message/<messageId>?expireMins=2";

    public static int downLoadImg(String imgUrl,String lastName) {
        int statusCode = 200;
        try{
            log.info("最后地址"+lastName);
            //创建post请求对象
            URL url = new URL(postUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", token);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.setRequestProperty("contentType", "utf-8");
            connection.setRequestProperty("Content-Type", "application/json"); connection.setConnectTimeout(30000);
            connection.setReadTimeout(30000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            String requestBody = "{\"imgUrl\":\""+imgUrl+"\"}";
            log.info("传入参数:"+requestBody);
            OutputStreamWriter writer  = new OutputStreamWriter(connection.getOutputStream(),"UTF-8");
            //body参数放这里
            writer.write(requestBody);
            writer.flush();
            statusCode = connection.getResponseCode();
            log.info("请求结果返回码"+statusCode);
            String message =  connection.getResponseMessage();
            log.info("请求返回消息"+message);
            if(statusCode == 200){
                InputStream inputStream = connection.getInputStream();
                byte[] buffer = new byte[1024];
                OutputStream outputStream = new FileOutputStream(lastName);
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                inputStream.close();
                outputStream.close();
            }
            writer.close();
            connection.disconnect();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return statusCode;
    }

    /**
     * 第三方接口调取
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param context
     *@return java.lang.String
     *@throws
     */
    public static String imagineImage(String context) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        ImaginDTO  imaginDTO = new ImaginDTO();
        imaginDTO.setIgnorePrefilter("false");
        imaginDTO.setRef("");
        imaginDTO.setMsg(context);
        imaginDTO.setWebhookOverride("");
        String param = JSON.toJSONString(imaginDTO);
        URL url = new URL(imagineUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        connection.setRequestProperty("Content-Type", "application/json"); connection.setConnectTimeout(30000);
        connection.setReadTimeout(30000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        out = new PrintWriter(connection.getOutputStream());
        out.print(param);
        out.flush();
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        while ((line = in.readLine()) != null)
        {
            result.append(line);
        }
        return  result.toString();
    }

    /**
     * 获取图片进度详情
     *
     *@Author leedan
     *@Description
     *@Date 2023/10/31
     *@param messageId
     *@return java.lang.String
     *@throws
     */
    public static String getImagineDetail(String messageId) throws IOException {
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        String lastUrl = getProcessUrl.replace("<messageId>",messageId);
        URL url = new URL(lastUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        connection.setReadTimeout(30000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        while ((line = in.readLine()) != null)
        {
            result.append(line);
        }
        return result.toString();
    }


    /**
     * 默认压缩图片
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/6
     *@param sourceFile
     *@param targetFile
     *@param targetSize
     *@return void
     *@throws
     */
    public static void compressImage(File sourceFile, File targetFile, long targetSize,int width,int height) throws IOException {
        BufferedImage image = ImageIO.read(sourceFile);
        long imageSize = sourceFile.length();
        double quality = (double) targetSize / imageSize;
        File compressedFile = new File(targetFile.getParent(), compressed + targetFile.getName());
        ImageIO.write(compress(image, quality,width, height), "png", compressedFile);
    }

    /**
     * 图片默认处理为300 * 300
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/6
     *@param image
     *@param quality
     *@return java.awt.image.BufferedImage
     *@throws
     */
    private static BufferedImage compress(BufferedImage image, double quality,int width,int height) {
        Image scaledImage = image.getScaledInstance((int) (image.getWidth() * quality), (int) (image.getHeight() * quality), Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage((int) (300), (int) (300), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.drawImage(scaledImage, 0, 0,300, 300, null);
        graphics.dispose();
        return bufferedImage;
    }

    /**
     *
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/9
     *@param context
     *@return java.lang.String
     *@throws
     */
    public static String SDText2Img(String context,String postUrl,String basicAuthorization) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        String param = context;
        URL url = new URL(postUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Basic "+basicAuthorization);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        connection.setRequestProperty("Content-Type", "application/json"); connection.setConnectTimeout(30000);
        connection.setReadTimeout(600000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        out = new PrintWriter(connection.getOutputStream());
        out.print(param);
        out.flush();
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        int  statusCode = connection.getResponseCode();
        if(statusCode != 200){
            return String.valueOf(statusCode);
        }
        while ((line = in.readLine()) != null)
        {
            result.append(line);
        }
        return  result.toString();
    }

    /**
     *  图生图
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/10
     *@param context
     *@param postUrl
     *@param basicAuthorization
     *@return java.lang.String
     *@throws
     */
    public static String SDImgText2Img(String context,String postUrl,String basicAuthorization) throws IOException {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        String param = context;
        URL url = new URL(postUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Basic "+basicAuthorization);
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        connection.setRequestProperty("Accept-Charset", "utf-8");
        connection.setRequestProperty("contentType", "utf-8");
        connection.setRequestProperty("Content-Type", "application/json"); connection.setConnectTimeout(30000);
        connection.setReadTimeout(600000);
        connection.setDoOutput(true);
        connection.setDoInput(true);
        out = new PrintWriter(connection.getOutputStream());
        out.print(param);
        out.flush();
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        int  statusCode = connection.getResponseCode();
        if(statusCode != 200){
            return String.valueOf(statusCode);
        }
        while ((line = in.readLine()) != null)
        {
            result.append(line);
        }
        return  result.toString();
    }

    /**
     *
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/10
     *@param
     *@return void
     *@throws
     */
    public static boolean saveBase64Image(String base64str, String savePath){
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(base64str);
            for (int i = 0; i < b.length; ++i) {
                //调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(savePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
