package Prototype;

/**
 * @author : create by lcy
 * @Project : MyCode
 * @createTime : 2023/3/28 17:45
 * @description :
 *
 * 邮件模板类
 */
public class AdvTemplate {

    // 广告信的名称
    private String advSubject = "建设银行国情信用卡抽奖活动";

    // 广告信内容
    private String advContext = "国庆抽奖活动通知，只要刷卡就送你一百万……";

    // 取得广告信的名称
    public String getAdvSubject() {
        return this.advSubject;
    }
    // 取得广告信的上下文内容
    public String getAdvContext() {
        return this.advContext;
    }
}
