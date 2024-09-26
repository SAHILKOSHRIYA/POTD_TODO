class MyCalendar {
    private List<int[]> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check for any overlap with existing bookings
        for (int[] event : calendar) {
            int bookedStart = event[0];
            int bookedEnd = event[1];
            // Check if the new event overlaps with this event
            if (start < bookedEnd && end > bookedStart) {
                return false;  // Overlap detected
            }
        }
        // No overlap, so add the event to the calendar
        calendar.add(new int[]{start, end});
        return true;
    }
}

