public class Customer {
    int complaintId;
    String complaintDescription;
    String complaintPriority;

    public Customer(int complaintId, String complaintDescription, String complaintPriority) {
        this.complaintId = complaintId;
        this.complaintDescription = complaintDescription;
        this.complaintPriority = complaintPriority;
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public String getComplaintPriority() {
        return complaintPriority;
    }

}
