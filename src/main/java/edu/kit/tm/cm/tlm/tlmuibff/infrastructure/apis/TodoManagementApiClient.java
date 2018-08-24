package edu.kit.tm.cm.tlm.tlmuibff.infrastructure.apis;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "${todoManagementMicroservice.name:todoManagementMicroservice}", url = "${todoManagementMicroservice.url:http://localhost:8080}")
public interface TodoManagementApiClient extends TodoManagementApi {
}