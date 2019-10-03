package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Eleccion {

    private List<Candidato> candidatosAEleccion;
    private List<Voto> votos;

    public Eleccion(List<Candidato> candidatosAEleccion) {
        this.candidatosAEleccion = candidatosAEleccion;
        this.votos = new ArrayList<>();
    }

    public void agregarVoto(Voto voto) throws VotoInvalidoException {
        if (!this.candidatosAEleccion.contains(voto.getCandidato())){
            throw new VotoInvalidoException("El voto contiene un candidato que no se encuentra en la elección");
        }
        this.votos.add(voto);
    }

    public Candidato obtenerCandidatoConMasVotosEnProvincia(Provincia provincia) {
        List<Voto> votosPorProvincia = this.obtenerVotosPorProvincia(provincia);
        return this.obtenerCandidatoMasVotadoDesdeLosVotos(votosPorProvincia);
    }

    public Partido obtenerPartidoConMasVotosNacional() {
        return this.obtenerPartidoMasVotadoDesdeLosVotos(this.votos);
    }

    private Partido obtenerPartidoMasVotadoDesdeLosVotos(List<Voto> votos) {

        Partido partidoMasVotado = null;
        // Obtenemos los partidos que participan
        List<Partido> totalPartidos = this.candidatosAEleccion.stream().map(Candidato::getPartido).collect(Collectors.toList());

        long totalVotos = 0;

        for (Partido partido: totalPartidos) {
            // Obtenemos para cada partido los candidatos
            List<Candidato> candidatosPartido = this.candidatosAEleccion.stream().
                    filter(candidato -> candidato.getPartido() == partido).collect(Collectors.toList());

            // Filtramos los votos para los candidatos del partido y los contamos
            long totalVotosPartido = votos.stream().filter(voto -> candidatosPartido.contains(voto.getCandidato())).count();

            if (totalVotosPartido > totalVotos){
               totalVotos = totalVotosPartido;
               partidoMasVotado = partido;
            }
        }
        return partidoMasVotado;
    }

    private Candidato obtenerCandidatoMasVotadoDesdeLosVotos(List<Voto> votos){
        Candidato candidatoMasVotado = null;
        long totalVotos = 0;

        for (Candidato candidato: this.candidatosAEleccion) {
           long totalVotosCandidato = votos.stream().filter(voto -> voto.getCandidato() == candidato).count();

           if (totalVotosCandidato > totalVotos){
               totalVotos = totalVotosCandidato;
               candidatoMasVotado = candidato;
           }
        }
        return candidatoMasVotado;
    }

    private List<Voto> obtenerVotosPorProvincia(Provincia provincia){
        return this.votos.stream().filter(voto -> voto.getProvincia() == provincia).collect(Collectors.toList());
    }

}
