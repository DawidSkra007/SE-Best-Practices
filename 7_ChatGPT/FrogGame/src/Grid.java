public class Grid {
    int dimension;

    public Grid(int dimension) {
        this.dimension = dimension;
    }

    public boolean isValid(Cell cell) {
        return cell.x >= 0 && cell.x < dimension && cell.y >= 0 && cell.y < dimension;
    }

}
