package service;

import model.LeaveRequest;

import java.util.ArrayList;
import java.util.List;

public class LeaveService {

    private final List<LeaveRequest> requests;

    public LeaveService() {
        requests = new ArrayList<>();
    }

    public void submitRequest(
            LeaveRequest leaveRequest) {

        requests.add(leaveRequest);
    }

    public List<LeaveRequest> getAllRequests() {
        return requests;
    }

    public void approveLeave(
            LeaveRequest leaveRequest) {

        leaveRequest.approve();
    }

    public void rejectLeave(
            LeaveRequest leaveRequest) {

        leaveRequest.reject();
    }
}