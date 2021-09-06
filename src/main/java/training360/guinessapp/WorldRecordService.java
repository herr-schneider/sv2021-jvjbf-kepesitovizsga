package training360.guinessapp;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import training360.guinessapp.dto.*;

import java.time.LocalDate;

@Service
public class WorldRecordService {

    private WorldRecordRepo worldRecordRepo;

    private ModelMapper modelMapper;

    public WorldRecordService(WorldRecordRepo worldRecordRepo, ModelMapper modelMapper) {
        this.worldRecordRepo = worldRecordRepo;
        this.modelMapper = modelMapper;
    }

    public WorldRecordDto createWorldRecord(WorldRecordCreateCommand createCommand) {
        WorldRecord worldRecord = new WorldRecord(createCommand.getDescription(), createCommand.getMeasure(),
                createCommand.getUnit(), createCommand.getDate(), createCommand.getRecorder());
        worldRecordRepo.save(worldRecord);
        return modelMapper.map(worldRecord, WorldRecordDto.class);
    }

    @Transactional
    public WorldRecordDto updateWithId(long id, BeatWorldRecordCommand command) {
        WorldRecord worldRecord = worldRecordRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("World record not found"));

        worldRecord.setMeasure(command.getMeasure());
        worldRecord.setDate(LocalDate.now());
        return modelMapper.map(worldRecord, WorldRecordDto.class);


    }
}
