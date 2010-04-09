/**
 * 
 */
package com.dreamcube.core.common.tools;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.core.io.ClassPathResource;


/**
 * 数字校验码生成器
 * @author holly Apr 9, 2010
 *
 */
public class WordImageProducer {
    // ----- 由容器配置 -----
    private int           imageWidth = 60;
    private int           imageHeight  = 25;

    /** 背景图片cache */
    private BufferedImage bgImage;

    /** 背景图片宽度 */
    private int           bgImageWidth;

    /** 背景图片高度 */
    private int           bgImageHeight;

    /**
     * 初始化。
     */
    public void init() throws IOException {
        if (bgImage == null) {
            ClassPathResource imagePath = new ClassPathResource(
                "ground.JPG");
            bgImage = ImageIO.read(imagePath.getURL());

        }

        bgImageWidth = bgImage.getWidth(null);
        bgImageHeight = bgImage.getHeight(null);

        // 预加载图形系统
        produce("1234");
    }

    /**
     * 将传入的文字生成图片文件。
     *
     * @param word
     * @return
     */
    public BufferedImage produce(String word) {
        // 从背景图片中随机切出一小块

        int startX = RandomUtils.nextInt(bgImageWidth - imageWidth);
        int startY = RandomUtils.nextInt(bgImageHeight - imageHeight);
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, bgImage.getType());

        bgImage.getSubimage(startX, startY, imageWidth, imageHeight).copyData(image.getRaster());


        // 在切出的背景图片上写文字
        if (StringUtils.isBlank(word)) {
            return image;
        }


        Graphics2D g2d = image.createGraphics();
        Font font = new Font("Batmos Regular", Font.BOLD, 20);

        font.deriveFont(20);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);

        FontMetrics fontMetrics = g2d.getFontMetrics();
        int wordWidth = fontMetrics.stringWidth(word);

        int posX = (imageWidth - wordWidth) / 2;
        int posY = 18;

        for (int i = 0; i < word.length(); i++) {
            String wordPart = String.valueOf(word.charAt(i));

            g2d.drawString(wordPart, posX, ((i % 2) == 0) ? (posY + 2) : (posY - 2));
            posX += fontMetrics.stringWidth(wordPart);
        }


        return image;
    }

    /**
     * @param imageHeight
     */
    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * @param imageWidth
     */
    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
}
