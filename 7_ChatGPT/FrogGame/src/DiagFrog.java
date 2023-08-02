public class DiagFrog extends Frog {
    public DiagFrog(Cell startPosition) {
        super(startPosition);
    }

    @Override
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
            case "North-East":
                currentPosition.x += 1;
                currentPosition.y += 1;
                break;
            case "North-West":
                currentPosition.x -= 1;
                currentPosition.y += 1;
                break;
            case "South-East":
                currentPosition.x += 1;
                currentPosition.y -= 1;
                break;
            case "South-West":
                currentPosition.x -= 1;
                currentPosition.y -= 1;
                break;
        }
    }
}
