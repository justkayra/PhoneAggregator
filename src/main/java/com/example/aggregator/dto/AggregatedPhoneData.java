package com.example.aggregator.dto;

import com.example.aggregator.Server;

import java.util.HashMap;

import java.util.Map;

public class AggregatedPhoneData {
    Map<String, Map<String, Integer>> phoneTotalResult = new HashMap<String, Map<String, Integer>>();

    public Map getPhones() {
        return phoneTotalResult;
    }

      public void addPhone(String number, String sector) {
        String normalizedCode = number.replace("+","");
        if (normalizedCode.startsWith("1") || normalizedCode.startsWith("2")) {
            normalizedCode = normalizedCode.substring(0, 1);
        } else if(normalizedCode.startsWith("44")){
            normalizedCode = normalizedCode.substring(0, 2);
        } else {
            normalizedCode = normalizedCode.substring(0, 7);
        }
        if (Server.allowedPrefixes.contains(normalizedCode)) {
            Map<String, Integer> sectorsMap = phoneTotalResult.get(normalizedCode);

            if (sectorsMap == null) {
                sectorsMap = new HashMap<String, Integer>();
                sectorsMap.put(sector, 1);
            } else {
                Integer sectorCount = sectorsMap.get(sector);
                if (sectorCount == null){
                    sectorsMap.put(sector, 1);
                }else {
                    sectorsMap.put(sector, sectorCount + 1);
                }
            }
            phoneTotalResult.put(normalizedCode, sectorsMap);
        }

    }
}
