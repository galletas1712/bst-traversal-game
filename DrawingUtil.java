import greenfoot.*;

public class DrawingUtil {
    static GreenfootImage drawNode(int x, int y, int type) {
        GreenfootImage image = new GreenfootImage(25, 25);
        image.setColor(Color.BLACK);
        image.drawOval(x, y, 25, 25);
        if(type == -1) {
            image.setColor(Color.GRAY);
        } else if(type == 0) {
            image.setColor(Color.RED);
        } else if(type == 1) {
            image.setColor(Color.GREEN);
        } else {
            // throw exception
        }
        image.fillOval(x, y, 25, 25);
        return image;
    }
    static GreenfootImage drawButton(boolean type, String text) {
        GreenfootImage image = new GreenfootImage(200, 50);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 200, 50);
        if(!type) {
            image.setColor(Color.RED);
            image.fillRect(0, 0, 200, 50);
            image.setColor(Color.WHITE);
            image.setFont(new Font(true, false, 18));
            image.drawString(text, 30, 30);
        } else {
            image.setColor(Color.GREEN);
            image.fillRect(0, 0, 200, 50);
            image.setColor(Color.WHITE);
            image.setFont(new Font(true, false, 18));
            image.drawString(text, 30, 30);
        }
        return image;
    }
}
