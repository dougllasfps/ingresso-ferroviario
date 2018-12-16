package br.com.digitoglobal.ferroviario.model.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartidaDTO {

    private String timeCasa;
    private String timeDesafiante;
    private String campeonato;
    private String data;
    private String local;
    private String descricaoPartida;
    private String imagem;
    private String valor;
}