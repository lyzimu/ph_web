package com.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class RandomValidateCode {
    public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";// 放到session中的key
    private Random random = new Random();
    private String randString ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//随机产生的字符串
    // 随机产生的字符串,也可以是汉字
    /*private String randString = "的一是在不了有和人这中大为上个"
            + "国我以要他时来用们生到作地于出就分对成会可主发年动同工也能下过"
            + "子说产种面而方后多定行学法所民得经十三之进着等部度家电力里如水化"
            + "高自二理起小物现实加量都两体制机当使点从业本去把性好应开它合还因由"
            + "其些然前外天政四日那社义事平形相全表间样与关各重新线内数正心反你明"
            + "看原又么利比或但质气第向道命此变条只没结解问意建月公无系军很情者最立代"
            + "想已通并提直题党程展五果料象员革位入常文总次品式活设及管特件长求老头基"
            + "资边流路级少图山统接知较将组见计别她手角期根论运农指几九区强放决西被干"
            + "做必战先回则任取据处队南给色光门即保治北造百规热领七海口东导器压志世金增"
            + "争济阶油思术极交受联什认六共权收证改清己美再采转更单风切打白教速花带安场"
            + "身车例真务具万每目至达走积示议声报斗完类八离华名确才科张信马节话米整空元"
            + "况今集温传土许步群广石记需段研界拉林律叫且究观越织装影算低持音众书布复容"
            + "儿须际商非验连断深难近矿千周委素技备半办青省列习响约支般史感劳便团往酸历"
            + "市克何除消构府称太准精值号率族维划选标写存候毛亲快效斯院查江型眼王按格养"
            + "易置派层片始却专状育厂京识适属圆包火住调满县局照参红细引听该铁价严";*/

    private int width = 100;// 图片宽度
    private int height = 30;// 图片高度
    private int lineSize = 50;// 干扰线数量
    private int stringNum = 4;// 随机产生的字符数量
    /*
     * 获得字体
     */
    private Font getFont() {
        return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
    }

    /*
     * 获得颜色
     */
    private Color getRandColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc - 16);
        int g = fc + random.nextInt(bc - fc - 14);
        int b = fc + random.nextInt(bc - fc - 18);
        return new Color(r, g, b);
    }

    /**
     * 生成随机图片
     */
    public  void getRandcode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        // BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
        Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,该对象可以在图像上进行各种绘制操作
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
        g.setColor(getRandColor(110, 133));
        // 绘制干扰线
        for (int i = 0; i <= lineSize; i++) {
            drowLine(g);
        }
        // 绘制随机字符
        String randomString = "";
        for (int i = 1; i <= stringNum; i++) {
            randomString = drowString(g, randomString, i);
        }
        session.removeAttribute(RANDOMCODEKEY);
        session.setAttribute(RANDOMCODEKEY, randomString);
        System.out.println(randomString);
        g.dispose();
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());// 将内存中的图片通过流动形式输出到客户端
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*
     * 绘制字符串
     */
    private String drowString(Graphics g, String randomString, int i) {
        g.setFont(getFont());
        g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
        String rand = getRandomString(random.nextInt(randString.length()));
        randomString += rand;
        g.translate(random.nextInt(3), random.nextInt(3));
        g.drawString(rand, 13 * i, 16);
        return randomString;
    }

    /*
     * 绘制干扰线
     */
    private void drowLine(Graphics g) {
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(40);
        int yl = random.nextInt(40);
        g.drawLine(x, y, x + xl, y + yl);
    }

    /*
     * 获取随机的字符
     */
    public String getRandomString(int num) {
        return String.valueOf(randString.charAt(num));
    }
}
