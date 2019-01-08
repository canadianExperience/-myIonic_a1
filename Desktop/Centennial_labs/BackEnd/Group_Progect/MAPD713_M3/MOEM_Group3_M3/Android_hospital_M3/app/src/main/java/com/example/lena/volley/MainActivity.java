package com.example.lena.volley;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    String JsonURL = "https://elena-mohsena-group-project.herokuapp.com/patients";
    String data = "";
    ListView myList;
    RequestQueue requestQueue;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = this;

        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

       // results = (TextView) findViewById(R.id.textView);
        myList = (ListView) findViewById(R.id.listv);

        StableArrayAdapter myAdapter;
        JsonArrayRequest arrayRequest = new JsonArrayRequest(JsonURL,
                new Response.Listener<JSONArray>(){

                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<Patient> myArrayList = new ArrayList<>();
                        try {
                            for(int i=0; i<response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);
                                String firstName = obj.getString("firstName");
                                String lastName = obj.getString("lastName");
                                String dateOfBirth = obj.getString("dateOfBirth");
                                String gender = obj.getString("gender");
                                String address = obj.getString("address");
                                String city = obj.getString("city");
                                String province = obj.getString("province");
                                String postalCode = obj.getString("postalCode");
                                String doctor = obj.getString("doctor");
                                String _id = obj.getString("_id");

                                Patient patient = new Patient(firstName, lastName, dateOfBirth,
                                        gender, address, city, province, postalCode, doctor, _id);
                                myArrayList.add(patient);
                            }

                            Patient[] patientsArray = myArrayList.toArray(new Patient[myArrayList.size()]);
                            //Initialize adapter
                            StableArrayAdapter myAdapter = new StableArrayAdapter(ctx, patientsArray);

                            
                            myList.setAdapter(myAdapter);
                            myAdapter.notifyDataSetChanged();
                        } catch (JSONException e){
                            Log.e(TAG, "Getting shape name", e);
                        }
                    }
                },
                new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage(), error);
                    }
                }
        );

        requestQueue.add(arrayRequest);
    }

    //Internal adapter class
    private class StableArrayAdapter extends ArrayAdapter<Patient> {
        private final Context context;
        private final Patient[] patients;

        //Constructor
        public StableArrayAdapter(Context context, Patient[] values) {
            super(context, R.layout.row_layout, values);
            this.context = context;
            this.patients = values;
        }
        //GetView method
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_layout, parent, false);
            //Find layout controls by id
            TextView firstName = rowView.findViewById(R.id.firstName_);
            TextView lastName = rowView.findViewById(R.id.lastName_);
            TextView dateOfBirth = rowView.findViewById(R.id.dateOfBirth_);
            TextView gender = rowView.findViewById(R.id.gender_);
            TextView address = rowView.findViewById(R.id.address_);
            TextView city = rowView.findViewById(R.id.city_);
            TextView province = rowView.findViewById(R.id.province_);
            TextView postalCode = rowView.findViewById(R.id.postalCode_);
            TextView doctor = rowView.findViewById(R.id.doctor_);
            TextView _id = rowView.findViewById(R.id._id_);

            //Initialize controls
           firstName.setText(patients[position].getFirstName());
           lastName.setText(patients[position].getLastName());
           dateOfBirth.setText(patients[position].getDateOfBirth());
           gender.setText(patients[position].getGender());
           address.setText(patients[position].getAddress());
           city.setText(patients[position].getCity());
           province.setText(patients[position].getProvince());
           postalCode.setText(patients[position].getPostalCode());
           doctor.setText(patients[position].getDoctor());
           _id.setText(patients[position].get_id());

            //Return rowView
            return rowView;
        }
    }
}