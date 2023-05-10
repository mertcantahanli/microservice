package com.kodlamaio.filterservice.configuration;

import com.kodlamaio.commonpackage.utils.mappers.ModelMapperManager;
import com.kodlamaio.commonpackage.utils.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperCongig {
    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper){
        return  new ModelMapperManager(mapper);
    }
}
