package com.example.umairbscs.darzi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Customers> data ;
    private Context mContext;
    AlertDialog alertDialog;
    AlertDialog alertDialog1;
    String c_id;
    DatabaseReference databaseReference;

    public MyAdapter(Context mContext, ArrayList<Customers> data){
        this.mContext = mContext;
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.list_view_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myvieholder, final int i) {
        myvieholder.Name.setText(data.get(i).getName());
        myvieholder.Phone.setText(data.get(i).getPhone());

        myvieholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customers customers = data.get(i);
                c_id = customers.getId();
                databaseReference = FirebaseDatabase.getInstance().getReference("Customers").child(c_id);
                showUpdateDialog(customers.getName(), customers.getPhone(), customers.getAddress(), customers.getChest(), customers.getWaist(), customers.getHips(), customers.getArms(), customers.getKurta(), customers.getShalwar(), customers.getSleeve(), customers.getNeck(), customers.getDiscp());
            }
        });
        myvieholder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Customers customers = data.get(i);
                c_id = customers.getId();
                databaseReference = FirebaseDatabase.getInstance().getReference("Customers").child(c_id);
                showDeleteDialog();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name;
        TextView Phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = (TextView) itemView.findViewById(R.id.inputname);
            Phone = (TextView) itemView.findViewById(R.id.inputphone);
        }
    }

    public void setFilter(ArrayList<Customers> newList){
        data = new ArrayList<>();
        data.addAll(newList);
        notifyDataSetChanged();
    }

    private void showUpdateDialog( String name, String phone, String address, String chest, String waist, String hips, String arms, String kurta, String shalwar, String sleeve, String neck, String discp){

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        final View dialogView = inflater.inflate(R.layout.update_dialog, null);
        dialogBuilder.setView(dialogView);

        Log.d("Dialog", String.valueOf(dialogBuilder));

        final EditText editTextName = (EditText) dialogView.findViewById(R.id.edtname);
        final EditText editTextPhone = (EditText) dialogView.findViewById(R.id.edPhone);
        final EditText editTextAddress = (EditText) dialogView.findViewById(R.id.edAddress);
        final EditText editTextChest = (EditText) dialogView.findViewById(R.id.edchest);
        final EditText editTextWaist = (EditText) dialogView.findViewById(R.id.edwaist);
        final EditText editTextHips = (EditText) dialogView.findViewById(R.id.edhips);
        final EditText editTextArms = (EditText) dialogView.findViewById(R.id.edarm);
        final EditText editTextKurta = (EditText) dialogView.findViewById(R.id.edkurta);
        final EditText editTextShalwar = (EditText) dialogView.findViewById(R.id.etshalwar);
        final EditText editTextSleeve = (EditText) dialogView.findViewById(R.id.etsleeve);
        final EditText editTextNeck = (EditText) dialogView.findViewById(R.id.edneck);
        final EditText editTextDiscp = (EditText) dialogView.findViewById(R.id.etdescripton);
        final Button btnupdate = (Button) dialogView.findViewById(R.id.btnupdate);


        editTextName.setText(name);
        editTextName.setEnabled(false);
        editTextPhone.setText(phone);
        editTextPhone.setEnabled(false);
        editTextAddress.setText(address);
        editTextAddress.setEnabled(false);
        editTextChest.setText(chest);
        editTextWaist.setText(waist);
        editTextHips.setText(hips);
        editTextArms.setText(arms);
        editTextKurta.setText(kurta);
        editTextShalwar.setText(shalwar);
        editTextSleeve.setText(sleeve);
        editTextNeck.setText(neck);
        editTextDiscp.setText(discp);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateCustomer(String.valueOf(editTextName.getText()), String.valueOf(editTextPhone.getText()), String.valueOf(editTextAddress.getText()),String.valueOf(editTextChest.getText()), String.valueOf(editTextWaist.getText()), String.valueOf(editTextHips.getText()), String.valueOf(editTextArms.getText()), String.valueOf(editTextKurta.getText()), String.valueOf(editTextShalwar.getText()), String.valueOf(editTextSleeve.getText()), String.valueOf(editTextNeck.getText()),String.valueOf(editTextDiscp.getText()));
                notifyDataSetChanged();
                alertDialog.dismiss();

            }
        });

        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void updateCustomer(String name, String phone, String address, String chest, String waist, String hips, String arms, String kurta, String shalwar, String sleeve, String neck, String discp){
        Customers customers = new Customers(c_id, name, phone, address, chest, waist, hips, arms, kurta, shalwar, sleeve, neck, discp);
        databaseReference.setValue(customers);

        Toast.makeText(mContext,"Customers Data Updated Sucessfully", Toast.LENGTH_LONG).show();
    }

    private void showDeleteDialog(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mContext);

        LayoutInflater inflater = LayoutInflater.from(mContext);

        final View dialogView = inflater.inflate(R.layout.delete_dialog, null);
        dialogBuilder.setView(dialogView);

        final Button btnyes = (Button) dialogView.findViewById(R.id.btnyes);
        final Button btnno = (Button) dialogView.findViewById(R.id.btnno);

        btnyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Toast.makeText(mContext,c_id, Toast.LENGTH_LONG).show();
                databaseReference.removeValue();
                alertDialog1.dismiss();
                notifyDataSetChanged();
            }
        });

        btnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = dialogBuilder.create();
        alertDialog1.show();
    }
}


