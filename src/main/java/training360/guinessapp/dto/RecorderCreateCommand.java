package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.Name;
import training360.guinessapp.ValidDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecorderCreateCommand {

    @Name
    private String name;

    @ValidDate
    private LocalDate dateOfBirth;
}
