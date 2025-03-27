package io.github.gustavoscgomes.transacao_api.service;

import io.github.gustavoscgomes.transacao_api.dto.EstatisticaDTO;
import io.github.gustavoscgomes.transacao_api.dto.TransacaoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticaService {

    private final TransacaoService transacaoService;

    public EstatisticaDTO listarEstatisticas(Integer intevalo) {
        log.info("Buscando Estatísticas...");

        List<TransacaoDTO> transacaoDTOS = transacaoService.listarTransacoes(intevalo);

        DoubleSummaryStatistics doubleSummaryStatistics = transacaoDTOS.stream()
                .mapToDouble(TransacaoDTO::valor)
                .summaryStatistics();

        if (transacaoDTOS.isEmpty()) {
            log.info("Não há transações registradas nos últimos 60 segundos");
            return new EstatisticaDTO(0l, 0.0, 0.0, 0.0, 0.0);
        }

        log.info("Estatísticas Retornadas com sucesso");

        return new EstatisticaDTO(doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(), doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMin(), doubleSummaryStatistics.getMax());
    }
}
