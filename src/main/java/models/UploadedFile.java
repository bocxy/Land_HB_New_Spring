package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file")
public class UploadedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private String filepath;
	private String landname;

	private String  survey_no;

	private String extent;

	private String ref_no;
	
	@ElementCollection
    @CollectionTable(name = "dynamic_values", joinColumns = @JoinColumn(name = "file_id"))
    @MapKeyColumn(name = "column_name")
    @Column(name = "value")
    private Map<String, String> dynamicValues = new HashMap<>();
}