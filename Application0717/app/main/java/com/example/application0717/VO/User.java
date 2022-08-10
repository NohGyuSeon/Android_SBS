package com.example.application0717.VO;

// alt + insert
public class User {
    // 사용자의 ID
    private String id;
    // 사용자의 이름
    private String name;
    // 사용자의 메일
    private String mail;

    public User(String id) {
        this(id, null, null);
    }

    public User(String id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    // id 같은 경우는 사용자를 식별하기 위한 필드이기 때문에
    // 다른 유저와 중복이되거나 수정되어서는 안된다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
