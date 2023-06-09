package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "awardotherdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AwardOtherDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String landname;
    private String filename;

    private String filepath;
    private String name;

    private String  status;

}
