package com.example.library;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) { this.service = service; }

    @PostMapping("/loan")
    public Loan loan(@RequestBody Map<String,Long> payload) {
        Long bookId = payload.get("bookId");
        Long memberId = payload.get("memberId");
        return service.loanBook(bookId, memberId);
    }

    @PostMapping("/return/{loanId}")
    public Loan returnBook(@PathVariable Long loanId) { return service.returnBook(loanId); }

    @GetMapping("/member/{memberId}")
    public List<Loan> byMember(@PathVariable Long memberId) { return service.byMember(memberId); }
}
