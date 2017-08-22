/*Copyright (c) 2017-2018 wm9.com All Rights Reserved.
 This software is the confidential and proprietary information of wm9.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wm9.com*/
package com.mobi_22ndaug_dev.db123__.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.mobi_22ndaug_dev.db123__.AllTypesSmallCase;
import com.mobi_22ndaug_dev.db123__.service.AllTypesSmallCaseService;


/**
 * Controller object for domain model class AllTypesSmallCase.
 * @see AllTypesSmallCase
 */
@RestController("db123__.AllTypesSmallCaseController")
@Api(value = "AllTypesSmallCaseController", description = "Exposes APIs to work with AllTypesSmallCase resource.")
@RequestMapping("/db123__/AllTypesSmallCase")
public class AllTypesSmallCaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AllTypesSmallCaseController.class);

    @Autowired
	@Qualifier("db123__.AllTypesSmallCaseService")
	private AllTypesSmallCaseService allTypesSmallCaseService;

	@ApiOperation(value = "Creates a new AllTypesSmallCase instance.")
@RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
public AllTypesSmallCase createAllTypesSmallCase(@RequestPart("wm_data_json") AllTypesSmallCase allTypesSmallCase, @RequestPart(value = "blobCol", required = false) MultipartFile _blobCol) {
		LOGGER.debug("Create AllTypesSmallCase with information: {}" , allTypesSmallCase);

    allTypesSmallCase.setBlobCol(WMMultipartUtils.toByteArray(_blobCol));
		allTypesSmallCase = allTypesSmallCaseService.create(allTypesSmallCase);
		LOGGER.debug("Created AllTypesSmallCase with information: {}" , allTypesSmallCase);

	    return allTypesSmallCase;
	}

    @ApiOperation(value = "Returns the AllTypesSmallCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllTypesSmallCase getAllTypesSmallCase(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting AllTypesSmallCase with id: {}" , id);

        AllTypesSmallCase foundAllTypesSmallCase = allTypesSmallCaseService.getById(id);
        LOGGER.debug("AllTypesSmallCase details with id: {}" , foundAllTypesSmallCase);

        return foundAllTypesSmallCase;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in AllTypesSmallCase instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getAllTypesSmallCaseBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in AllTypesSmallCase instance" , fieldName);

        if(!WMRuntimeUtils.isLob(AllTypesSmallCase.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        AllTypesSmallCase allTypesSmallCase = allTypesSmallCaseService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(allTypesSmallCase, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the AllTypesSmallCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllTypesSmallCase editAllTypesSmallCase(@PathVariable("id") Integer id, @RequestBody AllTypesSmallCase allTypesSmallCase) throws EntityNotFoundException {
        LOGGER.debug("Editing AllTypesSmallCase with id: {}" , allTypesSmallCase.getPkId());

        allTypesSmallCase.setPkId(id);
        allTypesSmallCase = allTypesSmallCaseService.update(allTypesSmallCase);
        LOGGER.debug("AllTypesSmallCase details with id: {}" , allTypesSmallCase);

        return allTypesSmallCase;
    }

    @ApiOperation(value = "Updates the AllTypesSmallCase instance associated with the given id.This API should be used when AllTypesSmallCase instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllTypesSmallCase editAllTypesSmallCase(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        AllTypesSmallCase newAllTypesSmallCase = WMMultipartUtils.toObject(multipartHttpServletRequest, AllTypesSmallCase.class, "db123__");
        newAllTypesSmallCase.setPkId(id);

        AllTypesSmallCase oldAllTypesSmallCase = allTypesSmallCaseService.getById(id);
        WMMultipartUtils.updateLobsContent(oldAllTypesSmallCase, newAllTypesSmallCase);
        LOGGER.debug("Updating AllTypesSmallCase with information: {}" , newAllTypesSmallCase);

        return allTypesSmallCaseService.update(newAllTypesSmallCase);
    }

    @ApiOperation(value = "Deletes the AllTypesSmallCase instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteAllTypesSmallCase(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting AllTypesSmallCase with id: {}" , id);

        AllTypesSmallCase deletedAllTypesSmallCase = allTypesSmallCaseService.delete(id);

        return deletedAllTypesSmallCase != null;
    }

    @RequestMapping(value = "/pkId-byteCol-shortCol", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the matching AllTypesSmallCase with given unique key values.")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public AllTypesSmallCase getByPkIdAndByteColAndShortCol(@RequestParam("pkId") int pkId, @RequestParam("byteCol") Byte byteCol, @RequestParam("shortCol") Short shortCol) {
        LOGGER.debug("Getting AllTypesSmallCase with uniques key PkIdAndByteColAndShortCol");
        return allTypesSmallCaseService.getByPkIdAndByteColAndShortCol(pkId, byteCol, shortCol);
    }

    /**
     * @deprecated Use {@link #findAllTypesSmallCases(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of AllTypesSmallCase instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllTypesSmallCase> searchAllTypesSmallCasesByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering AllTypesSmallCases list");
        return allTypesSmallCaseService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AllTypesSmallCase instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllTypesSmallCase> findAllTypesSmallCases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AllTypesSmallCases list");
        return allTypesSmallCaseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of AllTypesSmallCase instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<AllTypesSmallCase> filterAllTypesSmallCases(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering AllTypesSmallCases list");
        return allTypesSmallCaseService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Downloadable exportAllTypesSmallCases(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return allTypesSmallCaseService.export(exportType, query, pageable);
    }

	@ApiOperation(value = "Returns the total count of AllTypesSmallCase instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Long countAllTypesSmallCases( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting AllTypesSmallCases");
		return allTypesSmallCaseService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	public Page<Map<String, Object>> getAllTypesSmallCaseAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return allTypesSmallCaseService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service AllTypesSmallCaseService instance
	 */
	protected void setAllTypesSmallCaseService(AllTypesSmallCaseService service) {
		this.allTypesSmallCaseService = service;
	}

}
