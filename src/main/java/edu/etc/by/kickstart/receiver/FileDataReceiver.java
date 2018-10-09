package edu.etc.by.kickstart.receiver;

import edu.etc.by.kickstart.exception.ReceiverException;

import java.util.List;

interface FileDataReceiver {

    List<String> readAll(String filepath) throws ReceiverException;
}
