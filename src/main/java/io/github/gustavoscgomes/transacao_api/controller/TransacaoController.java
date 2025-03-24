package io.github.gustavoscgomes.transacao_api.controller;

import io.github.gustavoscgomes.transacao_api.dto.EstatisticaDTO;
import io.github.gustavoscgomes.transacao_api.dto.TransacaoDTO;
import io.github.gustavoscgomes.transacao_api.service.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {

    private final TransacaoService service;

    @PostMapping
    @Operation(
            summary = "Cria uma nova transação",
            description = "Contém as operações para criar uma nova transação",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Recurso criado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "A transação não foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que 0)"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)"
                    )
            }
            )

    public ResponseEntity<Void> receberTransacoes(@RequestBody TransacaoDTO transacaoDTO) {

        service.adicionarTransacao(transacaoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    @Operation(
            summary = "Apaga todas as informações",
            description = "Contém as operações para apagar as transações",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Todas as informações foram apagadas com sucesso"
                    )
            }
            )
    public ResponseEntity<Void> deletarTransacoes() {
        service.limparTransacoes();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
