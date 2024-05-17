package questions.extra;

public final class q4c {
    private final int id;

    public q4c(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        q4c immutable = new q4c(1);
        System.out.println("Immutable id: " + immutable.getId());
    }
}