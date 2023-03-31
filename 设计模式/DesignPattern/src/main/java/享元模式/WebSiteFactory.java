package 享元模式;

import java.util.HashMap;
import java.util.Map;

public class WebSiteFactory {
    //创建集合，充当池的作用
    private final Map<String,WebSite> pool= new HashMap<>();

    //根据网站类型获取网站，如果没有就创建
    public WebSite getWebSiteCategory(String type){
        if(!pool.containsKey(type)){
            synchronized (this){
                if(!pool.containsKey(type)){
                    pool.put(type,new ConcreteWebSite(type));
                }
            }
        }
        return pool.get(type);
    }

    public int getWebSiteCount(){
        return pool.size();
    }
}
