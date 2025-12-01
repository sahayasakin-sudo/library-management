package com.example.library;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    private final MemberRepository memberRepo;

    public LoanService(LoanRepository loanRepo, BookRepository bookRepo, MemberRepository memberRepo) {
        this.loanRepo = loanRepo;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    public Loan loanBook(Long bookId, Long memberId) {
        Book book = bookRepo.findById(bookId).orElseThrow();
        if (!book.isAvailable()) throw new IllegalStateException("Book not available");
        Member member = memberRepo.findById(memberId).orElseThrow();
        book.setAvailable(false);
        bookRepo.save(book);
        Loan loan = Loan.builder()
                .book(book)
                .member(member)
                .loanDate(LocalDate.now())
                .dueDate(LocalDate.now().plusWeeks(2))
                .returned(false)
                .build();
        return loanRepo.save(loan);
    }

    public Loan returnBook(Long loanId) {
        Loan loan = loanRepo.findById(loanId).orElseThrow();
        if (loan.isReturned()) throw new IllegalStateException("Already returned");
        loan.setReturned(true);
        Book book = loan.getBook();
        book.setAvailable(true);
        bookRepo.save(book);
        return loanRepo.save(loan);
    }

    public List<Loan> byMember(Long memberId) { return loanRepo.findByMemberId(memberId); }
}
