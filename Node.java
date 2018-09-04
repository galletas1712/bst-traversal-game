import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node extends Actor
{
    /**
     * Act - do whatever the Node wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int label;
    
    public Node(int label) {
        this.label = label;
        //System.out.println(label);
    }
    
    public void setStatus(int type) {
        this.setImage(DrawingUtil.drawNode(0, 0, type));
    }
    
    public void act() 
    {
        // Add your action code here.
        MyWorld world = (MyWorld) getWorld();
        if(world.idx == world.n) return;
        if(Greenfoot.mouseClicked(this)) {
            //System.out.println(world.t.inorder[world.idx] + " " + this.label);
            if(world.type == 0) { // inorder traversal
                if(world.t.inorder[world.idx] != this.label) {
                    setStatus(0);
                    Greenfoot.delay(100);
                    setStatus(-1);
                    ++world.error_count;
                    world.counter.setCount(world.error_count);
                } else {
                    setStatus(1);
                    ++world.idx;
                    if(world.idx == world.n) {
                        world.finished();
                    }
                }
            } else if(world.type == 1) {
                if(world.t.preorder[world.idx] != this.label) {
                    setStatus(0);
                    Greenfoot.delay(100);
                    setStatus(-1);
                    ++world.error_count;
                    world.counter.setCount(world.error_count);
                } else {
                    setStatus(1);
                    ++world.idx;
                    if(world.idx == world.n) {
                        world.finished();
                    }
                }
            } else if(world.type == 2) {
                if(world.t.postorder[world.idx] != this.label) {
                    setStatus(0);
                    Greenfoot.delay(100);
                    setStatus(-1);
                    ++world.error_count;
                    world.counter.setCount(world.error_count);
                } else {
                    setStatus(1);
                    ++world.idx;
                    if(world.idx == world.n) {
                        world.finished();
                    }
                }
            } else {
                // throw exception
            }
        }
    }    
}
