package snowcastervz.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Info")
public class Info {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="infoid")
    private Integer infoid;

    private Integer userid;
    private String info;
}
