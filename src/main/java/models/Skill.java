package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "skills")
public class Skill implements BaseEntity<Long> {

    private static final long serialVersionUID = 7586817179994468707L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "field")
    private String skillsField;

    @Column(name = "level")
    private String skillsLevel;
}
