package com.ilia.projeto.models;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "ponto")
public class Ponto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(nullable = false, updatable = false)
//    @Type(type="uuid-char")
//    private UUID uid;

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
