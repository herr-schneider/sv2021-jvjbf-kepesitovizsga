package training360.guinessapp;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import training360.guinessapp.dto.RecorderCreateCommand;
import training360.guinessapp.dto.RecorderDto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecorderService {

    private RecorderRepo recorderRepo;

    private ModelMapper modelMapper;

    public RecorderService(RecorderRepo recorderRepo, ModelMapper modelMapper) {
        this.recorderRepo = recorderRepo;
        this.modelMapper = modelMapper;
    }

    public RecorderDto createRecorder(RecorderCreateCommand createCommand) {
        Recorder recorder = new Recorder(createCommand.getName(), createCommand.getDateOfBirth());
        recorderRepo.save(recorder);
        return modelMapper.map(recorder, RecorderDto.class);
    }

    public List<RecorderDto> getRecorders() {
        List<RecorderDto> result = recorderRepo.findAll()
                .stream()
                .filter(r -> r.getName().startsWith("B") || r.getName().contains("e"))
                .map(r -> modelMapper.map(r, RecorderDto.class))
                .sorted((r1,r2) -> r1.getDateOfBirth().compareTo(r2.getDateOfBirth()))
                .collect(Collectors.toList());
        //Collections.sort(result, Comparator.comparing((RecorderDto::getDateOfBirth)));
        return result;
    }
}
