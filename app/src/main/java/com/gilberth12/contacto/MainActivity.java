package com.gilberth12.contacto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {// FragmentActivity implements
        //DatePickerDialog.OnDateSetListener{

    private TextInputEditText txtFechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            String nombreCompleto = parametros.getString(getResources().getString(R.string.pnombre));
            String fechaNacimiento = parametros.getString(getResources().getString(R.string.pfecha));
            String telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            String email = parametros.getString(getResources().getString(R.string.pemail));
            String descripcionContacto = parametros.getString(getResources().getString(R.string.pdescripcion));

            TextInputEditText txtNombreCompleto = (TextInputEditText) findViewById(R.id.txtNombreCompleto);
            TextInputEditText txtFechaNacimiento = (TextInputEditText) findViewById(R.id.txtFechaNacimiento);
            TextInputEditText txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
            TextInputEditText txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
            TextInputEditText txtDescripcion = (TextInputEditText) findViewById(R.id.txtDescripcionContacto);

            txtNombreCompleto.setText(nombreCompleto);
            txtFechaNacimiento.setText(fechaNacimiento);
            txtTelefono.setText(telefono);
            txtEmail.setText(email);
            txtDescripcion.setText(descripcionContacto);
        }
    }

    public void addListenerOnButton() {


        txtFechaNacimiento = (TextInputEditText) findViewById(R.id.txtFechaNacimiento);
        txtFechaNacimiento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int dia = c.get(Calendar.DAY_OF_MONTH);
                int mes = c.get(Calendar.MONTH);
                int ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        txtFechaNacimiento.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                }
                        ,dia, mes, ano);
                if (txtFechaNacimiento.getText().length() != 0){
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        cal.setTime(sdf.parse(txtFechaNacimiento.getText().toString()));// all done
                    }catch (ParseException ex) {

                    }
                    dia = cal.get(Calendar.DAY_OF_MONTH);
                    mes = cal.get(Calendar.MONTH);
                    ano = cal.get(Calendar.YEAR);
                }
                datePickerDialog.getDatePicker().updateDate(ano, mes, dia);
                datePickerDialog.show();

            }

        });

    }

    /** Called when the user clicks the Send button */
    public void enviarDatos(View view) {
        Intent intent = new Intent(this, ConfirmarDatos.class);
        TextInputEditText txtNombreCompleto = (TextInputEditText) findViewById(R.id.txtNombreCompleto);
        TextInputEditText txtFechaNacimiento = (TextInputEditText) findViewById(R.id.txtFechaNacimiento);
        TextInputEditText txtTelefono = (TextInputEditText) findViewById(R.id.txtTelefono);
        TextInputEditText txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        TextInputEditText txtDescripcionContacto = (TextInputEditText) findViewById(R.id.txtDescripcionContacto );
        intent.putExtra(getResources().getString(R.string.pnombre), txtNombreCompleto.getText().toString());
        intent.putExtra(getResources().getString(R.string.pfecha), txtFechaNacimiento.getText().toString());
        intent.putExtra(getResources().getString(R.string.ptelefono), txtTelefono.getText().toString());
        intent.putExtra(getResources().getString(R.string.pemail), txtEmail.getText().toString());
        intent.putExtra(getResources().getString(R.string.pdescripcion), txtDescripcionContacto.getText().toString());
        startActivity(intent);
    }

}
