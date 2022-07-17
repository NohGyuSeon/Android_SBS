package com.example.application0716.VO;

// alt + insert : 여러 메서드를 자동 완성
public class Simple {
    private String name;
    private int data;

    public Simple(String name, int data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Simple{" +
                "name='" + name + '\'' +
                ", data=" + data +
                '}';
    }
}
