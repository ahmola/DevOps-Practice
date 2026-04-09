package dev.devops.practice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter@Setter@ToString
@Entity
@Table(name = "hello")
public class Hello {
    @Id
    private Long id = 1L;

    @Column(nullable = false)
    private Long count = 0L;
}
