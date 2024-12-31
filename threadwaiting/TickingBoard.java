package threadwaiting;

import java.util.ArrayList;
import java.util.List;

public class TickingBoard {
    private final List<Integer> appointmentIds;
    private int idx;

    public TickingBoard() {
        appointmentIds = new ArrayList<>();
        idx = 0;
        for (int i = 1; i < 10; i++) {
            appointmentIds.add(i);
        }
    }

    public boolean nextAppointment(int customerId) {
        int aId = appointmentIds.get(idx);
        if (aId == customerId) {
            idx++;
            return true;
        }
        return false;
    }
}
