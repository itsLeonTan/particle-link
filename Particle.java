public class Particle {
    public int x, y, r;
    public float dir; // Direction of travel

    public Particle() {
        r = 3;
        x = (int) (Math.random() * (ParticleField.WIDTH - 2 * r));
        y = (int) (Math.random() * (ParticleField.HEIGHT - 2 * r));
        dir = (float) (Math.random() * 360);
    }
}
