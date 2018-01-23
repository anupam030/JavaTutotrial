package MultiThreading.Example;

import java.util.Date;
import java.util.HashMap;

public final class ImmutableClass {

    private final String name;
    private final String mobile;
    private final Date remindingDate;

    public ImmutableClass(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
        this.remindingDate = new Date(System.currentTimeMillis());
    }
  
    public String getName(){
        return name;
    }
  
    public String getMobile(){
        return mobile;
    }
  
    public Date getRemindingDate() {
        return (Date) remindingDate.clone();
    }
}


