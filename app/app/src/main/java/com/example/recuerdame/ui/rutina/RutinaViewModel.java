package com.example.recuerdame.ui.rutina;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class RutinaViewModel extends ViewModel{
    private static MutableLiveData<String> mText = null;

    public RutinaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rutina fragment");
    }


    public static LiveData<String> getText() {
        return mText;}
}
