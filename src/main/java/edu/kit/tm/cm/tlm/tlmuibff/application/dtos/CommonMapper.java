package edu.kit.tm.cm.tlm.tlmuibff.application.dtos;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Component
public class CommonMapper {
    public String optionalStringAsString(Optional<String> optionalString) {
        if (optionalString != null) {
            return optionalString.orElse(null);
        }
        return null;
    }

    public String optionalNotNullStringAsString(@NotNull Optional<String> optionalString) {
        return optionalString.orElse(null);
    }
}
