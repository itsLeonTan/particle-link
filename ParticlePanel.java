
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ParticlePanel extends JPanel {
    Particle[] particles = new Particle[100];

    public ParticlePanel() {
        Timer timer = new Timer(15, this::update);
        timer.start();

        for (int i = 0; i < particles.length; i++) {
            particles[i] = new Particle();
        }
    }

    private void update(ActionEvent e) {
        double step = 3.0;
        for (Particle p:particles) {
            if (p.x + p.r * 2 > ParticleField.WIDTH || p.x < 0) {
                p.dir = (float) ((360.0 - p.dir) % 360.0);
                p.changeHue();
            }
            if (p.y + p.r * 2 > ParticleField.HEIGHT || p.y < 0) {
                p.dir = (float) ((180.0 - p.dir + 360.0) % 360.0);
                p.changeHue();
            }

            double rad = Math.toRadians(p.dir);
            p.x += (int) (Math.sin(rad) * step);
            p.y -= (int) (Math.cos(rad) * step);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear screen
        setBackground(Color.BLACK);
        g.setColor(Color.WHITE);
        
        final int limit = 200;

        for (int i = 0; i < particles.length; i++) {
            for (int j = i + 1; j < particles.length; j++) {
                float d = (float) Math.sqrt(Math.pow(particles[j].x - particles[i].x, 2) + Math.pow(particles[j].y - particles[i].y, 2));

                if (d < limit) {
                    g.setColor(Color.getHSBColor(particles[i].mixHue((float) particles[j].hue), 1.0f, 1f - d / limit));
                    int r = particles[i].r;
                    g.drawLine(particles[i].x + r, particles[i].y + r, particles[j].x + r, particles[j].y + r);
                }
            }

            g.setColor(Color.getHSBColor(particles[i].hue, 1.0f, 0.8f));
            g.fillOval(particles[i].x, particles[i].y, particles[i].r * 2, particles[i].r * 2);
        }
    }
}
