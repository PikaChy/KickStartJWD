package edu.etc.by.kickstart.receiver;

import edu.etc.by.kickstart.exception.ReceiverException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDataReceiverImpl implements FileDataReceiver {
    public List<String> readAll(String filepath) throws ReceiverException {
        List<String> outputList;

        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {
            outputList = stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReceiverException("Something goes wrong during reading the file", e);
        }
        return outputList;
    }
}
