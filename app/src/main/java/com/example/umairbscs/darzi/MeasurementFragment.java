package com.example.umairbscs.darzi;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MeasurementFragment extends Fragment {

    private EditText Name, Phone, Address, Chest, Waist, Hips, Arms, Kurta, Shalwar, Sleeve, Neck, Discp;

    private Button btnsave;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_measurement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Name = (EditText) view.findViewById(R.id.edtname);
        Phone = (EditText) view.findViewById(R.id.edPhone);
        Address = (EditText) view.findViewById(R.id.edAddress);
        Chest = (EditText) view.findViewById(R.id.edchest);
        Waist = (EditText) view.findViewById(R.id.edwaist);
        Hips = (EditText) view.findViewById(R.id.edhips);
        Arms = (EditText) view.findViewById(R.id.edarm);
        Kurta = (EditText) view.findViewById(R.id.edkurta);
        Shalwar = (EditText) view.findViewById(R.id.etshalwar);
        Sleeve = (EditText) view.findViewById(R.id.etsleeve);
        Neck = (EditText) view.findViewById(R.id.edneck);
        Discp = (EditText) view.findViewById(R.id.etdescripton);
        btnsave = (Button) view.findViewById(R.id.btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Customers");

                String id = myRef.push().getKey();
                Customers customer = new Customers(id, String.valueOf(Name.getText()), String.valueOf(Phone.getText()), String.valueOf(Address.getText()), String.valueOf(Chest.getText()), String.valueOf(Waist.getText()), String.valueOf(Hips.getText()), String.valueOf(Arms.getText()), String.valueOf(Kurta.getText()), String.valueOf(Shalwar.getText()), String.valueOf(Sleeve.getText()), String.valueOf(Neck.getText()),String.valueOf(Discp.getText()));
                myRef.child(id).setValue(customer);
                Toast.makeText(getActivity(),"Your Data Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });


        /*Customers customer = new Customers();
        customer.setName(String.valueOf(Name.getText()));
        customer.setPhone(String.valueOf(Phone.getText()));*/

    }
}