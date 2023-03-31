package 职责链模式;

public abstract class Approver {
    String name;
    Approver approver;//下一个处理者

    public Approver(String name) {
        this.name = name;
    }

    public void setApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void processRequest(PurchaseRequest request);
}
