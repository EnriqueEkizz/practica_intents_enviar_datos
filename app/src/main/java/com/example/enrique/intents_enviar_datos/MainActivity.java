package com.example.enrique.intents_enviar_datos;

import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Controles
    public ArrayList<String> listaMenu;
    CheckBox chkMenu1;
    CheckBox chkMenu2;
    CheckBox chkMenu3;
    CheckBox chkMenu4;
    CheckBox chkMenu5;
    CheckBox chkMenu6;
    CheckBox chkMenu7;
    CheckBox chkMenu8;
    CheckBox chkMenu9;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear checks menu
        chkMenu1 = findViewById(R.id.chkMenu1);
        chkMenu2 = findViewById(R.id.chkMenu2);
        chkMenu3 = findViewById(R.id.chkMenu3);
        chkMenu4 = findViewById(R.id.chkMenu4);
        chkMenu5 = findViewById(R.id.chkMenu5);
        chkMenu6 = findViewById(R.id.chkMenu6);
        chkMenu7 = findViewById(R.id.chkMenu7);
        chkMenu8 = findViewById(R.id.chkMenu8);
        chkMenu9 = findViewById(R.id.chkMenu9);

        //Creando boton enviar
        btnEnviar = findViewById(R.id.btn_enviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Inicializar Arraylist listaMenu
                listaMenu = new ArrayList<>();

                clsEditarLista editarLista = new clsEditarLista();
                editarLista.editMenu(chkMenu1);
                editarLista.editMenu(chkMenu2);
                editarLista.editMenu(chkMenu3);
                editarLista.editMenu(chkMenu4);
                editarLista.editMenu(chkMenu5);
                editarLista.editMenu(chkMenu6);
                editarLista.editMenu(chkMenu7);
                editarLista.editMenu(chkMenu8);
                editarLista.editMenu(chkMenu9);

                //Verificar si tamaño de lista es mayor a 0
                if (listaMenu.size() > 0) {
                    Intent intent = new Intent();
                    ComponentName cName = new ComponentName("com.example.enrique.intents_recibir_datos","com.example.enrique.intents_recibir_datos.MainActivity");
                    intent.setComponent(cName);
                    intent.putExtra("listaMenu",listaMenu);
                    startActivity(intent);
                }
            }
        });
    }

    /*clase que permite recibir un checkbox y editar la lista de menu
    según es el estado del check*/
    private class clsEditarLista {
        private void editMenu(CheckBox xCheckbox) {
            int ind;
            String txt = xCheckbox.getText().toString();

            if (xCheckbox.isChecked()) {
                listaMenu.add(txt);
            } else {
                ind = listaMenu.indexOf(txt);
                if (ind > -1) {
                    listaMenu.remove(ind);
                }
            }
        }
    }

}
