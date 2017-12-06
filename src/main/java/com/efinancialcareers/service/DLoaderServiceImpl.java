package com.efinancialcareers.service;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component(value = "DLoaderService")
public class DLoaderServiceImpl implements DLoaderService {

    @PersistenceContext
    private EntityManager em;

}
