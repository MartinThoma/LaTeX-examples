public class Shark {
    // attributes
    private Laser laserAttachedToHead;

    // methods
    public void attack(Enemy e) {
        this.laserAttachedToHead.fire(e);
    }

    private void eat() {
        // rawr!
    }
}

// invoke method
Shark erik = new Shark();
erik.attack(somalianPirate);
