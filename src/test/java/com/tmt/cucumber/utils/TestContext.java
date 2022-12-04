package com.tmt.cucumber.utils;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class TestContext<GIVEN, ACTUAL, EXPECT> {

    private GIVEN given;
    private ACTUAL actual;
    private EXPECT expect;
    private Map<String, UUID> mappedKey = new HashMap<>();

}
