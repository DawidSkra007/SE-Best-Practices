public class Frog {
    Cell currentPosition;

    public Frog(Cell startPosition) {
        this.currentPosition = startPosition;
    }

    public void move(String direction) {
        switch (direction) {
            case "North":
                currentPosition.y += 1;
                break;
            case "South":
                currentPosition.y -= 1;
                break;
            case "East":
                currentPosition.x += 1;
                break;
            case "West":
                currentPosition.x -= 1;
                break;
        }
    }

}

