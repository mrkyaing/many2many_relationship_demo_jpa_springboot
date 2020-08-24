package com.prodev.manytomanydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prodev.manytomanydemo.entity.post;
import com.prodev.manytomanydemo.entity.tag;
import com.prodev.manytomanydemo.repository.postRepository;
import com.prodev.manytomanydemo.repository.tagRepository;

@SpringBootApplication
public class ManytomanydemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ManytomanydemoApplication.class, args);
	}
    @Autowired
    private postRepository postrepo;
    @Autowired
    private tagRepository tagrepo;
    
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		post p=new post("Hibernate many to many demo","many to many deom","spring boot with hivernate ");
		
		tag t1=new tag("spring boot");
		tag t2=new tag("hibernate");
		tag t3=new tag("hibernate");
		
		p.getTags().add(t1);
		p.getTags().add(t2);
		p.getTags().add(t3);
		
		t1.getPosts().add(p);
		t2.getPosts().add(p);
		t3.getPosts().add(p);
		
		postrepo.save(p);
		
	}

}
