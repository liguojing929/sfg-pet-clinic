package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate visitDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinTable(name = "pet_id")
    private Pet pet;

}
