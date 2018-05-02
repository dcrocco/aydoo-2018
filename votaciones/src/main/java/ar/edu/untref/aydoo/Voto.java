package ar.edu.untref.aydoo;

public class Voto {

    private Candidato candidatoVotado;
    private Provincia provincia;

    public Voto(Candidato candidatoVotado, Provincia provincia) {
        this.candidatoVotado = candidatoVotado;
        this.provincia = provincia;
    }

    public Provincia getProvincia() {
        return this.provincia;
    }

    public Candidato getCandidato() {
        System.out.println(this.candidatoVotado);
        return this.candidatoVotado;
    }
}
