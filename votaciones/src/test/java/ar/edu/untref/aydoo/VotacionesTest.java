package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class VotacionesTest {

    @Test
    public void obtenerCandidatoConMasVotosEnUnaProvincia(){

        Partido partidoDerecha = new Partido("Derecha");
        Partido partidoIzquierda = new Partido("Izquierda");
        Candidato candidatoJuan = new Candidato("Juan", partidoDerecha);
        Candidato candidatoCarlos = new Candidato("Carlos", partidoIzquierda);
        List<Canidato> listaDeCandidatos = new ArrayList<Candidato>();
        Eleccion unaEleccion = new Eleccion(listaDeCandidatos);

        Voto votoDerecha1 = new Voto(candidatoJuan);
        Voto votoIzquierda1 = new Voto(candidatoCarlos);
        Voto votoDerecha2 = new Voto(candidatoJuan);

        provincia buenosAires = new Provincia("Buenos Aires");

        unaEleccion.agregarVoto(votoDerecha1, buenosAires);
        unaEleccion.agregarVoto(votoIzquierda1, buenosAires);
        unaEleccion.agregarVoto(votoDerecha2, buenosAires);

        Assert.assertEquals(candidatoJuan, unaEleccion.obtenerCandidatoConMasVotosEnProvincia(buenosAires));

    }
}
