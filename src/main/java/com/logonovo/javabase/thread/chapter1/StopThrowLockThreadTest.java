package com.logonovo.javabase.thread.chapter1;

/**
 * @Author 小凡
 * Email: logonovo@gmail.com
 * @Date 2018/3/3 22:25
 */
public class StopThrowLockThreadTest extends Thread {
    private final SynchronizedObject object;

    public StopThrowLockThreadTest(SynchronizedObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.pringString("b", "bb");
    }

    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            Thread thread = new StopThrowLockThreadTest(object);
            thread.start();
            Thread.sleep(500);
            thread.stop();
            System.out.println(object.getUsername()+" "+object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class SynchronizedObject{
    private String username = "a";
    private String password = "aa";

    public synchronized void pringString(String username, String password){
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
