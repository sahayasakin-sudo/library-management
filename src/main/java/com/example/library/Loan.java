package com.example.library;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Member member;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned = false;
}
