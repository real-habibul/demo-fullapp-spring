package com.alterra.demofullapp.controller;

import com.alterra.demofullapp.entity.Member;
import com.alterra.demofullapp.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberRepository repo;

    @GetMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            return "Hello World!";
        } else {
            return "Hello " + name + "!";
        }
    }

    @GetMapping("/member/{id}")
    public String index(@PathVariable("id") int id) {
        return "Hello " + id + "!";
    }

    @PostMapping("/members")
    public Member save(@RequestBody CreateMemberRequest member) {
        System.out.println(member.getName());
        Member member1 = new Member();
        member1.setName(member.getName());
        repo.save(member1);
        return member1;
    }

    @GetMapping("/members")
    public List<Member> getAll() {
        List<Member> members = repo.findAll();
        return members;
    }

    @DeleteMapping("/members/{id}")
    public String delete(@PathVariable("id") Long id) {
        try {
            repo.deleteById(id);
            return String.format("{\"message\":\"success deleted\",\"status\":\"200\"}");
        } catch (Exception e) {
            return String.format("{\"message\":\"Member not Found\",\"status\":\"404\"}");
        }

    }


}
