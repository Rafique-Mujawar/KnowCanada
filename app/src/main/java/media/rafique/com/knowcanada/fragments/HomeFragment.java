package media.rafique.com.knowcanada.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import media.rafique.com.knowcanada.R;
import media.rafique.com.knowcanada.adapters.HomeListAdapter;
import media.rafique.com.knowcanada.base.BaseFragment;
import media.rafique.com.knowcanada.listenres.OnFragmentInteractionListener;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListActionListener;
import media.rafique.com.presenter.contractors.GetHomeListContractor.GetHomeListView;
import media.rafique.com.presenter.impl.GetHomeListPresenter;
import media.rafique.com.utilitymodule.data.HomeResponseItem;
import media.rafique.com.utilitymodule.error.KCError;

/**
 * A simple {@link BaseFragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends BaseFragment implements GetHomeListView {


  private OnFragmentInteractionListener mListener;
  private GetHomeListActionListener mActionListener;
  private RecyclerView mHomeRecyclerView;
  private SwipeRefreshLayout mSwipeRefreshLayout;
  private HomeListAdapter mAdapter;
  private TextView mEmptyListText;

  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   */
  public static HomeFragment newInstance(Bundle bundle) {
    HomeFragment fragment = new HomeFragment();
    if (null != bundle) {
      fragment.setArguments(bundle);
    }
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    initViews(view);
    initPresenters();
    initListeners();
    setupScreen();
    return view;
  }

  /**
   * Method to initialise all listeners
   */
  private void initListeners() {
    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        loadHomeData();
      }
    });
  }

  /**
   * Method to initialise all presenters
   */
  private void initPresenters() {
    mActionListener = new GetHomeListPresenter(this);
  }

  /**
   * Method to initialise views
   *
   * @param view {@link View}
   */
  private void initViews(View view) {
    mAdapter = new HomeListAdapter();
    mHomeRecyclerView = view.findViewById(R.id.rv_home_list);
    mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    mHomeRecyclerView.setAdapter(mAdapter);
    mSwipeRefreshLayout = view.findViewById(R.id.srl_home_list);
    mEmptyListText = view.findViewById(R.id.tv_empty_list);
  }

  /**
   * Method to setup the default screen
   */
  private void setupScreen() {
    removeEmptyListMessage();
    loadHomeData();
  }

  /**
   * Method to laod data from server
   */
  private void loadHomeData() {
    if (isNetworkAvailable()) {
      mSwipeRefreshLayout.setRefreshing(true);
      mActionListener.getHomeList();
    } else {
      showEmptyListMessage();
      showNetworkError();
    }
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * Callback method for Successfully fetching home list data
   *
   * @param list list of canadian facts
   */
  @Override
  public void onGetHomeListSuccess(ArrayList<HomeResponseItem> list) {
    mAdapter.setItems(list);
    removeEmptyListMessage();
  }

  /**
   * Callback method for Successfully fetching home list title
   *
   * @param title title of the data
   */
  @Override
  public void onHomeGetListTitle(String title) {
    mListener.setToolbarTitle(title);
  }

  /**
   * Callback method for empty list
   */
  @Override
  public void onEmptyHomeList() {
    showEmptyListMessage();
  }

  /**
   * Method to show empty list information
   */
  void showEmptyListMessage() {
    mSwipeRefreshLayout.setRefreshing(false);
    mHomeRecyclerView.setVisibility(View.GONE);
    mEmptyListText.setVisibility(View.VISIBLE);
  }

  /**
   * Method to hide empty list information and show list of items
   */
  void removeEmptyListMessage() {
    mSwipeRefreshLayout.setRefreshing(false);
    mHomeRecyclerView.setVisibility(View.VISIBLE);
    mEmptyListText.setVisibility(View.GONE);
  }

  /**
   * Callback method for error occurred while fetching home data
   *
   * @param error {@link KCError}
   */
  @Override
  public void onGetHomeListError(KCError error) {
    showEmptyListMessage();
  }
}
