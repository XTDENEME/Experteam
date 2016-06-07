package com.example.ext0132016.navigationdrawervideotutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;



import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {
    private final String TAG = this.getClass().getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etCinsiyet,etYas,etDepartman,etUnvan,etYil,etSosyal,etBonus,etFaaliyet;
    Button  btnArsivGonder;
    RadioGroup rgradio;
    RadioButton rberkek,rbkadin;
    CheckBox  cbSosyal1,cbSosyal2,cbSosyal3,cbBonus1,cbBonus2,cbBonus3,cbBonus4;

    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    ArrayAdapter<CharSequence> adapter;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;





    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        //etCinsiyet = (EditText)view.findViewById(R.id.etCinsiyet);
        //etYas= (EditText)view.findViewById(R.id.etYas);
        //etDepartman=(EditText)view.findViewById(R.id.etDepartman);
        // etUnvan=(EditText)view.findViewById(R.id.etUnvan);
        etYil=(EditText)view.findViewById(R.id.etYil);
        cbSosyal1 =(CheckBox)view.findViewById(R.id.checkBox);
        cbSosyal2 =(CheckBox)view.findViewById(R.id.checkBox1);
        cbSosyal3 =(CheckBox)view.findViewById(R.id.checkBox2);
        cbBonus1 =(CheckBox)view.findViewById(R.id.checkBox4);
        cbBonus2 =(CheckBox)view.findViewById(R.id.checkBox5);
        cbBonus3 =(CheckBox)view.findViewById(R.id.checkBox6);
        String etBonus ="xx"; //= (EditText)view.findViewById(R.id.etBonus);
        String etFaaliyet = "xx";//(EditText)view.findViewById(R.id.etBonus);

        rgradio = (RadioGroup)view.findViewById(R.id.radioSex);
        rberkek = (RadioButton)view.findViewById(R.id.radioMale);
        rbkadin = (RadioButton)view.findViewById(R.id.radioFemale);
        btnArsivGonder =(Button)view.findViewById(R.id.btnAnket);

        spinner = (Spinner)view.findViewById(R.id.spinner2);
        adapter = ArrayAdapter.createFromResource(GalleryFragment.this.getActivity(),R.array.yasGrubu,android.R.layout.simple_spinner_item);
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

        spinner2 = (Spinner)view.findViewById(R.id.spinner3);
        adapter2 = ArrayAdapter.createFromResource(GalleryFragment.this.getActivity(),R.array.departman,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(g(),parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3 = (Spinner)view.findViewById(R.id.spinner4);
        adapter3 = ArrayAdapter.createFromResource(GalleryFragment.this.getActivity(),R.array.Unvan,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Toast.makeText(g(),parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnArsivGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //String txtCinsiyet = etCinsiyet.getText().toString();
                int butonid = rgradio.getCheckedRadioButtonId();
                String txCinsiyet ="";
                if (butonid == R.id.radioMale) {
                    txCinsiyet = rberkek.getText().toString();
                } else if (butonid == R.id.radioFemale) {
                    txCinsiyet = rbkadin.getText().toString();
                }
                String txtYas = spinner.getSelectedItem().toString();
                String txtDepartman = spinner2.getSelectedItem().toString();
                String txtUnvan = spinner3.getSelectedItem().toString();//etUnvan.getText().toString();

                String txtYil = etYil.getText().toString();

                String txtSosyal ="";
                if (cbSosyal1.isChecked())
                {txtSosyal = txtSosyal + cbSosyal1.getText().toString(); //etEmail.getText().toString();
                }

                if (cbSosyal2.isChecked())
                {txtSosyal = txtSosyal + cbSosyal2.getText().toString();;
                }

                if (cbSosyal3.isChecked())
                {txtSosyal = txtSosyal + cbSosyal3.getText().toString();;
                }


                String txtBonus = "";
                if (cbBonus1.isChecked())
                {txtBonus = txtSosyal + cbBonus1.getText().toString();;
                }
                if (cbBonus2.isChecked())
                {txtBonus = txtSosyal + cbBonus2.getText().toString();;
                }
                if (cbBonus1.isChecked())
                {txtBonus = txtSosyal + cbBonus3.getText().toString();;
                }


                String txtFaaliyet = "xx";//etFaaliyet.getText().toString();


                Toast.makeText(GalleryFragment.this.getActivity(),txCinsiyet,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtYas,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtDepartman,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtUnvan,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtYil,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtSosyal,Toast.LENGTH_SHORT).show();
                Toast.makeText(GalleryFragment.this.getActivity(),txtBonus,Toast.LENGTH_SHORT).show();


                DBHandler db = new DBHandler(getActivity());

                db.addAnket(txCinsiyet,txtYas,txtDepartman,txtUnvan,txtYil,txtFaaliyet,txtSosyal,txtBonus);
            }
        });



        return view;

    }

}
