package 职责链模式;

public class Client {
    public static void main(String[] args) {
        PurchaseRequest request = new PurchaseRequest(1,1000f,1);
        DepartmentApprover departmentApprover = new DepartmentApprover("系主任");
        CollegeApprover collegeApprover = new CollegeApprover("院长");
        departmentApprover.setApprover(collegeApprover);
        departmentApprover.processRequest(request);
    }
}
