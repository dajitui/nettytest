package com.dream.springbootframe.wxpay.controller;



import com.dream.springbootframe.wxpay.utils.WXPayUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


@RestController
@RequestMapping("wx/pay")
public class WxPayController {

    public static int defaultWidthAndHeight=200;

    /**
     * 生成二维码
     * @param response
     * @throws Exception
     */
    @RequestMapping("/qr_code/type/two")
    public void pay2(HttpServletResponse response) throws Exception {
        Map<String, String> params = new TreeMap<String, String>();
        params.put("appid", "qr_code");//公众账号ID
        params.put("mch_id", "商户号");//商户号
        params.put("trade_type", "NATIVE");//交易类型
        params.put("out_trade_no", "201508061253461235846132"); //商户系统内部的订单号
        params.put("total_fee", "1");//订单总金额(分)
        params.put("spbill_create_ip", "123.12.12.123");
        params.put("body", "商品描述");    //商品描述。
        params.put("notify_url", "http://通知地址.com/wx/notify");//通知地址
        params.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
        String xml = WXPayUtil.generateSignedXml(params,"key");//(map, key) 返回xml

        HttpPost post = new HttpPost("https://api.mch.weixin.qq.com/pay/unifiedorder");//统一下单API
        post.setEntity(new StringEntity(xml, "UTF-8"));
        String result = WXPayUtil.doPostWithBrowser(post);
        Map<String, String> map = WXPayUtil.xmlToMap(result);
        String return_code = map.get("return_code");
        if("FAIL".equals(return_code)){
            String return_msg = map.get("return_msg");
            System.err.println("return_code:>>"+return_code+"   return_msg:>>>"+return_msg);
        }
        String result_code = map.get("result_code");
        if("FAIL".equals(result_code)){
            String err_code = map.get("result_code");
            String err_code_des = map.get("err_code_des");
            System.err.println("result_code:>>"+result_code+"   err_code:>>>"+err_code+"   err_code_des:>>>"+err_code_des);
        }
        String payurl = map.get("code_url");

        //生成二维码
        Map<EncodeHintType, Object> hints=new HashMap<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 1);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(payurl, BarcodeFormat.QR_CODE, defaultWidthAndHeight, defaultWidthAndHeight, hints);
            OutputStream out = response.getOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", out);//输出二维码
            out.flush();
            out.close();

        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
