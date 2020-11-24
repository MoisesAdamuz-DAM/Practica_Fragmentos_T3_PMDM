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

public class Dialogo2 extends DialogFragment {
    Aceptar1 mListener;
    RadioButton rH;
    RadioButton rM;
    String gender = "";


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo2, null));

        View MyView = inflater.inflate(R.layout.dialogo2, null);
        //Guardamos el editText del diálogo
        rH = MyView.findViewById(R.id.radioButton);
        rM = MyView.findViewById(R.id.radioButton2);
//Construimos la vista, le insertamos el títuloo y le añadimos los botones
        builder.setView(MyView)
                .setTitle(R.string.titulo2)
                .setPositiveButton(R.string.btnAceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        if (rH.isChecked()) {
                            try {
                                gender = "Hombre";
                                mListener.onDataSet2(gender);
                                mListener.abrirThirdDialog();

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            try {
                                gender = "Mujer";
                                mListener.onDataSet2(gender);
                                mListener.abrirThirdDialog();

                            } catch (Exception e) {
                                Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
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