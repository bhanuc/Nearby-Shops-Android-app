package org.nearbyshops.enduserappnew.ViewHolders.ViewHoldersCommon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.nearbyshops.enduserappnew.MyApplication;
import org.nearbyshops.enduserappnew.Preferences.PrefLocation;
import org.nearbyshops.enduserappnew.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ViewHolderSetLocationManually extends RecyclerView.ViewHolder{



    @BindView(R.id.locationAddress) TextView locationAddress;

    private Context context;
    private Fragment fragment;




    public static ViewHolderSetLocationManually create(ViewGroup parent, Context context, Fragment fragment)
    {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_set_location_manually,parent,false);
        return new ViewHolderSetLocationManually(view,context,fragment);
    }





    public ViewHolderSetLocationManually(View itemView, Context context, Fragment fragment) {
        super(itemView);

        ButterKnife.bind(this,itemView);
        this.context = context;
        this.fragment = fragment;


        bindDashboard();
    }









    public void bindDashboard()
    {
        boolean isLocationSetByUser = PrefLocation.isLocationSetByUser(context);

        if(isLocationSetByUser)
        {
            locationAddress.setText(context.getString(R.string.current_location_custom));
        }
        else
        {
            locationAddress.setText(context.getString(R.string.current_location_automated));
        }
    }





    @OnClick(R.id.list_item)
    void changeLocation()
    {
        if(fragment instanceof ListItemClick)
        {
            ((ListItemClick) fragment).changeLocationClick();
        }
    }







    private void showToastMessage(String message)
    {
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }







    public interface ListItemClick
    {
        void changeLocationClick();
    }



}

