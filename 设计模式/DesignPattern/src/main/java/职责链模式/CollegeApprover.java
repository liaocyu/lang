package 职责链模式;

public class CollegeApprover extends Approver{
    public CollegeApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if(request.getPrice()<=10000){
            System.out.println(request.getId()+"号被院主任处理成功");
        }else {
            approver.processRequest(request);
        }
    }
}
