package com.example.demo.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Pet information")
@Data
public class Pet {
    
    @ApiModelProperty(notes = "Internal id", example= "123")
    private Long id;
    @ApiModelProperty(notes = "Pet's name", example= "fido")
    private String name;

    @ApiModelProperty(notes = "Pet's etag", example= "ABC-123")
    private String tag;

    @ApiModelProperty(notes = "Pet's species", example= "Dog")
    private String species;
}
