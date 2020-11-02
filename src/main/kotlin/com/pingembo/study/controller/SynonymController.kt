package com.pingembo.study.controller

import com.pingembo.study.model.Synonym
import com.pingembo.study.service.WordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/api"])
class Synonym {

    @Autowired lateinit var wordService: WordService

    @GetMapping("/synonym/{word}")
    fun getSynonym(@PathVariable word: String ): ResponseEntity<Synonym> {
        return wordService.getSynonym(word)
    }
}