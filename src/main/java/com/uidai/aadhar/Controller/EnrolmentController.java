/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uidai.aadhar.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/enrolment")
@CrossOrigin("*")
public class EnrolmentController{

    private static final Logger logger = LoggerFactory.getLogger(EnrolmentController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcCall simpleJdbcCall;

    @PostConstruct
    public void init() {
        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("Enrolment_upload_list");
    }

    @PostMapping("/upload-list")
    public Map<String, Object> getEnrolmentUploadList(@RequestBody Map<String, Object> request) {

        logger.info("Received request: {}", request);

        Map<String, Object> responseMap = new LinkedHashMap<>();

        try {

            Map<String, Object> params = new HashMap<>();
            params.put("loginId", request.getOrDefault("loginId", ""));
            params.put("stDate", Date.valueOf(request.get("stDate").toString()));
            params.put("endDate", Date.valueOf(request.get("endDate").toString()));
            params.put("SiName", request.getOrDefault("siName", ""));
            params.put("district", request.getOrDefault("district", ""));
            params.put("operator_id", request.getOrDefault("operatorId", ""));

            logger.info("Calling Enrolment_upload_list SP with params: {}", params);

            Map<String, Object> result = simpleJdbcCall.execute(params);

            List<Map<String, Object>> data
                    = (List<Map<String, Object>>) result.get("#result-set-1");

            if (data != null && !data.isEmpty()) {
                responseMap.put("status", true);
                responseMap.put("message", "Data fetched successfully");
                responseMap.put("data", data);
            } else {
                responseMap.put("status", false);
                responseMap.put("message", "No records found");
                responseMap.put("data", data);
            }

        } catch (Exception e) {

            logger.error("Error while fetching enrolment upload list", e);

            responseMap.put("status", false);
            responseMap.put("message", "Something went wrong");
            responseMap.put("data", null);
        }

        return responseMap;
    }
    
    @PostMapping("/details")
    public Map<String, Object> getOperatorDetails(@RequestBody Map<String, Object> request) {

        Map<String, Object> responseMap = new LinkedHashMap<>();
        Map<String, Object> statusResponse = new LinkedHashMap<>();

        try {

            // 1️⃣ Get agency code from request
            String agencyCode = request.get("agencyCode") != null
                    ? request.get("agencyCode").toString()
                    : "";

            logger.info("Received request for Agency Code: {}", agencyCode);

            // 2️⃣ Call Stored Procedure
            String sql = "EXEC [UIDAI].[sp_GetOperatorDetails] @agency_code = ?";
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, agencyCode);

            // 3️⃣ Prepare Sets (for unique values)
            Set<String> operatorSet = new LinkedHashSet();
            Set<String> districtSet = new LinkedHashSet();
            String agencyCodeValue = null;

            for (Map<String, Object> row : result) {

                // Agency (only once)
                if (agencyCodeValue == null && row.get("agency_code") != null) {
                    agencyCodeValue = row.get("agency_code").toString();
                }

                // Operators (multiple allowed but unique)
                if (row.get("operator_id") != null) {
                    operatorSet.add(row.get("operator_id").toString());
                }

                // District (unique only)
                if (row.get("district_name") != null) {
                    districtSet.add(row.get("district_name").toString());
                }
            }

            // 4️⃣ Prepare Agency List
            List<Map<String, Object>> agencyCodeList = new ArrayList<>();
            if (agencyCodeValue != null) {
                Map<String, Object> agencyMap = new LinkedHashMap<>();
                agencyMap.put("agency_code", agencyCodeValue);
                agencyCodeList.add(agencyMap);
            }

            // 5️⃣ Prepare Operator List
            List<Map<String, Object>> operatorIdList = new ArrayList<>();
            for (String operator : operatorSet) {
                Map<String, Object> operatorMap = new LinkedHashMap<>();
                operatorMap.put("operator_id", operator);
                operatorIdList.add(operatorMap);
            }

            // 6️⃣ Prepare District List
            List<Map<String, Object>> districtDetails = new ArrayList<>();
            for (String district : districtSet) {
                Map<String, Object> districtMap = new LinkedHashMap<>();
                districtMap.put("district_name", district);
                districtDetails.add(districtMap);
            }

            // 7️⃣ Status Response
            if (!result.isEmpty()) {
                statusResponse.put("status", true);
                statusResponse.put("message", "Data fetched successfully");
            } else {
                statusResponse.put("status", false);
                statusResponse.put("message", "No records found");
            }

            // 8️⃣ Final Response
            responseMap.put("statusResponse", statusResponse);
            responseMap.put("agencyCodeList", agencyCodeList);
            responseMap.put("operatorIdList", operatorIdList);
            responseMap.put("districtDetails", districtDetails);

            logger.info("Response Data: {}", responseMap);

        } catch (Exception e) {

            logger.error("Error while fetching operator details", e);

            statusResponse.put("status", false);
            statusResponse.put("message", "Something went wrong");

            responseMap.put("statusResponse", statusResponse);
        }

        return responseMap;
    }
    
    /*

    @PostMapping("/details")
    public Map<String, Object> getOperatorDetails(@RequestBody Map<String, Object> request) {

        // Extract agency_code from the request body
        String agencyCode = request.get("agencyCode").toString();

        logger.info("Received request for Agency Code: {}", agencyCode);

        // Prepare SQL for stored procedure execution
        String sql = "EXEC [UIDAI].[sp_GetOperatorDetails] @agency_code = ?";

        // Execute the stored procedure using JdbcTemplate
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, agencyCode);

        // Prepare separate lists for Agency Details, Operator Details, and District Details
        List<Map<String, Object>> agencyCodeList = new ArrayList<>();
        List<Map<String, Object>> operatorIdList = new ArrayList<>();
        List<Map<String, Object>> districtDetails = new ArrayList<>();

        for (Map<String, Object> row : result) {
            // Agency Code List
            Map<String, Object> agencyCodeMap = new LinkedHashMap<>();
            agencyCodeMap.put("agency_code", row.get("agency_code"));
            agencyCodeList.add(agencyCodeMap);

            // Operator ID List
            Map<String, Object> operatorIdMap = new LinkedHashMap<>();
            operatorIdMap.put("operator_id", row.get("operator_id"));
            operatorIdList.add(operatorIdMap);

            // District Details List
            Map<String, Object> districtMap = new LinkedHashMap<>();
            districtMap.put("district_name", row.get("district_name"));
            districtDetails.add(districtMap);
        }

        // Prepare the status response
        Map<String, Object> statusResponse = new LinkedHashMap<>();
        if (!result.isEmpty()) {
            statusResponse.put("status", true);
            statusResponse.put("message", "Data fetched successfully");
        } else {
            statusResponse.put("status", false);
            statusResponse.put("message", "No records found");
        }

        // Prepare the final response map with status first
        Map<String, Object> responseMap = new LinkedHashMap<>();
        responseMap.put("statusResponse", statusResponse);  // Status goes first
        responseMap.put("agencyCodeList", agencyCodeList);
        responseMap.put("operatorIdList", operatorIdList);
        responseMap.put("districtDetails", districtDetails);

        logger.info("Response data: {}", responseMap);

        return responseMap;  // Return the response as JSON
    }
    */

}
