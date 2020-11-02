package com.pingembo.study.gateway

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

@Component
class BaseRestTemplateGateway {

    @Autowired
    lateinit var restTemplate: RestTemplate

    fun <T> get(params: Map<String, String>, url: String, headers: HttpHeaders, clazz: Class<T>): ResponseEntity<T> {
        val requestParams = LinkedMultiValueMap<String, String>()
        params.forEach(requestParams::add)
        val httpEntity = HttpEntity<MultiValueMap<String, String>>(requestParams,headers)
        restTemplate = RestTemplate()
        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, clazz)
    }
}