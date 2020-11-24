package com.example.myavatar;

public interface Aceptar1 {

    public void onDialogoAceptar();
    public void onDialogoCancelar();
    public void onDialogoSeleccion();

    //Capturar Información
    public void onDataSet(String nombre);
    public void onDataSet2(String sexo);
    public void onDataSet3(String raza);
    public void onDataSet4(String profesion);

    //Métodos para abrir diálogos
    public void abrirSecondDialog();
    public void abrirThirdDialog();
    public void abrirCuartoDialog();

    //Random
    public void randomVida();




}
