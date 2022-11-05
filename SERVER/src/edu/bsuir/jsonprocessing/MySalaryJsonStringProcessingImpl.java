package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.MySalary;

import java.io.IOException;

public class MySalaryJsonStringProcessingImpl implements JsonStringProcessing<MySalary>{

    @Override
    public String stringSerialisation(MySalary mySalary) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonMySalary = mapper.writeValueAsString(mySalary);
        return jsonMySalary;
    }

    @Override
    public MySalary stringDeserialisation(String jsonMySalary) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MySalary mySalary = mapper.readValue(jsonMySalary,MySalary.class);
        return mySalary;
    }



}
