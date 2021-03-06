/*Copyright (c) 2017-2018 wm9.com All Rights Reserved.
 This software is the confidential and proprietary information of wm9.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wm9.com*/

package com.mobi_22ndaug_dev.db123__.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wavemaker.runtime.data.dao.query.WMQueryExecutor;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.file.model.Downloadable;

import com.mobi_22ndaug_dev.db123__.AllTypes;

@Service
public class Db123__QueryExecutorServiceImpl implements Db123__QueryExecutorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Db123__QueryExecutorServiceImpl.class);

    @Autowired
    @Qualifier("db123__WMQueryExecutor")
    private WMQueryExecutor queryExecutor;

    @Transactional(readOnly = true, value = "db123__TransactionManager")
    @Override
    public Page<AllTypes> executeAlltypesData1(Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.executeNamedQuery("AlltypesData1", params, AllTypes.class, pageable);
    }

    @Transactional(readOnly = true, value = "db123__TransactionManager")
    @Override
    public Downloadable exportAlltypesData1(ExportType exportType, Pageable pageable) {
        Map params = new HashMap(0);


        return queryExecutor.exportNamedQueryData("AlltypesData1", params, exportType, AllTypes.class, pageable);
    }

}


