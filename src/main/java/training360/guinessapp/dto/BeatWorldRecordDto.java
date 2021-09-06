package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeatWorldRecordDto {
    private String description;

    private Double measure;

    private String unit;

    private LocalDate date;

    private Long recorder;
}
