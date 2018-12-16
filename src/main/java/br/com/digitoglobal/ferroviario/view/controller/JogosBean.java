package br.com.digitoglobal.ferroviario.view.controller;

import br.com.digitoglobal.ferroviario.configuration.scope.ViewScoped;
import br.com.digitoglobal.ferroviario.model.dto.PartidaDTO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ViewScoped
public class JogosBean implements Serializable {

    @Getter
    private List<PartidaDTO> jogos;

    @Getter
    private List<List<PartidaDTO>> jogosModel;

    @PostConstruct
    public void init()  {
        iniciarJogos();
        jogosModel = new ArrayList<>();

        int intervalo = 3;
        int index = 0;

        while (intervalo <= jogos.size()){
            jogosModel.add(jogos.subList(index, intervalo));
            index = intervalo;
            intervalo += 3;

        }

    }

    private void iniciarJogos() {
        jogos = new ArrayList<>();
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream("/data.json");
            JsonParser parser = new JsonParser();
            JsonObject parse = (JsonObject) parser.parse(new InputStreamReader(resourceAsStream, "UTF-8"));
            JsonArray jogosJson = parse.getAsJsonArray("jogos");

            for (JsonElement jogo : jogosJson) {

                JsonObject obj = (JsonObject) jogo;
                String timeCasa = obj.get("timeCasa").getAsString();
                String timeDesafiante = obj.get("timeDesafiante").getAsString();
                String campeonato = obj.get("campeonato").getAsString();
                String data = obj.get("data").getAsString();
                String local = obj.get("local").getAsString();
                String descricaoPartida = obj.get("descricaoPartida").getAsString();
                String imagem = obj.get("imagem").getAsString();
                String valor = obj.get("valor").getAsString();

                jogos.add(new PartidaDTO(timeCasa,timeDesafiante, campeonato, data, local, descricaoPartida,imagem,valor));

            }
        } catch (UnsupportedEncodingException
                e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(){
        return jogos.size() / 3;
    }

}