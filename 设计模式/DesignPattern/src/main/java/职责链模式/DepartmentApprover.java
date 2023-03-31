package 职责链模式;

public class DepartmentApprover extends Approver{
    public DepartmentApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getPrice()<=5000){
            System.out.println(request.getId()+"号被系主任处理成功");
        }else {
            approver.processRequest(request);
        }
    }
}
