package com.zplus.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Person implements Serializable
{
    private static final long serialVersionUID = -5598548936290354797L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(length = 32)
    private String name;
    
    @Column(length = 3)
    private int age;
    
    public Person(){}

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    /*@Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":").append(id);
        sb.append(",\"name\":\"").append(name).append('\"');
        sb.append(",\"age\":").append(age);
        sb.append('}');
        return sb.toString();
    }*/

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}
