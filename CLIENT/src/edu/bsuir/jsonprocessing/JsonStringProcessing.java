package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

public interface JsonStringProcessing<T>{

    String stringSerialisation(T obj) throws JsonMappingException, IOException;

    T stringDeserialisation(String obj) throws IOException;

}
