import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ModeSelector extends Actor {
    
    private int type;
    private boolean state;
    private String label;
    
    public ModeSelector(boolean state, String label, int type) {
        MyWorld world = (MyWorld) getWorld();
        this.state = state;
        this.label = label;
        this.type = type;
        this.setImage(DrawingUtil.drawButton(state, label));
    }
    
    public void reset() {
        this.state = false;
        this.setImage(DrawingUtil.drawButton(state, label));
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(this)) {
            MyWorld world = (MyWorld) getWorld();
            //if(world.type == this.type) return;
            world.cancelOldMode(this.type);
            this.state = true;
            this.setImage(DrawingUtil.drawButton(state, label));
        }
    }    
}
