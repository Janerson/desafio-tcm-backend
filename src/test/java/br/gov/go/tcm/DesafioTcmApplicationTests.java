package br.gov.go.tcm;

import br.gov.go.tcm.service.consumer_api.MunicipioConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesafioTcmApplicationTests {

    @Autowired
    private MunicipioConsumer consumer;

    @Test
    void contextLoads() {
    }



}
