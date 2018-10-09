package edu.etc.by.kickstart.receiver;

import edu.etc.by.kickstart.exception.ReceiverException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDataReceiverImpl implements FileDataReceiver {
    private static final String DEFAULT_URI = "repository/input.txt";

    public List<String> readAll(String uri) throws ReceiverException {
        List<String> outputList;

        if (uri.isEmpty()) {
            uri = DEFAULT_URI;
        }

        ClassLoader classLoader = getClass().getClassLoader();
        try (Stream<String> stream = Files.lines(Paths.get(
                classLoader.getResource(uri).getFile()))) {
            outputList = stream.collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new ReceiverException("Couldn't find input file", e);
        } catch (IOException e) {
            throw new ReceiverException("Something go wrong during reading the file", e);
        }
        return outputList;
    }
}
