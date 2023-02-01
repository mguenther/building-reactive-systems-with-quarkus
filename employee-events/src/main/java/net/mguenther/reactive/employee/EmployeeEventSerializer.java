package net.mguenther.reactive.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class EmployeeEventSerializer implements Serializer<EmployeeEvent> {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] serialize(final String topic, final EmployeeEvent event) {

        if (event == null) throw new SerializationException("Given record payload must not be null.");

        try {
            return mapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            throw new SerializationException("Unable to serialize record payload to byte[].", e);
        }
    }
}
