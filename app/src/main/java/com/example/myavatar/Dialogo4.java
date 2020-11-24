package com.example.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo4 extends DialogFragment {
    Aceptar1 mListener;
    RadioButton rArq;
    RadioButton rGue;
    RadioButton rMag;
    RadioButton rHer;
    RadioButton rMin;
    String profesion = " ";


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo4, null));

        View MyView = inflater.inflate(R.layout.dialogo4, null);
        //Guardamos el editText del diálogo
        rArq = MyView.findViewById(R.id.radioArquero);
        rGue= MyView.findViewById(R.id.radioGuerrero);
        rMag= MyView.findViewById(R.id.radioMago);
        rHer= MyView.findViewById(R.id.radioHerrero);
        rMin= MyView.findViewById(R.id.radioMinero);
//Construimos la vista, le insertamos el títuloo y le añadimos los botones
        builder.setView(MyView)
                .setTitle(R.string.titulo4)
                .setPositiveButton(R.string.btnAceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            if (rArq.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                profesion = "Arquero";
                                mListener.onDataSet4(profesion);
                                mListener.randomVida();
                            }
                            else if (rGue.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                profesion = "Guerrero";
                                mListener.onDataSet4(profesion);
                                mListener.randomVida();

                            } else if (rMag.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                profesion = "Mago";
                                mListener.onDataSet4(profesion);
                                mListener.randomVida();

                            } else if (rHer.isChecked()) {
                                profesion = "Herrero";
                                mListener.onDataSet4(profesion);
                                mListener.randomVida();
                            }
                            else if (rMin.isChecked()) {
                                profesion = "Minero";
                                mListener.onDataSet4(profesion);
                                mListener.randomVida();

                            }
                            else {
                                mListener.onDialogoSeleccion();
                            }
                        }
                        catch(Exception e)
                        {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(R.string.btnCancelar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Esto es para cerrar texto
                        dialog.dismiss();
                        mListener.onDialogoCancelar();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try{
            mListener = (Aceptar1) context;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(context.toString()+ " debe implementar OnNuevoDialogListener");
        }
    }
}
