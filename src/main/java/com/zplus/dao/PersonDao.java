package com.zplus.dao;

import com.zplus.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Long>
{
}
