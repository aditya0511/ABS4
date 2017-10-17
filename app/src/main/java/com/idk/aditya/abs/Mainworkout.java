package com.idk.aditya.abs;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class Mainworkout extends AppCompatActivity {

    public String[] name =
            {"beginners workout",
                    "general workout",
                    "advanced workout"};
    public String url;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, name);


        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        TextView txt=findViewById(R.id.textView);
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                switch (itemPosition)
                {
                    case 0:
                        txt.setText("Train 3 times per week, with one rest day in between (for example, Monday, Wednesday, Friday). \n" +
                                "Perform 10 minutes of warm up using cardio equipment (such as a rowing machine).\n" +
                                "Perform 1 to 2 sets of the following exercises:\n" +
                                "CHEST\n" +
                                "Dumbbell Bench Press (1x12 repetitions)\n" +
                                "Dumbbell Flies (1x12)\n" +
                                "BACK\n" +
                                "Wide Grip (Lat.) Pulldown (1x12)\n" +
                                "Seated Rows (1x12)\n" +
                                "TRICEPS\n" +
                                "Triceps PushDown (1x12)\n" +
                                "BICEPS\n" +
                                "Standing Dumbbell Curls (1x12)\n" +
                                "LEGS\n" +
                                "Leg Press (1x15)\n" +
                                "Leg Extension (1x15)\n" +
                                "Leg Curl (1x15)\n");
                        break;

                    case 1:
                        txt.setText("MONDAY\t \t \t \n" +
                                "Total-Body Strength Training Workout with Ab Emphasis. Complete one set of each ab exercise*, then complete the rest of the circuit twice.\n" +
                                "Exercise\tRepetitions\tRest\tSets\n" +
                                "Traditional Crunch*\t12-15\t \t1\n" +
                                "Bent-Leg Knee Raise* \t12-15\t \t1\n" +
                                "Oblique V-Up*\t10 each side \t \t1\n" +
                                "Bridge*\t1 or 2 \t \t1\n" +
                                "Back Extensions*\t12-15\t \t1\n" +
                                "Squats\t10-12\t30 seconds \t2\n" +
                                "Bench Press \t10\t30 seconds \t2\n" +
                                "Pulldown\t10\t30 seconds \t2\n" +
                                "Military Press \t10\t30 seconds \t2\n" +
                                "Upright Row \t10\t30 seconds \t2\n" +
                                "Triceps Pushdown\t10-12\t30 seconds \t2\n" +
                                "Leg Extension \t10-12\t30 seconds\t2\n" +
                                "Biceps Curl \t10\t30 seconds \t2\n" +
                                "Leg Curl \t10-12\t30 seconds\t2\n" +
                                "\n" +
                                "WEDNESDAY\t \t \t \n" +
                                "Total-Body Strength Training Workout with Ab Emphasis. Complete one set of each ab exercise*, then complete the rest of the circuit twice.\n" +
                                "Exercise\tRepetitions\tRest\tSets\n" +
                                "Standing Crunch *\t12-15\t \t1\n" +
                                "Pulse Up * \t12\t \t1\n" +
                                "Saxon Side Bend *\t6-10 each side \t \t1\n" +
                                "Side Bridge*\t1 or 2 \t \t1\n" +
                                "Back Extensions*\t12-15\t \t1\n" +
                                "Squats\t10-12\t30 seconds \t2\n" +
                                "Bench Press \t10\t30 seconds \t2\n" +
                                "Pulldown\t10\t30 seconds \t2\n" +
                                "Military Press \t10\t30 seconds \t2\n" +
                                "Upright Row \t10\t30 seconds \t2\n" +
                                "Triceps Pushdown\t10-12\t30 seconds \t2\n" +
                                "Leg Extension \t10-12\t30 seconds\t2\n" +
                                "Biceps Curl \t10\t30 seconds \t2\n" +
                                "Leg Curl \t10-12\t30 seconds\t2\n" +
                                "THURSDAY (optional)\n" +
                                "Light Cardiovascular Exercise Such as Walking (Try for 30–45 Minutes at a Brisk Pace) \n" +
                                "FRIDAY\t \t \t \n" +
                                "Total-Body Strength Training Workout with Leg Emphasis. Repeat entire circuit twice.\n" +
                                "Exercise\tRepetitions\tRest\tSets\n" +
                                "Squats\t10-12\t30 seconds \t2\n" +
                                "Bench Press \t10\t30 seconds \t2\n" +
                                "Pulldown\t10\t30 seconds \t2\n" +
                                "Traveling Lunge \t10-12 each leg \t30 seconds \t2\n" +
                                "Military Press \t10\t30 seconds \t2\n" +
                                "Upright Row \t10\t30 seconds \t2\n" +
                                "Step-Up\t10-12 each leg \t30 seconds \t2\n" +
                                "Triceps Pushdown\t10-12\t30 seconds \t2\n" +
                                "Leg Extension \t10-12\t30 seconds\t2\n" +
                                "Biceps Curl \t10\t30 seconds \t2\n" +
                                "Leg Curl \t10-12\t30 seconds\t2\n");
                        break;

                    case 2:
                        txt.setText("MONDAY\n" +
                                "AM: Low intensity cardio (40-60 minutes)\n" +
                                "Preferably done first thing in the morning (fasting). This could be slow jogging, brisk walking, treadmill or elliptical. \n" +
                                "PM: Leg Training\n" +
                                "Warm up\n" +
                                "Squats - 2 sets warm up (pyramiding to weight). 3-4 work sets 5-8 reps - try to increase weights.\n" +
                                "Leg Press - 3x10-12 reps\n" +
                                "Stiff-legged Deadlift - 2x10 reps \n" +
                                "Leg Extensions (1 or 2 sets - but by now your legs might be finished!!). \n" +
                                "Seated Calf Raises (4x10-12 reps). \n" +
                                "TUESDAY\n" +
                                "AM: Walk (60 minutes, fasted) \n" +
                                "WEDNESDAY\n" +
                                "PM: Shoulders, Triceps, Abs\n" +
                                "Use the ab workout as your warm-up - take as little rest between sets as possible.\n" +
                                "Hanging Leg Raises - 3 sets to failure.\n" +
                                "Rope Pulls - 2 sets. \n" +
                                "Barbell Military Press - 2 warm-up sets, 3x0 reps.\n" +
                                "Upright Rows - 3x12 reps.\n" +
                                "Lateral Raises - 2x12 reps. \n" +
                                "French Presses - 3x8-10 reps.\n" +
                                "Triceps Pushdowns - 2x8-10 reps.\n" +
                                "Reverse Triceps Pushdowns - 2x8-10 reps.\n" +
                                "THURSDAY\n" +
                                "Off\n" +
                                "FRIDAY\n" +
                                "AM: Low intensity cardio (40-60 minutes, fasted)\n" +
                                "Can also follow with 10 minutes of ab work. \n" +
                                "PM: Back\n" +
                                "Lat. Pulldowns - 2 warm up sets, 3-4 sets at 6-10 reps, increasing weight. \n" +
                                "Cable Rows - 3x10 reps. \n" +
                                "One armed Dumbbell Rows - 2x8 reps.\n" +
                                "Hyperextensions - 2x20 reps.\n" +
                                "Dumbbell Shrugs (2x10 reps or to failure). \n" +
                                "SATURDAY\n" +
                                "Cardio - Interval training or at increased heart rate (60-90%) 30-45 minutes (see also Target Heart Rate calculator). \n" +
                                "SUNDAY\n" +
                                "AM: Low intensity cardio (40-60 minutes, fasted)\n" +
                                "PM: Chest, Biceps\n" +
                                "Warm-up\n" +
                                "Flat Bench Press - 2 warm up sets. 3x8 reps. \n" +
                                "Hammer Incline Press - 2x8 reps, increasing weight.\n" +
                                "Incline Dumbbell Press - 3x6-10 reps.\n" +
                                "Dumbbell Pullovers - 3x12 reps.\n" +
                                "Barbell Biceps Curls - 2 warm up sets, 3x6-10 reps.\n" +
                                "Incline Dumbbell Curls - 2-3 sets 6-8 reps, increasing weight.\n" +
                                "Concentration Curls - 1 set to failure.\n");
                        break;
                    default:

                }
            }
        });
    }
}

     // ListView Item Click Listener

      //  listView.setOnItemClickListener(new View.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                // ListView Clicked item index
//                int itemPosition     = position;
//
//                // ListView Clicked item value
//                String  itemValue    = (String) listView.getItemAtPosition(position);
//
//                // Show Alert
//
//
//                Toast.makeText(getApplicationContext(),
//                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                        .show();
//
//            }
//
//        });
//    }




