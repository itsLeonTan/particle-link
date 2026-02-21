public class Particle {
    public int x, y, r;
    public float dir; // Direction of travel
    public float hue; 

    public Particle() {
        r = 3;
        x = (int) (Math.random() * (ParticleField.WIDTH - 2 * r));
        y = (int) (Math.random() * (ParticleField.HEIGHT - 2 * r));
        dir = (float) (Math.random() * 360);
        hue = (float) Math.random();
    }

    public void changeHue() {
        hue = (float) Math.random();
    }

    public float mixHue(float hue2) {
        float dif = hue2 - hue; // Raw difference
        
        // shift the range to -180 to 180 to find the shortest path
        dif = ((dif + 180f) % 360f); 
        if (dif < 0) dif += 360f;
        dif -= 180f;

        return (hue + dif / 2f + 360f) % 360f; // 
    }
}
