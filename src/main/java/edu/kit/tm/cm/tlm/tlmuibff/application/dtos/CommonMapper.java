package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
class CommonMapper {
    String optionalStringAsString(Optional<String> optionalString) {
        if (optionalString != null) {
            return optionalString.orElse(null);
        }
        return null;
    }
}
