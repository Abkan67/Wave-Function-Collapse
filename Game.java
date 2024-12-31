import javax.swing.JOptionPane;

public class Game {

	private Display display; static Game currentGame;private Animation animator; private Maze maze;
	private int width; private int height;
	Game() {
		currentGame = this;
		this.display = new Display(this, 1000,600);
		width = Integer.parseInt(JOptionPane.showInputDialog(display.getFrame(), "Select Width"));
		height = Integer.parseInt(JOptionPane.showInputDialog(display.getFrame(), "Select Height"));
		setupGame();
	}
	public void setupGame(){
		
		this.maze = new Maze(width,height, this.display.getFrame().getWidth(),this.display.getFrame().getHeight());
		maze.start();

		this.animator = new Animation(this);
		animator.start();
	}
	public void tick(){
		this.display.repaint();
	}
	public void closeEverything(){
		this.maze.stop();
		this.animator.stop();
	}
	public void restart() {
		closeEverything();
		setupGame();
	}

	public Display getDisplay() {return display;}
	public Animation getAnimator() {return animator;}
	public Maze getMaze() {return maze;}

	public static void main(String[] args) {
		new Game();
	}

}