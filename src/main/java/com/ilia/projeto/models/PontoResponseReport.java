package com.ilia.projeto.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PontoResponseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(updatable = false)
    private LocalDate createdAt;

    private LocalDateTime firstEntryDate;

    private LocalDateTime firstOutDate;

    private LocalDateTime lastEntryDate;

    private LocalDateTime lastOutDate;

    private int points;

    private Long totalHours;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
