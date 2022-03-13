package uz.pdp.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @NotNull(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Company id must not be empty")
    private Integer companyId;
}
