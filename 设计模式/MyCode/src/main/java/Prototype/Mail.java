package Prototype;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 17:40
 * @description :
 */
public class Mail implements Cloneable{
    // 收件人
    private String receiver;

    // 邮件名称
    private String subject;

    // 称谓
    private String appellation;

    // 邮件内容
    private String context;

    // 邮件尾部
    private String tail;

    public Mail(AdvTemplate advTemplate) {
        // 邮件内容
        this.context = advTemplate.getAdvContext();
        // 邮件名称
        this.subject = advTemplate.getAdvSubject();
    }

    @Override
    protected Mail clone() {
        Mail mail = null;

        try {
            mail = (Mail) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return mail;
    }


    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getContext() {
        return context;
    }

    public String getTail() {
        return tail;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getAppellation() {
        return appellation;
    }

}
