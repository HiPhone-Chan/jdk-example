package domain;

public class A {

    private int num;

    private String str;

    public A() {
    }

    public A(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return String.format("A [num=%s, str=%s]", num, str);
    }

}
