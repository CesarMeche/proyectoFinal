package co.edu.uptc.utilities.sorters;

import java.util.Comparator;

public class ComparadorStados implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        int a =(int)o1;
        int b =(int)o2;
        
        return a-b;
    }
    
}
