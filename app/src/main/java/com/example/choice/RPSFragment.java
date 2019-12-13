package com.example.choice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RPSFragment extends Fragment {

    private TextView textViewPlayer;
    private TextView textViewWinner;
    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScissors;
    private Button buttonReset;
    private int turn = 1;
    private int playerOne;
    private int playerTwo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_rps, container, false);
        wireWidgets(rootView);
        setListeners();

        return rootView;
    }

    public void wireWidgets(View rootView){
        textViewPlayer = rootView.findViewById(R.id.textview_rps_player);
        textViewWinner = rootView.findViewById(R.id.textview_rps_winner);
        buttonRock  = rootView.findViewById(R.id.button_rps_rock);
        buttonPaper = rootView.findViewById(R.id.button_rps_paper);
        buttonScissors = rootView.findViewById(R.id.button_rps_scissors);
        buttonReset = rootView.findViewById(R.id.button_rps_reset);
    }
    public void setListeners(){
        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn == 1){
                    playerOne = 1;
                    turn++;
                    textViewPlayer.setText("Player 2's Turn");
                }
                else{
                    playerTwo = 1;
                    checkWinner();
                }
            }
        });
        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn == 1){
                    playerOne = 2;
                    turn++;
                    textViewPlayer.setText("Player 2's Turn");
                }
                else{
                    playerTwo = 2;
                    checkWinner();
                }
            }
        });
        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn == 1){
                    playerOne = 3;
                    turn++;
                    textViewPlayer.setText("Player 2's Turn");
                }
                else{
                    playerTwo = 3;
                    checkWinner();
                }
            }
        });
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                turn = 1;
                textViewPlayer.setText("Player 1's Turn");
                textViewWinner.setText("");
                buttonRock.setEnabled(true);
                buttonPaper.setEnabled(true);
                buttonScissors.setEnabled(true);
            }
        });
    }
    public void checkWinner(){
        if(playerOne == 1 && playerTwo == 3 || playerOne == 2 && playerTwo == 1 || playerOne == 3 && playerTwo == 2){
            textViewWinner.setText("Player 1 Wins");
        }
        else if(playerTwo == 1 && playerOne == 3 || playerTwo == 2 && playerOne == 1 || playerTwo == 3 && playerOne == 2){
            textViewWinner.setText("Player 2 Wins");
        }
        else{
            textViewWinner.setText("Draw");
        }
        buttonRock.setEnabled(false);
        buttonPaper.setEnabled(false);
        buttonScissors.setEnabled(false);
    }
}
