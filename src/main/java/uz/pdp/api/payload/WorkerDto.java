package uz.pdp.api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    @NotNull(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Phone number must not be empty")
    private String phoneNumber;

    @NotNull(message = "Address id must not be empty")
    private Integer addressId;

    @NotNull(message = "Department id must not be empty")
    private Integer departmentId;
}
