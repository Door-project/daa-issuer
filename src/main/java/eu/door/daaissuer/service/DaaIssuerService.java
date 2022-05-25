package eu.door.daaissuer.service;

import eu.door.daaissuer.model.TestDto;
import org.springframework.stereotype.Component;

@Component
public class DaaIssuerService
{
    public TestDto test(TestDto testDto) {
        return testDto;
    }
}
