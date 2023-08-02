import java.util.*;

public class Path {
    List<Cell> cells;

    public Path() {
        cells = new ArrayList<>();
    }

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }

    public int length() {
        return cells.size();
    }
}

