package com.example.myavatar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,Aceptar1 {
Button button;
Dialogo dialogo;
Dialogo2 dialogo2;
Dialogo3 dialogo3;
Dialogo4 dialogo4;
EditText txt1;
EditText txtName;
EditText txtGen;
ImageView imgEsp;
ImageView imgPro;

TextView txtP;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btnCrear);
        button.setOnClickListener(this);

        txt1 = findViewById(R.id.textDialog);
        txtName = findViewById(R.id.textNombre);
        txtGen = findViewById(R.id.txtSex);

        txtP = findViewById(R.id.textNombre);


        imgEsp = findViewById(R.id.imgEspecie);
        imgEsp.setImageResource(R.drawable.ic_usuario);
        imgPro = findViewById(R.id.imgProfesion);
        imgPro.setImageResource(R.drawable.ic_informacion);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == (R.id.btnCrear))
        {
            //Abrir Dialog1
            dialogo = new Dialogo();
            dialogo.setCancelable(false);
            dialogo.show(getSupportFragmentManager(), "Nuevo Diálogo");
        }

    }

    @Override
    public void onDialogoAceptar() {

        Toast.makeText(this, "Instroduzca Nombre", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogoCancelar() {
        Toast.makeText(this, "Cancelado", Toast.LENGTH_SHORT).show();
    }

    public void onDialogoSeleccion()
    {
        Toast.makeText(this, "Elija una opcion", Toast.LENGTH_SHORT).show();
    }

    //Insertar nombre
    @Override
    public void onDataSet(String nombre) {

        Toast.makeText(this, "Nombre "+ nombre, Toast.LENGTH_SHORT).show();
        txtP.setText(nombre);


    }

    @Override
    public void onDataSet2(String sexo)
    {
        txtGen.setText(sexo);
    }
    public void onDataSet3(String raza) {
        if (txtGen.getText().toString().equals("Hombre"))

        {
            Toast.makeText(this, raza, Toast.LENGTH_SHORT).show();
            if (raza.equals("Enano")) {
                imgEsp.setImageResource(R.drawable.ic_gnomo);
            }
            else if (raza.equals("Elfo")) {
                imgEsp.setImageResource(R.drawable.ic_elfo);
            }
            else if (raza.equals("Hobbit")) {
                imgEsp.setImageResource(R.drawable.hobbit);
            }
        }
        else
        {
            if (raza.equals("Elfo")) {
                imgEsp.setImageResource(R.drawable.ic_elfa);
            }
        }
    }



    //Abrir Dialog2
    public void abrirSecondDialog()
    {
        dialogo2 = new Dialogo2();
        dialogo2.setCancelable(false);
        dialogo2.show(getSupportFragmentManager(), "Segundo Diálogo");
    }
    //Abrir Dialog3
    public void abrirThirdDialog()
    {
        dialogo3 = new Dialogo3();
        dialogo3.setCancelable(false);
        dialogo3.show(getSupportFragmentManager(), "Tercer Diálogo");
    }
    //Abrir Dialog4
    public void abrirCuartoDialog()
    {
        dialogo4 = new Dialogo4();
        dialogo4.setCancelable(false);
        dialogo4.show(getSupportFragmentManager(), "Cuarto Diálogo");
    }

    public void selectionBoton(String gen)
    {
      txtGen.setText(gen);

    }


}