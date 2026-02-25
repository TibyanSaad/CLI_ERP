public class Customer {
    int complaintId;
    String complaintDescription;
    String[] complaintPriority = {"LOW","MEDIUM","HIGH"};
    String cPriorityIndex;

    public Customer(int complaintId, String complaintDescription, int index){
        this.complaintId = complaintId;
        this.complaintDescription = complaintDescription;
        if (index > 3 || index < 0){
            this.cPriorityIndex = complaintPriority [1];
        }this.cPriorityIndex = complaintPriority[index];
    }
    public int getComplaintId(){
        return complaintId;
    }
    public String getComplaintDescription(){
        return complaintDescription;
    }
    public String getComplaintPriority(){
        return cPriorityIndex;
    }

}
