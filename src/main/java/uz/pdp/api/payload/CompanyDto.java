package uz.pdp.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    @NotNull(message = "CorpName must not be empty")
    private String corpName;

    @NotNull(message = "Director name must not be empty")
    private String directorName;

    @NotNull(message = "Address id must not be empty")
    private Integer addressId;
}
