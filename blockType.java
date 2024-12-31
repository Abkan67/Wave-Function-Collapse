import java.awt.Color;
import java.awt.Graphics2D;

public class blockType {
    public boolean north; public boolean south; public boolean east; public boolean west;
    blockType(boolean north, boolean south, boolean east, boolean west) {
        this.north=north; this.south=south;this.east=east;this.west=west;
    }

    public void draw(Graphics2D g, int x, int y, int width, int height){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
        g.setColor(new Color(0,255,50));
        if(north){g.fillRect(x+width/3, y, width/3, height*2/3);}
        if(south){g.fillRect(x+width/3, y+height/3, width/3, height*2/3);}
        if(east){g.fillRect(x+width/3, y+height/3, width*2/3, height/3);}
        if(west){g.fillRect(x, y+height/3, width*2/3, height/3);}
    }
    

    public static class Type1 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = true;
        public static boolean isEast = true; public static boolean isWest = true;
        Type1(){super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type2 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = false;
        public static boolean isEast = false; public static boolean isWest = false;
        Type2(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type3 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = true;
        public static boolean isEast = false; public static boolean isWest = false;
        Type3(){super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type4 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = false;
        public static boolean isEast = true; public static boolean isWest = true;
        Type4(){super(isNorth, isSouth, isEast, isWest); }
    }
    public static class Type5 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = true;
        public static boolean isEast = false; public static boolean isWest = true;
        Type5(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type6 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = true;
        public static boolean isEast = true; public static boolean isWest = true;
        Type6(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type7 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = false;
        public static boolean isEast = true; public static boolean isWest = true;
        Type7(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type8 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = true;
        public static boolean isEast = true; public static boolean isWest = false;
        Type8(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type9 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = false;
        public static boolean isEast = false; public static boolean isWest = true;
        Type9(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type10 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = true;
        public static boolean isEast = false; public static boolean isWest = false;
        Type10(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type11 extends blockType {
        public static boolean isNorth = false; public static boolean isSouth = false;
        public static boolean isEast = true; public static boolean isWest = false;
        Type11(){ super(isNorth, isSouth, isEast, isWest);}
    }
    public static class Type12 extends blockType {
        public static boolean isNorth = true; public static boolean isSouth = false;
        public static boolean isEast = false; public static boolean isWest = false;
        Type12(){ super(isNorth, isSouth, isEast, isWest);}
    }
}
