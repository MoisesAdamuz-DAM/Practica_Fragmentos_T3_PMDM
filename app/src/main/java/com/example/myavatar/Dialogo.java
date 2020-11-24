package com.example.myavatar;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {
   Aceptar1 mListener;
   EditText nombre;


    @Override

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialogo1, null));

        View MyView = inflater.inflate(R.layout.dialogo1, null);
        //Guardamos el editText del diálogo
        nombre = MyView.findViewById(R.id.textDialog);
//Construimos la vista, le insertamos el títuloo y le añadimos los botones
builder.setView(MyView)
        .setTitle(R.string.titulo1)
                .setPositiveButton(R.string.btnAceptar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                           if(!nombre.getText().toString().equals(""))
                           {
                               try {
                                   //Llamamos al método onDataSet de la interfaz Aceptar1 = mListener
                                   mListener.onDataSet(nombre.getText().toString());
                                   //Abrimos el segundo diálogo
                                   mListener.abrirSecondDialog();

                               } catch (Exception e) {
                                   Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                               }
                           }
                               else
                           {
                               mListener.onDialogoAceptar();
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

