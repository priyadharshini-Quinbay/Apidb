package com.quinbay.march22.SpringApplication2.repository;

import com.quinbay.march22.SpringApplication2.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRedisRepository {

    private static String STUDENT_COLLECTION="student";

    private RedisTemplate<String,Student> redisTemplate;

    private static HashOperations hashOps;

    @Autowired
    public StudentRedisRepository(RedisTemplate<String,Student> redisTemplate)
    {
        this.redisTemplate=redisTemplate;
    }



    @PostConstruct
    public void init()
    {
        this.hashOps=this.redisTemplate.opsForHash();
    }

    public  List<Student> findAll()
    {
        Map<String,Student> allElements=hashOps.entries(STUDENT_COLLECTION);
        return allElements.values().stream().collect(Collectors.toList());
    }

    public  Student findOne(String stuid)
    {

        return (Student)hashOps.get(STUDENT_COLLECTION,stuid);
    }

    public static Student save(Student Student)
    {
        hashOps.put(STUDENT_COLLECTION,Student.getId(),Student);
        return Student;
    }

    public static Student insert(Student Student)
    {
        hashOps.put(STUDENT_COLLECTION,Student.getId(),Student);
        return Student;
    }
    public static Student delete(Student Student){
        hashOps.delete(STUDENT_COLLECTION,Student.getId());
        return Student;

    }


}
