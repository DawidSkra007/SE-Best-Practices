import java.util.Random;

public class Die {
    Random random;

    public Die() {
        random = new Random();
    }

    public String roll() {
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                return "North";
            case 1:
                return "South";
            case 2:
                return "East";
            case 3:
                return "West";
        }
        return null;
    }
}