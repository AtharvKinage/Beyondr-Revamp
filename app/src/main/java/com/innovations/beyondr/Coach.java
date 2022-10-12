package com.innovations.beyondr;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.innovations.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Doctors#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Coach extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View root;
    ArrayList<Time> array = new ArrayList();

    CardView card1, card2, card3;

    private Spinner spinner;
    private static final String[] paths = {"Specialization",
            "Urology",
            "Dentist",
            "Allergy and immunology",
            "Anesthesiology",
            "Dermatology",
            "Diagnostic radiology",
            "Emergency medicine",
            "Family medicine",
            "Internal medicine",
            "Medical genetics",
            "Neurology",
            "Nuclear medicine",
            "Obstetrics and gynecology",
            "Ophthalmology",
            "Pathology",
            "Pediatrics",
            "Physical medicine and rehabilitation",
            "Preventive medicine",
            "Psychiatry",
            "Radiation oncology",
            "Surgery"};

    public Coach() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Doctors.
     */
    // TODO: Rename and change types and number of parameters
    public static Doctors newInstance(String param1, String param2) {
        Doctors fragment = new Doctors();
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
        root = inflater.inflate(R.layout.fragment_coach, container, false);

        card1 = root.findViewById(R.id.card1);
        card2 = root.findViewById(R.id.card2);
        card3 = root.findViewById(R.id.card3);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);

        spinner = (Spinner) root.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        setrecyclerviewfordates();

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh");
        String test = sdf.format(cal.getTime()) + ":00";

        diffCalc(test, "11:00", 60);

        return root;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void setrecyclerviewfordates() {

        LocalDate today = LocalDate.now();
        LocalDate firstDayOfTheMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDayOfTheMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        LocalDate squareCalendarMonthDayStart = today;
        LocalDate squareCalendarMonthDayEnd = today.plusDays(29);
        ArrayList<Model> totalDates = new ArrayList<>();
        while (!squareCalendarMonthDayStart.isAfter(squareCalendarMonthDayEnd)) {
            ZoneId defaultZoneId = ZoneId.systemDefault();
            Model model = new Model(Date.from(squareCalendarMonthDayStart.atStartOfDay(defaultZoneId).toInstant()), false);
            totalDates.add(model);
            squareCalendarMonthDayStart = squareCalendarMonthDayStart.plusDays(1);
        }

        RecyclerView recyclerView = root.findViewById(R.id.dates);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        CalendatDatesRecyclerAdapter calendatDatesRecyclerAdapter = new CalendatDatesRecyclerAdapter(totalDates, getContext());
        recyclerView.setAdapter(calendatDatesRecyclerAdapter);

    }

    public Calendar addHr(String startTime, int minutes) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d;

        Calendar gc = null ;
        try {
            d = df.parse(startTime);

            gc = new GregorianCalendar();
            gc.setTime(d);
            gc.add(Calendar.MINUTE, minutes);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return gc;
    }

    public void diffCalc(String time1, String time2, int minutes) {
        long diff=0;
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date1 = null;
        try {
            date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            diff = date2.getTime() - date1.getTime();
            Date date3 ;
            String string = time1;
            while(true)
            {
                Calendar gc = addHr(string, minutes) ;

                date3 = gc.getTime();
                string = getHrMin(gc.get(Calendar.HOUR_OF_DAY))+":"+getHrMin(gc.get(Calendar.MINUTE)) + " - " + getHrMin(gc.get(Calendar.HOUR_OF_DAY) + 1)+":"+getHrMin(gc.get(Calendar.MINUTE));
                if(date2.getTime()-date3.getTime()>=0)
                {
                    System.out.println("diff Hours :: "+string);
                    com.innovations.beyondr.Time time = new com.innovations.beyondr.Time(string, false);
                    array.add(time);
                }
                else
                {
                    break;
                }
            }

            RecyclerView recyclerView = root.findViewById(R.id.time);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setHasFixedSize(true);
            TimeAdapter timeAdapter = new TimeAdapter(array, getContext());
            recyclerView.setAdapter(timeAdapter);

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Difference in Houres:"+getDate(diff));
    }

    private String getDate(long diff) {
        long hours=diff/(60*60*1000);
        long minutes=(diff%(60*60*1000))/(60*1000);

        long sec=((diff%(60*60*1000))%(60*1000))/1000;
        String formateddate="";
        if(hours<10)
        {
            formateddate="0"+hours;
        }else{
            formateddate=""+hours;
        }
        if(minutes<10)
        {
            formateddate=formateddate+":0"+minutes;
        }else{
            formateddate=formateddate+":"+minutes;
        }
        if(sec<10)
        {
            formateddate=formateddate+":0"+sec;
        }else{
            formateddate=formateddate+":"+sec;
        }

        return formateddate;
    }

    private String getHrMin(int time) {
        String formatedTime;
        if(time<10)
        {
            formatedTime="0"+time;
        }else{
            formatedTime=""+time;
        }
        return formatedTime;
    }

    @Override
    public void onClick(View view) {
        if(view == card1){
            card1.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            card2.setCardBackgroundColor(getResources().getColor(R.color.white));
            card3.setCardBackgroundColor(getResources().getColor(R.color.white));
        }

        if(view == card2){
            card1.setCardBackgroundColor(getResources().getColor(R.color.white));
            card2.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            card3.setCardBackgroundColor(getResources().getColor(R.color.white));
        }

        if(view == card3){
            card1.setCardBackgroundColor(getResources().getColor(R.color.white));
            card2.setCardBackgroundColor(getResources().getColor(R.color.white));
            card3.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
        }
    }
}