package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.Name;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorldRecordCreateCommand {


    @Name
    private String description;

    @NotNull
    private Double measure;

    @NotNull
    @NotBlank
    @NotEmpty // @Name
    private String unit;

    @NotNull
    private LocalDate date;

    @NotNull
    private Long recorder;
}
