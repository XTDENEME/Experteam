package com.example.ext0132016.navigationdrawervideotutorial;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;




/**
 * A simple {@link Fragment} subclass.
 */
public class CameraFragment extends Fragment {


    public CameraFragment() {
        // Required empty public constructor
    }

    //SQLiteDatabase db = null;

    EditText etEmail,etPassword,etOkul,etBolum,etSinif,etAciklama;
    RadioGroup rgradio;
    RadioButton rberkek,rbkadin;
    Button btnOK;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_camera, container, false);

        etEmail =(EditText)view.findViewById(R.id.etEmail);
        etPassword=(EditText)view.findViewById(R.id.etPassword);
        etOkul = (EditText)view.findViewById(R.id.etOkul)    ;
        etBolum = (EditText)view.findViewById(R.id.etBolum);
        etSinif = (EditText)view.findViewById(R.id.etSinif);
       // etCinsiyet= (EditText)view.findViewById(R.id.etCinsiyet);
        etAciklama = (EditText)view.findViewById(R.id.etAciklama);

        spinner = (Spinner)view.findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(CameraFragment.this.getActivity(),R.array.sinif,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(g(),parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        rgradio = (RadioGroup)view.findViewById(R.id.radioSex);
        rberkek = (RadioButton)view.findViewById(R.id.radioMale);
        rbkadin = (RadioButton)view.findViewById(R.id.radioFemale);


        btnOK = (Button)view.findViewById(R.id.btnOK);



        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtAd = etEmail.getText().toString();
                String txtSoyad = etPassword.getText().toString();
                String txtOkul = etOkul.getText().toString();
                String txBolum = etBolum.getText().toString();
                //String txSinif = etSinif.getText().toString();

                String txSinif = spinner.getSelectedItem().toString();

                //String txCinsiyet = etCinsiyet.getText().toString();

                int butonid = rgradio.getCheckedRadioButtonId();
                String txCinsiyet ="";
                if (butonid == R.id.radioMale) {
                    txCinsiyet = rberkek.getText().toString();
                } else if (butonid == R.id.radioFemale) {
                    txCinsiyet = rbkadin.getText().toString();
                }

                String txAciklama = etAciklama.getText().toString();
                //KayitEkle(txtKullanici,txtSifre);

               // if (etEmail.getText().toString().equals("erdal")&& etPassword.getText().toString().equals("erdal")){
                    Toast.makeText(CameraFragment.this.getActivity(),txtAd,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txtSoyad,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txtOkul,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txBolum,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txSinif,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txCinsiyet,Toast.LENGTH_SHORT).show();
                    Toast.makeText(CameraFragment.this.getActivity(),txAciklama,Toast.LENGTH_SHORT).show();

               // }
                //else{
                  //  Toast.makeText(CameraFragment.this.getActivity(),"Yanlış",Toast.LENGTH_SHORT).show();
                //}

                DBHandler db = new DBHandler(getActivity());

                db.addShop( txtAd,
                            txtSoyad,
                            txtOkul,
                            txBolum,
                            txSinif,
                            txCinsiyet,
                            txAciklama);

            }
        });

        return view;
    }

}
