package com.pingembo.study.service

import com.pingembo.study.gateway.WordGateway
import com.pingembo.study.model.Synonym
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class WordService {

    @Autowired lateinit var wordGateway: WordGateway

    fun getSynonym(word: String): ResponseEntity<Synonym> {
        return wordGateway.getSynonym(word)
    }

}