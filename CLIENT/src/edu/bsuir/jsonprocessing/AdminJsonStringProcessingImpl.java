package edu.bsuir.jsonprocessing;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.bsuir.entities.Admin;

import java.io.IOException;

public class AdminJsonStringProcessingImpl implements JsonStringProcessing <Admin>{

    @Override
    public String stringSerialisation(Admin admin) throws JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonAdmin = mapper.writeValueAsString(admin);

        return jsonAdmin;
    }

    @Override
    public Admin stringDeserialisation(String jsonAdmin) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Admin admin = mapper.readValue(jsonAdmin,Admin.class);
        return admin;
    }


}
