package com.example.aaron.celebrityapp;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CelebrityInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebrityInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView tvDescription;
    ImageView imgCelebImage;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public CelebrityInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CelebrityInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebrityInfoFragment newInstance(String param1, String param2) {
        CelebrityInfoFragment fragment = new CelebrityInfoFragment();
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
        return inflater.inflate(R.layout.fragment_celebrity_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDescription = view.findViewById(R.id.description);
        imgCelebImage = view.findViewById(R.id.image);
        tvDescription.setText(mParam2);
        String Name = mParam1.replaceAll("\\s+","").toLowerCase();

        try {
            int idImage = R.drawable.class.getField(Name).getInt(null);
            int idDesc = R.string.class.getField(Name).getInt(null);
            String desc = getResources().getString(idDesc);
            tvDescription.setText(desc);
            imgCelebImage.setImageResource(idImage);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
