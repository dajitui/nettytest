package test;

import com.dream.springbootframe.config.netty.InformationOperateMapMatching;
import com.dream.springbootframe.config.netty.Mage;

public class test {
    public static void main(String[] args) {
        /*String text="{\"id\":\"1\",\"name\":\"1\",\"table\":\"2\",\"message\":\"10001\"}";
        Mage mage = null;
        try {
            mage = Mage.strJson2Mage(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(mage.toString());*/
        System.out.println(InformationOperateMapMatching.map);
    }
}
