package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.SalaryOfEmployee;

import java.io.IOException;

public class SalaryOfEmployeeJsonStringProcessingImpl implements JsonStringProcessing<SalaryOfEmployee>{

    @Override
    public String stringSerialisation(SalaryOfEmployee salaryOfEmployee) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonSalaryOfEmployee = mapper.writeValueAsString(salaryOfEmployee);
        return jsonSalaryOfEmployee;
    }

    @Override
    public SalaryOfEmployee stringDeserialisation(String jsonSalaryOfEmployee) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SalaryOfEmployee salaryOfEmployee = mapper.readValue(jsonSalaryOfEmployee,SalaryOfEmployee.class);
        return salaryOfEmployee;
    }
}
