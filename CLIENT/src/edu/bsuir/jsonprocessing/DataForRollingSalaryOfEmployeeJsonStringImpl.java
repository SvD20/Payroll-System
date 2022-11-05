package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.DataForRollingSalaryOfEmployee;

import java.io.IOException;

public class DataForRollingSalaryOfEmployeeJsonStringImpl implements JsonStringProcessing<DataForRollingSalaryOfEmployee>{
    @Override
    public String stringSerialisation(DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonDataForRollingSalaryOfEmployee= mapper.writeValueAsString(dataForRollingSalaryOfEmployee);
        return jsonDataForRollingSalaryOfEmployee;
    }

    @Override
    public DataForRollingSalaryOfEmployee stringDeserialisation(String jsonDataForRollingSalaryOfEmployee) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        DataForRollingSalaryOfEmployee dataForRollingSalaryOfEmployee = mapper.readValue(jsonDataForRollingSalaryOfEmployee,DataForRollingSalaryOfEmployee.class);
        return dataForRollingSalaryOfEmployee;
    }
}
