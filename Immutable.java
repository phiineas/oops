package questions;

public final class Immutable {
    private final int id;

    public Immutable(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        Immutable immutable = new Immutable(1);
        System.out.println("Immutable id: " + immutable.getId());
    }
}