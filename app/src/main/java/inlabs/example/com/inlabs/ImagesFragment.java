package inlabs.example.com.inlabs;


import android.app.Activity;
//import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment {


    RecyclerView recyclerView ;
    ArrayList<ImageHolder> images_list ;
    public ImagesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        System.out.println("IN CREATEVIEW FRAGMENT");

        Bundle bundle= this.getArguments();
        images_list= bundle.getParcelableArrayList("images_arraylist");
        //System.out.println(images_list.get(130).getDate_published());



        View root_view =inflater.inflate(R.layout.fragment_images, container, false);
        recyclerView =(RecyclerView) root_view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);


        StaggeredGridLayoutManager stag_grid = new StaggeredGridLayoutManager(getContext().getResources().getInteger(R.integer.grid_cols), LinearLayout.VERTICAL);
        //StaggeredGridView etsy_stag = new StaggeredGridView(getContext());
        stag_grid.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(stag_grid);
 

       RecyclerAdapter mAdapter =new RecyclerAdapter(images_list,getActivity());
        recyclerView.setAdapter(mAdapter);

        System.out.println("AT END OF FRAGMENT");
        return root_view;
    }

}
