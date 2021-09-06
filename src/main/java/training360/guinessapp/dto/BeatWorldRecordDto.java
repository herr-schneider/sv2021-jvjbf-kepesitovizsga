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

    private Double newRecordValue;

    private Double oldRecordValue;

    private String unitOfMeasure;

    private String oldRecorderName;

    private String newRecorderName;

    private LocalDate date;

    private Double getRecordDifference(){
        return oldRecordValue-newRecordValue;
    }

    private Long recorder;
}
