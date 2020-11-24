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

EditText txtVida;
EditText txtFuerza;
EditText txtMagia;
EditText txtVelocidad;

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

        txtVida = findViewById(R.id.textVida);
        txtFuerza = findViewById(R.id.textFuerza);
        txtMagia = findViewById(R.id.textMagia);
        txtVelocidad = findViewById(R.id.textVelocidad);

        txtP = findViewById(R.id.textNombre);

        //Hacemos visible los imageView
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
        //Insertamos la cadena obtenida en el diálogo 1
        txtP.setText(nombre);
    }
    @Override
    public void onDataSet2(String sexo)
    {
        //Insertamos la cadena obtenida en el diálogo 2
        txtGen.setText(sexo);
    }
    public void onDataSet3(String raza) {
        //Obtenemos la cadena generado en el texto de género
        //En el caso de que el texto obtenido sea igual a Hombre pasará lo siguiente
        if (txtGen.getText().toString().equals("Hombre"))
        {
            if (raza.equals("Enano")) {
                imgEsp.setImageResource(R.drawable.ic_gnomo);
            }
            else if (raza.equals("Elfo")) {
                imgEsp.setImageResource(R.drawable.ic_elfo);
            }
            else if (raza.equals("Hobbit")) {
                imgEsp.setImageResource(R.drawable.ic_hobbit);
            }
            else if (raza.equals("Hombre")) {
                imgEsp.setImageResource(R.drawable.ic_guerrero);
            }
        }
        else
        {
            if (raza.equals("Elfo")) {
                imgEsp.setImageResource(R.drawable.ic_elfa);
            }
            else if (raza.equals("Enano")) {
                imgEsp.setImageResource(R.drawable.ic_opera);
            }
            else if (raza.equals("Hobbit")) {
                imgEsp.setImageResource(R.drawable.ic_mujer);
            }
            else if (raza.equals("Hombre")) {
                imgEsp.setImageResource(R.drawable.ic_mujer2);
            }
        }
    }
    public void onDataSet4(String profesion)
    {
        if (profesion.equals("Arquero")) {
            imgPro.setImageResource(R.drawable.ic_arquero__2_);
        }
        else if (profesion.equals("Guerrero")) {
            imgPro.setImageResource(R.drawable.ic_batalla);
        }
        else if (profesion.equals("Mago")) {
            imgPro.setImageResource(R.drawable.ic_mago);
        }
        else if (profesion.equals("Minero")) {
            imgPro.setImageResource(R.drawable.ic_minero);
        }
        else if (profesion.equals("Herrero")) {
            imgPro.setImageResource(R.drawable.ic_herrero);
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

    public void randomVida()
    {
        int vi = (int) (Math.random()*100);
        txtVida.setText(String.valueOf(vi));
        int ma = (int) (Math.random()*10);
        txtMagia.setText(String.valueOf(ma));
        int fu = (int) (Math.random()*20);
        txtFuerza.setText(String.valueOf(fu));
        int ve = (int) (Math.random()*5);
        txtVelocidad.setText(String.valueOf(ve));

    }

}