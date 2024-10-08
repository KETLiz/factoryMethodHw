package org.example.factoryMethod;

public class Worker {
    private int id;
    private String name;
    private String post;

    public Worker(int id, String name, String post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPost() {
        return post;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                '}';
    }
}
