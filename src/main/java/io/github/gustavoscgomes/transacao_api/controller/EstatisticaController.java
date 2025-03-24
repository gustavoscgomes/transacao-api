package io.github.gustavoscgomes.transacao_api.controller;

import io.github.gustavoscgomes.transacao_api.dto.EstatisticaDTO;
import io.github.gustavoscgomes.transacao_api.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
@RequiredArgsConstructor
public class EstatisticaController {

    private final EstatisticaService service;

    @GetMapping
    @Operation(
            summary = "Calcular Estatísticas",
            description = "Este endpoint retorna as estatísticas das transações realizadas nos últimos 60 segundos. As estatísticas incluem quantidade, soma total, média, menor e maior valor transacionado.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna as estatísticas das transações realizadas nos últimos 60 segundos",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EstatisticaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Não há transações aceitas nos últimos 60 segundos, ou a transação não atende aos critérios definidos."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)."
                    )
            }
    )
    public ResponseEntity<EstatisticaDTO> buscarEstatisticas(
            @RequestParam(value = "intervaloBusca", required = false, defaultValue = "60") Integer intervalo) {
        return ResponseEntity.ok(service.listarEstatisticas(intervalo));
    }
}
