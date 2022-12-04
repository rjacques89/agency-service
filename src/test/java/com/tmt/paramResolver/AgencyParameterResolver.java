package com.tmt.paramResolver;

import com.tmt.domain.entity.Agency;
import org.junit.jupiter.api.extension.*;

import java.util.*;

import static com.tmt.utils.Constants.*;

public class AgencyParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Agency.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {

        return Agency.builder()
                .mainUuid(UUID.randomUUID())
                .code(AGENCY_CODE)
                .name(AGENCY_NAME)
                .address(AGENCY_ADDRESS)
                .picture(AGENCY_PICTURE)
                .phones(Set.of(AGENCY_PHONE_0, AGENCY_PHONE_1))
                .emails(Set.of(AGENCY_EMAIL_0, AGENCY_EMAIL_1))
                .build();
    }
}
