package com.eazybytes.accounts.dto;

import com.eazybytes.accounts.constants.AccountsConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DialectOverride;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account info"
)
public class CustomerDto {

    @Schema(
            description = "Name of the Customer", example = "Aditya Karade"
    )
    @NotBlank(message = "Name cannot be null or empty")
    @Size(min = 5,max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email Address of the Customer", example = "aditya.karade@gmail.com"
    )
    @NotBlank(message = "Email address can not be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the Customer", example = "7865432908"
    )
    @NotBlank(message = "Mobile Number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the Customer"
    )
    private AccountsDto accountsDto;
}
