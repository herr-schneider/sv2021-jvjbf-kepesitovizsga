package training360.guinessapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorldRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Double measure;

    private String unit;

    private LocalDate date;

    private Long recorder;

    public WorldRecord(String description, Double measure, String unit, LocalDate date, Long recorder) {
        this.description = description;
        this.measure = measure;
        this.unit = unit;
        this.date = date;
        this.recorder = recorder;
    }
}
