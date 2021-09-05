package br.gov.go.tcm.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignErrorDecoder implements ErrorDecoder{

    Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        ResponseStatusException exception = null;

        switch (response.status()) {
            case 503: {
                logger.error("ERRO API TCM " + response.status() + ", methodKey = " + methodKey);
                exception = new ResponseStatusException(HttpStatus.valueOf(response.status()), response.reason() + " -> " + response.request().url());
                break;
            }
            default:
                exception = new ResponseStatusException(HttpStatus.valueOf(response.status()),response.reason());
        }
        return exception;
    }
}
