package io.github.gustavoscgomes.transacao_api.controller;

import io.github.gustavoscgomes.transacao_api.dto.TransacaoDTO;
import io.github.gustavoscgomes.transacao_api.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping
    public ResponseEntity<Void> receberTransacoes(@RequestBody TransacaoDTO transacaoDTO) {

        service.adicionarTransacao(transacaoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
