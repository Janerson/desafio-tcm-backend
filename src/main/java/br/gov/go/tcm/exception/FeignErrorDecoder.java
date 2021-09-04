package br.gov.go.tcm.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    Logger logger = LoggerFactory.getLogger(FeignErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        logger.error("Status code " + response.status() + ", methodKey = " + methodKey);

        switch (response.status()) {
            case 503: {
                return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.reason() + " -> " + response.request().url());
            }
            default:
                return new ResponseStatusException(HttpStatus.valueOf(response.status()),response.reason());
        }
    }
}
