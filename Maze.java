import java.awt.Graphics2D;
import java.util.ArrayList;

public class Maze implements Runnable{
    private int blockSize = 20;
    private ArrayList<Block> blocks;
    private int width; private int height;
    Maze(int width, int height, int dimw, int dimh) {
        blockSize = (int)Math.min(dimw/width, dimh/height);
        this.width=width; this.height=height;
        this.blocks = new ArrayList<Block>();
        for(int y = 0; y<height; y++) {
            for(int x = 0; x<width; x++) {
                this.blocks.add(new Block(x, y));
            }
        } 
    }
    public ArrayList<Block> getBlocks(){return blocks;}
    public Block getBlock(int index){return blocks.get(index);}
    public void draw(Graphics2D g) {
        for(int i = 0; i<blocks.size(); i++){
            blocks.get(i).draw(g, 0,0,blockSize,blockSize);
        }
    }
    public void randomCollapse() {
        ArrayList<Block> smallestSupers = new ArrayList<Block>();
        int smallest = 100;//TODO: actualy program for this
        for(Block block: blocks){
            if(!block.collapsed){
                if(block.getOptions().size()<smallest){
                    smallestSupers = new ArrayList<Block>(); smallest = block.getOptions().size();
                } 
                if(block.getOptions().size()==smallest) {
                    smallestSupers.add(block);
                }
            }
        }
        if(smallestSupers.size()>0)
            smallestSupers.get((int)(Math.random()*smallestSupers.size())).randomCollapse();
        thisSleep(10);
    }

    public void runChanges() {
        boolean isChangeMade = false;
        boolean isMazeCollapsed = true;
        for(int i = 0; i<blocks.size(); i++) {
            if(blocks.get(i).checkOptions()){isChangeMade=true; thisSleep(10);}
            if(isMazeCollapsed && !blocks.get(i).collapsed){isMazeCollapsed = false;}
        }
        for(int i = 0; i<blocks.size(); i++) {
            Block block= blocks.get(i);
            Block n=null,e=null,s=null,w = null;
            if(i>=width){n = blocks.get(i-width);}
            if(i<blocks.size()-width){s=blocks.get(i+width);}
            if(i%width!=0){w = blocks.get(i-1);}
            if(i%width!=width-1){e=blocks.get(i+1);}
            if(block.update(n, s, e, w)){isChangeMade = true;}
        }
        if(!isChangeMade) {randomCollapse();}
        if(isMazeCollapsed){stop();}
    }

    private boolean running = true; private Thread thread;
    private void thisSleep(long mil){
        try { Thread.sleep(mil); } catch (InterruptedException e) {  e.printStackTrace(); }
    }
    public synchronized void start() {this.running = true; this.thread = new Thread(this);this.thread.start();}
    public synchronized void stop() {this.running = false; }
    public void run() {
        while(running) {
            this.tick();
            thisSleep(10);
        }
    }
    private void tick() {this.runChanges();}
}
