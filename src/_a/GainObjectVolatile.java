package _a;

public class GainObjectVolatile {
    private static volatile GainObject gainObject = new GainObject();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 start");
            gainObject.user1.setName("Vasy");
            System.out.println("t1 sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 wake up");
            gainObject.user1.setId(1);
            System.out.println("t1 start");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2 start");
            gainObject.user2.setId(1);
            gainObject.user1.setName("Non Vasy");
            System.out.println("t2 finish");
        });

        t1.start();
        t2.start();

        Thread.sleep(1100);
        System.out.println(gainObject);
    }
}

class GainObject {
    User1 user1 = new User1();
    User2 user2 = new User2();

    @Override
    public String toString() {
        return "GainObject{" +
                "user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
}

class User1 {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class User2 {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User2{" +
                "id=" + id +
                '}';
    }
}