import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Block {
    private static int[] allTypes = {1,2,3,4,5,6,7,8,9,10,11,12};
    private static blockType getType(int type) {
        switch (type) {
            case 1: return new blockType(blockType.Type1.isNorth,blockType.Type1.isSouth,blockType.Type1.isEast,blockType.Type1.isWest);
            case 2: return new blockType(blockType.Type2.isNorth,blockType.Type2.isSouth,blockType.Type2.isEast,blockType.Type2.isWest);
            case 3: return new blockType(blockType.Type3.isNorth,blockType.Type3.isSouth,blockType.Type3.isEast,blockType.Type3.isWest);
            case 4: return new blockType(blockType.Type4.isNorth,blockType.Type4.isSouth,blockType.Type4.isEast,blockType.Type4.isWest);
            case 5: return new blockType(blockType.Type5.isNorth,blockType.Type5.isSouth,blockType.Type5.isEast,blockType.Type5.isWest);
            case 6: return new blockType(blockType.Type6.isNorth,blockType.Type6.isSouth,blockType.Type6.isEast,blockType.Type6.isWest);
            case 7: return new blockType(blockType.Type7.isNorth,blockType.Type7.isSouth,blockType.Type7.isEast,blockType.Type7.isWest);
            case 8: return new blockType(blockType.Type8.isNorth,blockType.Type8.isSouth,blockType.Type8.isEast,blockType.Type8.isWest);
            case 9: return new blockType(blockType.Type9.isNorth,blockType.Type9.isSouth,blockType.Type9.isEast,blockType.Type9.isWest);
            case 10: return new blockType(blockType.Type10.isNorth,blockType.Type10.isSouth,blockType.Type10.isEast,blockType.Type10.isWest);
            case 11: return new blockType(blockType.Type11.isNorth,blockType.Type11.isSouth,blockType.Type11.isEast,blockType.Type11.isWest);
            case 12: return new blockType(blockType.Type12.isNorth,blockType.Type12.isSouth,blockType.Type12.isEast,blockType.Type12.isWest);
            default: return null;
        }
    }

    private blockType type; public boolean collapsed; private int x; private int y; private ArrayList<Integer> options;    
    Block(int x, int y) {
        this.x = x; this.y=y;
        this.options = new ArrayList<Integer>();
        for(int i: allTypes){this.options.add(i);}
    }
    public ArrayList<Integer> getOptions() {return options;}
    public boolean update(Block n, Block s, Block e, Block w) {
        if(collapsed) return false;
        boolean isChangeMade = false;
        for(int i = 0; i<options.size(); i++) {
            blockType bType =getType(options.get(i));
            boolean good = true;
            if(!((n==null||!n.collapsed) || n.type.south==bType.north)){good=false;}
            if(!((w==null||!w.collapsed) || w.type.east==bType.west)){good=false;}
            if(!((s==null||!s.collapsed) || s.type.north==bType.south)){good=false;}
            if(!((e==null||!e.collapsed) || e.type.west==bType.east)){good=false;}
            if(!good){this.options.remove(i); i--; isChangeMade = true;}            
        }
        if(this.options.size()==0){Game.currentGame.restart();}
        return isChangeMade;
    }
    public void collapse(int type){
        this.collapsed=true;
        this.type = getType(type);
    }
    public void randomCollapse(){
        if(this.options.size()==0) return;
        this.collapse(this.options.get((int)(Math.random()*this.options.size())));
    }
    public boolean checkOptions() {
        if(this.collapsed || this.options.size()!=1){return false;}
        collapse(options.get(0));
        return true;
    }
    public void draw(Graphics2D g, int minx, int miny, int width, int height) {
        if(collapsed){
            this.type.draw(g,minx + width*x,miny + height*y,width,height);
        } else{
            g.setColor(new Color(190,180,130));
            g.fill(new Rectangle(minx + width*x, miny + height * y, width, height));
        }
        g.setColor(Color.black);
        g.draw(new Rectangle(minx + width*x, miny + height * y, width, height));
    }
}
