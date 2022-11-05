package edu.bsuir.jsonprocessing;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.FormOfPayment;

import java.io.IOException;

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



}
