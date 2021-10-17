package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project implements BaseEntity<Long> {

    private static final long serialVersionUID = -8831832807197146954L;

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "start")
    private Date projectStart;

    @Column(name = "cost")
    private Integer cost;


    @Override
    public String toString() {

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");

        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", projectStart=" + formatForDateNow.format(projectStart) +
                ", cost=" + cost +
                '}';
    }
}
