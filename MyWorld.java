import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Exception;

public class MyWorld extends greenfoot.World {

    public static final int n = 10;
    private static final int x_offset = 0, y_offset = 0;
    private static final int x_dim = 600, y_dim = 600;

    public BinaryTree t;
    private int mxd;
    private ArrayList ls[];
    public Node nodes[];
    public ModeSelector preorder, inorder, postorder;
    public Counter counter;
    
    public int idx = 0;
    public int type = 1; // start with inorder
    public int error_count = 0;
    
    public void createTree() {
        t = new BinaryTree(n);
        ls = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) ls[i] = new ArrayList();
        nodes = new Node[n];
        
        for(int i = 0; i < n; i++) {
            ls[t.d[t.preorder[i]]].add(t.preorder[i]);
            mxd = Math.max(t.d[t.preorder[i]], mxd);
        }
        int y_denom = (y_dim + mxd - 1) / mxd;
        y_denom = (y_denom + 1) / 2;
        for(int d = 0; d <= n; d++) {
            int x_denom = (x_dim + ls[d].size()) / (ls[d].size() + 1);
            x_denom = (x_denom + 1) / 2;
            for(int i = 0; i < ls[d].size(); i++) {
                nodes[(int) ls[d].get(i)] = new Node((int) ls[d].get(i));
                // System.out.println(ls[d].get(i));
                addObject(nodes[(int) ls[d].get(i)], x_offset + x_denom * (i+1), y_offset + y_denom * (d+1));
            }
        }
        for(int i = 0; i < n; i++) {
            GreenfootImage image = DrawingUtil.drawNode(0, 0, -1);
            nodes[i].setImage(image);
            int x1 = nodes[i].getX();
            int y1 = nodes[i].getY();
            //System.out.println(i + " " + t.g[i].first + " " + t.g[i].second);
            if(t.g[i].first != -1) {
                getBackground().setColor(Color.BLUE);
                int x2 = nodes[t.g[i].first].getX();
                int y2 = nodes[t.g[i].first].getY();
                getBackground().drawLine(x1, y1, x2, y2);
            }
            if(t.g[i].second != -1) {
                getBackground().setColor(Color.RED);
                int x2 = nodes[t.g[i].second].getX();
                int y2 = nodes[t.g[i].second].getY();
                getBackground().drawLine(x1, y1, x2, y2);
            }
        }
    }
    
    private void createButtons() {
        inorder = new ModeSelector(false, "Inorder", 0);
        preorder = new ModeSelector(true, "Preorder", 1);
        postorder = new ModeSelector(false, "Postorder", 2);
        addObject(inorder, 400, 100);
        addObject(preorder, 400, 200);
        addObject(postorder, 400, 300);
    }
    
    public void cancelOldMode(int new_mode) {
        idx = 0;
        for(int i = 0; i < n; i++) nodes[i].setStatus(-1);
        if(type == 0) {
            inorder.reset();
        } else if(type == 1) {
            preorder.reset();
        } else if(type == 2) {
            postorder.reset();
        } else {
            throw new Error("bad type: " + type);
        }
        this.type = new_mode;
        error_count = 0;
        counter.setCount(error_count);
        
    }
    
    public void finished() {
        idx = 0;
        error_count = 0;
        counter.setCount(error_count);
        for(int i = 0; i < n; i++) nodes[i].setStatus(-1);
    }
    
    public MyWorld() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1);
        idx = 0;
        type = 1;
        error_count = 0;
        createTree();
        createButtons();
        counter = new Counter();
        counter.setCount(0);
        addObject(counter, 400, 400);
        
        //for(int i = 0; i < n; i++) System.out.println(i + " " + nodes[i].label);
    }
}
