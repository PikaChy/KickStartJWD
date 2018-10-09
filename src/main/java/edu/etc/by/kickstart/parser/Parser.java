package edu.etc.by.kickstart.parser;

import edu.etc.by.kickstart.exception.ParserException;

import java.util.List;

public interface Parser {
    Double[][] extractCubeBuildingData(List<String> data) throws ParserException;
}
