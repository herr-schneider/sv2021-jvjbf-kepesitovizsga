package training360.guinessapp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import training360.guinessapp.dto.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/worldrecord")
public class WorldRecordController {

    private WorldRecordService worldRecordService;

    public WorldRecordController(WorldRecordService worldRecordService) {
        this.worldRecordService = worldRecordService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WorldRecordDto createRecorder(@Valid @RequestBody WorldRecordCreateCommand createCommand) {
        return worldRecordService.createWorldRecord(createCommand);
    }

    @PutMapping("/{id}/beatrecords")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "400", description = "")
    public ResponseEntity updateWithId(@PathVariable("id") long id,
                                       @Valid @RequestBody BeatWorldRecordCommand command) {
        try {
            return ResponseEntity.ok(worldRecordService.updateWithId(id, command));
        } catch (IllegalArgumentException iae) {
            return ResponseEntity.notFound().build();
        }
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleValidException(MethodArgumentNotValidException mnve) {
        List<Violation> violations = mnve.getBindingResult().getFieldErrors().stream()
                .map(fe -> new Violation(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());

        Problem problem = Problem.builder()
                .withType(URI.create("/api/worldrecords"))
                .withTitle("Validation error")
                .withStatus(Status.NOT_FOUND)
                .withDetail(mnve.getMessage())
                .with("violations", violations)
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Problem> handleNotFound(IllegalArgumentException iae) {
        Problem problem = Problem.builder()
                .withType(URI.create("/api/worldrecords"))
                .withTitle("Not found!")
                .withStatus(Status.NOT_FOUND)
                .withDetail(iae.getMessage())
                .build();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(problem);
    }
}
