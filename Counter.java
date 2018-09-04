import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor {
    public void setCount(int count) {
        String str = "Errors: " + count;
        GreenfootImage image = new GreenfootImage(str, 24, Color.RED, Color.WHITE);
        this.setImage(image);
    }
}
