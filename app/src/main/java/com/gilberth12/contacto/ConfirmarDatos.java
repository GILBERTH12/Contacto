package com.gilberth12.contacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();
        String nombreCompleto = parametros.getString(getResources().getString(R.string.pnombre));
        String fechaNacimiento = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcionContacto = parametros.getString(getResources().getString(R.string.pdescripcion));

        TextView tvNombreCompleto = (TextView) findViewById(R.id.tvNombreCompleto);
        TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        TextView tvEmail = (TextView) findViewById(R.id.tvEmail);
        TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        tvNombreCompleto.setText(nombreCompleto);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcionContacto);
    }

    /** Called when the user clicks the Send button */
    public void enviarDatos(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        Bundle parametros = getIntent().getExtras();
        String nombreCompleto = parametros.getString(getResources().getString(R.string.pnombre));
        String fechaNacimiento = parametros.getString(getResources().getString(R.string.pfecha));
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
        String email = parametros.getString(getResources().getString(R.string.pemail));
        String descripcionContacto = parametros.getString(getResources().getString(R.string.pdescripcion));

        intent.putExtra(getResources().getString(R.string.pnombre), nombreCompleto);
        intent.putExtra(getResources().getString(R.string.pfecha), fechaNacimiento);
        intent.putExtra(getResources().getString(R.string.ptelefono), telefono);
        intent.putExtra(getResources().getString(R.string.pemail), email);
        intent.putExtra(getResources().getString(R.string.pdescripcion), descripcionContacto);
        startActivity(intent);
    }
}
