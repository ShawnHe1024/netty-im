package pers.shawn.nettyIm.common.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author jimmy
 * @create 2019-01-14 10:24
 * @desc fastjson序列化实现
 **/
public class JSONSerializer implements Serializer {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    public byte[] serialize(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsBytes(object);
    }

    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return objectMapper.readValue(bytes, clazz);
    }

}
