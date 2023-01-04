/**
 * insertion sort algorithm
 * method take array of objects
 * basic idea of algorithm: take a element from array and place it to its appropriate location
 * */
public class Sort <T extends Comparable>{
    public void sort(T[] objects){
        int size = objects.length;
        int position = 0;
        T currentItem = null;
        for (int element = 1; element<size; element++){
            currentItem = objects[element];
            position = element-1;
            while (position>=0 && objects[position].compareTo(currentItem) > 0){
                objects[position+1] = objects[position];
                position--;
            }
            objects[position+1] = currentItem;
        }
    }
}