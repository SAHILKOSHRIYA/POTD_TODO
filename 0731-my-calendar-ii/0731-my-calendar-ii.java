//import java.util.ArrayList;
//import java.util.List;
 import java .util.*;

class MyCalendarTwo {
    private List<int[]> events;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for triple booking by verifying overlap with existing overlaps
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                return false;                     // Triple booking would occur
            }
        }
        
        // Check for double booking and add to overlaps list if overlap occurs
        for (int[] event : events) {
            if (start < event[1] && end > event[0]) {
                overlaps.add(new int[] { Math.max(start, event[0]), Math.min(end, event[1]) });
            }
        }
        
        // Add the current event to the events list
        events.add(new int[] {start, end});
        return true;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */