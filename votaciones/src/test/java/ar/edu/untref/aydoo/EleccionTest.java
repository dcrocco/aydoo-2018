package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EleccionTest {

    @Test
    public void obtenerCandidatoConMasVotosEnUnaProvincia(){

        Partido partidoDerecha = new Partido("Derecha");
        Partido partidoIzquierda = new Partido("Izquierda");
        Candidato candidatoJuan = new Candidato("Juan", partidoDerecha);
        Candidato candidatoCarlos = new Candidato("Carlos", partidoIzquierda);
        List<Candidato> listaDeCandidatos = new ArrayList<>();
        listaDeCandidatos.add(candidatoJuan);
        listaDeCandidatos.add(candidatoCarlos);

        Eleccion unaEleccion = new Eleccion(listaDeCandidatos);
        Provincia buenosAires = new Provincia("Buenos Aires");

        Voto votoDerecha1 = new Voto(candidatoJuan, buenosAires);
        Voto votoIzquierda1 = new Voto(candidatoCarlos, buenosAires);
        Voto votoDerecha2 = new Voto(candidatoJuan, buenosAires);

        unaEleccion.agregarVoto(votoDerecha1);
        unaEleccion.agregarVoto(votoIzquierda1);
        unaEleccion.agregarVoto(votoDerecha2);

        Assert.assertEquals(candidatoJuan, unaEleccion.obtenerCandidatoConMasVotosEnProvincia(buenosAires));
    }
}
