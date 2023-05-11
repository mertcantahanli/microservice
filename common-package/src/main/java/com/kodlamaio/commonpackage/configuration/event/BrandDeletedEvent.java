package com.kodlamaio.commonpackage.configuration.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDeletedEvent {
    private UUID brandId;
}