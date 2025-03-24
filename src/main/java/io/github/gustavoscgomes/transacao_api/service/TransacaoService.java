package io.github.gustavoscgomes.transacao_api.service;

import io.github.gustavoscgomes.transacao_api.dto.EstatisticaDTO;
import io.github.gustavoscgomes.transacao_api.dto.TransacaoDTO;
import io.github.gustavoscgomes.transacao_api.exception.UnprocessableEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoDTO> transacoes = new ArrayList<>();

    public void adicionarTransacao(TransacaoDTO transacaoDTO) {
        log.info("Gravando Transação...");

        if (transacaoDTO.dataHora().isAfter(OffsetDateTime.now())) {
            log.error("Data e Hora maiores que a Data e Hora atual");
            throw new UnprocessableEntity("Data e Hora maiores que a Data e Hora atual");
        }

        if (transacaoDTO.valor() < 0) {
            log.error("O valor não pode ser menor que 0");
            throw new UnprocessableEntity("O valor não pode ser menor que 0");
        }

        transacoes.add(transacaoDTO);

        log.info("Transação gravada com sucesso:{}", transacaoDTO);
    }

    public void limparTransacoes() {
        log.info("Apagando informações...");

        transacoes.clear();

        log.info("Todas as informações foram apagadas com sucesso");
    }

    public List<TransacaoDTO> listarTransacoes(Integer intervalo) {
        log.info("Buscando transações...");

        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervalo);

        log.info("Transações retornadas com sucesso");

        return transacoes.stream()
                .filter(transacao -> transacao.dataHora().isAfter(dataHoraIntervalo))
                .toList();
    }

}
