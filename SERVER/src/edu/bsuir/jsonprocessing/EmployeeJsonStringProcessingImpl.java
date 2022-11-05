package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.Employee;


import java.io.IOException;
import java.util.List;


public class EmployeeJsonStringProcessingImpl implements JsonStringProcessing<Employee>{

    @Override
    public String stringSerialisation(Employee employee) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonEmployee = mapper.writeValueAsString(employee);

        return jsonEmployee;
    }

    @Override
    public Employee stringDeserialisation(String jsonEmployee) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.readValue(jsonEmployee,Employee.class);
        return employee;
    }


    public String stringListSerialisation(List<Employee> list) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonList = mapper.writeValueAsString(list);

        return jsonList;
    }


}
