package cn.chineseall.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

public class ValidateCodeUtil {
    
    private static final String CONTENT_TYPE = "image/jpeg";
    
    //验证码图片宽高
    private static final int WIDTH = 100, HEIGHT = 36;
    
    //验证码长度
    private static final int CODE_LENGTH = 4;
    
    //可重叠的部分宽度
    private static final int RECOVER_WIDTH = 0;
    
    private static Color getRandColor(int fc, int bc) {
        Random rand = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + rand.nextInt(bc - fc);
        int g = fc + rand.nextInt(bc - fc);
        int b = fc + rand.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    
    private static Font getRandFont() {
        Font font = new Font("", Font.BOLD, 30);
        return font;
    }
    
    public static String getRandomCode(int length){
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer("");
        for(int i=0;i<length;i++){
            buffer.append(chars.charAt(random.nextInt(chars.length())));
        }
        return buffer.toString();
    }
    
    private static void drawRandomBackGround(Graphics g,Random random){
        // 用随机颜色填充图像背景
        
        g.setColor(new Color(200,200,200));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        for (int i = 0; i < 5; i++) {
            g.setColor(getRandColor(50, 100));
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            g.drawOval(x, y, 4, 4);
        }
    }
    
    private static void drawOneChar(Graphics g,String code,Random random,int index){
        //随机宽度
        Graphics2D g2d = (Graphics2D) g;
        int avgWidth = WIDTH/CODE_LENGTH;
        int startX = avgWidth*index;
        int endX = startX + avgWidth;
        if(index == 0){
            startX = startX + 15;
            endX = endX + RECOVER_WIDTH;
        }else if(index == CODE_LENGTH-1){
            startX = startX - RECOVER_WIDTH;
            endX = endX - 10;
        }else{
            startX = startX - RECOVER_WIDTH;
            endX = endX + RECOVER_WIDTH;
        }
        
        int x = random.nextInt(endX-startX)+startX;
        //随机高度
        int startY = g2d.getFont().getSize()/2 + 5;
        int endY = HEIGHT - g2d.getFont().getSize()/2 - 10;
        int y = startY + random.nextInt(endY);
        // 生成随机颜色
        g2d.setColor(getRandColor(50, 80));
        // 将随机数字画在图像上
        g2d.translate(x, y);
        int dushu = random.nextInt(5) *  new int[]{1,-1}[random.nextInt(2)];
        g2d.rotate( dushu * Math.PI/180);
        g2d.drawString(code,0, 0);
        g2d.rotate(-dushu * Math.PI/180);
        g2d.translate((-1)*x, (-1)*y);
    }
    
    @RequestMapping("/secode")
    public static void secode(String randCode,HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        response.setContentType(CONTENT_TYPE);
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 创建一个图像对象
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        Random random = new Random();
        //随机背景
        drawRandomBackGround(graphics,random);
        
        // 随机数字符串
        // 设置字体
        graphics.setFont(getRandFont());
        for (int i = 0; i < CODE_LENGTH; i++) {
            String oneChar = Character.toString(randCode.charAt(i));
            drawOneChar(graphics, oneChar, random, i);
        }
        //request.getSession().setAttribute("verificationCode", randCode);
        // 使图像生效
        graphics.dispose();
        OutputStream os = response.getOutputStream();
        // 输出图像到页面
        ImageIO.write(image, "JPEG", os);
        os.flush();
        os.close();
    }
    
    public static void main(String args[]) throws IOException{
        // 创建一个图像对象
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.createGraphics();
        Random random = new Random();
        //随机背景
        drawRandomBackGround(graphics,random);
        
        // 随机数字符串
        String randCode = getRandomCode(CODE_LENGTH);
        System.out.println(randCode);
        // 设置字体
        graphics.setFont(getRandFont());
        for (int i = 0; i < CODE_LENGTH; i++) {
            String oneChar = Character.toString(randCode.charAt(i));
            drawOneChar(graphics, oneChar, random, i);
        }
        // 使图像生效
        graphics.dispose();
        OutputStream os = new FileOutputStream(new File("/home/huqilong/Desktop/test.jpg"));
        // 输出图像到页面
        ImageIO.write(image, "JPEG", os);
        os.flush();
        os.close();
    }
    
}
