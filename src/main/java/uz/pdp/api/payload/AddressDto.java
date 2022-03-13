package uz.pdp.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressDto {

    @NotNull(message = "Street must not be empty")
    private String street;

    @NotNull(message = "Home number must not be empty")
    private String homeNumber;
}
