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

    public Candidato obtenerCandidatoConMasVotosNacional() {
        return this.obtenerCandidatoMasVotadoDesdeLosVotos(this.votos);
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
