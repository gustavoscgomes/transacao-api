package io.github.gustavoscgomes.transacao_api.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(Double valor, OffsetDateTime dataHora) {
}
