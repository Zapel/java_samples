package JMX.jmxlesson;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Hello extends NotificationBroadcasterSupport implements HelloMBean {
    private String name;
    static int sequenceNumber = 0;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello from jmx.");

        Notification notification = new AttributeChangeNotification(this, sequenceNumber ++, System.currentTimeMillis(), "I said Hello.",
                "sequenceNumber", "int", sequenceNumber -1, sequenceNumber);
        sendNotification(notification);
    }

    @Override
    public int addIntegers(int a, int b) {
        return a + b;
    }

    @Override
    public Person returnPerson() {
        return new Person();
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBeans has changed.";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
