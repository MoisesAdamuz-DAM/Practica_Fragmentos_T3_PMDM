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

import com.example.myavatar.Aceptar1;
import com.example.myavatar.R;

public class Dialogo3 extends DialogFragment {
    Aceptar1 mListener;
    RadioButton rEna;
    RadioButton rElf;
    RadioButton rHob;
    RadioButton rHom;
    String raza = " ";


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo3, null));

        View MyView = inflater.inflate(R.layout.dialogo3, null);
        //Guardamos el editText del diálogo
        rEna = MyView.findViewById(R.id.radioEnano);
        rElf= MyView.findViewById(R.id.radioElfo);
        rHob= MyView.findViewById(R.id.radioHobbit);
        rHom= MyView.findViewById(R.id.radioHombre);
//Construimos la vista, le insertamos el títuloo y le añadimos los botones
        builder.setView(MyView)
                .setTitle(R.string.titulo3)
                .setPositiveButton(R.string.btnAceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            if (rEna.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                raza = "Enano";
                                mListener.onDataSet3(raza);
                                mListener.abrirCuartoDialog();

                        }
                       else if (rElf.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                raza = "Elfo";
                                mListener.onDataSet3(raza);
                                mListener.abrirCuartoDialog();

                        } else if (rHob.isChecked()) {

                                //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                raza = "Hobbit";
                                mListener.onDataSet3(raza);
                                mListener.abrirCuartoDialog();

                        } else if (rHom.isChecked()) {
                                raza = "Hombre";
                                mListener.onDataSet3(raza);
                                mListener.abrirCuartoDialog();
                        } else {

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
