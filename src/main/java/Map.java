import java.util.ArrayList;

public class Map {
    ArrayList<Integer> x = new ArrayList<>();
    ArrayList<Integer> y = new ArrayList<>();

    public ArrayList<Integer> getX() {
        return x;
    }

    public void setX(ArrayList<Integer> x) {
        this.x = x;
    }

    public ArrayList<Integer> getY() {
        return y;
    }

    public void setY(ArrayList<Integer> y) {
        this.y = y;
    }

    public Map(ArrayList<Integer> x, ArrayList<Integer> y) {
        this.x = x;
        this.y = y;
    }
}
