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
        List<TransacaoDTO> transacaoDTOS = transacaoService.listarTransacoes(intevalo);

        DoubleSummaryStatistics doubleSummaryStatistics = transacaoDTOS.stream()
                .mapToDouble(TransacaoDTO::valor)
                .summaryStatistics();

        return new EstatisticaDTO(doubleSummaryStatistics.getCount(),
                doubleSummaryStatistics.getSum(), doubleSummaryStatistics.getAverage(),
                doubleSummaryStatistics.getMin(), doubleSummaryStatistics.getMax());
    }
}
