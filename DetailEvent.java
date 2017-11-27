package esprit.tn.netlammou10.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noussa.crowd.Entities.Action;
import com.example.noussa.crowd.Netlammou;
import com.example.noussa.crowd.R;


public class DetailEvent extends Fragment {


    TextView nomEvent;
    TextView dataDebut;
    TextView dateFin;
    TextView description;
    TextView typeEvent;


    private OnFragmentInteractionListener mListener;


    public DetailEvent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_detail_event, container, false);

        nomEvent = (TextView) rootView.findViewById(R.id.nom_event);
        dataDebut = (TextView) rootView.findViewById(R.id.startDate_event);
        dateFin = (TextView) rootView.findViewById(R.id.endsDate_event);
        description = (TextView) rootView.findViewById(R.id.desc_event);
        //typeEvent = (TextView) rootView.findViewById(R.id.type_event);
        Netlammou app = (Netlammou) this.getActivity().getApplicationContext();
        Action event = (Action) app.getObject();
        nomEvent.setText(event.getName());
        dateFin.setText(event.getDescription());
        dataDebut.setText(event.getDesiredVolenteers());
        description.setText(event.getId());



        return rootView;
    }

/*
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }*/

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }

}
