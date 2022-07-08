package com.example.sd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    CardView abtn_url;
    CardView bbtn_url;
    CardView cbtn_url;
    WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        abtn_url = (CardView) getView().findViewById(R.id.btn_url);
        abtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent urlintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www4.chosun.ac.kr/acguide/9326/subview.do"));
                startActivity(urlintent);
            }
        });

        bbtn_url=(CardView) getView().findViewById(R.id.sw_url);
        bbtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent swintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sw.chosun.ac.kr/home/kor/board.do?menuPos=62"));
                startActivity(swintent);
            }
        });
        cbtn_url = (CardView) getView().findViewById(R.id.cu_url);

        cbtn_url.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent swintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sw.chosun.ac.kr/home/kor/board.do?menuPos=62"));
                startActivity(swintent);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        mWebView = (WebView) getView().findViewById(R.id.webview);
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www3.chosun.ac.kr/chosun/224/subview.do");
        return rootView;
    }
}