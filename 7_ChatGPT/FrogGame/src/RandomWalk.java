import java.util.HashSet;
import java.util.Set;

public class RandomWalk {
        int noOfHops;
        int noOfRolls;
        Path path;

        Set<Cell> visitedCells;

        public RandomWalk() {
            noOfHops = 0;
            noOfRolls = 0;
            path = new Path();
            visitedCells = new HashSet<>();
        }

        public void start(int dimension, Frog frog) {
            if (dimension < 1) {
                throw new IllegalArgumentException("Dimension must be greater than or equal to 1.");
            }
            Grid grid = new Grid(dimension);
            Die die = frog instanceof DiagFrog ? new EightDie() : new Die();

            while (visitedCells.size() < dimension * dimension) {
                String direction = die.roll();
                Cell newPosition = new Cell(frog.currentPosition.x, frog.currentPosition.y);
                frog.move(direction);
                newPosition.x = frog.currentPosition.x;
                newPosition.y = frog.currentPosition.y;

                while (!grid.isValid(newPosition) || visitedCells.contains(newPosition)) {
                    if (!path.cells.isEmpty()) {
                        frog.currentPosition.x = path.cells.get(path.length() - 1).x;
                        frog.currentPosition.y = path.cells.get(path.length() - 1).y;
                    }
                    direction = die.roll();
                    frog.move(direction);
                    newPosition.x = frog.currentPosition.x;
                    newPosition.y = frog.currentPosition.y;
                    noOfRolls++;
                }

                path.addCell(newPosition);
                visitedCells.add(new Cell(newPosition.x, newPosition.y));
                noOfHops++;
                noOfRolls++;
            }
        }

        public int getNoOfHops() {
            return noOfHops;
        }

        public int getNoOfRolls() {
            return noOfRolls;
        }

        public Path getPath() {
            return path;
        }
}
