package com.example.library;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberRepository repo;

    public MemberController(MemberRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Member> all() { return repo.findAll(); }

    @PostMapping
    public Member create(@RequestBody Member m) { return repo.save(m); }
}
