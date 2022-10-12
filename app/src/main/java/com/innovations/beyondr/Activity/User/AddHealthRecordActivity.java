package com.innovations.beyondr.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Report;
import com.amplifyframework.datastore.generated.model.ReportType;
import com.innovations.beyondr.R;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class AddHealthRecordActivity extends AppCompatActivity {
    EditText summaryname, summaryinstr, summarydosage , summaryreason;
    EditText rxname, rxdosasage, rxinstr , rxreason;
    EditText labsname , labsdosage, labsinstr, labsreason, date;
    String meetingid , userid, id;
    EditText visitnotes;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_record);
        progressBar = findViewById(R.id.p);
        summarydosage = findViewById(R.id.dosage);
        summaryinstr  = findViewById(R.id.instruction);
        summaryname  = findViewById(R.id.name);
        summaryreason = findViewById(R.id.reason);
        rxname = findViewById(R.id.rxname);
        rxdosasage = findViewById(R.id.rxdosage);
        rxinstr = findViewById(R.id.rxinstr);
        rxreason =  findViewById(R.id.rxreason);
        labsname =  findViewById(R.id.labsname);
        labsdosage=  findViewById(R.id.labsdosage);
        labsinstr =  findViewById(R.id.labsinstr);
        date =  findViewById(R.id.date);


        labsreason = findViewById(R.id.labsreason);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onsaveclick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        if (TextUtils.isEmpty(summaryname.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            summaryname.setError("Please enter all details");

            return;

        } else if (TextUtils.isEmpty(summaryreason.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            summaryreason.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(summaryinstr.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            summaryinstr.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(summarydosage.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            summaryreason.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(rxreason.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            rxreason.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(rxname.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            rxname.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(rxinstr.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            rxinstr.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(labsname.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            labsname.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(labsinstr.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            labsinstr.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(labsreason.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            labsreason.setError("Please enter all details");
            return;

        } else if (TextUtils.isEmpty(labsdosage.getText().toString().trim())) {
            progressBar.setVisibility(View.GONE);
            labsdosage.setError("Please enter all details");
            return;

        } else {

            Report report = Report.builder()
                    .userId(Amplify.Auth.getCurrentUser().getUserId())
                    .reoporttype(ReportType.PERSONAL)
                    .date(new Temporal.DateTime(new Date(), getOffset()))
                    .summnaryname(summaryname.getText().toString().trim())
                    .summarydosage(summarydosage.getText().toString().trim())
                    .summnaryinstr(summaryinstr.getText().toString().trim())
                    .summnaryreason(summaryreason.getText().toString().trim())
                    .rxname(rxname.getText().toString().trim())
                    .rxdosage(rxdosasage.getText().toString().trim())
                    .rxinstr(rxinstr.getText().toString().trim())
                    .rxreason(rxreason.getText().toString().trim())
                    .labsname(labsname.getText().toString().trim())
                    .labsdosage(labsdosage.getText().toString().trim())
                    .labsinstr(labsinstr.getText().toString().trim())
                    .labsreason(labsreason.getText().toString().trim())
                    .doctorId(Amplify.Auth.getCurrentUser().getUserId())
                    .meetingid(UUID.randomUUID().toString())
                    .build();
            Amplify.API.mutate(
                    ModelMutation.create(report),
                    sucess -> pressback(),
                    error -> Log.e("TAG", "D" + error)


            );
        }
    }
    private int getOffset() {
        GregorianCalendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        return (int) TimeUnit.SECONDS.convert(rawOffset, TimeUnit.MILLISECONDS);
    }

    private void pressback() {
        progressBar.setVisibility(View.GONE);
        //Toast.makeText(AddHealthRecord.this, "", Toast.LENGTH_LONG).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }
    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }
}