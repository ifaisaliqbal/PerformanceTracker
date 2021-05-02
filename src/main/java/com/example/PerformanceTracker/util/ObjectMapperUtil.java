/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.PerformanceTracker.util;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

/**
 *
 * @author iqbal
 */
public class ObjectMapperUtil {
    
    private static ModelMapper modelMapper = new ModelMapper();
    
    public static <D,S> D map(final S source, D destination) {
        modelMapper.map(source, destination);
        return destination;
    }
    
    public static <D,S> List<D> mapAll(final List<S> sList, Class<D> outClass) {
        return sList
                        .stream()
                        .map(item -> modelMapper.map(item, outClass))
                        .collect(Collectors.toList());               
    }
}
