package 组合模式;

import com.sun.org.apache.xpath.internal.operations.Or;

public abstract class OrganizationComponent {
    private String name;
    private String desc;

    protected void add(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        throw new UnsupportedOperationException();
    }

    protected abstract void print();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public OrganizationComponent(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
