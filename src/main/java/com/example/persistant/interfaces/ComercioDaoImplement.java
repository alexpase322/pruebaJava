package com.example.persistant.interfaces;

import com.example.persistant.models.Comercio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@Transactional
public class ComercioDaoImplement implements ComercioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    SubCategoryDao subCategoryDao;

    @Autowired
    LocationDao locationDao;

    @Autowired
    ManagerDao managerDao;


}
