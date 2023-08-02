import java.util.*;

public class Cell {
    int x;
    int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(x, y);
    }
}

