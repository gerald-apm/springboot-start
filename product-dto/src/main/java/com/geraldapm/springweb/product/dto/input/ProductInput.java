package com.geraldapm.springweb.product.dto.input;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductInput {
    @Pattern(regexp = "/^[a-zA-Z ]*$/", message = "Name Hanya boleh alphabet dan spasi")
    private String name;

    @NotBlank(message = "description tidak boleh blank")
    private String description;

    @NotNull(message = "price tidak boleh null")
    private Double price;
}
