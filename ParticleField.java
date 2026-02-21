import javax.swing.JFrame;

public class ParticleField {
    final public static int WIDTH = 1200;
    final public static int HEIGHT = 800;
    public static void main() {
        JFrame frame = new JFrame("ParticleLink");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new ParticlePanel());
        frame.setVisible(true);
    }
}