package edu.bsuir.jsonprocessing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.Employee;
import edu.bsuir.entities.FormOfPayment;

import java.io.IOException;
import java.util.List;

public class FormOfPaymentJsonStringProcessingImpl implements JsonStringProcessing<FormOfPayment>{

    @Override
    public String stringSerialisation(FormOfPayment formOfPayment) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonEmployee = mapper.writeValueAsString(formOfPayment);

        return jsonEmployee;
    }

    @Override
    public FormOfPayment stringDeserialisation(String jsonFormOfPayment) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FormOfPayment formOfPayment = mapper.readValue(jsonFormOfPayment,FormOfPayment.class);
        return formOfPayment;
    }

    public String stringListSerialisation(List<FormOfPayment> list) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonList = mapper.writeValueAsString(list);

        return jsonList;
    }

}
