package com.pingembo.study.gateway

import com.pingembo.study.model.Synonym
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
class WordGateway {

    @Autowired
    lateinit var baseRestTemplateGateway: BaseRestTemplateGateway

    fun getSynonym (word: String): ResponseEntity<Synonym>{
        val url: String = "https://wordsapiv1.p.rapidapi.com/words/"+word+"/synonyms"
        val httpHeaders = HttpHeaders()
        httpHeaders.set("x-rapidapi-host", "wordsapiv1.p.rapidapi.com");
        httpHeaders.set("x-rapidapi-key", "aeda918fdemsh73e3da6ea7fa46fp198572jsn86f13716205e");
        val params = emptyMap<String, String>()

        return baseRestTemplateGateway.get(
                params,
                url,
                httpHeaders,
                Synonym :: class.java)
    }
}