package Domain;

import java.util.ArrayList;
import java.util.Iterator;
public class UnitList<T extends Unit> implements Iterable<T>{
    private ArrayList<T> units = new ArrayList<T>();

    public void add(T unit) {
        units.add(unit);
    }

    public void remove(T unit) {
        units.remove(unit);
    }

    public void remove(int index) {
        units.remove(index);
    }

    public int size() {
        return units.size();
    }

    public T get(int index) {
        return units.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return units.iterator();
    }
    
    public ArrayList<T> getUnits() {
        return units;
    }

    @Override
    public String toString() {
        String text = "";
        for (T unit : units) {
            text += unit.getClass().getName() + " (" + unit.getCenterX() + "," + unit.getCenterY() + "),(" + unit.getWidth() + "," + unit.getHeight() + ") \n";
        }
        return text;
    }

}
