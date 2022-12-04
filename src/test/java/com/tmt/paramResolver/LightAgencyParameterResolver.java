package com.tmt.paramResolver;

import com.tmt.domain.response.LightAgency;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.Set;
import java.util.UUID;

import static com.tmt.utils.Constants.*;

public class LightAgencyParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == LightAgency.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

        var lightAgency = factory.createProjection(LightAgency.class);
        lightAgency.setMainUuId(UUID.randomUUID());
        lightAgency.setCode(AGENCY_CODE);
        lightAgency.setName(AGENCY_NAME);
        lightAgency.setAddress(AGENCY_ADDRESS);
        lightAgency.setPhones(Set.of(AGENCY_PHONE_0, AGENCY_PHONE_1));
        lightAgency.setEmails(Set.of(AGENCY_EMAIL_0, AGENCY_EMAIL_1));

        return lightAgency;
    }
}
