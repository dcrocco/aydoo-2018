package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EleccionTest {

    private Partido partidoDerecha;
    private Partido partidoIzquierda;
    private Candidato candidatoDerecha;
    private Candidato candidatoIzquierda;
    private List<Candidato> listaDeCandidatos;
    private Eleccion unaEleccion;
    private Provincia provinciaBuenosAires;
    private Provincia provinciaSanLuis;

    @Before
    public void crearInstanciasDeEleccion(){
        this.partidoDerecha = new Partido("Derecha");
        this.partidoIzquierda = new Partido("Izquierda");
        this.candidatoDerecha = new Candidato("Juan", this.partidoDerecha);
        this.candidatoIzquierda = new Candidato("Carlos", this.partidoIzquierda);
        this.listaDeCandidatos = new ArrayList<>();
        this.listaDeCandidatos.add(candidatoDerecha);
        this.listaDeCandidatos.add(candidatoIzquierda);
        this.provinciaBuenosAires = new Provincia("Buenos Aires");
        this.provinciaSanLuis = new Provincia("San Luis");
        this.unaEleccion = new Eleccion(this.listaDeCandidatos);
    }

    @Test
    public void obtenerCandidatoConMasVotosEnUnaProvincia() throws VotoInvalidoException {
        Voto votoDerecha1 = new Voto(this.candidatoDerecha, this.provinciaBuenosAires);
        Voto votoIzquierda1 = new Voto(this.candidatoIzquierda, this.provinciaBuenosAires);
        Voto votoDerecha2 = new Voto(this.candidatoDerecha, this.provinciaBuenosAires);

        this.unaEleccion.agregarVoto(votoDerecha1);
        this.unaEleccion.agregarVoto(votoIzquierda1);
        this.unaEleccion.agregarVoto(votoDerecha2);

        Assert.assertEquals(this.candidatoDerecha, unaEleccion.obtenerCandidatoConMasVotosEnProvincia(this.provinciaBuenosAires));
    }

    @Test
    public void obtenerCandidatoConMasVotosANivelNacional() throws VotoInvalidoException {

        Voto votoDerecha1 = new Voto(this.candidatoDerecha, this.provinciaBuenosAires);
        Voto votoIzquierda1 = new Voto(this.candidatoIzquierda, this.provinciaBuenosAires);
        Voto votoIzquierda2 = new Voto(this.candidatoIzquierda, this.provinciaBuenosAires);

        this.unaEleccion.agregarVoto(votoDerecha1);
        this.unaEleccion.agregarVoto(votoIzquierda1);
        this.unaEleccion.agregarVoto(votoIzquierda2);

        Assert.assertEquals(candidatoIzquierda, unaEleccion.obtenerCandidatoConMasVotosNacional());
    }

    @Test
    public void obtenerCandidatoConMasVotosANivelNacionalConDistintoEnProvincia() throws VotoInvalidoException {

        Voto votoDerecha1 = new Voto(this.candidatoDerecha, this.provinciaBuenosAires);
        Voto votoDerecha2 = new Voto(this.candidatoDerecha, this.provinciaSanLuis);
        Voto votoDerecha3 = new Voto(this.candidatoDerecha, this.provinciaSanLuis);
        Voto votoIzquierda1 = new Voto(this.candidatoIzquierda, this.provinciaBuenosAires);
        Voto votoIzquierda2 = new Voto(this.candidatoIzquierda, this.provinciaBuenosAires);

        this.unaEleccion.agregarVoto(votoDerecha1);
        this.unaEleccion.agregarVoto(votoDerecha2);
        this.unaEleccion.agregarVoto(votoDerecha3);
        this.unaEleccion.agregarVoto(votoIzquierda1);
        this.unaEleccion.agregarVoto(votoIzquierda2);

        Assert.assertEquals(candidatoDerecha, unaEleccion.obtenerCandidatoConMasVotosNacional());
    }

    @Test(expected = VotoInvalidoException.class)
    public void agregarVotoAEleccionDeUnCandidatoQueNoSeEnecuentraEnLaMisma() throws VotoInvalidoException {

        Partido partidoInexistente = new Partido("Inexistente");
        Candidato candidatoInexistente = new Candidato("Inexistente", partidoInexistente);
        Voto votoInvalido = new Voto(candidatoInexistente, this.provinciaBuenosAires);
        this.unaEleccion.agregarVoto(votoInvalido);
    }
}
